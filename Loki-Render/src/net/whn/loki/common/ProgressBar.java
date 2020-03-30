/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.whn.loki.common;

/**
 *
 * @author nikoz
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ProgressBar {

    public static void main(String[] args) {
        new ProgressBar();
    }

    public ProgressBar() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                new BackgroundWorker().execute();

            }

        });
    }

    public class BackgroundWorker extends SwingWorker<Void, Void> {

        private ProgressMonitor monitor;

        public BackgroundWorker() {
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
                        if (monitor == null) {
                            monitor = new ProgressMonitor(null, "Processing", null, 0, 99);
                        }
                        monitor.setProgress(getProgress());
                    }
                }

            });
        }

        @Override
        protected void done() {
            if (monitor != null) {
                monitor.close();
            }
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (int index = 0; index < 100; index++) {
                setProgress(index);
                Thread.sleep(125);
            }
            return null;
        }
    }
}

