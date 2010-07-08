package gaspoverka;

import gaspoverka.data.arch.Dev;
import gaspoverka.data.result.*;
import gaspoverka.table.*;

import javax.swing.table.*;

public class PoverkaIzm extends javax.swing.JFrame {

    Dev counter;
    Dev refrence;

    Result res;

    TTM MRTM;
    TTM KPTM;
    String[] KPnames = {"№", "Зн.Н", "Зн.В", "Погр."};
    String[] MRnames = {"№", "ДИ.Н", "ДИ.В", "Погр"};
    PovIzmDataTM dataTM;
    DefIzmTR dataTR;

    public PoverkaIzm() {
        counter = new Dev();
        refrence = new Dev();
        MRTM = new TTM(counter.getMR(), MRnames);
        KPTM = new TTM(counter.getKP(), KPnames);
        res = new Result();

        dataTM = new PovIzmDataTM(res);
        dataTR = new DefIzmTR();
        
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Измерение");
        
        try {
            dataTable.setDefaultRenderer(Class.forName("java.lang.Double"), dataTR);
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        }

        refreshData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataPanel = new javax.swing.JPanel();
        jspData = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        devSelection = new javax.swing.JPanel();
        refPanel = new javax.swing.JPanel();
        refCB = new javax.swing.JComboBox();
        refPL = new javax.swing.JLabel();
        refP = new javax.swing.JTextField();
        refTL = new javax.swing.JLabel();
        refT = new javax.swing.JTextField();
        refUseCalP = new javax.swing.JCheckBox();
        refUseCalT = new javax.swing.JCheckBox();
        devPanel = new javax.swing.JPanel();
        devCB = new javax.swing.JComboBox();
        devPL = new javax.swing.JLabel();
        devP = new javax.swing.JTextField();
        devTL = new javax.swing.JLabel();
        devT = new javax.swing.JTextField();
        devUseCalP = new javax.swing.JCheckBox();
        devUseCalT = new javax.swing.JCheckBox();
        ctrlPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        newIzmButton = new javax.swing.JButton();
        delIzmButton = new javax.swing.JButton();
        flushIzmButton = new javax.swing.JButton();
        RRL = new javax.swing.JLabel();
        RR = new javax.swing.JTextField();
        CVL = new javax.swing.JLabel();
        CV = new javax.swing.JTextField();
        calcButton = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        dataTable.setModel(dataTM);
        jspData.setViewportView(dataTable);

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspData, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
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

        refUseCalP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refUseCalPActionPerformed(evt);
            }
        });

        refUseCalT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refUseCalTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout refPanelLayout = new javax.swing.GroupLayout(refPanel);
        refPanel.setLayout(refPanelLayout);
        refPanelLayout.setHorizontalGroup(
            refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(refPanelLayout.createSequentialGroup()
                        .addComponent(refPL)
                        .addGap(18, 18, 18)
                        .addComponent(refP, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(refPanelLayout.createSequentialGroup()
                        .addComponent(refTL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refT)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refUseCalP)
                    .addComponent(refUseCalT))
                .addGap(14, 14, 14))
            .addComponent(refCB, 0, 120, Short.MAX_VALUE)
        );
        refPanelLayout.setVerticalGroup(
            refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refPanelLayout.createSequentialGroup()
                .addComponent(refCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(refPL)
                        .addComponent(refP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refUseCalP))
                .addGap(5, 5, 5)
                .addGroup(refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(refTL)
                        .addComponent(refT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refUseCalT)))
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
                        .addGroup(devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(devPanelLayout.createSequentialGroup()
                                .addComponent(devPL)
                                .addGap(18, 18, 18)
                                .addComponent(devP, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(devPanelLayout.createSequentialGroup()
                                .addComponent(devTL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(devT)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(devUseCalT)
                            .addComponent(devUseCalP)))
                    .addComponent(devCB, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        devPanelLayout.setVerticalGroup(
            devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devPanelLayout.createSequentialGroup()
                .addComponent(devCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(devPL)
                        .addComponent(devP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(devUseCalP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(devUseCalT)
                    .addGroup(devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(devTL)
                        .addComponent(devT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        startButton.setText("Старт");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Стоп");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        newIzmButton.setText("Новое");
        newIzmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newIzmButtonActionPerformed(evt);
            }
        });

        delIzmButton.setText("Удалить");
        delIzmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delIzmButtonActionPerformed(evt);
            }
        });

        flushIzmButton.setText("C");
        flushIzmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flushIzmButtonActionPerformed(evt);
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
                        .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RRL)
                            .addComponent(CVL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CV, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(RR, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                    .addGroup(ctrlPanelLayout.createSequentialGroup()
                        .addComponent(newIzmButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delIzmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calcButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(flushIzmButton)))
                .addContainerGap())
        );
        ctrlPanelLayout.setVerticalGroup(
            ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctrlPanelLayout.createSequentialGroup()
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton)
                    .addComponent(RRL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopButton)
                    .addComponent(CVL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newIzmButton)
                    .addComponent(delIzmButton)
                    .addComponent(calcButton)
                    .addComponent(flushIzmButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout devSelectionLayout = new javax.swing.GroupLayout(devSelection);
        devSelection.setLayout(devSelectionLayout);
        devSelectionLayout.setHorizontalGroup(
            devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devSelectionLayout.createSequentialGroup()
                .addComponent(refPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(devPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(devSelectionLayout.createSequentialGroup()
                .addComponent(ctrlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        devSelectionLayout.setVerticalGroup(
            devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devSelectionLayout.createSequentialGroup()
                .addGroup(devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(devPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ctrlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspdevInfoKP, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ICL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PLL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UDL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspdevInfoKP, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jspDevInfoMR, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(devSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(devSelection, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void devCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devCBActionPerformed
        refreshData();
    }//GEN-LAST:event_devCBActionPerformed

    private void refCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refCBActionPerformed
        refreshData();
    }//GEN-LAST:event_refCBActionPerformed

    private void calcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonActionPerformed
        res.calc();
        dataTM.set();
    }//GEN-LAST:event_calcButtonActionPerformed

    private void flushIzmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flushIzmButtonActionPerformed
        dataTM.flush();
}//GEN-LAST:event_flushIzmButtonActionPerformed

    private void delIzmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delIzmButtonActionPerformed
        dataTM.delRow();
}//GEN-LAST:event_delIzmButtonActionPerformed

    private void newIzmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newIzmButtonActionPerformed
        dataTM.addRow();
}//GEN-LAST:event_newIzmButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stopButtonActionPerformed

    private void refUseCalPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refUseCalPActionPerformed
        res.setRP(Integer.parseInt(refP.getText()), refUseCalP.isSelected());
    }//GEN-LAST:event_refUseCalPActionPerformed

    private void refUseCalTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refUseCalTActionPerformed
        res.setRT(Integer.parseInt(refT.getText()), refUseCalT.isSelected());
    }//GEN-LAST:event_refUseCalTActionPerformed

    private void refreshData() {

        counter.loadDevByType((String) devCB.getSelectedItem());
        UD.setText(String.valueOf(counter.getUD()));
        PL.setText(String.valueOf(counter.getPL()));
        IC.setText(String.valueOf(counter.getIC()));
        MRTM.setDev(counter.getMR());
        KPTM.setDev(counter.getKP());
        devP.setText("11");
        devT.setText("12");

        refrence.loadDevByType((String) refCB.getSelectedItem());
        //default values
        refP.setText(String.valueOf((refrence.getChannelV()*2)+3));
        refT.setText(String.valueOf((refrence.getChannelV()*2)+4));

}

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PoverkaIzm().setVisible(true);
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
    private javax.swing.JButton delIzmButton;
    private javax.swing.JComboBox devCB;
    private javax.swing.JTable devInfoKP;
    private javax.swing.JTable devInfoMR;
    private javax.swing.JTextField devP;
    private javax.swing.JLabel devPL;
    private javax.swing.JPanel devPanel;
    private javax.swing.JPanel devSelection;
    private javax.swing.JTextField devT;
    private javax.swing.JLabel devTL;
    private javax.swing.JCheckBox devUseCalP;
    private javax.swing.JCheckBox devUseCalT;
    private javax.swing.JButton flushIzmButton;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane jspData;
    private javax.swing.JScrollPane jspDevInfoMR;
    private javax.swing.JScrollPane jspdevInfoKP;
    private javax.swing.JButton newIzmButton;
    private javax.swing.JComboBox refCB;
    private javax.swing.JTextField refP;
    private javax.swing.JLabel refPL;
    private javax.swing.JPanel refPanel;
    private javax.swing.JTextField refT;
    private javax.swing.JLabel refTL;
    private javax.swing.JCheckBox refUseCalP;
    private javax.swing.JCheckBox refUseCalT;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
