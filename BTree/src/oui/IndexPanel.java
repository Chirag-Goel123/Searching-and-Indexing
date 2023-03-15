package oui;
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
import javax.swing.JComboBox;

public class IndexPanel extends JPanel implements ActionListener{
    private JLabel lblRows;
    private JComboBox comboIndices;
    private JButton btnCreate;
    private JProgressBar progressBar; 

    public IndexPanel(JTabbedPane tabPane)
    {
        tabPane.addTab("Indices",this);
        initComponents();
    }
    private void initComponents()
    {
        this.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.darkGray));
        this.setBackground(new Color(0,100,0));

        lblRows=new JLabel();
        lblRows.setFont(new Font("Monospaced",0,50));
        lblRows.setForeground(new Color(255,255,255));
        lblRows.setText("Column:");

        comboIndices=new JComboBox(new String[] {"Select-One",:"Name","UserName","Password"});
        comboIndices.setFont(new Font("Monospaced",0,35));

        btnCreate=new JButton();
        btnCreate.setFont(new Font("Monospaced",0,50));
        btnCreate.addActionListener(this);

        progressBar=new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setFont(new Font("Monospaced",0,50));

        javax.swing.GroupLayout layout=new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup().addGroup(
            layout.createSequentialGroup()
            .addContainerGap(0, Short.MAX_VALUE)
            .addComponent(lblRows)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(comboIndices)
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
        .addComponent(comboIndices)
        .addComponent(lblRows)
        .addGap(50, 50, 50)
        .addComponent(btnCreate)
        .addGap(50, 50, 50)
        .addComponent(progressBar))
        .addContainerGap(0,Short.MAX_VALUE));
    }
    public void actionPerformed(ActionEvent ae)
    {
        IndexPanel obj=this;
        Thread t=new Thread(new Runnable() {
            @Override
            public void run()
            {
                try{
                    if(comboIndices.getSelectedIndex()==0)
                    {
                        JOptionPane.showMessageDialog(obj, "Please Select a Cloumn");
                        return;
                    }
                    DataManager.CreateIndex(comboIndices.getSelectedItem().toString(),obj);
                    JOptionPane.showMessageDialog(obj, "Index Created Succesfully");
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
