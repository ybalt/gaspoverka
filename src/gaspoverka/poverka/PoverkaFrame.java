package gaspoverka.poverka;

import gaspoverka.util.*;
import gaspoverka.table.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import javax.swing.*;

public class PoverkaFrame extends javax.swing.JFrame {

    private static PoverkaFrame _instance = null;
    Dev counter;
    Dev refrence;
    Poverka data;
    TTM MRTM;
    TTM KPTM;
    String[] KPnames = {"№", "Зн.Н", "Зн.В", "Погр."};
    String[] MRnames = {"№", "ДИ.Н", "ДИ.В", "Погр"};
    povTM dataTM;
    DefPovTR dataTR;
    int KP;

    public PoverkaFrame() {
        counter = new Dev();
        refrence = new Dev();
        MRTM = new TTM(counter.getMR(), MRnames);
        KPTM = new TTM(counter.getKP(), KPnames);
        data = new Poverka();
        dataTM = new povTM(data);
        dataTR = new DefPovTR();
        this.setTitle("Поверка");

        initComponents();
        KP = Integer.valueOf(KPnum.getValue().toString());
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        try {
            dataTable.setDefaultRenderer(Class.forName("java.lang.Double"), dataTR);
        } catch (ClassNotFoundException ex) {
        }
        counter.loadDevByType((String) devCB.getSelectedItem());
        refrence.loadDevByType((String) refCB.getSelectedItem());

        refreshData();
        dataTM.setRow(KP);
        data.setCount(counter);
        data.setRef(refrence);

        startButton.setEnabled(true);
        stopButton.setEnabled(false);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        //setSize(screenWidth / 2, screenHeight / 2);
        setLocation((screenWidth / 2) - (this.getSize().width / 2), 40);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        save = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        num = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        owner = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        executor = new javax.swing.JTextField();
        saveB = new javax.swing.JButton();
        cancelB = new javax.swing.JButton();
        povnum = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        KPnum = new javax.swing.JSpinner();
        devSelection = new javax.swing.JPanel();
        refPanel = new javax.swing.JPanel();
        refCB = new javax.swing.JComboBox();
        devPanel = new javax.swing.JPanel();
        devCB = new javax.swing.JComboBox();
        ctrlPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        RRL = new javax.swing.JLabel();
        TIZM = new javax.swing.JTextField();
        CVL = new javax.swing.JLabel();
        Measures = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Tmedian = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Penv = new javax.swing.JTextField();
        Tenv = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bGetPressure = new javax.swing.JButton();
        isDeltaT = new javax.swing.JCheckBox();
        SB = new javax.swing.JLabel();
        dataPane = new javax.swing.JTabbedPane();
        izmPane = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        G = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        T = new javax.swing.JTextField();
        P = new javax.swing.JTextField();
        N = new javax.swing.JTextField();
        A = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        V = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        povPane = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        save.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        save.setTitle("Сохранение результатов");
        save.setAlwaysOnTop(true);
        save.setMinimumSize(new java.awt.Dimension(220, 285));
        save.setModal(true);

        jLabel1.setText("Номер устройства");

        jLabel2.setText("Владелец");

        jLabel24.setText("Исполнитель поверки");

        saveB.setText("Запись");
        saveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBActionPerformed(evt);
            }
        });

        cancelB.setText("Отмена");
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBActionPerformed(evt);
            }
        });

        jLabel26.setText("Номер поверки");

        javax.swing.GroupLayout saveLayout = new javax.swing.GroupLayout(save.getContentPane());
        save.getContentPane().setLayout(saveLayout);
        saveLayout.setHorizontalGroup(
            saveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(saveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(povnum, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addGroup(saveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(num, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addComponent(owner)
                        .addComponent(executor))
                    .addGroup(saveLayout.createSequentialGroup()
                        .addComponent(saveB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(cancelB))
                    .addComponent(jLabel26)
                    .addComponent(jLabel24)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        saveLayout.setVerticalGroup(
            saveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(owner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(executor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(povnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(saveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveB)
                    .addComponent(cancelB))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Поверка");
        setMinimumSize(new java.awt.Dimension(750, 560));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        jLabel25.setText("Кол-во контр. точек");

        KPnum.setFont(new java.awt.Font("Tahoma", 1, 12));
        KPnum.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(1), null, Integer.valueOf(1)));
        KPnum.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                KPnumStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(KPnum, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KPnum, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                        .addComponent(jspDevInfoMR, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jspdevInfoKP, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UDL)
                            .addComponent(ICL)
                            .addComponent(PLL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PL, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(UD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(IC, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(UDL)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspDevInfoMR, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jspdevInfoKP, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
        );

        refPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Эталон"));

        refCB.setModel(new javax.swing.DefaultComboBoxModel(refrence.getRefList()));
        refCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout refPanelLayout = new javax.swing.GroupLayout(refPanel);
        refPanel.setLayout(refPanelLayout);
        refPanelLayout.setHorizontalGroup(
            refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(refCB, 0, 120, Short.MAX_VALUE)
        );
        refPanelLayout.setVerticalGroup(
            refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refPanelLayout.createSequentialGroup()
                .addComponent(refCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        devPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Счетчик"));

        devCB.setModel(new javax.swing.DefaultComboBoxModel(refrence.getDevListByChannel(4)));
        devCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout devPanelLayout = new javax.swing.GroupLayout(devPanel);
        devPanel.setLayout(devPanelLayout);
        devPanelLayout.setHorizontalGroup(
            devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devPanelLayout.createSequentialGroup()
                .addComponent(devCB, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        devPanelLayout.setVerticalGroup(
            devPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devPanelLayout.createSequentialGroup()
                .addComponent(devCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        startButton.setBackground(new java.awt.Color(0, 102, 51));
        startButton.setText("Старт");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setBackground(new java.awt.Color(153, 0, 0));
        stopButton.setText("Стоп");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Запись");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        reportButton.setText("Загрузка");
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        RRL.setText("Время изм.");

        TIZM.setText("60");

        CVL.setText("Испытаний");

        Measures.setText("1");

        jLabel3.setText("Время. усред.");

        Tmedian.setText("1");

        jLabel4.setText("с");

        jLabel5.setText("с");

        jLabel7.setText("Т");

        jLabel8.setText("P");

        jLabel9.setText("С°");

        jLabel10.setText("кПа");

        bGetPressure.setText("Р");
        bGetPressure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGetPressureActionPerformed(evt);
            }
        });

        isDeltaT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                isDeltaTItemStateChanged(evt);
            }
        });
        isDeltaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isDeltaTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ctrlPanelLayout = new javax.swing.GroupLayout(ctrlPanel);
        ctrlPanel.setLayout(ctrlPanelLayout);
        ctrlPanelLayout.setHorizontalGroup(
            ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ctrlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ctrlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(2, 2, 2)
                        .addComponent(Tenv, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(5, 5, 5)
                        .addComponent(isDeltaT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bGetPressure)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(Penv, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ctrlPanelLayout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reportButton, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                    .addGroup(ctrlPanelLayout.createSequentialGroup()
                        .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RRL)
                            .addComponent(jLabel3)
                            .addComponent(CVL))
                        .addGap(18, 18, 18)
                        .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ctrlPanelLayout.createSequentialGroup()
                                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TIZM, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tmedian, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                    .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)))
                            .addComponent(Measures, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );
        ctrlPanelLayout.setVerticalGroup(
            ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctrlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RRL)
                    .addComponent(TIZM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(startButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Measures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CVL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(Tmedian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(stopButton)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportButton)
                    .addComponent(saveButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Penv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel7)
                        .addComponent(Tenv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8)
                        .addComponent(bGetPressure))
                    .addComponent(isDeltaT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout devSelectionLayout = new javax.swing.GroupLayout(devSelection);
        devSelection.setLayout(devSelectionLayout);
        devSelectionLayout.setHorizontalGroup(
            devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(refPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(ctrlPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, devSelectionLayout.createSequentialGroup()
                    .addGap(130, 130, 130)
                    .addComponent(devPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        devSelectionLayout.setVerticalGroup(
            devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devSelectionLayout.createSequentialGroup()
                .addGroup(devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(devPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(ctrlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        SB.setBackground(new java.awt.Color(0, 0, 0));
        SB.setFont(new java.awt.Font("Tahoma", 1, 14));

        dataPane.setFocusable(false);
        dataPane.setFont(new java.awt.Font("Tahoma", 1, 14));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel11.setText("Температура");

        G.setFont(new java.awt.Font("Tahoma", 1, 36));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel12.setText("м3/ч");

        T.setFont(new java.awt.Font("Tahoma", 1, 14));

        P.setFont(new java.awt.Font("Tahoma", 1, 14));

        N.setFont(new java.awt.Font("Tahoma", 1, 14));

        A.setFont(new java.awt.Font("Tahoma", 1, 14));

        time.setFont(new java.awt.Font("Tahoma", 1, 14));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel13.setText("Текущий расход");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel14.setText("Давление");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel15.setText("Количество имп.");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel16.setText("С°");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel17.setText("кПа");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel18.setText("Коэффициент");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel19.setText("Реальное время");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel20.setText("имп.");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel21.setText("мсек");

        V.setFont(new java.awt.Font("Tahoma", 1, 14));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel22.setText("Объем за реальное время");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel23.setText("м3");

        javax.swing.GroupLayout izmPaneLayout = new javax.swing.GroupLayout(izmPane);
        izmPane.setLayout(izmPaneLayout);
        izmPaneLayout.setHorizontalGroup(
            izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(izmPaneLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(izmPaneLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, izmPaneLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(izmPaneLayout.createSequentialGroup()
                                        .addComponent(V, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23))
                                    .addGroup(izmPaneLayout.createSequentialGroup()
                                        .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17))
                                    .addGroup(izmPaneLayout.createSequentialGroup()
                                        .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(T, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)))))
                        .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(izmPaneLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, izmPaneLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(53, 53, 53))))
                    .addGroup(izmPaneLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15)
                    .addGroup(izmPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addGroup(izmPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(izmPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel21))
                    .addComponent(jLabel19))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        izmPaneLayout.setVerticalGroup(
            izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(izmPaneLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(izmPaneLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(izmPaneLayout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21)))
                        .addGroup(izmPaneLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17))
                            .addGap(6, 6, 6)
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(izmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(V, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23)))))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        dataPane.addTab("Измерение", izmPane);

        dataTable.setModel(dataTM);
        dataTable.setSelectionForeground(java.awt.Color.black);
        povPane.setViewportView(dataTable);

        dataPane.addTab("Поверка", povPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(devSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(dataPane, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
            .addComponent(SB, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(devSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataPane, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refCBActionPerformed
        refrence.loadDevByType((String) refCB.getSelectedItem());
        data.setRef(refrence);
        refreshData();
}//GEN-LAST:event_refCBActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        povnum.setText(String.valueOf(data.getLastPovNum() + 1));
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        save.setLocation((screenWidth / 2) - (this.getSize().width / 2), 40);
        save.setVisible(true);
}//GEN-LAST:event_saveButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        long lastP = data.getLastPovNum();
        data.loadResult(lastP);
        dataTM = new povTM(data);
        dataTable.repaint();
        Tenv.setText(String.valueOf(data.getTenv()));
        Penv.setText(String.valueOf(data.getPenv()));
        isDeltaT.setSelected(data.getIsDeltaT());
        
        //refreshData();
}//GEN-LAST:event_reportButtonActionPerformed

    private void devCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devCBActionPerformed
        counter.loadDevByType((String) devCB.getSelectedItem());
        data.setCount(counter);
        refreshData();
}//GEN-LAST:event_devCBActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        int row, Tm, Ti;
        double val;
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        bGetPressure.setEnabled(false);
        try {
            data.setTm(dataTM);
            data.setEnv(Tenv, 5);
            if (povPane.isVisible()) { //poverka
                row = dataTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Выберите строку в таблице, соответствующую номеру измерения ");
                    startButton.setEnabled(true);
                    stopButton.setEnabled(false);
                    bGetPressure.setEnabled(true);
                    return;
                }
                if (!Tmedian.getText().isEmpty()) {
                    Tm = Integer.parseInt(Tmedian.getText());
                } else {
                    Tm = 0;
                }
                if (Tm < 1) {
                    JOptionPane.showMessageDialog(null, "Время усреднения не может быть меньше единицы ");
                    startButton.setEnabled(true);
                    stopButton.setEnabled(false);
                    bGetPressure.setEnabled(true);
                    return;
                }
                if (TIZM.getText().isEmpty() || Measures.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Введите время измерения и количество измерений ");
                    startButton.setEnabled(true);
                    stopButton.setEnabled(false);
                    bGetPressure.setEnabled(true);
                    return;
                }
                if (!TIZM.getText().isEmpty()) {
                    Ti = Integer.parseInt(TIZM.getText());
                } else {
                    Ti = 0;
                }
                if (!Measures.getText().isEmpty()) {
                    val = Double.parseDouble(Measures.getText());
                } else {
                    val = 0;
                }
                data.startPov(Ti, val, Tm, row, this);
            } else { //izmerenie
                if (!Tmedian.getText().isEmpty()) {
                    Tm = Integer.parseInt(Tmedian.getText());
                } else {
                    Tm = 0;
                }
                if (Tm < 1) {
                    JOptionPane.showMessageDialog(null, "Время усреднения не может быть меньше единицы ");
                    startButton.setEnabled(true);
                    stopButton.setEnabled(false);
                    bGetPressure.setEnabled(true);
                    return;
                }
                data.startIzm(this);
            }
        } catch (Exception e) {
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            bGetPressure.setEnabled(true);
        }

    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        data.stop();
        try {
            while (data.thread.isAlive()) {
                Thread.sleep(100);
            }
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            bGetPressure.setEnabled(true);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_stopButtonActionPerformed

    private void saveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBActionPerformed
        if (owner.getText().equals("")
                || num.getText().equals("")
                || executor.getText().equals("")
                || povnum.getText().equals("")
                || Penv.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Сохранение невозможно - не заполнены обязательные поля");
            return;
        }
        data.setDevNum(num.getText());
        data.setOwner(owner.getText());
        data.setPovNum(Long.parseLong(povnum.getText()));
        data.setExec(executor.getText());
        data.setTenv(Double.parseDouble(Tenv.getText()));
        data.setPenv(Double.parseDouble(Penv.getText()));
        save.dispose();
        data.saveResult(dataTM.getIsDeltaT());

    }//GEN-LAST:event_saveBActionPerformed

    private void cancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBActionPerformed
        save.dispose();
    }//GEN-LAST:event_cancelBActionPerformed

    private void KPnumStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_KPnumStateChanged
        KP = Integer.valueOf(KPnum.getValue().toString());
        dataTM.setRow(KP);
    }//GEN-LAST:event_KPnumStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        data.stop();
    }//GEN-LAST:event_formWindowClosing

    private void bGetPressureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGetPressureActionPerformed
        data.getEnv(Penv, 41);
    }//GEN-LAST:event_bGetPressureActionPerformed

    private void isDeltaTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_isDeltaTItemStateChanged
         if (evt.getStateChange() == ItemEvent.DESELECTED) {
            dataTM.setIsDeltaT(false);
        } else {
            dataTM.setIsDeltaT(true);
        }
        dataTM.fireTableChanged(null);
    }//GEN-LAST:event_isDeltaTItemStateChanged

    private void isDeltaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isDeltaTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isDeltaTActionPerformed

    public JPanel getPanel() {
        return this.izmPane;
    }

    private void refreshData() {
        UD.setText(String.valueOf(counter.getUD()));
        PL.setText(String.valueOf(counter.getPL()));
        IC.setText(String.valueOf(counter.getIC()));
        MRTM.refresh();
        KPTM.refresh();

    }

    public synchronized static PoverkaFrame getInstance() {
        if (_instance == null || !_instance.isVisible()) {
            _instance = new PoverkaFrame();
        }
        return _instance;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField A;
    private javax.swing.JLabel CVL;
    public javax.swing.JTextField G;
    private javax.swing.JTextField IC;
    private javax.swing.JLabel ICL;
    private javax.swing.JSpinner KPnum;
    public javax.swing.JTextField Measures;
    public javax.swing.JTextField N;
    public javax.swing.JTextField P;
    private javax.swing.JTextField PL;
    private javax.swing.JLabel PLL;
    public javax.swing.JTextField Penv;
    private javax.swing.JLabel RRL;
    public javax.swing.JLabel SB;
    public javax.swing.JTextField T;
    public javax.swing.JTextField TIZM;
    public javax.swing.JTextField Tenv;
    public javax.swing.JTextField Tmedian;
    private javax.swing.JTextField UD;
    private javax.swing.JLabel UDL;
    public javax.swing.JTextField V;
    private javax.swing.JButton bGetPressure;
    private javax.swing.JButton cancelB;
    private javax.swing.JPanel ctrlPanel;
    private javax.swing.JTabbedPane dataPane;
    private javax.swing.JTable dataTable;
    private javax.swing.JComboBox devCB;
    private javax.swing.JTable devInfoKP;
    private javax.swing.JTable devInfoMR;
    private javax.swing.JPanel devPanel;
    private javax.swing.JPanel devSelection;
    private javax.swing.JTextField executor;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JCheckBox isDeltaT;
    private javax.swing.JPanel izmPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jspDevInfoMR;
    private javax.swing.JScrollPane jspdevInfoKP;
    private javax.swing.JTextField num;
    private javax.swing.JTextField owner;
    private javax.swing.JScrollPane povPane;
    private javax.swing.JTextField povnum;
    private javax.swing.JComboBox refCB;
    private javax.swing.JPanel refPanel;
    private javax.swing.JButton reportButton;
    private javax.swing.JDialog save;
    private javax.swing.JButton saveB;
    private javax.swing.JButton saveButton;
    public javax.swing.JButton startButton;
    public javax.swing.JButton stopButton;
    public javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}
