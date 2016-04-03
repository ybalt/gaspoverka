package gaspoverka;

import gaspoverka.poverka.PoverkaFrame;
import gaspoverka.calibration.AttestationFrame;
import gaspoverka.util.Log;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MainFrame extends javax.swing.JFrame {

    public static memDB db = memDB.getInstance();
    public static Log log = Log.getInstance();

    public MainFrame() {
        initComponents();
        try {
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension screenSize = tk.getScreenSize();
            int screenHeight = screenSize.height;
            int screenWidth = screenSize.width;
            setSize(screenWidth, screenHeight);
            setLocation(0, 0);
            bPanel.setLocation((screenWidth / 2) - (bPanel.getSize().width / 2), 0);
            sb.setLocation((screenWidth / 2) - (sb.getSize().width / 2), bPanel.getSize().height);
            pic.setSize(500, 500);
            pic.setLocation((screenWidth / 2) - (pic.getSize().width / 2), (bPanel.getSize().height + sb.getSize().height));
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sb = new javax.swing.JLabel();
        bPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        PovButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pov_rep = new javax.swing.JButton();
        devButton = new javax.swing.JButton();
        att_rep = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        AttButton = new javax.swing.JButton();
        pic = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ЗАО \"Белавтоматикасервис\" - ГАЗ-Поверка");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        getContentPane().setLayout(null);

        sb.setBackground(new java.awt.Color(204, 255, 204));
        sb.setFont(new java.awt.Font("Tahoma", 1, 12));
        sb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(sb);
        sb.setBounds(0, 440, 700, 30);

        bPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bPanel.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Поверка"));

        PovButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        PovButton.setText("Поверка");
        PovButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PovButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PovButton, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(PovButton, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );

        bPanel.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Настройка"));

        pov_rep.setFont(new java.awt.Font("Tahoma", 1, 14));
        pov_rep.setText("Отчеты Поверка");
        pov_rep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pov_repActionPerformed(evt);
            }
        });

        devButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        devButton.setText("Устройства");
        devButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devButtonActionPerformed(evt);
            }
        });

        att_rep.setFont(new java.awt.Font("Tahoma", 1, 14));
        att_rep.setText("Отчет Аттестация");
        att_rep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                att_repActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(devButton, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(pov_rep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(att_rep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pov_rep, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(devButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(att_rep, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bPanel.add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Аттестация"));

        AttButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        AttButton.setText("Аттестация");
        AttButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AttButton, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(AttButton, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );

        bPanel.add(jPanel3);

        getContentPane().add(bPanel);
        bPanel.setBounds(59, 6, 589, 157);

        pic.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout picLayout = new javax.swing.GroupLayout(pic);
        pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );
        picLayout.setVerticalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        getContentPane().add(pic);
        pic.setBounds(300, 170, 100, 100);

        File.setText("Файл");

        Exit.setText("Выход");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar1.add(File);

        Help.setText("Помощь");

        About.setText("О программе");
        Help.add(About);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PovButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PovButtonActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                PoverkaFrame.getInstance().setVisible(true);
            }
        });
    }//GEN-LAST:event_PovButtonActionPerformed

    private void AttButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttButtonActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                AttestationFrame.getInstance().setVisible(true);
            }
        });
    }//GEN-LAST:event_AttButtonActionPerformed

    private void devButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devButtonActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                EditDevFrame.getInstance().setVisible(true);
            }
        });
    }//GEN-LAST:event_devButtonActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void att_repActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_att_repActionPerformed
        AttToExcel attToExcel = new AttToExcel(this.sb);
        attToExcel.populate();
    }//GEN-LAST:event_att_repActionPerformed

    private void pov_repActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pov_repActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ReportFrame.getInstance().setVisible(true);
            }
        });
    }//GEN-LAST:event_pov_repActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(final String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                new MainFrame().setVisible(true);


            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JButton AttButton;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    private javax.swing.JButton PovButton;
    private javax.swing.JButton att_rep;
    private javax.swing.JPanel bPanel;
    private javax.swing.JButton devButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pic;
    private javax.swing.JButton pov_rep;
    public javax.swing.JLabel sb;
    // End of variables declaration//GEN-END:variables
}
