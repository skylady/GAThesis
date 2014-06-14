/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga.thesis.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;
import ga.thesis.entities.Test;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Mike
 */
public class GUIForm extends javax.swing.JFrame {

    /**
     * Creates new form GUIForm
     */
    public static HashMap<Integer, ArrayList<Integer>> representPeriods() {
        HashMap<Integer, ArrayList<Integer>> map;
        map = new HashMap<Integer, ArrayList<Integer>>();
        int i = 10;
        for (int j = 1; j < 6; j++) {
            for (int k = 0; k < 6; k++) {
                ArrayList<Integer> columnRow = new ArrayList<Integer>();

                columnRow.add(j);
                columnRow.add(k);
                map.put(i, columnRow);
                i++;

            }
        }
        return map;
    }

    public class LineWrapCellRenderer extends JTextArea implements TableCellRenderer {

        public Font getSmallSize() {
            Font was = this.getFont();
            Font fon = new Font(was.getName(), was.getStyle(), 9);
            setFont(fon);
            return fon;
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {

            JTextArea c = new JTextArea();

            if (value instanceof SimpleString1) {
                c.setFont(getSmallSize());
            }

            if (value != null) {
                c.setText(value.toString());
            } else {
                c.setText("");
            }

            c.setWrapStyleWord(true);
            c.setLineWrap(true);
            return c;
        }

    }

    public GUIForm() {
        initComponents();

        jTable1.setShowGrid(true);
        jTable1.setRowHeight(78);
        
        jTable1.setDefaultRenderer(Object.class, new LineWrapCellRenderer());

    }

    private class SimpleString {

        private String c;

        public SimpleString(String s) {
            this.c = s;
        }

        @Override
        public String toString() {
            return c;
        }
    }

    private class SimpleString1 {

        private String c;

        public SimpleString1(String s) {
            this.c = s;
        }

        @Override
        public String toString() {
            return c;
        }
    }

    private void initCombo(List<String> list, final HashMap<String, HashMap<Integer, ArrayList<String>>> map) {
        for (String name : list) {
            jComboBox1.addItem(name);
        }
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initTable(jComboBox1.getSelectedItem().toString(), map);
            }
        });

    }

    private void showM(String c) {
        JOptionPane.showMessageDialog(null, c);
    }
    public void notifyDone(HashMap<String, HashMap<Integer, ArrayList<String>>> map) {
        jButton3.setEnabled(true);
        Set<String> keys = map.keySet();
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(keys);
        initCombo(list, map);
    }

    public void initTable(String kurs, HashMap<String, HashMap<Integer, ArrayList<String>>> map) {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 10; i < representPeriods().size() + 10; i++) {

            ArrayList<Integer> period = representPeriods().get(i);
            model.setValueAt(new SimpleString(""), period.get(1), period.get(0));

        }

        HashMap<Integer, ArrayList<String>> kursMap = map.get(kurs);

        for (int i = 10; i < representPeriods().size() + 10; i++) {
            if (kursMap.containsKey(i)) {
                ArrayList<String> pairs = kursMap.get(i);
                ArrayList<Integer> period = representPeriods().get(i);
                model.setValueAt(new SimpleString1(concatString(pairs)), period.get(1), period.get(0));
            }
        }
    }

    public static String concatString(ArrayList<String> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i)).append(" ");
        }
        return builder.toString();
    }

    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - unknown
    private void initComponents() {
        jMenuBar1 = new JMenuBar();
        jMenu2 = new JMenu();
        jMenu6 = new JMenu();
        jMenu5 = new JMenu();
        jMenuItem2 = new JMenuItem();
        jMenu3 = new JMenu();
        jMenu4 = new JMenu();
        jButton2 = new JButton();
        jComboBox1 = new JComboBox();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabel2 = new JLabel();
        jButton3 = new JButton();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();

        //======== this ========
        setDefaultCloseOperation(3);
        setTitle("\u041f\u0440\u043e\u0433\u0440\u0430\u043c\u0430 \u043f\u043e\u0431\u0443\u0434\u043e\u0432\u0438 \u0440\u043e\u0437\u043a\u043b\u0430\u0434\u0443");
        Container contentPane = getContentPane();

        //======== jMenuBar1 ========
        {

            //======== jMenu2 ========
            {
                jMenu2.setText("\u0424\u0430\u0439\u043b");

                //======== jMenu6 ========
                {
                    jMenu6.setText("\u0415\u043a\u0441\u043f\u043e\u0440\u0442 \u0440\u043e\u0437\u043a\u043b\u0430\u0434\u0443");
                }
                jMenu2.add(jMenu6);

                //======== jMenu5 ========
                {
                    jMenu5.setText("\u041d\u0430\u043b\u0430\u0448\u0442\u0443\u0432\u0430\u043d\u043d\u044f \u0430\u043b\u0433\u043e\u0440\u0438\u0442\u043c\u0443");
                    jMenu5.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            jMenu5MouseClicked(e);
                        }
                    });
                    jMenu5.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jMenu5ActionPerformed(e);
                        }
                    });
                }
                jMenu2.add(jMenu5);

                //---- jMenuItem2 ----
                jMenuItem2.setText("\u0412\u0438\u0439\u0442\u0438 \u0437 \u043f\u0440\u043e\u0433\u0440\u0430\u043c\u0438");
                jMenuItem2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem2ActionPerformed(e);
                    }
                });
                jMenu2.add(jMenuItem2);
            }
            jMenuBar1.add(jMenu2);

            //======== jMenu3 ========
            {
                jMenu3.setText("\u0420\u043e\u0431\u043e\u0442\u0430 \u0437 \u0411\u0414");
            }
            jMenuBar1.add(jMenu3);

            //======== jMenu4 ========
            {
                jMenu4.setText("\u0414\u043e\u043f\u043e\u043c\u043e\u0433\u0430");
            }
            jMenuBar1.add(jMenu4);
        }
        setJMenuBar(jMenuBar1);

        //---- jButton2 ----
        jButton2.setFont(new Font("Courier New", Font.BOLD, 14));
        jButton2.setText("\u0415\u043a\u0441\u043f\u043e\u0440\u0442");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed(e);
            }
        });

        //---- jComboBox1 ----
        jComboBox1.setFont(new Font("Courier New", Font.PLAIN, 11));
        jComboBox1.setModel(new DefaultComboBoxModel(new String[] {
            "..."
        }));
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jComboBox1ActionPerformed(e);
            }
        });

        //---- jLabel1 ----
        jLabel1.setBackground(new Color(204, 204, 255));
        jLabel1.setFont(new Font("Courier New", Font.PLAIN, 20));
        jLabel1.setHorizontalAlignment(0);
        jLabel1.setText("\u041f\u0440\u043e\u0433\u0440\u0430\u043c\u0430 \u043f\u043e\u0431\u0443\u0434\u043e\u0432\u0438 \u0440\u043e\u0437\u043a\u043b\u0430\u0434\u0443");

        //======== jScrollPane1 ========
        {

            //---- jTable1 ----
            jTable1.setBorder(new LineBorder(Color.black, 1, true));
            jTable1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"1 \u043f\u0430\u0440\u0430", "", null, null, "", null},
                    {"2 \u043f\u0430\u0440\u0430", null, null, null, "", null},
                    {"3 \u043f\u0430\u0440\u0430", null, null, null, null, null},
                    {"4 \u043f\u0430\u0440\u0430", null, null, null, null, null},
                    {"5 \u043f\u0430\u0440\u0430", null, null, null, null, null},
                    {"6 \u043f\u0430\u0440\u0430", null, null, "", null, null},
                },
                new String[] {
                    "", "\u041f\u043e\u043d\u0435\u0434\u0456\u043b\u043e\u043a", "\u0412\u0456\u0432\u0442\u043e\u0440\u043e\u043a", "\u0421\u0435\u0440\u0435\u0434\u0430", "\u0427\u0435\u0442\u0432\u0435\u0440", "\u041f'\u044f\u0442\u043d\u0438\u0446\u044f"
                }
            ));
            jScrollPane1.setViewportView(jTable1);
        }

        //---- jLabel2 ----
        jLabel2.setFont(new Font("Courier New", Font.PLAIN, 12));
        jLabel2.setText("\u0412\u0456\u0434\u043e\u0431\u0440\u0430\u0436\u0430\u0442\u0438 \u043a\u0443\u0440\u0441:");

        //---- jButton3 ----
        jButton3.setFont(new Font("Courier New", Font.BOLD, 14));
        jButton3.setText("\u0417\u0430\u043f\u0443\u0441\u043a");
        jButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                jButton3MouseReleased(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(162, 162, 162)
                    .addComponent(jLabel2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(52, 52, 52)
                    .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(jButton2)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(31, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
                            .addGap(179, 179, 179))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== jMenu1 ========
        {
            jMenu1.setText("jMenu1");
        }

        //---- jMenuItem1 ----
        jMenuItem1.setText("jMenuItem1");
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
        //  GAParameters.

    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        // TODO add your handling code here:
        if (jButton3.isEnabled()) {
            Test alg = new Test(this);
            jButton3.setEnabled(false);
            alg.main();
        }
    }//GEN-LAST:event_jButton3MouseReleased

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        
        GAParameters form = new GAParameters();
        form.show();
    }//GEN-LAST:event_jMenu5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar jMenuBar1;
    private JMenu jMenu2;
    private JMenu jMenu6;
    private JMenu jMenu5;
    private JMenuItem jMenuItem2;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JButton jButton2;
    private JComboBox jComboBox1;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JLabel jLabel2;
    private JButton jButton3;
    private JMenu jMenu1;
    private JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables

}
