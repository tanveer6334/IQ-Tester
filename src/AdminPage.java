//import java.awt.BorderLayout;
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
//import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class AdminPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setTitle("Admin Panel");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280,720);
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
        
        
        
		JButton btnAddQuestion = new JButton("Text Question");
		btnAddQuestion.setIcon(new ImageIcon(AdminPage.class.getResource("/icon64/file.png")));
		btnAddQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuesUpdate frame = new QuesUpdate();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();			
			}
		});
		
		JButton btnAddImageQuestion = new JButton("Image Question");
		btnAddImageQuestion.setIcon(new ImageIcon(AdminPage.class.getResource("/icon64/picture.png")));
		btnAddImageQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddImageQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageQupdate frame = new ImageQupdate();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAddImageQuestion.setBounds(484, 164, 300, 70);
		contentPane.add(btnAddImageQuestion);
		btnAddQuestion.setBounds(484, 68, 300, 70);
		contentPane.add(btnAddQuestion);
		
		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.setIcon(new ImageIcon(AdminPage.class.getResource("/icon64/admin-with-cogwheels.png")));
		btnEditUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserData frame = new UserData();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnEditUser.setBounds(484, 259, 300, 70);
		contentPane.add(btnEditUser);
		
		JButton btnChangeSetting = new JButton("Change Setting");
		btnChangeSetting.setIcon(new ImageIcon(AdminPage.class.getResource("/icon64/settings.png")));
		btnChangeSetting.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChangeSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings frame = new Settings();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnChangeSetting.setBounds(484, 354, 300, 70);
		contentPane.add(btnChangeSetting);
		
		JButton btnAddAdmin = new JButton("Add Admin");
		btnAddAdmin.setIcon(new ImageIcon(AdminPage.class.getResource("/icon64/user-2.png")));
		btnAddAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRegistration frame = new AdminRegistration();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAddAdmin.setBounds(484, 454, 300, 70);
		contentPane.add(btnAddAdmin);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(AdminPage.class.getResource("/icon64/home.png")));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage frame = new MainPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(484, 550, 300, 70);
		contentPane.add(btnHome);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminPage.class.getResource("/Background/11.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
	}
}
