package gaspoverka;

import gaspoverka.table.*;
import gaspoverka.data.*;
import java.lang.Object.*;
import java.util.Vector;

/**
 *
 * @author bes
 */
public class EditDev extends javax.swing.JFrame {

    Dev dev;
    Vector<Dev> devVector;
    DevTM devTM;
    TTM MRTM;
    TTM KPTM;
    String[] KPnames = {"№", "Зн.Н", "Зн.В", "Погр."};
    String[] MRnames = {"№", "ДИ.Н", "ДИ.В", "Погр"};

    public EditDev() {
        dev = new Dev();
        devVector = dev.getDevTable();

        devTM = new DevTM(devVector);
        MRTM = new TTM(devVector.get(0).getMR(), MRnames);
        KPTM = new TTM(devVector.get(0).getKP(), KPnames);

        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Поверяемые СИ");

        tableDev.setSelectionMode(NORMAL);
        tableDev.setRowSelectionInterval(0, 0);
        reloadDevData();
        enableEdit(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        devInfoPanel = new javax.swing.JPanel();
        jspMR = new javax.swing.JScrollPane();
        tableMR = new javax.swing.JTable();
        jspKP = new javax.swing.JScrollPane();
        tableKP = new javax.swing.JTable();
        MRSpinner = new javax.swing.JSpinner();
        KPSpinner = new javax.swing.JSpinner();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        modButton = new javax.swing.JButton();
        devListPanel = new javax.swing.JScrollPane();
        tableDev = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jspMR.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Диапазоны измерения"));

        tableMR.setModel(MRTM);
        jspMR.setViewportView(tableMR);

        jspKP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Контрольные точки"));

        tableKP.setModel(KPTM);
        tableKP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jspKP.setViewportView(tableKP);

        MRSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        MRSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MRSpinnerStateChanged(evt);
            }
        });

        KPSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        KPSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                KPSpinnerStateChanged(evt);
            }
        });

        okButton.setText("Ок");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Отмена");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout devInfoPanelLayout = new javax.swing.GroupLayout(devInfoPanel);
        devInfoPanel.setLayout(devInfoPanelLayout);
        devInfoPanelLayout.setHorizontalGroup(
            devInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspKP, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(devInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(devInfoPanelLayout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, devInfoPanelLayout.createSequentialGroup()
                        .addComponent(KPSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(devInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(modButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MRSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addComponent(jspMR, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        devInfoPanelLayout.setVerticalGroup(
            devInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(devInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(devInfoPanelLayout.createSequentialGroup()
                        .addGroup(devInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(KPSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MRSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton))
                        .addGap(18, 18, 18)
                        .addComponent(delButton)
                        .addGap(18, 18, 18)
                        .addComponent(modButton)
                        .addGap(31, 31, 31)
                        .addGroup(devInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton)
                            .addComponent(cancelButton)))
                    .addComponent(jspKP, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jspMR, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tableDev.setModel(devTM);
        tableDev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDevMouseClicked(evt);
            }
        });
        devListPanel.setViewportView(tableDev);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(devListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(devInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(devInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(devListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableDevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDevMouseClicked
        if (devTM.getRowEdit()==-1) {
        reloadDevData();}
    }//GEN-LAST:event_tableDevMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        enableEdit(true);
        devVector.add(new Dev());
        devTM.fireTableChanged(null);
        MRTM.setDev(devVector.lastElement().getMR());
        MRSpinner.setValue(new Integer(0));
        
        KPTM.setDev(devVector.lastElement().getKP());
        KPSpinner.setValue(new Integer(0));

        tableDev.setRowSelectionInterval(devVector.size()-1,devVector.size()-1);
        devTM.setRowEdit(devVector.size()-1);
    }//GEN-LAST:event_addButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        devVector.get(devTM.getRowEdit()).save();
        devTM.setRowEdit(-1);
        enableEdit(false);
        refreshDevTable();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        tableDev.setRowSelectionInterval(0, 0);
        devTM.setRowEdit(-1);
        enableEdit(false);
        refreshDevTable();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        devVector.get(tableDev.getSelectedRow()).delete();
        refreshDevTable();
    }//GEN-LAST:event_delButtonActionPerformed

    private void modButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modButtonActionPerformed
        enableEdit(true);
        devTM.setRowEdit(tableDev.getSelectedRow());
    }//GEN-LAST:event_modButtonActionPerformed

    private void KPSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_KPSpinnerStateChanged
        int value = Integer.valueOf(KPSpinner.getValue().toString());
        KPTM.setRow(value);


    }//GEN-LAST:event_KPSpinnerStateChanged

    private void MRSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MRSpinnerStateChanged
        int value = Integer.valueOf(MRSpinner.getValue().toString());
        MRTM.setRow(value);


    }//GEN-LAST:event_MRSpinnerStateChanged

    public void refreshDevTable() {
        devVector = dev.getDevTable();
        devTM.refresh(devVector);
        tableDev.setRowSelectionInterval(0, 0);
        reloadDevData();
    }

    public void reloadDevData() {
        if (tableDev.getSelectedRow() >= 0) {
            String type = (String) devTM.getValueAt(tableDev.getSelectedRow(), 0);
            int number = tableDev.getSelectedRow();
            devVector.get(number).load(type);
            MRTM.setDev(devVector.get(number).getMR());
            KPTM.setDev(devVector.get(number).getKP());
            KPSpinner.setValue(KPTM.getRowCount());
            MRSpinner.setValue(MRTM.getRowCount());
        }
    }

    public void enableEdit(Boolean value) {
        tableKP.setEnabled(value);
        tableMR.setEnabled(value);

        MRTM.setEdit(value);
        KPTM.setEdit(value);

        KPSpinner.setEnabled(value);
        MRSpinner.setEnabled(value);

        okButton.setEnabled(value);
        cancelButton.setEnabled(value);

        addButton.setEnabled(!value);
        delButton.setEnabled(!value);
        modButton.setEnabled(!value);

    }

    public void clearData() {

    }

    public void updateDev() {
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new EditDev().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner KPSpinner;
    private javax.swing.JSpinner MRSpinner;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton delButton;
    private javax.swing.JPanel devInfoPanel;
    private javax.swing.JScrollPane devListPanel;
    private javax.swing.JScrollPane jspKP;
    private javax.swing.JScrollPane jspMR;
    private javax.swing.JButton modButton;
    private javax.swing.JButton okButton;
    private javax.swing.JTable tableDev;
    private javax.swing.JTable tableKP;
    private javax.swing.JTable tableMR;
    // End of variables declaration//GEN-END:variables
}
