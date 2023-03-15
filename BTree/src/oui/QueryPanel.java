package oui;

import javax.swing.JPanel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.xml.crypto.Data;
import javax.naming.directory.SearchResult;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class QueryPanel extends JPanel implements ActionListener{
    private JLabel lblselQuery;
    private JComboBox comboBoxQuery;
    private JLabel lbleql;
    private JTextField txtQuery;
    private JButton btnSearch;
    private JLabel lblStats;
    private JLabel lblUser;

    public QueryPanel(JTabbedPane tabPane)
    {
        tabPane.addTab("Query", this);
        initComponents();
    }
    private void initComponents()
    {
        this.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.darkGray));
        this.setBackground(new Color(0,100,0));

        lblselQuery=new JLabel();
        lblselQuery.setFont(new Font("Monospaced",0,45));
        lblselQuery.setForeground(new Color(255,255,255));
        lblselQuery.setText("Select * from Table Where ");

        String[] option={"Name","UserName","Password"};
        comboBoxQuery=new JComboBox<>(option);
        comboBoxQuery.setFont(new Font("Monospaced",0,20));
        comboBoxQuery.setPreferredSize(new Dimension(150,50));
        
        lbleql=new JLabel();
        lbleql.setFont(new Font("Monospaced",0,45));
        lbleql.setForeground(new Color(255,255,255));
        lbleql.setText("=");

        txtQuery=new JTextField("");
        txtQuery.setColumns(10);
        txtQuery.setFont(new Font("Monospaced",0,36));

        btnSearch=new JButton();
        btnSearch.setFont(new Font("Monospaced",0,50));
        btnSearch.setText("Search");
        btnSearch.addActionListener(this);

        lblStats=new JLabel();
        lblStats.setFont(new Font("Monospaced",0,25));
        lblStats.setForeground(new Color(255,255,255));
        lblStats.setText("Search Method: ##SM##,Time taken: ##TT##,Pages Read: ##PR##");

        lblUser=new JLabel();
        lblUser.setFont(new Font("Monospaced",0,25));
        lblUser.setForeground(new Color(255,255,255));
        lblUser.setText("Id: ##ID##, Name: ##Name##, User Name: ##UN##,Password: ##PWD##");

        javax.swing.GroupLayout layout=new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup().addGroup(
            layout.createSequentialGroup()
            .addContainerGap(0, Short.MAX_VALUE)
            .addComponent(lblselQuery)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(comboBoxQuery)
            .addContainerGap(0,Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup().addContainerGap(0,Short.MAX_VALUE)
            .addComponent(lbleql)
            .addContainerGap(0,Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup().addContainerGap(0,Short.MAX_VALUE)
            .addComponent(txtQuery)
            .addContainerGap(0,Short.MAX_VALUE)))
        ));

        layout.setVerticalGroup(layout.createSequentialGroup()
        .addContainerGap(0, Short.MAX_VALUE)

        .addGroup(layout.createParallelGroup()
        .addComponent(lblselQuery)
        .addComponent(comboBoxQuery)
        .addGap(50, 50, 50)
        .addComponent(lbleql)
        .addGap(50, 50, 50)
        .addComponent(txtQuery))
        .addGap(50,50,50)
        .addComponent(btnSearch)
        .addGap(50, 50, 50)
        .addComponent(lblStats)
        .addGap(50, 50, 50)
        .addComponent(lblUser)
        .addContainerGap(0,Short.MAX_VALUE));
    }
    public void actionPerformed(ActionEvent ae)
    {
       DataManager.Search(comboBoxQuery.getSelectedItem().toString(),txtQuery.getText());
    }

    public void updateResults(SearchResult result)
    {
        if(result.DataRow!=null)
        {
            lblUser.setText(
                "RollNumber: ##RNO## ,Name: ##NAME##, User Name: ##UN##,Password: ##PWD##"
                .replace("##RNO##", result.DataRow.RollNum +"\n")
                .replace("##NAME##", result.DataRow.Name +"\n")
                .replace("##UN##", result.DataRow.UserName +"\n")
                .replace("##PWD##", result.DataRow.Password +"\n")
                
            );
        }
        lblStats.setText(
            "Search Method: ##SM## , Time taken: ##TT##,Pages Read: ##PR##"
            .replace("##SM##", result.IndexUsed? "Index Seek\n":"Table Scan \n")
            .replace("##TT##", result.TimeTaken+" ms\n")
            .replace("##PR##", result.PagesLoaded +"\n")
        );
    }
}
