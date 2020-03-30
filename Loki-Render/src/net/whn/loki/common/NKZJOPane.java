/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.whn.loki.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// ww w.  j a  v a  2s  .co  m
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author nikoz
 */
public class NKZJOPane {
    public static void main(String[] args) {
    int TIME_VISIBLE = 300;
    JFrame frame1 = new JFrame();
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setSize(100, 100);
    frame1.setLocation(100, 100);

    JButton button = new JButton("My Button");
    frame1.getContentPane().add(button);

    button.addActionListener(e -> {
      JOptionPane pane = new JOptionPane("Message",
          JOptionPane.INFORMATION_MESSAGE);
      JDialog dialog = pane.createDialog(null, "Title");
      dialog.setModal(false);
      dialog.setVisible(true);

      new Timer(TIME_VISIBLE, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          dialog.setVisible(false);
        }
      }).start();
    });

    frame1.setVisible(true);

  }
  public static JDialog showDiagWithAutoClose(String[] args) {
    //int TIME_VISIBLE = 3000;
    int TIME_VISIBLE = Integer.parseInt(args[2]);
   
      JOptionPane pane = new JOptionPane(args[1],
          JOptionPane.INFORMATION_MESSAGE);
      JDialog dialog = pane.createDialog(null, args[0]);
      dialog.setModal(Boolean.parseBoolean(args[3]) );
      dialog.setVisible(true);

      new Timer(TIME_VISIBLE, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          dialog.setVisible(false);
        }
      }).start();
    return dialog;

  }
}


