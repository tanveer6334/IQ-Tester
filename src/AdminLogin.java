
//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.sql.*;
import javax.swing.*;
import java.awt.Font;
//import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
//import java.awt.Window.Type;


@SuppressWarnings("serial")
public class AdminLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField userField;
	private JPasswordField passField;
	private JButton homeBtn;
	private JButton btnBack;
	private JButton btnLogin;
	private JLabel label;
	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setType(Type.UTILITY);
		connection=sqliteConnection.dbConnector();
		
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280,720);
		contentPane = new JPanel();
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
        
        
        
		JLabel userLbl = new JLabel("Admin");
		userLbl.setIcon(new ImageIcon(AdminLogin.class.getResource("/icon64/user.png")));
		userLbl.setForeground(Color.BLACK);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		userLbl.setBounds(321, 188, 150, 70);
		contentPane.add(userLbl);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setIcon(new ImageIcon(AdminLogin.class.getResource("/icon64/key.png")));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(321, 275, 150, 70);
		contentPane.add(lblPassword);
		
		userField = new JTextField();
		userField.setFont(new Font("Tahoma", Font.BOLD, 16));
		userField.setBounds(516, 199, 300, 50);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		/*
		 * if pressed enter, automatic login
		 */
		passField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        //System.out.println("Hello");
			        btnLogin.doClick();
			    }
			}
		});
		
		passField.setBounds(516, 287, 300, 50);
		contentPane.add(passField);
		
		btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(AdminLogin.class.getResource("/icon64/unlocked-padlock.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userChecker();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBounds(563, 364, 145, 73);
		contentPane.add(btnLogin);
		
		homeBtn = new JButton("Home");
		homeBtn.setIcon(new ImageIcon(AdminLogin.class.getResource("/icon32/home.png")));
		homeBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage frame = new MainPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		homeBtn.setBounds(1004, 560, 120, 40);
		contentPane.add(homeBtn);
		
		btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(AdminLogin.class.getResource("/icon32/previous.png")));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage frame = new MainPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(169, 560, 120, 40);
		contentPane.add(btnBack);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(AdminLogin.class.getResource("/Background/16.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void userChecker(){
		try{
			
			String query="select * from Admin where Username=? and Password=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, userField.getText());
			pst.setString(2, passField.getText());
			
			ResultSet rs = pst.executeQuery();
			
			int count = 0;
			while(rs.next()){
				count++;
			}
			

			pst.close();
			rs.close();
			
			
			if(count == 1){
				JOptionPane.showMessageDialog(null, "Admin Logged In");
				
				AdminPage frame = new AdminPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
				return;
			}
			else if(count > 1){
				JOptionPane.showMessageDialog(null, "Duplicate Username and password");
				return;
			}
			else{
				JOptionPane.showMessageDialog(null, "Username and password not correct");
				return;
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}

}
