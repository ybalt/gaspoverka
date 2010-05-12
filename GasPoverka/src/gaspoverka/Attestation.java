package gaspoverka;

import gaspoverka.table.*;
import java.awt.*;
import javax.swing.*;

public class Attestation extends javax.swing.JFrame {

    AttCalTM calTM;
    AttIzmTM izmTM;
    AttPovTM povTM;

    public Attestation() {
        initComponents();


        pressureCal.setSelected(true);
        calTM = new AttCalTM();
        calTM.setRows(5, "кПа");
        tableCal.setModel(calTM);

        izmTM = new AttIzmTM();
        tableIzm.setModel(izmTM);

        povTM = new AttPovTM();
        povTM.setRow();
        tablePov.setModel(povTM);


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSensor = new javax.swing.ButtonGroup();
        bgDevice = new javax.swing.ButtonGroup();
        jtP = new javax.swing.JTabbedPane();
        AttCal = new javax.swing.JPanel();
        choosePanelCal = new javax.swing.JPanel();
        pressureCal = new javax.swing.JRadioButton();
        temperatureCal = new javax.swing.JRadioButton();
        calcButtonCal = new javax.swing.JButton();
        rbDev1Cal = new javax.swing.JRadioButton();
        rbDev2Cal = new javax.swing.JRadioButton();
        rbDev3Cal = new javax.swing.JRadioButton();
        rbDev4Cal = new javax.swing.JRadioButton();
        saveButtonCal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cnannelCal = new javax.swing.JTextField();
        jspCal = new javax.swing.JScrollPane();
        tableCal = new javax.swing.JTable();
        graphP = new Graph();
        AttIzm = new javax.swing.JPanel();
        choosePanelIzm = new javax.swing.JPanel();
        pressureIzm = new javax.swing.JRadioButton();
        temperatureIzm = new javax.swing.JRadioButton();
        calcButtonIzm = new javax.swing.JButton();
        rbDev1Izm = new javax.swing.JRadioButton();
        rbDev2Izm = new javax.swing.JRadioButton();
        rbDev3Izm = new javax.swing.JRadioButton();
        rbDev4Izm = new javax.swing.JRadioButton();
        newButtonIzm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        channelIzm = new javax.swing.JTextField();
        clearButtonIzm = new javax.swing.JButton();
        saveButtonIzm = new javax.swing.JButton();
        jspIzm = new javax.swing.JScrollPane();
        tableIzm = new javax.swing.JTable();
        AttPov = new javax.swing.JPanel();
        choosePanelPov = new javax.swing.JPanel();
        pressurePov = new javax.swing.JRadioButton();
        temperaturePov = new javax.swing.JRadioButton();
        calcButtonPov = new javax.swing.JButton();
        rbDev1Pov = new javax.swing.JRadioButton();
        rbDev2Pov = new javax.swing.JRadioButton();
        rbDev3Pov = new javax.swing.JRadioButton();
        rbDev4Pov = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        channelPov = new javax.swing.JTextField();
        saveButtonPov = new javax.swing.JButton();
        jspPov = new javax.swing.JScrollPane();
        tablePov = new javax.swing.JTable();

        setTitle("Аттестация установки");
        setResizable(false);

        bgSensor.add(pressureCal);
        pressureCal.setText("Давление");
        pressureCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressureCalActionPerformed(evt);
            }
        });

        bgSensor.add(temperatureCal);
        temperatureCal.setText("Температура");
        temperatureCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temperatureCalActionPerformed(evt);
            }
        });

        calcButtonCal.setText("Расчет");
        calcButtonCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcButtonCalActionPerformed(evt);
            }
        });

        bgDevice.add(rbDev1Cal);
        rbDev1Cal.setText("Эталон1");

        bgDevice.add(rbDev2Cal);
        rbDev2Cal.setText("Эталон2");

        bgDevice.add(rbDev3Cal);
        rbDev3Cal.setText("Эталон3");

        bgDevice.add(rbDev4Cal);
        rbDev4Cal.setText("Поверяемый");

        saveButtonCal.setText("Запись");

        jLabel1.setText("канал");

        cnannelCal.setEditable(false);

        javax.swing.GroupLayout choosePanelCalLayout = new javax.swing.GroupLayout(choosePanelCal);
        choosePanelCal.setLayout(choosePanelCalLayout);
        choosePanelCalLayout.setHorizontalGroup(
            choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelCalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDev4Cal)
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbDev1Cal)
                            .addGroup(choosePanelCalLayout.createSequentialGroup()
                                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbDev2Cal)
                                    .addComponent(rbDev3Cal))
                                .addGap(66, 66, 66)
                                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pressureCal)
                                    .addComponent(temperatureCal))))
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(choosePanelCalLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel1))
                            .addGroup(choosePanelCalLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(cnannelCal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(calcButtonCal)
                            .addComponent(saveButtonCal))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        choosePanelCalLayout.setVerticalGroup(
            choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelCalLayout.createSequentialGroup()
                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbDev1Cal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDev2Cal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDev3Cal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDev4Cal))
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(temperatureCal)
                            .addComponent(cnannelCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pressureCal))
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calcButtonCal)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveButtonCal)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tableCal.setModel(new javax.swing.table.DefaultTableModel(
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
        jspCal.setViewportView(tableCal);

        graphP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        graphP.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout graphPLayout = new javax.swing.GroupLayout(graphP);
        graphP.setLayout(graphPLayout);
        graphPLayout.setHorizontalGroup(
            graphPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        graphPLayout.setVerticalGroup(
            graphPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout AttCalLayout = new javax.swing.GroupLayout(AttCal);
        AttCal.setLayout(AttCalLayout);
        AttCalLayout.setHorizontalGroup(
            AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choosePanelCal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jspCal, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
            .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AttCalLayout.createSequentialGroup()
                    .addGap(144, 144, 144)
                    .addComponent(graphP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(175, Short.MAX_VALUE)))
        );
        AttCalLayout.setVerticalGroup(
            AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttCalLayout.createSequentialGroup()
                .addComponent(choosePanelCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspCal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
            .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttCalLayout.createSequentialGroup()
                    .addContainerGap(259, Short.MAX_VALUE)
                    .addComponent(graphP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jtP.addTab("Калибровка", AttCal);

        bgSensor.add(pressureIzm);
        pressureIzm.setText("Давление");
        pressureIzm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressureIzmActionPerformed(evt);
            }
        });

        bgSensor.add(temperatureIzm);
        temperatureIzm.setText("Температура");
        temperatureIzm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temperatureIzmActionPerformed(evt);
            }
        });

        calcButtonIzm.setText("Расчет");
        calcButtonIzm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcButtonIzmActionPerformed(evt);
            }
        });

        bgDevice.add(rbDev1Izm);
        rbDev1Izm.setText("Эталон1");

        bgDevice.add(rbDev2Izm);
        rbDev2Izm.setText("Эталон2");

        bgDevice.add(rbDev3Izm);
        rbDev3Izm.setText("Эталон3");

        bgDevice.add(rbDev4Izm);
        rbDev4Izm.setText("Поверяемый");

        newButtonIzm.setText("Новое");
        newButtonIzm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonIzmActionPerformed(evt);
            }
        });

        jLabel2.setText("канал");

        channelIzm.setEditable(false);

        clearButtonIzm.setText("Очистить");
        clearButtonIzm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonIzmActionPerformed(evt);
            }
        });

        saveButtonIzm.setText("Сохранить");

        javax.swing.GroupLayout choosePanelIzmLayout = new javax.swing.GroupLayout(choosePanelIzm);
        choosePanelIzm.setLayout(choosePanelIzmLayout);
        choosePanelIzmLayout.setHorizontalGroup(
            choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelIzmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDev1Izm)
                    .addGroup(choosePanelIzmLayout.createSequentialGroup()
                        .addGroup(choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbDev2Izm)
                            .addComponent(rbDev3Izm))
                        .addGap(66, 66, 66)
                        .addGroup(choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pressureIzm)
                            .addComponent(temperatureIzm)))
                    .addComponent(rbDev4Izm))
                .addGap(18, 18, 18)
                .addGroup(choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelIzmLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2))
                    .addComponent(channelIzm, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcButtonIzm))
                .addGap(18, 18, 18)
                .addGroup(choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveButtonIzm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearButtonIzm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newButtonIzm, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        choosePanelIzmLayout.setVerticalGroup(
            choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelIzmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelIzmLayout.createSequentialGroup()
                        .addComponent(rbDev1Izm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDev2Izm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDev3Izm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDev4Izm))
                    .addGroup(choosePanelIzmLayout.createSequentialGroup()
                        .addGroup(choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(choosePanelIzmLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(choosePanelIzmLayout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addComponent(channelIzm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel2))
                                    .addComponent(temperatureIzm)))
                            .addGroup(choosePanelIzmLayout.createSequentialGroup()
                                .addComponent(newButtonIzm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearButtonIzm)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveButtonIzm)
                            .addGroup(choosePanelIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pressureIzm)
                                .addComponent(calcButtonIzm)))))
                .addContainerGap())
        );

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
            .addComponent(choosePanelIzm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jspIzm, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );
        AttIzmLayout.setVerticalGroup(
            AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttIzmLayout.createSequentialGroup()
                .addComponent(choosePanelIzm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspIzm, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        jtP.addTab("Измерение", AttIzm);

        bgSensor.add(pressurePov);
        pressurePov.setText("Давление");
        pressurePov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressurePovActionPerformed(evt);
            }
        });

        bgSensor.add(temperaturePov);
        temperaturePov.setText("Температура");
        temperaturePov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temperaturePovActionPerformed(evt);
            }
        });

        calcButtonPov.setText("Расчет");
        calcButtonPov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcButtonPovActionPerformed(evt);
            }
        });

        bgDevice.add(rbDev1Pov);
        rbDev1Pov.setText("Эталон1");

        bgDevice.add(rbDev2Pov);
        rbDev2Pov.setText("Эталон2");

        bgDevice.add(rbDev3Pov);
        rbDev3Pov.setText("Эталон3");

        bgDevice.add(rbDev4Pov);
        rbDev4Pov.setText("Поверяемый");

        jLabel3.setText("канал");

        channelPov.setEditable(false);

        saveButtonPov.setText("Сохранить");

        javax.swing.GroupLayout choosePanelPovLayout = new javax.swing.GroupLayout(choosePanelPov);
        choosePanelPov.setLayout(choosePanelPovLayout);
        choosePanelPovLayout.setHorizontalGroup(
            choosePanelPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelPovLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choosePanelPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDev1Pov)
                    .addGroup(choosePanelPovLayout.createSequentialGroup()
                        .addGroup(choosePanelPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbDev2Pov)
                            .addComponent(rbDev3Pov))
                        .addGap(66, 66, 66)
                        .addGroup(choosePanelPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pressurePov)
                            .addComponent(temperaturePov)))
                    .addComponent(rbDev4Pov))
                .addGap(18, 18, 18)
                .addGroup(choosePanelPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelPovLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3))
                    .addComponent(channelPov, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcButtonPov))
                .addGap(18, 18, 18)
                .addComponent(saveButtonPov)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        choosePanelPovLayout.setVerticalGroup(
            choosePanelPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelPovLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choosePanelPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelPovLayout.createSequentialGroup()
                        .addComponent(rbDev1Pov)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDev2Pov)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDev3Pov)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDev4Pov))
                    .addGroup(choosePanelPovLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(choosePanelPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(choosePanelPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(choosePanelPovLayout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(channelPov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3))
                            .addComponent(temperaturePov))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(choosePanelPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveButtonPov)
                            .addGroup(choosePanelPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pressurePov)
                                .addComponent(calcButtonPov)))))
                .addContainerGap())
        );

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
            .addComponent(choosePanelPov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jspPov, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );
        AttPovLayout.setVerticalGroup(
            AttPovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttPovLayout.createSequentialGroup()
                .addComponent(choosePanelPov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspPov, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
        );

        jtP.addTab("Поверка", AttPov);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtP)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtP, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private class Graph extends JPanel {

        Graph() {
            setBackground(Color.BLACK);
        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);


            int dy = getSize().height;
            int dx = getSize().width;

            g.setColor(Color.WHITE);
            int count = calTM.getRowCount();

            int x = 0;
            int y = dy;

            for (int i = 0; i < count; i++) {
                x += dx / (count + 1);
                g.drawLine(x, dy, x, dy - 5);
                y -= dx / (count + 1);
                g.drawLine(0, y, 5, y);
            }

            for (int i=0;i<count;i++) {
                
            }










        } // paintComponent
    }
    private void pressureCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pressureCalActionPerformed
        calTM.setRows(5, "кПа");
        graphP.repaint();
    }//GEN-LAST:event_pressureCalActionPerformed

    private void temperatureCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperatureCalActionPerformed
        calTM.setRows(6, "С°");
        graphP.repaint();

    }//GEN-LAST:event_temperatureCalActionPerformed

    private void calcButtonCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonCalActionPerformed
        calTM.set();
    }//GEN-LAST:event_calcButtonCalActionPerformed

    private void pressureIzmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pressureIzmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pressureIzmActionPerformed

    private void temperatureIzmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperatureIzmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_temperatureIzmActionPerformed

    private void calcButtonIzmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonIzmActionPerformed
        izmTM.set();
    }//GEN-LAST:event_calcButtonIzmActionPerformed

    private void newButtonIzmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonIzmActionPerformed
        izmTM.addRow();
    }//GEN-LAST:event_newButtonIzmActionPerformed

    private void clearButtonIzmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonIzmActionPerformed
        izmTM.clear();
    }//GEN-LAST:event_clearButtonIzmActionPerformed

    private void pressurePovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pressurePovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pressurePovActionPerformed

    private void temperaturePovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperaturePovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_temperaturePovActionPerformed

    private void calcButtonPovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonPovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calcButtonPovActionPerformed

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
    private javax.swing.JButton calcButtonCal;
    private javax.swing.JButton calcButtonIzm;
    private javax.swing.JButton calcButtonPov;
    private javax.swing.JTextField channelIzm;
    private javax.swing.JTextField channelPov;
    private javax.swing.JPanel choosePanelCal;
    private javax.swing.JPanel choosePanelIzm;
    private javax.swing.JPanel choosePanelPov;
    private javax.swing.JButton clearButtonIzm;
    private javax.swing.JTextField cnannelCal;
    private javax.swing.JPanel graphP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jspCal;
    private javax.swing.JScrollPane jspIzm;
    private javax.swing.JScrollPane jspPov;
    private javax.swing.JTabbedPane jtP;
    private javax.swing.JButton newButtonIzm;
    private javax.swing.JRadioButton pressureCal;
    private javax.swing.JRadioButton pressureIzm;
    private javax.swing.JRadioButton pressurePov;
    private javax.swing.JRadioButton rbDev1Cal;
    private javax.swing.JRadioButton rbDev1Izm;
    private javax.swing.JRadioButton rbDev1Pov;
    private javax.swing.JRadioButton rbDev2Cal;
    private javax.swing.JRadioButton rbDev2Izm;
    private javax.swing.JRadioButton rbDev2Pov;
    private javax.swing.JRadioButton rbDev3Cal;
    private javax.swing.JRadioButton rbDev3Izm;
    private javax.swing.JRadioButton rbDev3Pov;
    private javax.swing.JRadioButton rbDev4Cal;
    private javax.swing.JRadioButton rbDev4Izm;
    private javax.swing.JRadioButton rbDev4Pov;
    private javax.swing.JButton saveButtonCal;
    private javax.swing.JButton saveButtonIzm;
    private javax.swing.JButton saveButtonPov;
    private javax.swing.JTable tableCal;
    private javax.swing.JTable tableIzm;
    private javax.swing.JTable tablePov;
    private javax.swing.JRadioButton temperatureCal;
    private javax.swing.JRadioButton temperatureIzm;
    private javax.swing.JRadioButton temperaturePov;
    // End of variables declaration//GEN-END:variables
}
