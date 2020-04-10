/**
 *Project: Loki Renderer - A distributed job queue manager.
 *Version 0.8.0
 *Copyright (C) 2014 Daniel Petersen
 *Created on Sep 3, 2009
 */
/**
 *This program is free software: you can redistribute it and/or modify
 *it under the terms of the GNU General Public License as published by
 *the Free Software Foundation, either version 3 of the License, or
 *(at your option) any later version.
 *
 *This program is distributed in the hope that it will be useful,
 *but WITHOUT ANY WARRANTY; without even the implied warranty of
 *MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *GNU General Public License for more details.
 *
 *You should have received a copy of the GNU General Public License
 *along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
 package net.whn.loki.common.configs;

import net.whn.loki.common.ICommon;
import net.whn.loki.common.Main;
import net.whn.loki.common.ProjectFileObject;
import net.whn.loki.io.IOHelper;
import net.whn.loki.master.JobsModel;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.io.BufferedReader;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.logging.Level;


/**
 *
 * @author daniel, Michael, NiKoZ
 */
public class Config implements Serializable, ICommon {

    private static final Logger log = Logger.getLogger(Config.class.toString());
    //common
    private ConcurrentHashMap<String, ProjectFileObject> fileCacheMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ProjectFileObject> gruntFileCacheMap = new ConcurrentHashMap<>();

    private volatile LokiRole lokiRole = LokiRole.ASK;
    private volatile long cacheSize; //in bytes
    private static final int bytesPerMB = 1048576;
    private volatile long cacheSizeLimit = 100 * bytesPerMB; //in bytes
    private static File lokiConfigFile;    //static because it's methods are static
    private boolean autoFileHandling = true;
    //multicast
    private InetAddress multicastAddress;
    private int gruntMulticastPort = 53913;
    private int announceInterval = 1000;
    //TCP
    private int connectPort = 53914;
    private int filesReceivePort = 53915;
    private int updateMachinePort = 53916;
    //master
    private long jobIDCounter;
    private long taskIDCounter;
    private JobsModel jobsModel;
    //addjobFrom memory
    private File projectFile = new File("");
    private String runnableBlendFileName;
    private File outputFolder = new File("");
    private String filePrefix = "";
    //grunt
    private String blenderBin = "blender";
    private boolean autoDiscoverMaster = true;
    private InetAddress masterAddress;
    //IO
    private static final Deflater fastDeflater = new Deflater(1);
    //formatting
    private static DecimalFormat MBformatter = new DecimalFormat("#0.0");
    private boolean isEnabledAutoRunScripts;
    private boolean isEnabledCommandLineScripts;
    private String LOKI_VERSION;

    //NiKoZ WaS HeRe
    private static final long serialVersionUID = 6529685098267757690L;
    //NiKoZ WaS HeRe
    /**
     * Called by main if no previous Config exists
     * @param lokiBaseFolder
     */
    public Config(File lokiBaseFolder) {

        jobsModel = new JobsModel(lokiBaseFolder); //master
        try {
            multicastAddress = InetAddress.getByName("232.26.11.4");
        } catch (UnknownHostException ex) {
            log.severe(ex.getMessage());
        }
        LOKI_VERSION = Main.LOKI_VERSION;
    }

    public void setAutoFileHandling(boolean auto) {
        autoFileHandling = auto;
    }
    
    public boolean getAutoFileHandling () {
        return autoFileHandling;
    }

    public void setMasterIp(InetAddress mAddress) {
        masterAddress = mAddress;
    }
    
    public InetAddress getMasterIp() {
        return masterAddress;
    }

    public boolean isAutoDiscoverMaster() {
        return autoDiscoverMaster;
    }
    
    public void setAutoDiscoverMaster(boolean auto) {
        autoDiscoverMaster = auto;
    }

    public LokiRole getLokiRole() {
        return lokiRole;
    }

    public void setLokiRole(LokiRole lokiRole) {
        this.lokiRole = lokiRole;
    }

    public InetAddress getMulticastAddress() {
        return multicastAddress;
    }

    public int getGruntMulticastPort() {
        return gruntMulticastPort;
    }

    public int getConnectPort() {
        return connectPort;
    }

    public int getFilesReceivePort() {
        return filesReceivePort;
    }

    public int getUpdateMachinePort() {
        return updateMachinePort;
    }

    public int getAnnounceInterval() {
        return announceInterval;
    }

    public long getJobIDCounter() {
        return jobIDCounter;
    }

    public long getTaskIDCounter() {
        return taskIDCounter;
    }

    public JobsModel getJobsModel() {
        return jobsModel;
    }

    public ConcurrentHashMap<String, ProjectFileObject> getFileCacheMap() {
        return fileCacheMap;
    }

    public void setBlenderBin(String bBin) {
        blenderBin = bBin;
    }

    public String getBlenderBin() {
        return blenderBin;
    }

    public File getOutputFolder() {
        return outputFolder;
    }

    public void setOutputFolder(File outDirFile) {
        this.outputFolder = outDirFile;
    }

    public File getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

    /**
     *
     * @return a formatted string in format #0.0
     */
    public String getCacheSizeStr() {
        double result = (double) getCacheSize() / (double) bytesPerMB;
        return MBformatter.format(result) + " MB";
    }

    public long getCacheSize() {
        return cacheSize = IOHelper.getFileCacheSize(fileCacheMap);
    }

    public void setCacheSizeLimitMB(int limit) {
        cacheSizeLimit = (long) (limit * bytesPerMB);
    }

    public void setCacheSizeLimitBytes(long limit) {
        cacheSizeLimit = limit;
    }

    public int getCacheSizeLimitMB() {
        int cacheSizeLimitMB = (int) (cacheSizeLimit / bytesPerMB);
        return cacheSizeLimitMB;
    }

    public long getCacheSizeLimitBytes() {
        return cacheSizeLimit;
    }

    public void setCacheSizeLimit(long cacheSizeLimit) {
        this.cacheSizeLimit = cacheSizeLimit;
    }

    public String getFilePrefix() {
        return filePrefix;
    }

    public void setFilePrefix(String filePrefix) {
        this.filePrefix = filePrefix;
    }

    /**
     * Writes unique mastercfg data to loki.cfg.as a rule, any common data
 that is not a reference to object is written by master
     * @param jobIDCounter
     * @param taskIDCounter
     */
    public void setMasterCfg(long jobIDCounter, long taskIDCounter) {
        this.jobIDCounter = jobIDCounter;
        this.taskIDCounter = taskIDCounter;
        log.finest("master setting jobIDCounter");
    }

    public void setTaskIDCounter(long taskIDCounter) {
        this.taskIDCounter = taskIDCounter;
    }

    public static String readFirstLineFromFileWithFinallyBlock(String path)
                                   throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
    
    /**
     * If a cfg file exists, then it reads the cfg object from it
     * @param lokiBaseFolder
     * @return cfg object if file is present, new cfg object otherwise
     */
    public synchronized static Config readConfigFile(File lokiBaseFolder) {

        lokiConfigFile = new File(lokiBaseFolder, "loki.cfg");
        Config c; 
        long time = System.currentTimeMillis();
        if (lokiConfigFile.canRead()) {
            //log.info("lokiConfigFile.getPath" + lokiConfigFile.getPath());
            //log.info("lokiConfigFile.getAbsolutePath" + lokiConfigFile.getAbsolutePath());
            try {
                String json = readFirstLineFromFileWithFinallyBlock(lokiConfigFile.getPath());
                //log.info("json: " + json);
                Gson gson = new Gson();
                c = (Config) gson.fromJson(json, Config.class);
                //time = System.currentTimeMillis() - time;
                //log.finest("config file read in (ms): " + Long.toString(time));
                return c;
            } catch (IOException ex) {
                Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JsonSyntaxException ex) {
                log.log(Level.WARNING, "failed to read loki.cfg: {0}", ex.getMessage());
            }
            /*try (
                FileInputStream fileInputStream = new FileInputStream(lokiConfigFile);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                InflaterInputStream inflaterInputStream = new InflaterInputStream(bufferedInputStream);
                ObjectInputStream objectInputStream = new ObjectInputStream(inflaterInputStream)) {

                return (Config) objectInputStream.readObject();
                
            } catch (Exception ex) {
                log.warning("failed to read loki.cfg: " + ex.getMessage());
            }*/
        }
        return new Config(lokiBaseFolder);
    }

    /**
     * Writes the current Config object to the cfg file. this and the read method
     * are synchronized so we guarantee that two threads are never reading/
     * writing the config file at the same time
     * @param config
     * @throws IOException
     */
    public synchronized static void writeCfgToFile(Config config) throws IOException {

        lokiConfigFile = new File(Main.lokiBaseFolder, "loki.cfg");
        
        long time;
        try (FileWriter file = new FileWriter(lokiConfigFile)) {
            Gson gson = new Gson();
            String json = gson.toJson(config);
            time = System.currentTimeMillis();
            file.write(json);
            file.flush();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonSyntaxException ex) {
            log.log(Level.WARNING, "failed to read loki.cfg: {0}", ex.getMessage());
        }
        //time = System.currentTimeMillis() - time;
        //log.fine("config file written in (ms): " + Long.toString(time));
        /*
        try (FileOutputStream file = new FileOutputStream(lokiConfigFile);
             BufferedOutputStream buffer = new BufferedOutputStream(file);
             DeflaterOutputStream dout = new DeflaterOutputStream(buffer, fastDeflater);
             ObjectOutput objOut = new ObjectOutputStream(dout)) {

            objOut.writeObject(config);
            objOut.flush();
        }*/
    }

    public boolean isEnabledAutoRunScripts() {
        return isEnabledAutoRunScripts;
    }

    public void setEnabledAutoRunScripts(boolean enabledAutoRunScripts) {
        this.isEnabledAutoRunScripts = enabledAutoRunScripts;
    }

    public boolean isEnabledCommandLineScripts() {
        return isEnabledCommandLineScripts;
    }

    public void setEnabledCommandLineScripts(boolean enabledCommandLineScripts) {
        this.isEnabledCommandLineScripts = enabledCommandLineScripts;
    }

    public ConcurrentHashMap<String, ProjectFileObject> getGruntFileCacheMap() {
        return gruntFileCacheMap;
    }

    public void setGruntFileCacheMap(ConcurrentHashMap<String, ProjectFileObject> gruntFileCacheMap) {
        this.gruntFileCacheMap = gruntFileCacheMap;
    }

    public String getLOKI_VERSION() {
        return LOKI_VERSION;
    }

    public void setLOKI_VERSION(String LOKI_VERSION) {
        this.LOKI_VERSION = LOKI_VERSION;
    }

    public void deleteLokiConfigFile() {
        lokiConfigFile.delete();
    }

    /**
     *
     * @param config - this is old Config, what file loki.cfg, was deleted;
     * @return - new config, with old saved settings
     */
    public Config initializeFrom(Config config) {

        fileCacheMap = config.getFileCacheMap();
        gruntFileCacheMap= config.getGruntFileCacheMap();
        lokiRole = config.getLokiRole();
        getCacheSize();
        cacheSizeLimit = config.getCacheSizeLimitBytes();
        autoFileHandling = config.getAutoFileHandling();
        jobIDCounter = config.getJobIDCounter();
        taskIDCounter = config.getTaskIDCounter();
        jobsModel = config.getJobsModel();
        projectFile = config.getProjectFile();
        outputFolder = config.getOutputFolder();
        filePrefix = config.getFilePrefix();
        blenderBin = config.getBlenderBin();
        autoDiscoverMaster = config.isAutoDiscoverMaster();
        masterAddress = config.getMasterIp();
        isEnabledAutoRunScripts = config.isEnabledAutoRunScripts();
        isEnabledCommandLineScripts = config.isEnabledCommandLineScripts();
        return this;
    }

    public String getRunnableBlendFileName() {
        return runnableBlendFileName;
    }

    public void setRunnableBlendFileName(String runnableBlendFileName) {
        this.runnableBlendFileName = runnableBlendFileName;
    }
}
