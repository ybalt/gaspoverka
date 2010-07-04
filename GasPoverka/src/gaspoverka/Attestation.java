package gaspoverka;

import gaspoverka.data.config.Channel;
import gaspoverka.table.*;

public class Attestation extends javax.swing.JFrame {

    AttCalTM calTM;
    AttIzmTM izmTM;
    AttPovTM povTM;
    int device;
    Channel channel;
    int value;

    public Attestation() {
        initComponents();
        channel = new Channel();
        //cal
        calTM = new AttCalTM();
        calTable.setModel(calTM);
        refresh();
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
        choosePanelCal = new javax.swing.JPanel();
        calcButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jsChannel = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        VL = new javax.swing.JLabel();
        RRL = new javax.swing.JLabel();
        MCL = new javax.swing.JLabel();
        V = new javax.swing.JTextField();
        RR = new javax.swing.JTextField();
        MC = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
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

        jsChannel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jsChannel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        jsChannel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsChannelStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Канал");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout choosePanelCalLayout = new javax.swing.GroupLayout(choosePanelCal);
        choosePanelCal.setLayout(choosePanelCalLayout);
        choosePanelCalLayout.setHorizontalGroup(
            choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelCalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1))
                    .addComponent(calcButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        choosePanelCalLayout.setVerticalGroup(
            choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelCalLayout.createSequentialGroup()
                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(calcButton))
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton)
                            .addComponent(newButton)))
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jsChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        AttCal.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                AttCalComponentShown(evt);
            }
        });

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
        calTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        calTable.setRowMargin(5);
        calTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        calTable.getTableHeader().setResizingAllowed(false);
        calTable.getTableHeader().setReorderingAllowed(false);
        calTable.setUpdateSelectionOnSort(false);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttCalLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AttCalLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ur2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AttCalLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ur1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(98, 98, 98))
            .addComponent(jspCal, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
        AttCalLayout.setVerticalGroup(
            AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttCalLayout.createSequentialGroup()
                .addComponent(jspCal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ur1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ur2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jtP.addTab("Калибровка", AttCal);

        AttIzm.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                AttIzmComponentShown(evt);
            }
        });

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

        VL.setText("Значение измеряемой величины");

        RRL.setText("Периодичность вывода");

        MCL.setText("Количество измерений в точке");

        startButton.setText("Старт");

        stopButton.setText("Стоп");

        javax.swing.GroupLayout AttIzmLayout = new javax.swing.GroupLayout(AttIzm);
        AttIzm.setLayout(AttIzmLayout);
        AttIzmLayout.setHorizontalGroup(
            AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspIzm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
            .addGroup(AttIzmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VL)
                    .addComponent(RRL)
                    .addComponent(MCL))
                .addGap(46, 46, 46)
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RR)
                    .addComponent(V)
                    .addComponent(MC, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        AttIzmLayout.setVerticalGroup(
            AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttIzmLayout.createSequentialGroup()
                .addComponent(jspIzm, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VL)
                    .addComponent(V, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RRL)
                    .addComponent(RR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MCL)
                    .addComponent(MC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopButton))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jtP.addTab("Измерение", AttIzm);

        AttPov.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                AttPovComponentShown(evt);
            }
        });

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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(choosePanelCal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(choosePanelCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtP, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calTableMouseClicked
        String u1 = "Y="
                + channel.getPoints().get(calTable.getSelectedRow()).getK1()
                + "*X";
        if (channel.getPoints().get(calTable.getSelectedRow()).getB1() >= 0) {
            u1 += "+" + channel.getPoints().get(calTable.getSelectedRow()).getB1();
        } else {
            u1 += channel.getPoints().get(calTable.getSelectedRow()).getB1();
        }
        String u2 = "Y="
                + channel.getPoints().get(calTable.getSelectedRow()).getK2()
                + "*X";
        if (channel.getPoints().get(calTable.getSelectedRow()).getB2() >= 0) {
            u2 += "+" + channel.getPoints().get(calTable.getSelectedRow()).getB2();
        } else {
            u2 += channel.getPoints().get(calTable.getSelectedRow()).getB2();
        }

        ur1.setText(u1);
        ur2.setText(u2);
    }//GEN-LAST:event_calTableMouseClicked

    private void calcButtonCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonCalActionPerformed
        channel.calcCalibrationData();
}//GEN-LAST:event_calcButtonCalActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        izmTM.addRow();
    }//GEN-LAST:event_newButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        channel.saveCalibrationData();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void AttCalComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AttCalComponentShown
        newButton.setEnabled(false);
    }//GEN-LAST:event_AttCalComponentShown

    private void AttIzmComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AttIzmComponentShown
        newButton.setEnabled(true);
    }//GEN-LAST:event_AttIzmComponentShown

    private void AttPovComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AttPovComponentShown
        newButton.setEnabled(false);
    }//GEN-LAST:event_AttPovComponentShown

    private void jsChannelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsChannelStateChanged
         refresh();
    }//GEN-LAST:event_jsChannelStateChanged

    public void refresh() {
        value = Integer.valueOf(jsChannel.getValue().toString());
        channel.loadCalibrationData(value);
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
    private javax.swing.JTextField MC;
    private javax.swing.JLabel MCL;
    private javax.swing.JTextField RR;
    private javax.swing.JLabel RRL;
    private javax.swing.JTextField V;
    private javax.swing.JLabel VL;
    private javax.swing.ButtonGroup bgChannel;
    private javax.swing.JTable calTable;
    private javax.swing.JButton calcButton;
    private javax.swing.JPanel choosePanelCal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner jsChannel;
    private javax.swing.JScrollPane jspCal;
    private javax.swing.JScrollPane jspIzm;
    private javax.swing.JScrollPane jspPov;
    private javax.swing.JTabbedPane jtP;
    private javax.swing.JButton newButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JTable tableIzm;
    private javax.swing.JTable tablePov;
    private javax.swing.JLabel ur1;
    private javax.swing.JLabel ur2;
    // End of variables declaration//GEN-END:variables
}
