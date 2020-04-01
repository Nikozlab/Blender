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

/*
 * JobDetailsForm.java
 *
 * Created on Oct 14, 2009, 11:00:47 PM
 */
package net.whn.loki.master;

import java.util.Calendar;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import net.whn.loki.common.ICommon.JobStatus;
import net.whn.loki.common.LokiForm;
import net.whn.loki.common.Task;

/**
 *
 * @author daniel
 */
public class JobDetailsForm extends LokiForm {

    /** Creates new form JobDetailsForm */
    public JobDetailsForm(Job j) {
        job = j;
        tasks = job.getTasks();
        tasksModel = new TasksModel(job);
        initComponents();

        setTitle("Job details for '" + job.getJobName() + "'");
        setViewTime();
        //tblTasks.getColumnModel().getColumn(0).setPreferredWidth(5);
        //tblTasks.getColumnModel().getColumn(1).setPreferredWidth(5);
        //tblTasks.getColumnModel().getColumn(2).setPreferredWidth(7);
        //tblTasks.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblTasks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Detail
        lblType.setText(job.getJobType().toString());
        setStatus();
        lblFirstFrame.setText(Integer.toString(job.getFirstTask()));
        lblLastFrame.setText(Integer.toString(job.getLastTask()));
        lblProjFile.setText(job.getOrigProjFile().getName());
        lblOutputDir.setText(job.getOutputDirFile().getAbsolutePath());
        lblFilePrefix.setText(job.getFilePrefix());
        lblTileRendering.setText(job.getTileStr());
        if(job.isAutoFileTransfer()) {
            lblAutoFileTransfer.setText("enabled");
        } else {
            lblAutoFileTransfer.setText("disabled");
        }

        //Tasks
        lblReady.setText(Integer.toString(job.getReady()));
        lblRunning.setText(Integer.toString(job.getRunning()));
        lblDone.setText(Integer.toString(job.getDone()));
        lblFailed.setText(Integer.toString(job.getFailed()));

        //Task table
        tblTasks.getColumnModel().getColumn(0).setMaxWidth(60);
        tblTasks.getColumnModel().getColumn(1).setMaxWidth(40);
    }

    public void RefreshJobDetailsForm() {
        
        tasks = job.getTasks();
        tasksModel = new TasksModel(job);
        initComponents();

        setTitle("Job details for '" + job.getJobName() + "'");
        setViewTime();
        //tblTasks.getColumnModel().getColumn(0).setPreferredWidth(5);
        //tblTasks.getColumnModel().getColumn(1).setPreferredWidth(5);
        //tblTasks.getColumnModel().getColumn(2).setPreferredWidth(7);
        //tblTasks.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblTasks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Detail
        lblType.setText(job.getJobType().toString());
        setStatus();
        lblFirstFrame.setText(Integer.toString(job.getFirstTask()));
        lblLastFrame.setText(Integer.toString(job.getLastTask()));
        lblProjFile.setText(job.getOrigProjFile().getName());
        lblOutputDir.setText(job.getOutputDirFile().getAbsolutePath());
        lblFilePrefix.setText(job.getFilePrefix());
        lblTileRendering.setText(job.getTileStr());
        if(job.isAutoFileTransfer()) {
            lblAutoFileTransfer.setText("enabled");
        } else {
            lblAutoFileTransfer.setText("disabled");
        }

        //Tasks
        lblReady.setText(Integer.toString(job.getReady()));
        lblRunning.setText(Integer.toString(job.getRunning()));
        lblDone.setText(Integer.toString(job.getDone()));
        lblFailed.setText(Integer.toString(job.getFailed()));

        //Task table
        tblTasks.getColumnModel().getColumn(0).setMaxWidth(60);
        tblTasks.getColumnModel().getColumn(1).setMaxWidth(40);
    }
    
    /*PRIVATE*/
    private void setStatus() {
        if (job.getStatus() == JobStatus.A) {
            lblStatus.setText("ready");
        } else if (job.getStatus() == JobStatus.B ||
                job.getStatus() == JobStatus.C) {
            lblStatus.setText("running");
        } else if (job.getStatus() == JobStatus.D) {
            lblStatus.setText("done");
        }
    }

    private void setViewTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        lblViewTime.setText(calendar.getTime().toString());
    }

    private void setTxtOutput() {
        String txt = "***select a task in the Task list***";
        String cl = "";
        int row = tblTasks.getSelectedRow();
        if (row != -1) {    //we have a selected row
            if (cbxOutput.getSelectedIndex() == 0) { //stdout
                txt = tasks[row].getStdout();
            } else if (cbxOutput.getSelectedIndex() == 1) {  //errout
                txt = tasks[row].getErrOut();
            }

            String[] tokens = tasks[row].getTaskCL();
            if (tokens != null) {
                for (String token : tokens) {
                    cl += token + " ";
                }
            } else {
                cl = "";
            }
        }
        
        txtOutput.setText(txt);
        txtTaskCL.setText(cl);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetail = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblFirstFrame = new javax.swing.JLabel();
        lblProjFile = new javax.swing.JLabel();
        lblOutputDir = new javax.swing.JLabel();
        lblFilePrefix = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblLastFrame = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTileRendering = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblAutoFileTransfer = new javax.swing.JLabel();
        pnlTaskDetail = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cbxOutput = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        txtTaskCL = new javax.swing.JTextField();
        pnlTaskTally = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblReady = new javax.swing.JLabel();
        lblRunning = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblFailed = new javax.swing.JLabel();
        lblDone = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnlBottom = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        lblViewTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTasks = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelRefresh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlDetail.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        jLabel1.setText("type:");

        jLabel2.setText("status:");

        jLabel3.setText("task range:");

        jLabel4.setText("project file:");

        jLabel5.setText("output directory:");

        jLabel6.setText("output file prefix:");

        lblType.setText("Blender Internal");

        lblStatus.setText("Ready");

        lblFirstFrame.setText("0");

        lblProjFile.setText("null");

        lblOutputDir.setText("null");

        lblFilePrefix.setText("null");

        jLabel8.setText("to");

        lblLastFrame.setText("0");

        jLabel13.setText("tile rendering:");

        lblTileRendering.setText("null");

        jLabel14.setText("auto file transfer:");

        lblAutoFileTransfer.setText("null");

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblType)
                    .addComponent(lblStatus)
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addComponent(lblFirstFrame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLastFrame))
                    .addComponent(lblProjFile)
                    .addComponent(lblOutputDir)
                    .addComponent(lblFilePrefix)
                    .addComponent(lblTileRendering)
                    .addComponent(lblAutoFileTransfer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblFirstFrame)
                    .addComponent(jLabel8)
                    .addComponent(lblLastFrame))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblProjFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblOutputDir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblFilePrefix))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(lblTileRendering))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblAutoFileTransfer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTaskDetail.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected task"));

        jLabel23.setText("task command line:");

        cbxOutput.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "stdout", "errout" }));
        cbxOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOutputActionPerformed(evt);
            }
        });

        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane2.setViewportView(txtOutput);

        txtTaskCL.setEditable(false);

        javax.swing.GroupLayout pnlTaskDetailLayout = new javax.swing.GroupLayout(pnlTaskDetail);
        pnlTaskDetail.setLayout(pnlTaskDetailLayout);
        pnlTaskDetailLayout.setHorizontalGroup(
            pnlTaskDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTaskDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaskDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(txtTaskCL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxOutput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlTaskDetailLayout.setVerticalGroup(
            pnlTaskDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaskDetailLayout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaskCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTaskTally.setBorder(javax.swing.BorderFactory.createTitledBorder("Task tally"));

        jLabel9.setText("ready:");

        lblReady.setText("0");

        lblRunning.setText("0");

        jLabel7.setText("running:");

        jLabel10.setText("done:");

        lblFailed.setText("0");

        lblDone.setText("0");

        jLabel11.setText("failed:");

        javax.swing.GroupLayout pnlTaskTallyLayout = new javax.swing.GroupLayout(pnlTaskTally);
        pnlTaskTally.setLayout(pnlTaskTallyLayout);
        pnlTaskTallyLayout.setHorizontalGroup(
            pnlTaskTallyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaskTallyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaskTallyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTaskTallyLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaskTallyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReady)
                    .addComponent(lblRunning)
                    .addComponent(lblDone)
                    .addComponent(lblFailed))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnlTaskTallyLayout.setVerticalGroup(
            pnlTaskTallyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaskTallyLayout.createSequentialGroup()
                .addGroup(pnlTaskTallyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblReady))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaskTallyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblRunning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaskTallyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblDone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaskTallyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblFailed)))
        );

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel21.setText("View generated:");

        lblViewTime.setText("null");

        javax.swing.GroupLayout pnlBottomLayout = new javax.swing.GroupLayout(pnlBottom);
        pnlBottom.setLayout(pnlBottomLayout);
        pnlBottomLayout.setHorizontalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblViewTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBottomLayout.setVerticalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblViewTime)
                    .addComponent(btnClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblTasks.setModel(tasksModel);
        tblTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTasksMouseClicked(evt);
            }
        });
        tblTasks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblTasksKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblTasks);

        jLabel12.setText("Task list");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        jButton1.setText("Refresh");
        jButton1.setName("refreshBtn"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelRefresh.setText("jLabel15");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlBottom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlTaskDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlTaskTally, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(17, 17, 17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabelRefresh)
                                        .addGap(29, 29, 29)))))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlTaskTally, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelRefresh)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlTaskDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOutputActionPerformed
        setTxtOutput();
    }//GEN-LAST:event_cbxOutputActionPerformed

    private void tblTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTasksMouseClicked
        setTxtOutput();
    }//GEN-LAST:event_tblTasksMouseClicked

    private void tblTasksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTasksKeyReleased
        setTxtOutput();
    }//GEN-LAST:event_tblTasksKeyReleased

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        long JobId;
        JobId = job.getJobID();
        jLabelRefresh.setText("refresh Job with ID:" + JobId); // TODO add your handling code here:
       // job.getStatus()
       RefreshJobDetailsForm();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    private final Job job;
    private  TasksModel tasksModel;
    private  Task[] tasks;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox cbxOutput;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelRefresh;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAutoFileTransfer;
    private javax.swing.JLabel lblDone;
    private javax.swing.JLabel lblFailed;
    private javax.swing.JLabel lblFilePrefix;
    private javax.swing.JLabel lblFirstFrame;
    private javax.swing.JLabel lblLastFrame;
    private javax.swing.JLabel lblOutputDir;
    private javax.swing.JLabel lblProjFile;
    private javax.swing.JLabel lblReady;
    private javax.swing.JLabel lblRunning;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTileRendering;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblViewTime;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JPanel pnlTaskDetail;
    private javax.swing.JPanel pnlTaskTally;
    private javax.swing.JTable tblTasks;
    private javax.swing.JTextArea txtOutput;
    private javax.swing.JTextField txtTaskCL;
    // End of variables declaration//GEN-END:variables

    private class TasksModel extends AbstractTableModel {

        TasksModel(Job j) {
            job = j;
            tasks = job.getTasks();
            columnHeaders = new String[]{
                        "frame",
                        "tile",
                        "grunt",
                        "status",
                        "time"
                    };
        }

        @Override
        public String getColumnName(int col) {
            return columnHeaders[col].toString();
        }

        @Override
        public int getRowCount() {
            return tasks.length;
        }

        @Override
        public int getColumnCount() {
            return columnHeaders.length;
        }

        @Override
        public Object getValueAt(int row, int column) {
            if (column == 0) {
                return Integer.toString(tasks[row].getFrame());
            } else if (column == 1) {
                if (tasks[row].getTile() == -1) {
                    return "n/a";
                } else {
                    return Integer.toString(tasks[row].getTile());
                }
            } else if (column == 2) {
                return tasks[row].getGruntName();
            } else if (column == 3) {
                return tasks[row].getStatus().toString().toLowerCase();
            } else if (column == 4) {
                return tasks[row].getTaskTime();
            } else {
                return "";
            }
        }
        /*PRIVATE*/
        private final String[] columnHeaders;
        private final Job job;
        private final Task[] tasks;
    }
}
