import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setType(Type.UTILITY);
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * Layout 1
		 */
		
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(contentPane);
        
        /*
         *	Escape code 
         */
        
        contentPane.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT"); 
        contentPane.getRootPane().getActionMap().put("EXIT", new AbstractAction(){ 
        public void actionPerformed(ActionEvent e)
        	{
        		//frmHome.dispose();
        		System.exit(0);
        	}
        });
        
        
        
		
		JButton btnUserReg = new JButton("New User");
		btnUserReg.setIcon(new ImageIcon(MainPage.class.getResource("/icon64/user-2.png")));
		btnUserReg.setFont(new Font("Dialog", Font.BOLD, 20));
		btnUserReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserRegistration frame = new UserRegistration();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				frame.setVisible(true);
				dispose();
				return;
			}
		});
		btnUserReg.setBounds(463, 42, 250, 70);
		contentPane.add(btnUserReg);
		
		JButton UserLogIn = new JButton("Old User");
		UserLogIn.setIcon(new ImageIcon(MainPage.class.getResource("/icon64/avatar.png")));
		UserLogIn.setFont(new Font("Dialog", Font.BOLD, 20));
		UserLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin frame = new UserLogin();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				frame.setVisible(true);
				dispose();
				return;
			}
		});
		UserLogIn.setBounds(463, 140, 250, 70);
		contentPane.add(UserLogIn);
		
		JButton btnScore = new JButton("High Scores");
		btnScore.setIcon(new ImageIcon(MainPage.class.getResource("/icon64/comparative.png")));
		btnScore.setFont(new Font("Dialog", Font.BOLD, 20));
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comparison frame = new Comparison();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				frame.setVisible(true);
				dispose();
				return;
			}
		});
		btnScore.setBounds(463, 242, 250, 70);
		contentPane.add(btnScore);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setIcon(new ImageIcon(MainPage.class.getResource("/icon64/user.png")));
		btnAdmin.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin frame = new AdminLogin();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				frame.setVisible(true);
				dispose();
				return;
			}
		});
		btnAdmin.setBounds(463, 345, 250, 70);
		contentPane.add(btnAdmin);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setIcon(new ImageIcon(MainPage.class.getResource("/icon64/worker.png")));
		btnCredits.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credits frame = new Credits();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				frame.setVisible(true);
				dispose();
				return;
			}
		});
		btnCredits.setBounds(463, 450, 250, 70);
		contentPane.add(btnCredits);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(MainPage.class.getResource("/icon64/cancel-button.png")));
		btnExit.setFont(new Font("Dialog", Font.BOLD, 20));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(463, 551, 250, 70);
		contentPane.add(btnExit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainPage.class.getResource("/Image/use ur brain.jpg")));
		label.setBounds(697, 0, 1008, 729);
		contentPane.add(label);
	}
}
