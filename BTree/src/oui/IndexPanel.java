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
    }
    public void actionPerformed(ActionEvent ae)
    {

    }
}
