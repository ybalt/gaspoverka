package gaspoverka;

import gaspoverka.data.arch.Dev;
import gaspoverka.data.*;
import gaspoverka.table.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class PoverkaPov extends javax.swing.JFrame {

    Dev counter;
    Dev refrence;
    TTM MRTM;
    TTM KPTM;
    String[] KPnames = {"№", "Зн.Н", "Зн.В", "Погр."};
    String[] MRnames = {"№", "ДИ.Н", "ДИ.В", "Погр"};
    PovPovDataTM dataTM;
    DefTR dataTR;

    public PoverkaPov() {
        counter = new Dev();
        refrence = new Dev();
        MRTM = new TTM(counter.getMR(), MRnames);
        KPTM = new TTM(counter.getKP(), KPnames);
        dataTM = new PovPovDataTM();
        dataTR = new DefTR();

        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Измерение");

        try {
            dataTable.setDefaultRenderer(Class.forName("java.lang.Double"), dataTR);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }



        //dataTable.getColumn(dataTable.getColumnName(0)).setCellRenderer(new ButtonRenderer());
        //dataTable.getColumn(dataTable.getColumnName(0)).setCellEditor(new ButtonEditor(new JButton()));
        refreshData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataPanel = new javax.swing.JPanel();
        jspData = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        RRL = new javax.swing.JLabel();
        CVL = new javax.swing.JLabel();
        RR = new javax.swing.JTextField();
        CV = new javax.swing.JTextField();
        devInfo = new javax.swing.JLayeredPane();
        UD = new javax.swing.JTextField();
        UDL = new javax.swing.JLabel();
        PL = new javax.swing.JTextField();
        PLL = new javax.swing.JLabel();
        IC = new javax.swing.JTextField();
        ICL = new javax.swing.JLabel();
        jspdevInfoKP = new javax.swing.JScrollPane();
        devInfoKP = new javax.swing.JTable();
        jspDevInfoMR = new javax.swing.JScrollPane();
        devInfoMR = new javax.swing.JTable();
        savedbButton = new javax.swing.JButton();
        devSelection = new javax.swing.JPanel();
        devPane = new javax.swing.JLayeredPane();
        devCB = new javax.swing.JComboBox();
        devP = new javax.swing.JTextField();
        devT = new javax.swing.JTextField();
        devTL = new javax.swing.JLabel();
        devPL = new javax.swing.JLabel();
        refPane = new javax.swing.JLayeredPane();
        refCB = new javax.swing.JComboBox();
        refP = new javax.swing.JTextField();
        refT = new javax.swing.JTextField();
        refTL = new javax.swing.JLabel();
        refPL = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CV1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dataTable.setModel(dataTM);
        jspData.setViewportView(dataTable);

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspData, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addComponent(jspData, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RRL.setText("Пер. вывода");

        CVL.setText("Контр. объем");

        devInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Информация")));
        UD.setBounds(110, 20, 60, 20);
        devInfo.add(UD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        UDL.setText("Условный диаметр");
        UDL.setBounds(10, 20, 96, 14);
        devInfo.add(UDL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PL.setBounds(110, 40, 60, 20);
        devInfo.add(PL, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PLL.setText("Потеря давления");
        PLL.setBounds(10, 40, 89, 14);
        devInfo.add(PLL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        IC.setBounds(110, 60, 60, 20);
        devInfo.add(IC, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ICL.setText("Коэф. передачи");
        ICL.setBounds(10, 60, 82, 14);
        devInfo.add(ICL, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jspdevInfoKP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Контр. точки"));

        devInfoKP.setModel(KPTM);
        devInfoKP.getTableHeader().setResizingAllowed(false);
        devInfoKP.getTableHeader().setReorderingAllowed(false);
        jspdevInfoKP.setViewportView(devInfoKP);

        jspdevInfoKP.setBounds(160, 110, 170, 140);
        devInfo.add(jspdevInfoKP, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jspDevInfoMR.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Диапазоны"));

        devInfoMR.setModel(MRTM);
        jspDevInfoMR.setViewportView(devInfoMR);

        jspDevInfoMR.setBounds(10, 110, 150, 140);
        devInfo.add(jspDevInfoMR, javax.swing.JLayeredPane.DEFAULT_LAYER);

        savedbButton.setText("Запись в БД");
        savedbButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savedbButtonActionPerformed(evt);
            }
        });
        savedbButton.setBounds(200, 20, 100, 23);
        devInfo.add(savedbButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        devPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Счетчик")));

        devCB.setModel(new javax.swing.DefaultComboBoxModel(counter.getDevListByChannel(4)));
        devCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devCBActionPerformed(evt);
            }
        });
        devCB.setBounds(10, 20, 100, 20);
        devPane.add(devCB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        devP.setBounds(60, 50, 50, 20);
        devPane.add(devP, javax.swing.JLayeredPane.DEFAULT_LAYER);
        devT.setBounds(60, 80, 50, 20);
        devPane.add(devT, javax.swing.JLayeredPane.DEFAULT_LAYER);

        devTL.setText("Темп.");
        devTL.setBounds(10, 80, 30, 14);
        devPane.add(devTL, javax.swing.JLayeredPane.DEFAULT_LAYER);

        devPL.setText("Давл.");
        devPL.setBounds(10, 50, 30, 14);
        devPane.add(devPL, javax.swing.JLayeredPane.DEFAULT_LAYER);

        refPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Эталон")));
        refPane.setName(""); // NOI18N

        refCB.setModel(new javax.swing.DefaultComboBoxModel(refrence.getDevListByChannel(1)));
        refCB.setBounds(10, 20, 100, 20);
        refPane.add(refCB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        refP.setBounds(60, 50, 50, 20);
        refPane.add(refP, javax.swing.JLayeredPane.DEFAULT_LAYER);
        refT.setBounds(60, 80, 50, 20);
        refPane.add(refT, javax.swing.JLayeredPane.DEFAULT_LAYER);

        refTL.setText("Темп.");
        refTL.setBounds(10, 80, 30, 14);
        refPane.add(refTL, javax.swing.JLayeredPane.DEFAULT_LAYER);

        refPL.setText("Давл.");
        refPL.setBounds(10, 50, 30, 14);
        refPane.add(refPL, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout devSelectionLayout = new javax.swing.GroupLayout(devSelection);
        devSelection.setLayout(devSelectionLayout);
        devSelectionLayout.setHorizontalGroup(
            devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refPane, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(devPane, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        devSelectionLayout.setVerticalGroup(
            devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(devSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(devPane, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refPane, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        startButton.setText("Старт");

        stopButton.setText("Стоп");

        jLabel1.setText("Кол-во изм. в точке");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(devSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CVL)
                                    .addComponent(RRL)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CV1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(CV, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(RR, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(startButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(devInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(devSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RRL)
                            .addComponent(startButton)
                            .addComponent(RR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CVL)
                            .addComponent(stopButton)
                            .addComponent(CV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(CV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(devInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void devCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devCBActionPerformed
        refreshData();
    }//GEN-LAST:event_devCBActionPerformed

    private void savedbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savedbButtonActionPerformed
        reportPov rep = new reportPov();
        rep.setVisible(true);
    }//GEN-LAST:event_savedbButtonActionPerformed

    private void refreshData() {
        counter.load((String) devCB.getSelectedItem());
        UD.setText(String.valueOf(counter.getUD()));
        PL.setText(String.valueOf(counter.getPL()));
        IC.setText(String.valueOf(counter.getIC()));
        MRTM.refresh();
        KPTM.refresh();
    }

    class ButtonColumn extends AbstractCellEditor
            implements TableCellRenderer, TableCellEditor, ActionListener {

        JTable table;
        JButton renderButton;
        JButton editButton;
        String text;

        public ButtonColumn(JTable table, int column) {
            super();
            this.table = table;
            renderButton = new JButton();

            editButton = new JButton();
            editButton.setFocusPainted(false);
            editButton.addActionListener(this);

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(column).setCellRenderer(this);
            columnModel.getColumn(column).setCellEditor(this);
        }

        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (hasFocus) {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            } else if (isSelected) {
                renderButton.setForeground(table.getSelectionForeground());
                renderButton.setBackground(table.getSelectionBackground());
            } else {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            }

            renderButton.setText((value == null) ? "" : value.toString());
            return renderButton;
        }

        public Component getTableCellEditorComponent(
                JTable table, Object value, boolean isSelected, int row, int column) {
            text = (value == null) ? "" : value.toString();
            editButton.setText(text);
            return editButton;
        }

        public Object getCellEditorValue() {
            return text;
        }

        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
            System.out.println(e.getActionCommand() + " : " + table.getSelectedRow());
        }
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
    private javax.swing.JTextField CV1;
    private javax.swing.JLabel CVL;
    private javax.swing.JTextField IC;
    private javax.swing.JLabel ICL;
    private javax.swing.JTextField PL;
    private javax.swing.JLabel PLL;
    private javax.swing.JTextField RR;
    private javax.swing.JLabel RRL;
    private javax.swing.JTextField UD;
    private javax.swing.JLabel UDL;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JTable dataTable;
    private javax.swing.JComboBox devCB;
    private javax.swing.JLayeredPane devInfo;
    private javax.swing.JTable devInfoKP;
    private javax.swing.JTable devInfoMR;
    private javax.swing.JTextField devP;
    private javax.swing.JLabel devPL;
    private javax.swing.JLayeredPane devPane;
    private javax.swing.JPanel devSelection;
    private javax.swing.JTextField devT;
    private javax.swing.JLabel devTL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jspData;
    private javax.swing.JScrollPane jspDevInfoMR;
    private javax.swing.JScrollPane jspdevInfoKP;
    private javax.swing.JComboBox refCB;
    private javax.swing.JTextField refP;
    private javax.swing.JLabel refPL;
    private javax.swing.JLayeredPane refPane;
    private javax.swing.JTextField refT;
    private javax.swing.JLabel refTL;
    private javax.swing.JButton savedbButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
