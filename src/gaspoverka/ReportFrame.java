package gaspoverka;

import gaspoverka.poverka.Poverka;
import gaspoverka.table.ReportTM;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ReportFrame extends javax.swing.JFrame {

    private static ReportFrame _instance = null;
    Poverka pov;
    ReportTM reportTM;

    public ReportFrame() {
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        //setSize(screenWidth / 2, screenHeight / 2);
        setLocation((screenWidth/2)-(this.getSize().width/2), 40);
        pov = new Poverka();
        reportTM = new ReportTM(pov.getList());
        table.setModel(reportTM);
    }

    public synchronized static ReportFrame getInstance() {
        if (_instance == null || !_instance.isVisible()) {
            _instance = new ReportFrame();
        }

        return _instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        out = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        sb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Отчеты");

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onReportClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        out.setText("Вывести отчет");
        out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outActionPerformed(evt);
            }
        });

        delete.setText("Удалить запись");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        sb.setFont(new java.awt.Font("Tahoma", 1, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(out)
                .addGap(4, 4, 4)
                .addComponent(sb, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(delete))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(out)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(sb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(delete)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onReportClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onReportClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_onReportClicked

    private void outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outActionPerformed
        pov.loadResult(pov.getList().get(table.getSelectedRow()).getPovNum());
        PovToExcel toExcel = new PovToExcel(pov);
        toExcel.populate();
    }//GEN-LAST:event_outActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if (table.getSelectedRow() >= 0) {
            long num = reportTM.pov.get(table.getSelectedRow()).getPovNum();
            pov.delReport(num);
            reportTM = new ReportTM(pov.getList());
            table.setModel(reportTM);
            reportTM.fireTableChanged(null);
        }
    }//GEN-LAST:event_deleteActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton out;
    private javax.swing.JLabel sb;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
