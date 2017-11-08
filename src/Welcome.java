import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Window.Type;

public class Welcome {

	
	private JButton btnWc;
	private JLabel lblName;
	private JTextPane quotePane;
	
	JFrame frmHome;
	private JButton btnSkip;
	private JLabel lblNewLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frmHome.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frmHome.setUndecorated(true);
		frmHome.getContentPane().setBackground(Color.WHITE);
		frmHome.setTitle("IQ Tester");
		frmHome.setType(Type.UTILITY);
		frmHome.setBounds(100, 100, 1280, 720);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);
		
		
		/*
		 * Layout 1
		 */
		
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(frmHome);
		
        
        
        
        
		
        /*
         *	Escape code 
         */
        
        frmHome.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT"); 
        frmHome.getRootPane().getActionMap().put("EXIT", new AbstractAction(){ 
        public void actionPerformed(ActionEvent e)
        	{
        		//frmHome.dispose();
        		System.exit(0);
        	}
        });
        
        
        
		btnWc = new JButton("Welcome!");
		btnWc.setIcon(new ImageIcon(Welcome.class.getResource("/icon64/binary-thinking.png")));
		btnWc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        System.out.println("Hello");
			        btnWc.doClick();
			    }
				
			}
		});
		btnWc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnWc.setVisible(false);
				quotePane.setVisible(true);
				lblName.setVisible(true);
				btnSkip.setVisible(true);
				quotePane.setText("When you start in science, you are brainwashed into believing how careful you must be, and how difficult it is to discover things. There's something that might be called the 'graduate student syndrome'; graduate students hardly believe they can make a discovery.");
				lblName.setText("~Francis Crick");
			}
		});
		btnWc.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnWc.setBounds(472, 275, 300, 90);
		frmHome.getContentPane().add(btnWc);
		
		lblName = new JLabel("Name");
		lblName.setBackground(Color.BLACK);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblName.setBounds(865, 409, 207, 69);
		frmHome.getContentPane().add(lblName);
		
		quotePane = new JTextPane();
		quotePane.setFont(new Font("Tahoma", Font.ITALIC, 30));
		quotePane.setText("Quote");
		quotePane.setBounds(204, 148, 850, 250);
		frmHome.getContentPane().add(quotePane);
		
		btnSkip = new JButton("Skip");
		btnSkip.setIcon(new ImageIcon(Welcome.class.getResource("/icon32/next.png")));
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage frame = new MainPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				frmHome.dispose();
			}
		});
		
		btnSkip.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSkip.setBounds(543, 557, 150, 50);
		frmHome.getContentPane().add(btnSkip);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Welcome.class.getResource("/Background/brain.jpg")));
		lblNewLabel.setBounds(138, 11, 1008, 729);
		frmHome.getContentPane().add(lblNewLabel);
		
		/*
		 * Hide Components
		 */
		 	btnWc.setVisible(true);
		 	quotePane.setVisible(false);
		 	lblName.setVisible(false);
		 	btnSkip.setVisible(false);
		 	
		 	
	}
}
