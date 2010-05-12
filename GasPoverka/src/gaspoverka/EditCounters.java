package gaspoverka;

import gaspoverka.table.*;
import gaspoverka.data.*;
import java.lang.Object.*;

public class EditCounters extends javax.swing.JFrame {

    MRTM MRTM;
    KPTM KPTM;
    CounterTM devTM;
    Counters device;

    public EditCounters() {
        MRTM = new MRTM();
        KPTM = new KPTM();
        devTM = new CounterTM();
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Поверяемые СИ");

        device = new Counters();
        tableDev.setSelectionMode(NORMAL);
        tableDev.setRowSelectionInterval(0, 0);
        refreshData(device.getFirst());
        Enabled(false);
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jspMR = new javax.swing.JScrollPane();
        tableMR = new javax.swing.JTable();
        jspKP = new javax.swing.JScrollPane();
        tableKP = new javax.swing.JTable();
        TypeL = new javax.swing.JLabel();
        Type = new javax.swing.JTextField();
        ChannelL = new javax.swing.JLabel();
        Channel = new javax.swing.JTextField();
        UDL = new javax.swing.JLabel();
        UD = new javax.swing.JTextField();
        PLL = new javax.swing.JLabel();
        PL = new javax.swing.JTextField();
        IC = new javax.swing.JTextField();
        ICL = new javax.swing.JLabel();
        UDLL = new javax.swing.JLabel();
        PLLL = new javax.swing.JLabel();
        ICLL = new javax.swing.JLabel();
        MRSpinner = new javax.swing.JSpinner();
        KPSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ListPanel = new javax.swing.JScrollPane();
        tableDev = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        modButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableMR.setModel(MRTM);
        jspMR.setViewportView(tableMR);

        tableKP.setModel(KPTM);
        tableKP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jspKP.setViewportView(tableKP);

        TypeL.setText("Тип СИ");

        Type.setText("jTextField1");

        ChannelL.setText("Канал");

        Channel.setText("jTextField1");

        UDL.setText("Усл. диам.");

        UD.setText("jTextField1");

        PLL.setText("Потеря давления");

        PL.setText("jTextField1");

        IC.setText("jTextField1");

        ICL.setText("Коэф. передачи");

        UDLL.setText("мм");

        PLLL.setText("Па");

        ICLL.setText("имп/м3");

        MRSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        MRSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MRSpinnerStateChanged(evt);
            }
        });

        KPSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        KPSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                KPSpinnerStateChanged(evt);
            }
        });

        jLabel1.setText("Контрольные точки");

        jLabel2.setText("Диапазон измерений");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jspKP, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TypeL)
                        .addGap(41, 41, 41)
                        .addComponent(Type))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ICL)
                            .addComponent(PLL)
                            .addComponent(UDL)
                            .addComponent(ChannelL))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Channel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IC, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UDLL)
                    .addComponent(PLLL)
                    .addComponent(ICLL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jspMR, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(KPSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
                .addComponent(MRSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TypeL)
                            .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ChannelL)
                            .addComponent(Channel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UDL)
                            .addComponent(UD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UDLL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PLL)
                            .addComponent(PL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PLLL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ICL)
                            .addComponent(IC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ICLL)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspKP, 0, 0, Short.MAX_VALUE)
                            .addComponent(jspMR, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MRSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        okButton.setText("Ок");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancel.setText("Отмена");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        tableDev.setModel(devTM);
        tableDev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDevMouseClicked(evt);
            }
        });
        ListPanel.setViewportView(tableDev);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
        );

        addButton.setText("Добавить");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        delButton.setText("Удалить");
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        modButton.setText("Изменить");
        modButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(addButton)
                .addGap(138, 138, 138)
                .addComponent(delButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(modButton)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(delButton)
                    .addComponent(modButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableDevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDevMouseClicked
        try {
            String type = (String) devTM.getValueAt(tableDev.getSelectedRow(), 0);
            int selection = tableDev.getSelectedRow();
            refreshData(type);
            tableDev.setRowSelectionInterval(selection, selection);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_tableDevMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Enabled(true);
        clearData();
    }//GEN-LAST:event_addButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        updateDev();
        device.save();
        tableDev.setRowSelectionInterval(0, 0);
        refreshData(device.getFirst());
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        tableDev.setRowSelectionInterval(0, 0);
        refreshData(device.getFirst());
        Enabled(false);
    }//GEN-LAST:event_cancelActionPerformed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        String type = (String) devTM.getValueAt(tableDev.getSelectedRow(), 0);
        device.delete(type);
    }//GEN-LAST:event_delButtonActionPerformed

    private void modButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modButtonActionPerformed
        Enabled(true);
    }//GEN-LAST:event_modButtonActionPerformed

    private void KPSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_KPSpinnerStateChanged
        String value = KPSpinner.getValue().toString();
        //System.out.println(value);
        KPTM.setMRRow(Integer.valueOf(value));
    }//GEN-LAST:event_KPSpinnerStateChanged

    private void MRSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MRSpinnerStateChanged
        String value = MRSpinner.getValue().toString();
        //System.out.println(value);
        MRTM.setMRRow(Integer.valueOf(value));
    }//GEN-LAST:event_MRSpinnerStateChanged

    public void refreshData(String type) {
        devTM.set();
        device.load(type);
        MRTM.reload(device.getMR());
        KPTM.reload(device.getKP());
        Type.setText(device.getType());
        Channel.setText(String.valueOf(device.getChannel()));
        UD.setText(String.valueOf(device.getUD()));
        PL.setText(String.valueOf(device.getPL()));
        IC.setText(String.valueOf(device.getIC()));
        KPSpinner.setValue(KPTM.getRowCount());
        MRSpinner.setValue(MRTM.getRowCount());
    }

    public void Enabled(Boolean value) {
        Type.setEnabled(value);
        Channel.setEnabled(value);
        UD.setEnabled(value);
        PL.setEnabled(value);
        IC.setEnabled(value);
        MRTM.setEdit(value);
        KPTM.setEdit(value);
        KPSpinner.setEnabled(value);
        MRSpinner.setEnabled(value);
    }

    public void clearData() {
        Channel.setText("");
        UD.setText("");
        PL.setText("");
        IC.setText("");
        MRTM.setMRRow(1);
        KPTM.setMRRow(1);
    }

    public void updateDev() {
        device.setType(Type.getText());
        device.setChannel(Integer.valueOf(Channel.getText()));
        device.setUD(Double.valueOf(UD.getText()));
        device.setPL(Double.valueOf(PL.getText()));
        device.setIC(Double.valueOf(IC.getText()));
        KPTM.updateData(device.getKP());
        MRTM.updateData(device.getMR());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EditCounters().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Channel;
    private javax.swing.JLabel ChannelL;
    private javax.swing.JTextField IC;
    private javax.swing.JLabel ICL;
    private javax.swing.JLabel ICLL;
    private javax.swing.JSpinner KPSpinner;
    private javax.swing.JScrollPane ListPanel;
    private javax.swing.JSpinner MRSpinner;
    private javax.swing.JTextField PL;
    private javax.swing.JLabel PLL;
    private javax.swing.JLabel PLLL;
    private javax.swing.JTextField Type;
    private javax.swing.JLabel TypeL;
    private javax.swing.JTextField UD;
    private javax.swing.JLabel UDL;
    private javax.swing.JLabel UDLL;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancel;
    private javax.swing.JButton delButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jspKP;
    private javax.swing.JScrollPane jspMR;
    private javax.swing.JButton modButton;
    private javax.swing.JButton okButton;
    private javax.swing.JTable tableDev;
    private javax.swing.JTable tableKP;
    private javax.swing.JTable tableMR;
    // End of variables declaration//GEN-END:variables
}
