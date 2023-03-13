package oui;

import java.awt.Color;
import java.awt.Font;
import java.lang.foreign.GroupLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DataPanel extends JPanel implements ActionListener{
    
    private JLabel lblRows;
    private JTextField txtRows;
    private JButton btnCreate;
    private JProgressBar progressBar; 
    public DataPanel(JTabbedPane tabPane)
    {
        tabPane.addTab("Data", this);
        initComponents();
    }
    private void initComponents()
    {
        this.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.darkGray));
        this.setBackground(new Color(0,100,0));

        lblRows=new JLabel();
        lblRows.setFont(new Font("Monospaced",0,50));
        lblRows.setForeground(new Color(255,255,255));
        lblRows.setText("Rows");

        txtRows=new JTextField();
        txtRows.setColumns(10);
        txtRows.setFont(new Font("Monospaced",0,50));

        btnCreate=new JButton();
        btnCreate.setFont(new Font("Monospaced",0,50));
        btnCreate.setText("Create Test Data");
        // On button Click code fire.. Observer Design Pattern
        // On button Click actionPerfomed function will fire
        // in argument pass only those object who implements actionListener Interface
        btnCreate.addActionListener(this);

        progressBar=new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setMaximum(0);
        progressBar.setMaximum(100);
        progressBar.setFont(new Font("Monospaced",0,50));

        javax.swing.GroupLayout layout=new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup().addGroup(
            layout.createSequentialGroup()
            .addContainerGap(0, Short.MAX_VALUE)
            .addComponent(lblRows)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtRows)
            .addContainerGap(0,Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup().addContainerGap(0,Short.MAX_VALUE)
            .addComponent(btnCreate)
            .addContainerGap(0,Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup().addContainerGap(0,Short.MAX_VALUE)
            .addComponent(progressBar)
            .addContainerGap(0,Short.MAX_VALUE)))
        ));

        layout.setVerticalGroup(layout.createSequentialGroup()
        .addContainerGap(0, Short.MAX_VALUE)

        .addGroup(layout.createParallelGroup()
        .addComponent(txtRows)
        .addComponent(lblRows)
        .addGap(50, 50, 50)
        .addComponent(btnCreate)
        .addGap(50, 50, 50)
        .addComponent(progressBar))
        .addContainerGap(0,Short.MAX_VALUE));
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        DataPanel obj=this;
        Thread t=new Thread(new Runnable() {
            @Override
            public void run()
            {
                try{
                    int rows=Integer.parseInt(txtRows.getText());
                    DataManager.CreateData(rows,obj);
                    JOptionPane.showMessageDialog(obj, "Data Created Succesfully");
                    progressBar.setValue(0);
                }
                catch(Exception ex)
                {

                }
            }
        });
        t.start();
    }

    public void updateStatus(int percent)
    {
        progressBar.setValue(percent);
    }
}
