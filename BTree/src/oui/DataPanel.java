package oui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class DataPanel extends JPanel implements ActionListener{
    
    private JPanel lblRows;
    private JTextField txtRows;
    private JButton btnCreate;
    private JProgressBar progressBar; 
    public DataPanel(JTabbedPane tabPane)
    {
        tabPane.addTab("Data", this);
        initComponents();
    }
    private void initComponents(){
        
    }
}
