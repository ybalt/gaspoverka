package gaspoverka;

import gaspoverka.table.*;
import gaspoverka.data.*;


public class Attestation extends javax.swing.JFrame {

    AttCalTM calTM;
    AttIzmTM izmTM;
    AttPovTM povTM;
    int device;
    Channel channel;

    public Attestation() {
        initComponents();
        channel = new Channel();
        //cal
        ch5.setSelected(true);
        channel.getChannelData(5);
        calTM = new AttCalTM();
        calTM.setData(channel.getPoints());
        calTable.setModel(calTM);
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

        bgChannel = new javax.swing.ButtonGroup();
        choosePanelCal1 = new javax.swing.JPanel();
        calcButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        dev1 = new javax.swing.JPanel();
        ch5 = new javax.swing.JRadioButton();
        ch6 = new javax.swing.JRadioButton();
        dev2 = new javax.swing.JPanel();
        ch7 = new javax.swing.JRadioButton();
        ch8 = new javax.swing.JRadioButton();
        dev3 = new javax.swing.JPanel();
        ch9 = new javax.swing.JRadioButton();
        ch10 = new javax.swing.JRadioButton();
        dev4 = new javax.swing.JPanel();
        ch11 = new javax.swing.JRadioButton();
        ch12 = new javax.swing.JRadioButton();
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

        calcButton.setText("Расчет");
        calcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcButtonCalActionPerformed(evt);
            }
        });

        saveButton.setText("Запись");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        newButton.setText("Новая");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        dev1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Эталон1"));

        bgChannel.add(ch5);
        ch5.setText("5 - Температура");
        ch5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch5ActionPerformed(evt);
            }
        });

        bgChannel.add(ch6);
        ch6.setText("6 - Давление");
        ch6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dev1Layout = new javax.swing.GroupLayout(dev1);
        dev1.setLayout(dev1Layout);
        dev1Layout.setHorizontalGroup(
            dev1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ch5)
            .addComponent(ch6)
        );
        dev1Layout.setVerticalGroup(
            dev1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dev1Layout.createSequentialGroup()
                .addComponent(ch5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ch6))
        );

        dev2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Эталон2"));

        bgChannel.add(ch7);
        ch7.setText("7 - Температура");

        bgChannel.add(ch8);
        ch8.setText("8 - Давление");

        javax.swing.GroupLayout dev2Layout = new javax.swing.GroupLayout(dev2);
        dev2.setLayout(dev2Layout);
        dev2Layout.setHorizontalGroup(
            dev2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ch7)
            .addComponent(ch8)
        );
        dev2Layout.setVerticalGroup(
            dev2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dev2Layout.createSequentialGroup()
                .addComponent(ch7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ch8))
        );

        dev3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Эталон3"));

        bgChannel.add(ch9);
        ch9.setText("9 - Температура");

        bgChannel.add(ch10);
        ch10.setText("10 - Давление");

        javax.swing.GroupLayout dev3Layout = new javax.swing.GroupLayout(dev3);
        dev3.setLayout(dev3Layout);
        dev3Layout.setHorizontalGroup(
            dev3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ch9)
            .addComponent(ch10)
        );
        dev3Layout.setVerticalGroup(
            dev3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dev3Layout.createSequentialGroup()
                .addComponent(ch9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ch10))
        );

        dev4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Счетчик"));

        bgChannel.add(ch11);
        ch11.setText("11 - Температура");

        bgChannel.add(ch12);
        ch12.setText("12 - Давление");

        javax.swing.GroupLayout dev4Layout = new javax.swing.GroupLayout(dev4);
        dev4.setLayout(dev4Layout);
        dev4Layout.setHorizontalGroup(
            dev4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ch11)
            .addComponent(ch12)
        );
        dev4Layout.setVerticalGroup(
            dev4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dev4Layout.createSequentialGroup()
                .addComponent(ch11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ch12))
        );

        javax.swing.GroupLayout choosePanelCal1Layout = new javax.swing.GroupLayout(choosePanelCal1);
        choosePanelCal1.setLayout(choosePanelCal1Layout);
        choosePanelCal1Layout.setHorizontalGroup(
            choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelCal1Layout.createSequentialGroup()
                .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCal1Layout.createSequentialGroup()
                        .addComponent(dev1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dev2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dev3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(choosePanelCal1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(calcButton)
                        .addGap(139, 139, 139)
                        .addComponent(saveButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCal1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dev4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        choosePanelCal1Layout.setVerticalGroup(
            choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelCal1Layout.createSequentialGroup()
                .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCal1Layout.createSequentialGroup()
                        .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dev1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dev2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dev3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(choosePanelCal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calcButton)
                            .addComponent(saveButton)))
                    .addGroup(choosePanelCal1Layout.createSequentialGroup()
                        .addComponent(dev4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        calTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        calTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        calTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calTableMouseClicked(evt);
            }
        });
        jspCal.setViewportView(calTable);

        ur1.setFont(new java.awt.Font("Tahoma", 0, 18));
        ur1.setText("xxxxxxxxxxxxxxxx");

        ur2.setFont(new java.awt.Font("Tahoma", 0, 18));
        ur2.setText("xxxxxxxxxxxxxxxx");

        jLabel5.setText("Уравнение 1:");

        jLabel6.setText("Уравнение 2:");

        javax.swing.GroupLayout AttCalLayout = new javax.swing.GroupLayout(AttCal);
        AttCal.setLayout(AttCalLayout);
        AttCalLayout.setHorizontalGroup(
            AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttCalLayout.createSequentialGroup()
                .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(ur1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jspCal, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jspIzm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
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
            .addComponent(jspPov, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
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
            .addComponent(jtP, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(choosePanelCal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(choosePanelCal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtP, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calTableMouseClicked
        String u1 = "y=x*"
                + channel.getPoints().get(calTable.getSelectedRow()).getK1()
                + "+"
                + channel.getPoints().get(calTable.getSelectedRow()).getB1();
        String u2 = "y=x*"
                + channel.getPoints().get(calTable.getSelectedRow()).getK2()
                + "+"
                + channel.getPoints().get(calTable.getSelectedRow()).getB2();

        ur1.setText(u1);
        ur2.setText(u2);
    }//GEN-LAST:event_calTableMouseClicked

    private void calcButtonCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonCalActionPerformed
        channel.calc();
}//GEN-LAST:event_calcButtonCalActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        izmTM.addRow();
    }//GEN-LAST:event_newButtonActionPerformed

    private void ch5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch5ActionPerformed
        channel.getChannelData(5);
        refresh();
    }//GEN-LAST:event_ch5ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        channel.save();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void ch6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch6ActionPerformed
        
    }//GEN-LAST:event_ch6ActionPerformed
    
    public void refresh() {
        calTM.setData(channel.getPoints());

    }

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
    private javax.swing.ButtonGroup bgChannel;
    private javax.swing.JTable calTable;
    private javax.swing.JButton calcButton;
    private javax.swing.JRadioButton ch10;
    private javax.swing.JRadioButton ch11;
    private javax.swing.JRadioButton ch12;
    private javax.swing.JRadioButton ch5;
    private javax.swing.JRadioButton ch6;
    private javax.swing.JRadioButton ch7;
    private javax.swing.JRadioButton ch8;
    private javax.swing.JRadioButton ch9;
    private javax.swing.JPanel choosePanelCal1;
    private javax.swing.JPanel dev1;
    private javax.swing.JPanel dev2;
    private javax.swing.JPanel dev3;
    private javax.swing.JPanel dev4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jspCal;
    private javax.swing.JScrollPane jspIzm;
    private javax.swing.JScrollPane jspPov;
    private javax.swing.JTabbedPane jtP;
    private javax.swing.JButton newButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable tableIzm;
    private javax.swing.JTable tablePov;
    private javax.swing.JLabel ur1;
    private javax.swing.JLabel ur2;
    // End of variables declaration//GEN-END:variables
}
