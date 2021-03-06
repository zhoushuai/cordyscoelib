/*
 * ChooseAppender.java
 *
 * Created on January 14, 2009, 12:39 PM
 */

package com.cordys.coe.tools.orgmanager;

import com.cordys.coe.tools.orgmanager.log4j.Appender;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 * This method allows to choose the appender.
 *
 * @author  pgussow
 */
public class ChooseAppender extends javax.swing.JDialog
{
    /**
     * Holds all appenders that were selected.
     */
    private ArrayList<String> m_alSelected = new ArrayList<String>();
    /**
     * Holds whether or not the dialog was closed OK.
     */
    private boolean m_bOK;

    /**
     * This method returns whether or not the dialog was closed by clicking the OK button.
     *
     * @return  Whether or not the dialog was closed by clicking the OK button.
     */
    public boolean isOK()
    {
        return m_bOK;
    }

    /**
     * Creates new form ChooseAppender.
     *
     * @param  parent       DOCUMENTME
     * @param  modal        DOCUMENTME
     * @param  alAppenders  DOCUMENTME
     * @param  alSelected   DOCUMENTME
     */
    public ChooseAppender(java.awt.Frame parent, boolean modal, ArrayList<Appender> alAppenders,
                          ArrayList<String> alSelected)
    {
        super(parent, modal);
        initComponents();

        DefaultTableModel dtm = (DefaultTableModel) m_tblAppenders.getModel();

        for (Appender aAppender : alAppenders)
        {
            boolean bSelected = false;

            if (alSelected.contains(aAppender.getName()))
            {
                bSelected = true;
            }

            dtm.addRow(new Object[] { bSelected, aAppender.getName(), aAppender.getClassName() });
        }
    }

    /**
     * This method returns the selected appenders.
     *
     * @return  The selected appenders.
     */
    public ArrayList<String> getSelectedAppenders()
    {
        return new ArrayList<String>(m_alSelected);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    private void initComponents()
    {
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JButton bOK = new javax.swing.JButton();
        javax.swing.JButton bCancel = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        m_tblAppenders = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Choose the appenders to add");

        bOK.setText("OK");
        bOK.setMaximumSize(new java.awt.Dimension(75, 23));
        bOK.setMinimumSize(new java.awt.Dimension(75, 23));
        bOK.setPreferredSize(new java.awt.Dimension(75, 23));
        bOK.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    bOKActionPerformed(evt);
                }
            });
        jPanel1.add(bOK);

        bCancel.setText("Cancel");
        bCancel.setMaximumSize(new java.awt.Dimension(75, 23));
        bCancel.setMinimumSize(new java.awt.Dimension(75, 23));
        bCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        bCancel.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    bCancelActionPerformed(evt);
                }
            });
        jPanel1.add(bCancel);

        m_tblAppenders.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
                                                                        new String[] { "", "Name", "Class" })
            {
                Class<?>[] types = new Class[]
                                   {
                                       java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
                                   };
                boolean[] canEdit = new boolean[] { true, false, false };

                public Class<?> getColumnClass(int columnIndex)
                {
                    return types[columnIndex];
                }

                @Override public boolean isCellEditable(int rowIndex, int columnIndex)
                {
                    return canEdit[columnIndex];
                }
            });
        m_tblAppenders.addMouseListener(new java.awt.event.MouseAdapter()
            {
                public void mouseClicked(java.awt.event.MouseEvent evt)
                {
                    doDoubleClick(evt);
                }
            });
        jScrollPane1.setViewportView(m_tblAppenders);
        m_tblAppenders.getColumnModel().getColumn(0).setMinWidth(20);
        m_tblAppenders.getColumnModel().getColumn(0).setPreferredWidth(20);
        m_tblAppenders.getColumnModel().getColumn(0).setMaxWidth(20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax
                                                                                                                 .swing
                                                                                                                 .GroupLayout
                                                                                                                 .Alignment.TRAILING,
                                                                                                                 layout
                                                                                                                 .createSequentialGroup()
                                                                                                                 .addContainerGap()
                                                                                                                 .addGroup(layout
                                                                                                                           .createParallelGroup(javax
                                                                                                                                                .swing
                                                                                                                                                .GroupLayout
                                                                                                                                                .Alignment.TRAILING)
                                                                                                                           .addComponent(jPanel1,
                                                                                                                                         javax
                                                                                                                                         .swing
                                                                                                                                         .GroupLayout
                                                                                                                                         .Alignment.LEADING,
                                                                                                                                         javax
                                                                                                                                         .swing
                                                                                                                                         .GroupLayout.DEFAULT_SIZE,
                                                                                                                                         539,
                                                                                                                                         Short.MAX_VALUE)
                                                                                                                           .addComponent(jScrollPane1,
                                                                                                                                         javax
                                                                                                                                         .swing
                                                                                                                                         .GroupLayout
                                                                                                                                         .Alignment.LEADING,
                                                                                                                                         javax
                                                                                                                                         .swing
                                                                                                                                         .GroupLayout.DEFAULT_SIZE,
                                                                                                                                         539,
                                                                                                                                         Short.MAX_VALUE))
                                                                                                                 .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax
                                                                                                               .swing
                                                                                                               .GroupLayout
                                                                                                               .Alignment.TRAILING,
                                                                                                               layout
                                                                                                               .createSequentialGroup()
                                                                                                               .addContainerGap()
                                                                                                               .addComponent(jScrollPane1,
                                                                                                                             javax
                                                                                                                             .swing
                                                                                                                             .GroupLayout.DEFAULT_SIZE,
                                                                                                                             112,
                                                                                                                             Short.MAX_VALUE)
                                                                                                               .addPreferredGap(javax
                                                                                                                                .swing
                                                                                                                                .LayoutStyle
                                                                                                                                .ComponentPlacement.RELATED)
                                                                                                               .addComponent(jPanel1,
                                                                                                                             javax
                                                                                                                             .swing
                                                                                                                             .GroupLayout.PREFERRED_SIZE,
                                                                                                                             javax
                                                                                                                             .swing
                                                                                                                             .GroupLayout.DEFAULT_SIZE,
                                                                                                                             javax
                                                                                                                             .swing
                                                                                                                             .GroupLayout.PREFERRED_SIZE)
                                                                                                               .addContainerGap()));

        pack();
    } // </editor-fold>//GEN-END:initComponents

    /**
     * DOCUMENTME.
     *
     * @param  evt  DOCUMENTME
     */
    private void bOKActionPerformed(java.awt.event.ActionEvent evt) //GEN-FIRST:event_bOKActionPerformed
    {
        DefaultTableModel dtm = (DefaultTableModel) m_tblAppenders.getModel();

        for (int iCount = 0; iCount < dtm.getRowCount(); iCount++)
        {
            boolean bTemp = (Boolean) dtm.getValueAt(iCount, 0);

            if (bTemp == true)
            {
                m_alSelected.add((String) dtm.getValueAt(iCount, 1));
            }
        }
        m_bOK = true;
        dispose();
    } //GEN-LAST:event_bOKActionPerformed

    /**
     * This method cancels the dialog.
     *
     * @param  evt  The click event.
     */
    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) //GEN-FIRST:event_bCancelActionPerformed
    {
        m_bOK = false;
        dispose();
    } //GEN-LAST:event_bCancelActionPerformed

    /**
     * DOCUMENTME.
     *
     * @param  evt  DOCUMENTME
     */
    private void doDoubleClick(java.awt.event.MouseEvent evt) //GEN-FIRST:event_doDoubleClick
    {
        if (evt.getClickCount() == 2)
        {
            int iRow = m_tblAppenders.getSelectedRow();

            if (iRow >= 0)
            {
                DefaultTableModel dtm = (DefaultTableModel) m_tblAppenders.getModel();
                m_alSelected.add((String) dtm.getValueAt(iRow, 1));

                m_bOK = true;
                dispose();
            }
        }
    } //GEN-LAST:event_doDoubleClick

    /**
     * DOCUMENTME.
     *
     * @param  args  the command line arguments
     */
    public static void main(String[] args)
    {
        final ArrayList<Appender> al = new ArrayList<Appender>();
        Appender a = new Appender();
        a.setName("a");
        a.setClassName("a.a.a.a");
        al.add(a);
        a = new Appender();
        a.setName("b");
        a.setClassName("b.b.b.b");
        al.add(a);
        a = new Appender();
        a.setName("c");
        a.setClassName("c.c.c.c");
        al.add(a);
        a = new Appender();
        a.setName("d");
        a.setClassName("d.d.d.d");
        al.add(a);
        java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    final ChooseAppender dialog = new ChooseAppender(new javax.swing.JFrame(), true, al,
                                                                     new ArrayList<String>());
                    dialog.addWindowListener(new java.awt.event.WindowAdapter()
                        {
                            public void windowClosing(java.awt.event.WindowEvent e)
                            {
                                if (dialog.isOK())
                                {
                                    System.out.println("OK! " + dialog.getSelectedAppenders());
                                }
                                else
                                {
                                    System.out.println("Canceled");
                                }
                                System.exit(0);
                            }
                        });
                    dialog.setVisible(true);
                }
            });
    }

    /**
     * Variables declaration - do not modify//GEN-BEGIN:variables.
     */
    private javax.swing.JTable m_tblAppenders;
    // End of variables declaration//GEN-END:variables
}
