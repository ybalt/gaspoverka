package gaspoverka;

import gaspoverka.data.arch.Dev;
import gaspoverka.data.*;
import gaspoverka.data.result.Result;
import gaspoverka.table.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class PoverkaPov extends javax.swing.JFrame {

    Dev counter;
    Dev refrence;
    Result res;
    TTM MRTM;
    TTM KPTM;
    String[] KPnames = {"№", "Зн.Н", "Зн.В", "Погр."};
    String[] MRnames = {"№", "ДИ.Н", "ДИ.В", "Погр"};
    PovPovDataTM dataTM;
    DefPovTR dataTR;

    public PoverkaPov() {
        counter = new Dev();
        refrence = new Dev();
        res = new Result();
        MRTM = new TTM(counter.getMR(), MRnames);
        KPTM = new TTM(counter.getKP(), KPnames);
        dataTM = new PovPovDataTM(res);
        dataTR = new DefPovTR();

        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Измерение");

        try {
            dataTable.setDefaultRenderer(Class.forName("java.lang.Double"), dataTR);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        refreshData();
        dataTM.addRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataPanel = new javax.swing.JPanel();
        jspData = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        infoPanel = new javax.swing.JPanel();
        jspdevInfoKP = new javax.swing.JScrollPane();
        devInfoKP = new javax.swing.JTable();
        jspDevInfoMR = new javax.swing.JScrollPane();
        devInfoMR = new javax.swing.JTable();
        IC = new javax.swing.JTextField();
        ICL = new javax.swing.JLabel();
        PLL = new javax.swing.JLabel();
        UDL = new javax.swing.JLabel();
        PL = new javax.swing.JTextField();
        UD = new javax.swing.JTextField();
        owner = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        devnum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        devSelection = new javax.swing.JPanel();
        refPanel = new javax.swing.JPanel();
        refCB = new javax.swing.JComboBox();
        refPL = new javax.swing.JLabel();
        refP = new javax.swing.JTextField();
        refTL = new javax.swing.JLabel();
        refT = new javax.swing.JTextField();
        devPanel = new javax.swing.JPanel();
        devCB = new javax.swing.JComboBox();
        devPL = new javax.swing.JLabel();
        devP = new javax.swing.JTextField();
        devTL = new javax.swing.JLabel();
        devT = new javax.swing.JTextField();
        ctrlPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        RRL = new javax.swing.JLabel();
        RR = new javax.swing.JTextField();
        CVL = new javax.swing.JLabel();
        CV = new javax.swing.JTextField();
        calcButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dataTable.setModel(dataTM);
        jspData.setViewportView(dataTable);

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspData, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addContainerGap())
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );

        jspdevInfoKP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Контр. точки"));

        devInfoKP.setModel(KPTM);
        devInfoKP.getTableHeader().setResizingAllowed(false);
        devInfoKP.getTableHeader().setReorderingAllowed(false);
        jspdevInfoKP.setViewportView(devInfoKP);

        jspDevInfoMR.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Диапазоны"));

        devInfoMR.setModel(MRTM);
        jspDevInfoMR.setViewportView(devInfoMR);

        ICL.setText("Коэф. передачи");

        PLL.setText("Потеря давления");

        UDL.setText("Условный диаметр");

        jLabel1.setText("Владелец");

        jLabel2.setText("№");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jspDevInfoMR, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                                .addComponent(PLL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(PL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                                .addComponent(ICL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(IC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                                .addComponent(UDL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(jLabel1)
                            .addContainerGap())
                        .addGroup(infoPanelLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoPanelLayout.createSequentialGroup()
                                    .addComponent(owner, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addContainerGap())
                                .addComponent(jspdevInfoKP, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(devnum, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ICL)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PLL)
                    .addComponent(owner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(UD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UDL))
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(devnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspdevInfoKP, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(jspDevInfoMR, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
        );

        refPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Эталон"));

        refCB.setModel(new javax.swing.DefaultComboBoxModel(refrence.getRefList()));
        refCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refCBActionPerformed(evt);
            }
        });

        refPL.setText("Давл.");

        refTL.setText("Темп.");

        javax.swing.GroupLayout refPanelLayout = new javax.swing.GroupLayout(refPanel);
        refPanel.setLayout(refPanelLayout);
        refPanelLayout.setHorizontalGroup(
            refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(refPanelLayout.createSequentialGroup()
                        .addComponent(refPL)
                        .addGap(18, 18, 18)
                        .addComponent(refP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(refPanelLayout.createSequentialGroup()
                        .addComponent(refTL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
            .addComponent(refCB, 0, 120, Short.MAX_VALUE)
        );
        refPanelLayout.setVerticalGroup(
            refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refPanelLayout.createSequentialGroup()
                .addComponent(refCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refPL)
                    .addComponent(refP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refTL)
                    .addComponent(refT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        devPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Счетчик"));

        devCB.setModel(new javax.swing.DefaultComboBoxModel(refrence.getDevListByChannel(4)));
        devCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devCBActionPerformed(evt);
            }
        });

        devPL.setText("Давл.");

        devTL.setText("Темп.");

        javax.swing.GroupLayout devPanelLayout = new javax.swing.GroupLayout(devPanel);
        devPanel.setLayout(devPanelLayout);
        devPanelLayout.setHorizontalGroup(
            devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devPanelLayout.createSequentialGroup()
                .addGroup(devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(devPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(devPanelLayout.createSequentialGroup()
                                .addComponent(devPL)
                                .addGap(18, 18, 18)
                                .addComponent(devP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(devPanelLayout.createSequentialGroup()
                                .addComponent(devTL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(devT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(devCB, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        devPanelLayout.setVerticalGroup(
            devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devPanelLayout.createSequentialGroup()
                .addComponent(devCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(devPL)
                    .addComponent(devP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(devTL)
                    .addComponent(devT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        startButton.setText("Старт");

        stopButton.setText("Стоп");

        saveButton.setText("Запись");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        reportButton.setText("Отчет");
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        RRL.setText("Пер. вывода");

        CVL.setText("Контр. объем");

        calcButton.setText("Расчет");
        calcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ctrlPanelLayout = new javax.swing.GroupLayout(ctrlPanel);
        ctrlPanel.setLayout(ctrlPanelLayout);
        ctrlPanelLayout.setHorizontalGroup(
            ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctrlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ctrlPanelLayout.createSequentialGroup()
                        .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RRL)
                            .addComponent(CVL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CV)
                            .addComponent(RR, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
                    .addGroup(ctrlPanelLayout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calcButton)))
                .addContainerGap())
        );
        ctrlPanelLayout.setVerticalGroup(
            ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctrlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RRL)
                    .addComponent(RR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CVL)
                        .addComponent(CV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(stopButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveButton)
                        .addComponent(reportButton))
                    .addComponent(calcButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout devSelectionLayout = new javax.swing.GroupLayout(devSelection);
        devSelection.setLayout(devSelectionLayout);
        devSelectionLayout.setHorizontalGroup(
            devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(ctrlPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, devSelectionLayout.createSequentialGroup()
                    .addComponent(refPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(devPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        devSelectionLayout.setVerticalGroup(
            devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devSelectionLayout.createSequentialGroup()
                .addGroup(devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(devPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ctrlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dataPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(devSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(devSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refCBActionPerformed
        refreshData();
}//GEN-LAST:event_refCBActionPerformed

    private void devCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devCBActionPerformed
        refreshData();
}//GEN-LAST:event_devCBActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (owner.getText().equals("") ||
            devnum.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Сохранение невозможно - не заполнены обязатаельные поля");
            return;
        }
        res.setChannel(refrence.getChannel());
        res.setDevNum(devnum.getText());
        res.setOwner(owner.getText());
        res.setPovNum(res.getLastPovNum()+1);
        res.setType(counter.getType());
        
        res.save();
}//GEN-LAST:event_saveButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
}//GEN-LAST:event_reportButtonActionPerformed

    private void calcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonActionPerformed
        res.calc();
        dataTM.set();
}//GEN-LAST:event_calcButtonActionPerformed

    private void refreshData() {
        counter.load((String) devCB.getSelectedItem());
        UD.setText(String.valueOf(counter.getUD()));
        PL.setText(String.valueOf(counter.getPL()));
        IC.setText(String.valueOf(counter.getIC()));
        MRTM.refresh();
        KPTM.refresh();

        devP.setText("11");
        devT.setText("12");
        refrence.load((String) refCB.getSelectedItem());
        refP.setText(String.valueOf((refrence.getChannel()*2)+3));
        refT.setText(String.valueOf((refrence.getChannel()*2)+4));
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PoverkaPov().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CV;
    private javax.swing.JLabel CVL;
    private javax.swing.JTextField IC;
    private javax.swing.JLabel ICL;
    private javax.swing.JTextField PL;
    private javax.swing.JLabel PLL;
    private javax.swing.JTextField RR;
    private javax.swing.JLabel RRL;
    private javax.swing.JTextField UD;
    private javax.swing.JLabel UDL;
    private javax.swing.JButton calcButton;
    private javax.swing.JPanel ctrlPanel;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JTable dataTable;
    private javax.swing.JComboBox devCB;
    private javax.swing.JTable devInfoKP;
    private javax.swing.JTable devInfoMR;
    private javax.swing.JTextField devP;
    private javax.swing.JLabel devPL;
    private javax.swing.JPanel devPanel;
    private javax.swing.JPanel devSelection;
    private javax.swing.JTextField devT;
    private javax.swing.JLabel devTL;
    private javax.swing.JTextField devnum;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jspData;
    private javax.swing.JScrollPane jspDevInfoMR;
    private javax.swing.JScrollPane jspdevInfoKP;
    private javax.swing.JTextField owner;
    private javax.swing.JComboBox refCB;
    private javax.swing.JTextField refP;
    private javax.swing.JLabel refPL;
    private javax.swing.JPanel refPanel;
    private javax.swing.JTextField refT;
    private javax.swing.JLabel refTL;
    private javax.swing.JButton reportButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
