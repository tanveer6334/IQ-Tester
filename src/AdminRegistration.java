//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
//import java.awt.Window.Type;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class AdminRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JTextField nameField;
	private JPasswordField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegistration frame = new AdminRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JPasswordField passField2;
	/**
	 * Create the frame.
	 */
	public AdminRegistration() {
		setTitle("Admin Registration");
		setType(Type.UTILITY);
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
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
        
        
        
		userField = new JTextField();
		userField.setFont(new Font("Dialog", Font.BOLD, 16));
		userField.setColumns(10);
		userField.setBounds(568, 164, 250, 50);
		contentPane.add(userField);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Dialog", Font.BOLD, 16));
		nameField.setColumns(10);
		nameField.setBounds(568, 63, 250, 50);
		contentPane.add(nameField);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Dialog", Font.BOLD, 16));
		passField.setBounds(568, 258, 250, 50);
		contentPane.add(passField);
		
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setIcon(new ImageIcon(AdminRegistration.class.getResource("/icon64/user.png")));
		nameLbl.setForeground(Color.BLACK);
		nameLbl.setFont(new Font("Dialog", Font.BOLD, 15));
		nameLbl.setBounds(348, 51, 200, 70);
		contentPane.add(nameLbl);
		
		JLabel userLbl = new JLabel("Username");
		userLbl.setIcon(new ImageIcon(AdminRegistration.class.getResource("/icon64/users.png")));
		userLbl.setForeground(Color.BLACK);
		userLbl.setFont(new Font("Dialog", Font.BOLD, 15));
		userLbl.setBounds(348, 152, 200, 70);
		contentPane.add(userLbl);
		
		JLabel passLbl = new JLabel("Password");
		passLbl.setIcon(new ImageIcon(AdminRegistration.class.getResource("/icon64/key.png")));
		passLbl.setForeground(Color.BLACK);
		passLbl.setFont(new Font("Dialog", Font.BOLD, 15));
		passLbl.setBounds(348, 246, 200, 70);
		contentPane.add(passLbl);
		
		JLabel confirmLbl = new JLabel("Confirm Password");
		confirmLbl.setIcon(new ImageIcon(AdminRegistration.class.getResource("/icon64/Confirm-pass.png")));
		confirmLbl.setForeground(Color.BLACK);
		confirmLbl.setFont(new Font("Dialog", Font.BOLD, 15));
		confirmLbl.setBounds(348, 343, 200, 70);
		contentPane.add(confirmLbl);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setIcon(new ImageIcon(AdminRegistration.class.getResource("/icon64/accepted-notes.png")));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checker();
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignUp.setBounds(516, 464, 180, 70);
		contentPane.add(btnSignUp);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(AdminRegistration.class.getResource("/icon32/home.png")));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage frame = new MainPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHome.setBounds(1085, 611, 120, 40);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(AdminRegistration.class.getResource("/icon32/previous.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage frame = new AdminPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(70, 611, 120, 40);
		contentPane.add(btnBack);
		
		passField2 = new JPasswordField();
		passField2.setFont(new Font("Dialog", Font.BOLD, 16));
		passField2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        btnSignUp.doClick();
			    }
			}
		});
		passField2.setBounds(568, 355, 250, 50);
		contentPane.add(passField2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminRegistration.class.getResource("/Background/20.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
	}
	
	@SuppressWarnings("deprecation")
	public void checker()
	{
		/*
		 * Set User Registration value
		 */
		
		String pass1 = passField.getText();
		String pass2 = passField2.getText();
		
		if(!pass1.equals(pass2)){
			passField.setText("");
			passField2.setText("");
			JOptionPane.showMessageDialog(null, "Password do not match");
			return;
		}
		else{
			
			try{
				String query="select * from Admin where Username=?";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.setString(1, userField.getText());
			
				ResultSet rs = pst.executeQuery();
			
				int count = 0;
				while(rs.next()){
					count++;
				}
				
				pst.close();
				rs.close();
				
				if(count >= 1){
					JOptionPane.showMessageDialog(null, "Username already Exists");
					return;
				}
				else{
					storeInfo();
					return;
				}
				
				
			}catch(Exception e7){
				e7.printStackTrace();
			}
		
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public void storeInfo()
	{

		
		try{
			String query = "insert into Admin (Name,Username,Password) values (?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			
			pst.setString(1, nameField.getText());
			pst.setString(2, userField.getText());	
			pst.setString(3, passField.getText());
			
			pst.execute();
			pst.close();
			
			JOptionPane.showMessageDialog(null, "Admin Registered");
		
			AdminPage frame = new AdminPage();
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			frame.setUndecorated(true);
			frame.setVisible(true);
			dispose();
		
			return;
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
}
