package gaspoverka.calibration;

import gaspoverka.util.Channel;
import gaspoverka.util.Dev;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;

public final class AttestationFrame extends javax.swing.JFrame {

    private static AttestationFrame _instance = null;
    AttCalTM calTM;
    AttACalTM ACalTM;
    AttIzmTM izmTM;
    Dev device;
    int channelNum;
    CalibrationData data;
    Attestation attestation;
    Channel channel;
    static char p1[] = {7, 5, 9, 1, 5, 3};
    static char p2[] = {1, 2, 3, 6, 9};

    public AttestationFrame() {

        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        //setSize(screenWidth / 2, screenHeight / 2);
        setLocation((screenWidth / 2) - (this.getSize().width / 2), 40);

        device = new Dev();
        channelNum = 1;
        device.loadDevByChannel(channelNum);
        channel = new Channel(channelNum);
        attestation = new Attestation(channel);

        //cal
        calTM = new AttCalTM();
        calTable.setModel(calTM);
        calTM.setDataVector(channel.getCalData().getPoints());


        //izm
        data = new CalibrationData();
        izmTM = new AttIzmTM(data);
        tableIzm.setModel(izmTM);

        //pov
        refresh();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgChannel = new javax.swing.ButtonGroup();
        pw = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        pin1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pin2 = new javax.swing.JPasswordField();
        save = new javax.swing.JButton();
        cansel = new javax.swing.JButton();
        choosePanelCal = new javax.swing.JPanel();
        calcButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jsChannel = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        rbDevP = new javax.swing.JRadioButton();
        rbDevT1 = new javax.swing.JRadioButton();
        clearButton = new javax.swing.JButton();
        rbDevT2 = new javax.swing.JRadioButton();
        lType = new javax.swing.JLabel();
        rbET = new javax.swing.JRadioButton();
        rbDevPP = new javax.swing.JRadioButton();
        rbA = new javax.swing.JRadioButton();
        jtP = new javax.swing.JTabbedPane();
        AttCal = new javax.swing.JPanel();
        jspCal = new javax.swing.JScrollPane();
        calTable = new javax.swing.JTable();
        ur2 = new javax.swing.JLabel();
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
        cbUseCalibration = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        mTime = new javax.swing.JTextField();
        sb = new javax.swing.JLabel();

        pw.setTitle("Запись");
        pw.setMinimumSize(new java.awt.Dimension(200, 200));
        pw.setResizable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setText("Введите PIN1 и PIN2");

        jLabel4.setText("PIN1");

        jLabel7.setText("PIN2");

        save.setText("Запись");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cansel.setText("Отмена");
        cansel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canselActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pwLayout = new javax.swing.GroupLayout(pw.getContentPane());
        pw.getContentPane().setLayout(pwLayout);
        pwLayout.setHorizontalGroup(
            pwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pwLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(pwLayout.createSequentialGroup()
                        .addGroup(pwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pin1)
                            .addComponent(pin2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                    .addGroup(pwLayout.createSequentialGroup()
                        .addComponent(save)
                        .addGap(18, 18, 18)
                        .addComponent(cansel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pwLayout.setVerticalGroup(
            pwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pwLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(pwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cansel)
                    .addComponent(save))
                .addContainerGap())
        );

        setTitle("Аттестация установки");
        setMinimumSize(new java.awt.Dimension(520, 540));

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

        bgChannel.add(rbDevP);
        rbDevP.setSelected(true);
        rbDevP.setText("Давление");
        rbDevP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDevPActionPerformed(evt);
            }
        });

        bgChannel.add(rbDevT1);
        rbDevT1.setText("Температура");
        rbDevT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDevT1ActionPerformed(evt);
            }
        });

        clearButton.setText("Сброс");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        bgChannel.add(rbDevT2);
        rbDevT2.setText("Температура D80");
        rbDevT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDevT2ActionPerformed(evt);
            }
        });

        lType.setFont(new java.awt.Font("Tahoma", 1, 12));

        bgChannel.add(rbET);
        rbET.setText("Tокр");
        rbET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbETActionPerformed(evt);
            }
        });

        bgChannel.add(rbDevPP);
        rbDevPP.setText("Перепад давления");
        rbDevPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDevPPActionPerformed(evt);
            }
        });

        bgChannel.add(rbA);
        rbA.setText("Аппроксимационный полиндром");
        rbA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout choosePanelCalLayout = new javax.swing.GroupLayout(choosePanelCal);
        choosePanelCal.setLayout(choosePanelCalLayout);
        choosePanelCalLayout.setHorizontalGroup(
            choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, choosePanelCalLayout.createSequentialGroup()
                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(calcButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, choosePanelCalLayout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(lType, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGap(4, 4, 4)
                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDevP)
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addComponent(rbDevT1)
                        .addGap(41, 41, 41)
                        .addComponent(rbET))
                    .addComponent(rbDevT2)
                    .addComponent(rbDevPP)
                    .addComponent(rbA))
                .addGap(18, 18, 18))
        );
        choosePanelCalLayout.setVerticalGroup(
            choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelCalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelCalLayout.createSequentialGroup()
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(choosePanelCalLayout.createSequentialGroup()
                                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calcButton)
                                    .addComponent(newButton))
                                .addGap(9, 9, 9)
                                .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saveButton)
                                    .addComponent(clearButton)))
                            .addGroup(choosePanelCalLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jsChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lType, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, choosePanelCalLayout.createSequentialGroup()
                        .addComponent(rbDevPP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDevP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(choosePanelCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbDevT1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbET))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDevT2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        AttCal.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                AttCalComponentShown(evt);
            }
        });

        jspCal.setMaximumSize(new java.awt.Dimension(454, 404));

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
        calTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        calTable.setCellSelectionEnabled(true);
        calTable.setMaximumSize(new java.awt.Dimension(300, 64));
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

        ur2.setFont(new java.awt.Font("Tahoma", 0, 24));
        ur2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ur2.setText("xxxxxxxxxxxxxxxx");

        jLabel6.setText("Уравнение калибровки");

        javax.swing.GroupLayout AttCalLayout = new javax.swing.GroupLayout(AttCal);
        AttCal.setLayout(AttCalLayout);
        AttCalLayout.setHorizontalGroup(
            AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttCalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AttCalLayout.createSequentialGroup()
                            .addComponent(jspCal, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttCalLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(192, 192, 192)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttCalLayout.createSequentialGroup()
                        .addComponent(ur2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        AttCalLayout.setVerticalGroup(
            AttCalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttCalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspCal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ur2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jtP.addTab("Калибровка", AttCal);

        AttIzm.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                AttIzmComponentShown(evt);
            }
        });

        jspIzm.setMaximumSize(new java.awt.Dimension(454, 404));

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
        tableIzm.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tableIzm.setMaximumSize(new java.awt.Dimension(300, 64));
        tableIzm.getTableHeader().setResizingAllowed(false);
        tableIzm.getTableHeader().setReorderingAllowed(false);
        jspIzm.setViewportView(tableIzm);

        VL.setText("Значение измеряемой величины");

        RRL.setText("Периодичность вывода");

        MCL.setText("Количество измерений в точке");

        V.setText("20");

        RR.setText("100");

        MC.setText("5");

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

        cbUseCalibration.setText("Использовать калибровочную информацию");
        cbUseCalibration.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbUseCalibrationItemStateChanged(evt);
            }
        });

        jLabel2.setText("Время измерения");

        mTime.setText("1000");

        javax.swing.GroupLayout AttIzmLayout = new javax.swing.GroupLayout(AttIzm);
        AttIzm.setLayout(AttIzmLayout);
        AttIzmLayout.setHorizontalGroup(
            AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttIzmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AttIzmLayout.createSequentialGroup()
                        .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VL)
                            .addComponent(MCL)
                            .addGroup(AttIzmLayout.createSequentialGroup()
                                .addComponent(RRL)
                                .addGap(18, 18, 18)
                                .addComponent(RR, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(MC, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(V, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                    .addComponent(cbUseCalibration))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mTime)
                    .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addGap(90, 90, 90))
            .addComponent(jspIzm, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );
        AttIzmLayout.setVerticalGroup(
            AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttIzmLayout.createSequentialGroup()
                .addComponent(jspIzm, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VL)
                    .addComponent(V, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RRL)
                    .addComponent(RR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(mTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AttIzmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MCL)
                    .addComponent(MC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbUseCalibration)
                .addContainerGap())
        );

        jtP.addTab("Измерение", AttIzm);

        sb.setFont(new java.awt.Font("Tahoma", 1, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choosePanelCal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jtP, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sb, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(choosePanelCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtP, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sb, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calTableMouseClicked
        try {
            int row = calTable.getSelectedRow();
            ur2.setText(channel.getCalData().getPoints().get(row).getUr2());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_calTableMouseClicked

    private void calcButtonCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonCalActionPerformed
        if (AttIzm.isVisible()) {
            data.setChannel(channel.getChannel());
            data.set();
            izmTM.fireTableChanged(null);
        }
}//GEN-LAST:event_calcButtonCalActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        if (AttCal.isVisible()) {
            calTM.addRow(1);
            calTM.fireTableChanged(null);
        }

    }//GEN-LAST:event_newButtonActionPerformed

    private void AttCalComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AttCalComponentShown
        newButton.setEnabled(true);
    }//GEN-LAST:event_AttCalComponentShown

    private void AttIzmComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AttIzmComponentShown
        newButton.setEnabled(true);
    }//GEN-LAST:event_AttIzmComponentShown

    private void jsChannelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsChannelStateChanged
        channelNum = Integer.valueOf(jsChannel.getValue().toString());
        device.loadDevByChannel(channelNum);
        refresh();
    }//GEN-LAST:event_jsChannelStateChanged

    private void rbDevPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDevPActionPerformed

        refresh();
    }//GEN-LAST:event_rbDevPActionPerformed

    private void rbDevT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDevT1ActionPerformed

        refresh();
    }//GEN-LAST:event_rbDevT1ActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        if (AttCal.isVisible()) {
            calTM.clear();
        }
        if (AttIzm.isVisible()) {
            data.clear();
            izmTM.fireTableChanged(null);
        }
    }//GEN-LAST:event_clearButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if (!V.getText().isEmpty()
                && !MC.getText().isEmpty()
                && !RR.getText().isEmpty()) {
            data.setValue(Double.parseDouble(V.getText()));
            data.clear();
            data.add(Integer.parseInt(MC.getText()));
            izmTM.fireTableChanged(null);
            //start measure
            attestation.setTM(izmTM);
            attestation.start(Integer.parseInt(RR.getText()), Integer.parseInt(mTime.getText()), 2, this.sb);
            //end measure
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (AttIzm.isVisible()) {
            attestation.saveAttestationData(data);
        } else {
            pw.setModal(true);
            pw.setVisible(true);
        }

    }//GEN-LAST:event_saveButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        attestation.stop();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void cbUseCalibrationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbUseCalibrationItemStateChanged
        if (evt.getStateChange() == ItemEvent.DESELECTED) {
            attestation.setCalibrated(false);
        } else {
            attestation.setCalibrated(true);
        }
        attestation.setResult();
        data.setChannel(channel.getChannel());
        data.set();
        izmTM.fireTableChanged(null);
    }//GEN-LAST:event_cbUseCalibrationItemStateChanged

    private void rbDevT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDevT2ActionPerformed
        refresh();
    }//GEN-LAST:event_rbDevT2ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (pin1.getText().equals("759153")
                && pin2.getText().equals("12369")) {
            channel.getCalData().saveCalibrationData();
            channel.getCalData().calcCalibrationData();
            pw.setVisible(false);
            JOptionPane.showMessageDialog(null, "Запись в базу произведена");
        } else {
            pw.setVisible(false);
            JOptionPane.showMessageDialog(null, "Пароли не совпадают");
        }
        pin1.setText("");
        pin2.setText("");
    }//GEN-LAST:event_saveActionPerformed

    private void rbETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbETActionPerformed
        refresh();
    }//GEN-LAST:event_rbETActionPerformed

    private void canselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canselActionPerformed
        pin1.setText("");
        pin2.setText("");
        pw.setVisible(false);
    }//GEN-LAST:event_canselActionPerformed

    private void rbDevPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDevPPActionPerformed
        refresh();
    }//GEN-LAST:event_rbDevPPActionPerformed

    private void rbAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAActionPerformed
        refresh();
    }//GEN-LAST:event_rbAActionPerformed

    public void refresh() {
        if (channelNum == 4) {
            lType.setText("проверяемый счетчик");
            rbDevT1.setText("Температура D50");
            rbDevT2.setVisible(true);
        } else {
            rbDevT1.setText("Температура");
            rbDevT2.setVisible(false);
            rbA.setEnabled(true);
            lType.setText(device.getType());
        }
        if (rbDevPP.isSelected()) {
            channel.setChannel(channelNum * 10 + 5);
        }
        if (rbDevP.isSelected()) {
            channel.setChannel(channelNum * 10 + 1);
        }
        if (rbDevT1.isSelected()) {
            channel.setChannel(channelNum * 10 + 2);
        }
        if (rbDevT2.isSelected()) {
            channel.setChannel(channelNum * 10 + 3);
        }
        if (rbET.isSelected()) {
            channel.setChannel(5);
        }
        if (rbA.isSelected()) {
            ACalTM = new AttACalTM();
            channel.setChannel(channelNum);
            ACalTM.setDataVector(channel);
            calTable.setModel(ACalTM);
        } else {
            //attestation.setCh(channel);
            calTM.setDataVector(channel.getCalData().getPoints());
            calTable.setModel(calTM);
        }
    }

    public synchronized static AttestationFrame getInstance() {
        if (_instance == null || !_instance.isVisible()) {
            _instance = new AttestationFrame();
        }
        return _instance;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AttCal;
    private javax.swing.JPanel AttIzm;
    private javax.swing.JTextField MC;
    private javax.swing.JLabel MCL;
    private javax.swing.JTextField RR;
    private javax.swing.JLabel RRL;
    private javax.swing.JTextField V;
    private javax.swing.JLabel VL;
    private javax.swing.ButtonGroup bgChannel;
    private javax.swing.JTable calTable;
    private javax.swing.JButton calcButton;
    private javax.swing.JButton cansel;
    private javax.swing.JCheckBox cbUseCalibration;
    private javax.swing.JPanel choosePanelCal;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner jsChannel;
    private javax.swing.JScrollPane jspCal;
    private javax.swing.JScrollPane jspIzm;
    private javax.swing.JTabbedPane jtP;
    private javax.swing.JLabel lType;
    private javax.swing.JTextField mTime;
    private javax.swing.JButton newButton;
    private javax.swing.JPasswordField pin1;
    private javax.swing.JPasswordField pin2;
    private javax.swing.JDialog pw;
    private javax.swing.JRadioButton rbA;
    private javax.swing.JRadioButton rbDevP;
    private javax.swing.JRadioButton rbDevPP;
    private javax.swing.JRadioButton rbDevT1;
    private javax.swing.JRadioButton rbDevT2;
    private javax.swing.JRadioButton rbET;
    private javax.swing.JButton save;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel sb;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JTable tableIzm;
    private javax.swing.JLabel ur2;
    // End of variables declaration//GEN-END:variables
}
