package gaspoverka;

import gaspoverka.table.*;


public class Attestation extends javax.swing.JFrame {

    AttCalTM calTM;
    AttIzmTM izmTM;
    AttPovTM povTM;
    int device;

    public Attestation() {
        initComponents();

        //cal
        device = 1;
        rbDev1.setSelected(true);
        temp.setSelected(true);
        calTM = new AttCalTM();
        calTable.setModel(calTM);
        tempActionPerformed(null);
        //izm
       izmTM = new AttIzmTM();
        tableIzm.setModel(izmTM);
        //pov
        povTM = new AttPovTM();
        povTM.setRow();
        tablePov.setModel(povTM);


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSensor = new javax.swing.ButtonGroup();
        bgDevice = new javax.swing.ButtonGroup();
        choosePanelCal1 = new javax.swing.JPanel();
        press = new javax.swing.JRadioButton();
        temp = new javax.swing.JRadioButton();
        calcButton = new javax.swing.JButton();
        rbDev1 = new javax.swing.JRadioButton();
        rbDev2 = new javax.swing.JRadioButton();
        rbDev3 = new javax.swing.JRadioButton();
        rbDev4 = new javax.swing.JRadioButton();
        saveButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        channel = new javax.swing.JTextField();
        newButton = new javax.swing.JButton();
        jtP = new javax.swing.JTabbedPane();
        AttCal = new javax.swing.JPanel();
        jspCal = new javax.swing.JScrollPane();
        calTable = new javax.swing.JTable();
        ur1 = new javax.swing.JLabel();
        ur2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AttIzm = new javax.swing.JPanel();
        jspIzm = new javax.swing.JScrollPane();
        tableIzm = new javax.swing.JTable();
        AttPov = new javax.swing.JPanel();
        jspPov = new javax.swing.JScrollPane();
        tablePov = new javax.swing.JTable();

        setTitle("Аттестация установки");
        setResizable(false);

        bgSensor.add(press);
        press.setText("Давление");
        press.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressActionPerformed(evt);
            }
        });

        bgSensor.add(temp);
        temp.setText("Температура");
        temp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempActionPerformed(evt);
            }
        });

        calcButton.setText("Расчет");
        calcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcButtonCalActionPerformed(evt);
            }
        });

        bgDevice.add(rbDev1);
        rbDev1.setText("Эталон1");
        rbDev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDev1CalActionPerformed(evt);
            }
        });

        bgDevice.add(rbDev2);
        rbDev2.setText("Эталон2");
        rbDev2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDev2CalActionPerformed(evt);
            }
        });

        bgDevice.add(rbDev3);
        rbDev3.setText("Эталон3");
        rbDev3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDev3CalActionPerformed(evt);
            }
        });

        bgDevice.add(rbDev4);
        rbDev4.setText("Поверяемый");
        rbDev4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDev4CalActionPerformed(evt);
            }
        });

        saveButton.setText("Запись");

        jLabel2.setText("канал");

        channel.setEditable(false);

        newButton.setText("Новая");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout choosePanelCal1Layout = new javax.swing.GroupLayout(choosePanelCal1);
        choosePanelCal1.setLayout(choosePanelCal1Layout);
        choosePanelCal1Layout.setHorizontalGroup(
            choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelCal1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCal1Layout.createSequentialGroup()
                        .addComponent(rbDev1)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2))
                    .addGroup(choosePanelCal1Layout.createSequentialGroup()
                        .addComponent(rbDev2)
                        .addGap(41, 41, 41)
                        .addComponent(channel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(choosePanelCal1Layout.createSequentialGroup()
                        .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbDev4)
                            .addComponent(rbDev3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(temp)
                            .addComponent(press))))
                .addGap(30, 30, 30)
                .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(choosePanelCal1Layout.createSequentialGroup()
                        .addComponent(calcButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveButton))
                    .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        choosePanelCal1Layout.setVerticalGroup(
            choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelCal1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCal1Layout.createSequentialGroup()
                        .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbDev1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbDev2)
                            .addComponent(channel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbDev3)
                            .addComponent(temp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbDev4)
                            .addComponent(press)))
                    .addGroup(choosePanelCal1Layout.createSequentialGroup()
                        .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calcButton)
                            .addComponent(saveButton))
                        .addGap(18, 18, 18)
                        .addComponent(newButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        calTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        calTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calTableMouseClicked(evt);
            }
        });
        jspCal.setViewportView(calTable);

        ur1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ur1.setText("xxxxxxxxxxxxxxxx");

        ur2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ur2.setText("xxxxxxxxxxxxxxxx");

        jLabel5.setText("Уравнение 1:");

        jLabel6.setText("Уравнение 2:");

        javax.swing.GroupLayout AttCalLayout = new javax.swing.GroupLayout(AttCal);
        AttCal.setLayout(AttCalLayout);
        AttCalLayout.setHorizontalGroup(
            AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspCal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
            .addGroup(AttCalLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AttCalLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ur2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AttCalLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ur1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        AttCalLayout.setVerticalGroup(
            AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttCalLayout.createSequentialGroup()
                .addComponent(jspCal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ur1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ur2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jtP.addTab("Калибровка", AttCal);

        tableIzm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableIzm.getTableHeader().setResizingAllowed(false);
        tableIzm.getTableHeader().setReorderingAllowed(false);
        jspIzm.setViewportView(tableIzm);

        javax.swing.GroupLayout AttIzmLayout = new javax.swing.GroupLayout(AttIzm);
        AttIzm.setLayout(AttIzmLayout);
        AttIzmLayout.setHorizontalGroup(
            AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspIzm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );
        AttIzmLayout.setVerticalGroup(
            AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttIzmLayout.createSequentialGroup()
                .addComponent(jspIzm, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jtP.addTab("Измерение", AttIzm);

        tablePov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePov.getTableHeader().setResizingAllowed(false);
        tablePov.getTableHeader().setReorderingAllowed(false);
        jspPov.setViewportView(tablePov);

        javax.swing.GroupLayout AttPovLayout = new javax.swing.GroupLayout(AttPov);
        AttPov.setLayout(AttPovLayout);
        AttPovLayout.setHorizontalGroup(
            AttPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspPov, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );
        AttPovLayout.setVerticalGroup(
            AttPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspPov, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        jtP.addTab("Поверка", AttPov);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choosePanelCal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jtP, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(choosePanelCal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtP, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calTableMouseClicked
        int selection = calTable.getSelectedRow();
        ur1.setText(calTM.ur1(selection));
        ur2.setText(calTM.ur2(selection));

    }//GEN-LAST:event_calTableMouseClicked

    private void rbDev4CalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDev4CalActionPerformed
        device = 4;
        temp.setSelected(true);
        tempActionPerformed(null);
}//GEN-LAST:event_rbDev4CalActionPerformed

    private void rbDev3CalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDev3CalActionPerformed
        device = 3;
        temp.setSelected(true);
        tempActionPerformed(null);
}//GEN-LAST:event_rbDev3CalActionPerformed


    private void rbDev2CalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDev2CalActionPerformed
        device = 2;
        temp.setSelected(true);
        tempActionPerformed(null);
}//GEN-LAST:event_rbDev2CalActionPerformed

    private void rbDev1CalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDev1CalActionPerformed
        device = 1;
        temp.setSelected(true);
        tempActionPerformed(null);
}//GEN-LAST:event_rbDev1CalActionPerformed


    private void pressureCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pressureCalActionPerformed
        calTM.setRows(5, "кПа");
       
    }//GEN-LAST:event_pressureCalActionPerformed

    private void temperatureCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperatureCalActionPerformed
        calTM.setRows(6, "С°");
       

    }//GEN-LAST:event_temperatureCalActionPerformed


    private void calcButtonCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonCalActionPerformed
        calTM.set();
        calTable.setRowSelectionInterval(0, 0);
        calTableMouseClicked(null);

        izmTM.set();

        povTM.set();
}//GEN-LAST:event_calcButtonCalActionPerformed

    private void tempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempActionPerformed
        calTM.setRows(6, "С°");
        channel.setText(String.valueOf((device*2)+4));
    }//GEN-LAST:event_tempActionPerformed

    private void pressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pressActionPerformed
         calTM.setRows(5, "кПа");
         channel.setText(String.valueOf((device*2)+3));
    }//GEN-LAST:event_pressActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        izmTM.addRow();
    }//GEN-LAST:event_newButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Attestation().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AttCal;
    private javax.swing.JPanel AttIzm;
    private javax.swing.JPanel AttPov;
    private javax.swing.ButtonGroup bgDevice;
    private javax.swing.ButtonGroup bgSensor;
    private javax.swing.JTable calTable;
    private javax.swing.JButton calcButton;
    private javax.swing.JButton calcButtonCal;
    private javax.swing.JButton calcButtonPov;
    private javax.swing.JButton calcButtonPov1;
    private javax.swing.JTextField channel;
    private javax.swing.JTextField channelCal;
    private javax.swing.JTextField channelPov;
    private javax.swing.JTextField channelPov1;
    private javax.swing.JPanel choosePanelCal;
    private javax.swing.JPanel choosePanelCal1;
    private javax.swing.JPanel choosePanelPov;
    private javax.swing.JPanel choosePanelPov1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jspCal;
    private javax.swing.JScrollPane jspIzm;
    private javax.swing.JScrollPane jspPov;
    private javax.swing.JTabbedPane jtP;
    private javax.swing.JButton newButton;
    private javax.swing.JRadioButton press;
    private javax.swing.JRadioButton pressureCal;
    private javax.swing.JRadioButton pressurePov;
    private javax.swing.JRadioButton pressurePov1;
    private javax.swing.JRadioButton rbDev1;
    private javax.swing.JRadioButton rbDev1Cal;
    private javax.swing.JRadioButton rbDev1Pov;
    private javax.swing.JRadioButton rbDev1Pov1;
    private javax.swing.JRadioButton rbDev2;
    private javax.swing.JRadioButton rbDev2Cal;
    private javax.swing.JRadioButton rbDev2Pov;
    private javax.swing.JRadioButton rbDev2Pov1;
    private javax.swing.JRadioButton rbDev3;
    private javax.swing.JRadioButton rbDev3Cal;
    private javax.swing.JRadioButton rbDev3Pov;
    private javax.swing.JRadioButton rbDev3Pov1;
    private javax.swing.JRadioButton rbDev4;
    private javax.swing.JRadioButton rbDev4Cal;
    private javax.swing.JRadioButton rbDev4Pov;
    private javax.swing.JRadioButton rbDev4Pov1;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton saveButtonCal;
    private javax.swing.JButton saveButtonPov;
    private javax.swing.JButton saveButtonPov1;
    private javax.swing.JTable tableIzm;
    private javax.swing.JTable tablePov;
    private javax.swing.JRadioButton temp;
    private javax.swing.JRadioButton temperatureCal;
    private javax.swing.JRadioButton temperaturePov;
    private javax.swing.JRadioButton temperaturePov1;
    private javax.swing.JLabel ur1;
    private javax.swing.JLabel ur2;
    // End of variables declaration//GEN-END:variables
}
