package oui;


import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
public class HomePanel extends javax.swing.JPanel{
    public HomePanel (JTabbedPane tabPane)
    {
        tabPane.addTab("Home", this);
        initComponents();
    }
    private JTextArea jTextArea;
    private void initComponents()
    {
        this.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.darkGray));
        this.setBackground(new Color(0,100,0));

        jTextArea=new JTextArea();
        jTextArea.setFont(new Font("Monospaced",0,35));
        jTextArea.setForeground(new Color(102,0,102));
        jTextArea.setColumns(60);
        jTextArea.setRows(5);
        jTextArea.setText("In this project,we are making a software which will make ");
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);

        javax.swing.GroupLayout layout=new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
            layout.createSequentialGroup()
            .addContainerGap(0, Short.MAX_VALUE)
            .addComponent(jTextArea)
            .addContainerGap(0,Short.MAX_VALUE)
        ));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
            layout.createSequentialGroup()
            .addContainerGap(0, Short.MAX_VALUE)
            .addComponent(jTextArea)
            .addContainerGap(0,Short.MAX_VALUE)
        ));
    }
}
