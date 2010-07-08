package gaspoverka;

import gaspoverka.data.arch.Dev;
import gaspoverka.data.config.Point;
import gaspoverka.data.result.Ver;
import gaspoverka.table.*;
import java.util.Vector;

public class Attestation extends javax.swing.JFrame {

    AttCalTM calTM;
    AttIzmTM izmTM;
    AttPovTM povTM;
    Dev device;
    int channel;
    Vector<Point> cal_data;
    Ver results;


    public Attestation() {
        initComponents();
        device = new Dev();
        channel = 1;
        device.loadDevByChannel(channel);
        device.loadCalibrationData();
        cal_data = device.getCalibration_dataV();

        //cal
        calTM = new AttCalTM();
        calTable.setModel(calTM);
        //izm
        results = new Ver();
        izmTM = new AttIzmTM(results);
        tableIzm.setModel(izmTM);
        //pov
        povTM = new AttPovTM();
        povTM.setRow();
        tablePov.setModel(povTM);

        refresh();


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
        lType = new javax.swing.JLabel();
        rbDev = new javax.swing.JRadioButton();
        rbPress = new javax.swing.JRadioButton();
        rbTemp = new javax.swing.JRadioButton();
        clearButton = new javax.swing.JButton();
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

        jsChannel.setFont(new java.awt.Font("Tahoma", 1, 36));
        jsChannel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));
        jsChannel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jsChannel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsChannelStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Канал");

        lType.setFont(new java.awt.Font("Tahoma", 1, 18));

        bgChannel.add(rbDev);
        rbDev.setSelected(true);
        rbDev.setText("Счетчик");
        rbDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDevActionPerformed(evt);
            }
        });

        bgChannel.add(rbPress);
        rbPress.setText("Давление");
        rbPress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPressActionPerformed(evt);
            }
        });

        bgChannel.add(rbTemp);
        rbTemp.setText("Температура");
        rbTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTempActionPerformed(evt);
            }
        });

        clearButton.setText("Сброс");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout choosePanelCalLayout = new javax.swing.GroupLayout(choosePanelCal);
        choosePanelCal.setLayout(choosePanelCalLayout);
        choosePanelCalLayout.setHorizontalGroup(
            choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelCalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(clearButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calcButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDev)
                    .addComponent(rbPress)
                    .addComponent(rbTemp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        choosePanelCalLayout.setVerticalGroup(
            choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelCalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addComponent(rbDev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbPress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbTemp))
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addComponent(lType, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(saveButton)
                                .addComponent(newButton))
                            .addComponent(calcButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton))
                    .addComponent(jsChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(6, Short.MAX_VALUE))
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
        calTable.setCellSelectionEnabled(true);
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
            .addComponent(jspCal, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttCalLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AttCalLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ur2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AttCalLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ur1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(77, 77, 77))
        );
        AttCalLayout.setVerticalGroup(
            AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttCalLayout.createSequentialGroup()
                .addComponent(jspCal, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ur1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ur2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
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
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Стоп");

        javax.swing.GroupLayout AttIzmLayout = new javax.swing.GroupLayout(AttIzm);
        AttIzm.setLayout(AttIzmLayout);
        AttIzmLayout.setHorizontalGroup(
            AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspIzm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
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
                .addContainerGap(131, Short.MAX_VALUE))
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
            .addComponent(jspPov, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );
        AttPovLayout.setVerticalGroup(
            AttPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspPov, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );

        jtP.addTab("Поверка", AttPov);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtP, 0, 0, Short.MAX_VALUE)
            .addComponent(choosePanelCal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(choosePanelCal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtP, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calTableMouseClicked
        Vector<Point> data = null;

        if (rbDev.isSelected()) {
            data = device.getCalibration_dataV();
        }
        if (rbPress.isSelected()) {
            data = device.getCalibration_dataP();
        }
        if (rbTemp.isSelected()) {
            data = device.getCalibration_dataT();
        }

        int row = calTable.getSelectedRow();
        System.out.println(row);
        if (data != null) {
            String u1 = "Y="
                    + data.get(row).getK1()
                    + "*X";
            if (data.get(row).getB1() >= 0) {
                u1 += "+" + data.get(row).getB1();
            } else {
                u1 += data.get(row).getB1();
            }
            String u2 = "Y="
                    + data.get(row).getK2()
                    + "*X";
            if (data.get(row).getB2() >= 0) {
                u2 += "+" + data.get(row).getB2();
            } else {
                u2 += data.get(row).getB2();
            }

            ur1.setText(u1);
            ur2.setText(u2);
        }
    }//GEN-LAST:event_calTableMouseClicked

    private void calcButtonCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonCalActionPerformed
         if (AttCal.isVisible()) {
            device.calcCalibrationData();
         }
         if (AttIzm.isVisible()) {
             results.set();
             izmTM.set();
         }
         if (AttPov.isVisible()) {
             povTM.set();
         }

}//GEN-LAST:event_calcButtonCalActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        if (AttCal.isVisible()) {
            calTM.addRow();
        }
        if (AttIzm.isVisible()) {
            izmTM.addRow();
        }
    }//GEN-LAST:event_newButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        device.saveCalibrationData();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void AttCalComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AttCalComponentShown
        newButton.setEnabled(true);
    }//GEN-LAST:event_AttCalComponentShown

    private void AttIzmComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AttIzmComponentShown
        newButton.setEnabled(true);
    }//GEN-LAST:event_AttIzmComponentShown

    private void AttPovComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AttPovComponentShown
        newButton.setEnabled(false);
    }//GEN-LAST:event_AttPovComponentShown

    private void jsChannelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsChannelStateChanged
        channel = Integer.valueOf(jsChannel.getValue().toString());
        device.loadDevByChannel(channel);
        device.loadCalibrationData();
        refresh();
    }//GEN-LAST:event_jsChannelStateChanged

    private void rbDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDevActionPerformed
        cal_data = device.getCalibration_dataV();
        refresh();
    }//GEN-LAST:event_rbDevActionPerformed

    private void rbPressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPressActionPerformed
        cal_data = device.getCalibration_dataP();
        refresh();
    }//GEN-LAST:event_rbPressActionPerformed

    private void rbTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTempActionPerformed
        cal_data = device.getCalibration_dataT();
        refresh();
    }//GEN-LAST:event_rbTempActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        if (AttCal.isVisible()) {
            calTM.clear();
        }
        if (AttIzm.isVisible()) {
            izmTM.clear();
        }
    }//GEN-LAST:event_clearButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed

    public void refresh() {
        if (channel == 4) {
            lType.setText("проверяемый счетчик");
        } else {
            lType.setText(device.getType());
        }
        calTM.setData(cal_data);
       
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
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner jsChannel;
    private javax.swing.JScrollPane jspCal;
    private javax.swing.JScrollPane jspIzm;
    private javax.swing.JScrollPane jspPov;
    private javax.swing.JTabbedPane jtP;
    private javax.swing.JLabel lType;
    private javax.swing.JButton newButton;
    private javax.swing.JRadioButton rbDev;
    private javax.swing.JRadioButton rbPress;
    private javax.swing.JRadioButton rbTemp;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JTable tableIzm;
    private javax.swing.JTable tablePov;
    private javax.swing.JLabel ur1;
    private javax.swing.JLabel ur2;
    // End of variables declaration//GEN-END:variables
}
