import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	private DetailsPanel detailsPanel;
	
	
	public MainFrame(String title, int layoutVersion){
		super(title);
		
		//setlayout manager
		setLayout(new BorderLayout());
		
		
		//cre
		
		System.out.println("layoutversion is: " + layoutVersion);
		detailsPanel = new DetailsPanel(layoutVersion);	
		//add swing components to content pane 	
		Container c = getContentPane();	
		c.add(detailsPanel, BorderLayout.WEST);
		
		
		
	}
	
	
}
