/**
 *Project: Loki Render - A distributed job queue manager.
 *Version 0.7.2
 *Copyright (C) 2014 Daniel Petersen
 *Created on Aug 8, 2009, 8:09:39 PM
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
package net.whn.loki.master;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JOptionPane;
import net.whn.loki.common.LokiForm;

/**
 *Provides a form for creating a new job
 * @author daniel
 */
public class AddJobForm extends LokiForm {

    /** Creates new form AddJobForm */
    public AddJobForm(MasterForm mHandle) {
        initComponents();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        masterForm = mHandle;
        txtProjectFile.setText(masterForm.getCfg().getProjFile().toString());
        txtOutputDir.setText(masterForm.getCfg().getOutDirFile().toString());
        txtOutputPrefix.setText(masterForm.getCfg().getFilePrefix());
        comboboxTileMultiplier.setSelectedIndex(2);
        cbxAutoFileTransfer.setSelected(
                masterForm.getCfg().getAutoFileHandling());
        updateMultiplierText();
    }

    /*BEGIN PRIVATE*/
    private final MasterForm masterForm;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projectFileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        cbxJobType = new javax.swing.JComboBox();
        typeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        fileLabel = new javax.swing.JLabel();
        firstFrameLabel = new javax.swing.JLabel();
        lastFrameLabel = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtProjectFile = new javax.swing.JTextField();
        txtFirstFrame = new javax.swing.JTextField();
        txtLastFrame = new javax.swing.JTextField();
        FileBrowseButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtOutputDir = new javax.swing.JTextField();
        OutputBrowseButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtOutputPrefix = new javax.swing.JTextField();
        cbxAutoFileTransfer = new javax.swing.JCheckBox();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        pnlTileRendering = new javax.swing.JPanel();
        cbxEnableTile = new javax.swing.JCheckBox();
        comboboxTileMultiplier = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lblMultiplier = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Job");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        cbxJobType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blender" }));
        cbxJobType.setToolTipText("select the job type here");
        cbxJobType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxJobTypeActionPerformed(evt);
            }
        });

        typeLabel.setText("Type:");

        nameLabel.setText("Name:");

        fileLabel.setText("Project File:");

        firstFrameLabel.setText("First Frame:");

        lastFrameLabel.setText("Last Frame:");

        txtName.setToolTipText("type a unique job name here");

        txtProjectFile.setToolTipText("specify the full path to the project file here");

        txtFirstFrame.setToolTipText("the first frame in the frame range to be rendered (e.g. '1')");

        txtLastFrame.setToolTipText("the last frame in the frame range to be rendered (e.g. '200')");

        FileBrowseButton.setText("Browse");
        FileBrowseButton.setName("FileBrowseButton"); // NOI18N
        FileBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileBrowseButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Output Directory:");

        txtOutputDir.setToolTipText("the output directory where rendered frames will be placed");

        OutputBrowseButton.setText("Browse");
        OutputBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutputBrowseButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Output File Prefix:");

        txtOutputPrefix.setToolTipText("specify a file prefix for the rendered frames (e.g. \"scene1_\" would give \"scene1_0024.jpg\", etc.)");
        txtOutputPrefix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOutputPrefixActionPerformed(evt);
            }
        });

        cbxAutoFileTransfer.setText("Enable automatic file transfer");
        cbxAutoFileTransfer.setToolTipText("Uncheck this if you have setup a network share with project files that all nodes can access.\nUseful for large projects with lots of texture files, etc.");
        cbxAutoFileTransfer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbxAutoFileTransferStateChanged(evt);
            }
        });
        cbxAutoFileTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAutoFileTransferActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastFrameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(firstFrameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fileLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(typeLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxAutoFileTransfer)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLastFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFirstFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOutputPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxJobType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProjectFile, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                            .addComponent(txtOutputDir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FileBrowseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OutputBrowseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFirstFrame, txtLastFrame});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtName, txtOutputPrefix});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxJobType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProjectFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileLabel)
                    .addComponent(FileBrowseButton))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOutputDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(OutputBrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOutputPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstFrameLabel)
                    .addComponent(txtFirstFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastFrameLabel)
                    .addComponent(txtLastFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cbxAutoFileTransfer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelButton.setText("Cancel");
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.setMaximumSize(new java.awt.Dimension(60, 30));
        saveButton.setMinimumSize(new java.awt.Dimension(60, 30));
        saveButton.setName("saveButton"); // NOI18N
        saveButton.setPreferredSize(new java.awt.Dimension(60, 30));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        pnlTileRendering.setBorder(javax.swing.BorderFactory.createTitledBorder("Tile rendering"));
        pnlTileRendering.setToolTipText("Tile rendering splits a frame into separate parts for parallel rendering of tiles.");

        cbxEnableTile.setText("Enabled");
        cbxEnableTile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEnableTileActionPerformed(evt);
            }
        });

        comboboxTileMultiplier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        comboboxTileMultiplier.setToolTipText("select a multiplier to specify how many tiles parts will be used");
        comboboxTileMultiplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxTileMultiplierActionPerformed(evt);
            }
        });

        jLabel3.setText("Multiplier:");

        lblMultiplier.setToolTipText("the total number of tiles parts");

        javax.swing.GroupLayout pnlTileRenderingLayout = new javax.swing.GroupLayout(pnlTileRendering);
        pnlTileRendering.setLayout(pnlTileRenderingLayout);
        pnlTileRenderingLayout.setHorizontalGroup(
            pnlTileRenderingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTileRenderingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTileRenderingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxEnableTile)
                    .addGroup(pnlTileRenderingLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboboxTileMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        pnlTileRenderingLayout.setVerticalGroup(
            pnlTileRenderingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTileRenderingLayout.createSequentialGroup()
                .addComponent(cbxEnableTile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTileRenderingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMultiplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTileRenderingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(comboboxTileMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlTileRendering, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTileRendering, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Disposes of the form without doing anything.
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
         //System.out.println("cancelButtonActionPerformed evt.getActionCommand:" + evt.getActionCommand());
         //System.out.println("cancelButtonActionPerformed evt.toString:" + evt.toString());
         masterForm.cancelBTNStatus = true;
         dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * performs final validation then creates a new job object with the
     * given values and passes it to the masterForm
     * @param evt
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        boolean valid = true;
        masterForm.cancelBTNStatus = false;
        File f;

        //check that the name field isn't empty
        if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a name.");
            valid = false;
            txtName.requestFocusInWindow();
        }

        //check that the project file exists
        try {
            f = new File(txtProjectFile.getText());
            if (!f.canRead() && valid) {
                JOptionPane.showMessageDialog(rootPane,
                        "Please enter a valid project file.");
                valid = false;
                txtProjectFile.requestFocusInWindow();
            }
        } catch (NullPointerException nullEx) {
            JOptionPane.showMessageDialog(rootPane,
                    "Please enter a valid project file.");
            valid = false;
            txtProjectFile.requestFocusInWindow();
        }

        //check that the output dir exists and is writable
        try {
            f = new File(txtOutputDir.getText());
            File outputTest = new File(f, "zoki");
            
                outputTest.createNewFile();
                outputTest.delete();
        } catch (NullPointerException nullEx) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a valid project file.");
            valid = false;
            txtOutputDir.requestFocusInWindow();
        } catch (IOException ioe) {
                JOptionPane.showMessageDialog(rootPane,
                        "Loki cannot write to the output directory.");
                valid = false;
                txtOutputDir.requestFocusInWindow();
        }

        //check that the frame entries are integers
        try {
            int first = Integer.parseInt(txtFirstFrame.getText());
            int last = Integer.parseInt(txtLastFrame.getText());

            if ((first > last) && valid) {
                JOptionPane.showMessageDialog(rootPane, "The last frame " +
                        "must be the same or larger than the first frame.");
                valid = false;
                txtFirstFrame.requestFocusInWindow();
            }
            if (first < 1 && valid) {
                JOptionPane.showMessageDialog(rootPane, "Frames must be " +
                        "positive numbers.");
                valid = false;
                txtFirstFrame.requestFocusInWindow();
            }
        } catch (NumberFormatException NumEx) {
            if (valid) {
                JOptionPane.showMessageDialog(rootPane, "Please enter valid " +
                        "numbers for first and last frames.");
                valid = false;
                txtFirstFrame.requestFocusInWindow();
            }
        }

        //after all the validation checks
        if (valid) {
            masterForm.addJob(new JobFormInput(
                    cbxJobType.getSelectedItem().toString(),
                    txtName.getText(),
                    txtProjectFile.getText(),
                    txtOutputDir.getText(),
                    txtOutputPrefix.getText(),
                    Integer.parseInt(txtFirstFrame.getText()),
                    Integer.parseInt(txtLastFrame.getText()), 3,
                    cbxEnableTile.isSelected(),
                    Integer.parseInt(
                    (String) comboboxTileMultiplier.getSelectedItem()),
                    cbxAutoFileTransfer.isSelected()));
            dispose();
            masterForm.setEnabled(true);

            //'remember' paths for next dialog run
            masterForm.getCfg().setProjFile(
                    new File(txtProjectFile.getText()));
            masterForm.getCfg().setOutDirFile(
                    new File(txtOutputDir.getText()));
            masterForm.getCfg().setFilePrefix(txtOutputPrefix.getText());
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void FileBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileBrowseButtonActionPerformed
        // System.out.println(">>>masterForm.getCfg().getProjFile():" + masterForm.getCfg().getProjFile());

        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                //masterForm.getCfg().getProjFile());
        fileChooser.setDialogTitle("Select a project file");
        fileChooser.addChoosableFileFilter(new BlendFilter());
        if (fileChooser.showDialog(jLabel1, "Select") == JFileChooser.APPROVE_OPTION) {
            txtProjectFile.setText(
                    fileChooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_FileBrowseButtonActionPerformed

    private void updateMultiplierText() {
        Integer multiplier = Integer.parseInt(
                (String) comboboxTileMultiplier.getSelectedItem());
        String txt = multiplier.toString() + " * " + multiplier.toString() +
                " = " + Integer.toString(multiplier * multiplier) + " tiles";
        lblMultiplier.setText(txt);
    }

    private void OutputBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutputBrowseButtonActionPerformed
        JFileChooser dirChooser = new JFileChooser();
        dirChooser.setDialogTitle("Select an output directory");
        dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        dirChooser.setAcceptAllFileFilterUsed(false);
        dirChooser.setCurrentDirectory(masterForm.getCfg().getOutDirFile());
        if (dirChooser.showDialog(jLabel1, "Select") == JFileChooser.APPROVE_OPTION) {
            txtOutputDir.setText(
                    dirChooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_OutputBrowseButtonActionPerformed

    private void txtOutputPrefixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOutputPrefixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOutputPrefixActionPerformed

    private void cbxEnableTileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEnableTileActionPerformed
        comboboxTileMultiplier.setEnabled(cbxEnableTile.isSelected());
        lblMultiplier.setEnabled(cbxEnableTile.isSelected());
    }//GEN-LAST:event_cbxEnableTileActionPerformed

    private void comboboxTileMultiplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxTileMultiplierActionPerformed
        updateMultiplierText();
    }//GEN-LAST:event_comboboxTileMultiplierActionPerformed

    private void cbxAutoFileTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAutoFileTransferActionPerformed
        if(cbxAutoFileTransfer.isSelected()) {
            pnlTileRendering.setEnabled(true);
            cbxEnableTile.setEnabled(true);
            jLabel3.setEnabled(true);
            comboboxTileMultiplier.setEnabled(true);
            lblMultiplier.setEnabled(true);
        } else {
            pnlTileRendering.setEnabled(false);
            cbxEnableTile.setEnabled(false);
            cbxEnableTile.setSelected(false);
            jLabel3.setEnabled(false);
            comboboxTileMultiplier.setEnabled(false);
            lblMultiplier.setEnabled(false);
        }
    }//GEN-LAST:event_cbxAutoFileTransferActionPerformed

    private void cbxAutoFileTransferStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbxAutoFileTransferStateChanged
        
    }//GEN-LAST:event_cbxAutoFileTransferStateChanged

    private void cbxJobTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxJobTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxJobTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FileBrowseButton;
    private javax.swing.JButton OutputBrowseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox cbxAutoFileTransfer;
    private javax.swing.JCheckBox cbxEnableTile;
    private javax.swing.JComboBox cbxJobType;
    private javax.swing.JComboBox comboboxTileMultiplier;
    private javax.swing.JLabel fileLabel;
    private javax.swing.JLabel firstFrameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lastFrameLabel;
    private javax.swing.JLabel lblMultiplier;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel pnlTileRendering;
    private javax.swing.JFileChooser projectFileChooser;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField txtFirstFrame;
    private javax.swing.JTextField txtLastFrame;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOutputDir;
    private javax.swing.JTextField txtOutputPrefix;
    private javax.swing.JTextField txtProjectFile;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
