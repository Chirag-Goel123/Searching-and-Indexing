package oui;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
public class App extends JFrame{
    JTabbedPane tabPane;
    HomePanel homePanel;
    DataPanel dataPanel;
    IndexPanel indexPanel;
    QueryPanel queryPanel;

    public App()
    {
        tabPane=new JTabbedPane();
        tabPane.setFont(new Font("Comic Sans MS",1,30));
        tabPane.setBackground(Color.DARK_GRAY);
        tabPane.setForeground(Color.WHITE);

        homePanel=new HomePanel(tabPane);
        dataPanel=new DataPanel(tabPane);
        // indexPanel=new IndexPanel(tabPane);
        // queryPanel=new QueryPanel(tabPane);

        // Add tabPane in JFrame
        super.add(tabPane);

        pack();
        super.setTitle("Index Implementation");
        super.setExtendedState(MAXIMIZED_BOTH);
        //Close JVM also when we close window
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
}
