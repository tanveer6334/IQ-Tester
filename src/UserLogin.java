import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passField;
	private JButton loginBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JButton backBtn;
	private JButton homeBtn;
	private JLabel label;
	/**
	 * Create the frame.
	 */
	public UserLogin() {
		setType(Type.UTILITY);
		setTitle("Log In");
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
		userField.setFont(new Font("Tahoma", Font.BOLD, 16));
		userField.setBounds(530, 122, 250, 40);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Tahoma", Font.BOLD, 16));
		passField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        //System.out.println("Hello");
			        loginBtn.doClick();
			    }
			}
		});
		passField.setBounds(530, 244, 250, 40);
		contentPane.add(passField);
		
		JLabel userLbl = new JLabel("Username");
		userLbl.setIcon(new ImageIcon(UserLogin.class.getResource("/icon64/users.png")));
		userLbl.setBackground(new Color(240, 240, 240));
		userLbl.setForeground(Color.BLACK);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		userLbl.setBounds(370, 107, 150, 70);
		contentPane.add(userLbl);
		
		JLabel passLbl = new JLabel("Password");
		passLbl.setIcon(new ImageIcon(UserLogin.class.getResource("/icon64/key.png")));
		passLbl.setBackground(new Color(240, 240, 240));
		passLbl.setForeground(Color.BLACK);
		passLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		passLbl.setBounds(370, 227, 150, 70);
		contentPane.add(passLbl);
		
		loginBtn = new JButton("Login");
		loginBtn.setIcon(new ImageIcon(UserLogin.class.getResource("/icon64/unlocked-padlock.png")));
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Check login ID PASS
				 */
				
				userChecker();
				
				
			}
		});
		loginBtn.setBounds(509, 366, 170, 70);
		contentPane.add(loginBtn);
		
		backBtn = new JButton("Back");
		backBtn.setIcon(new ImageIcon(UserLogin.class.getResource("/icon32/previous.png")));
		backBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage frame = new MainPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		backBtn.setBounds(159, 567, 120, 40);
		contentPane.add(backBtn);
		
		homeBtn = new JButton("Home");
		homeBtn.setIcon(new ImageIcon(UserLogin.class.getResource("/icon32/home.png")));
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
		homeBtn.setBounds(976, 567, 120, 40);
		contentPane.add(homeBtn);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(UserLogin.class.getResource("/Background/16.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
		connection=sqliteConnection.dbConnector();
	}
	
	
	
	@SuppressWarnings("deprecation")
	public void userChecker()
	{
		try{
			
			String query="select * from User where Username=? and Password=?";
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
				setPlayer();
				JOptionPane.showMessageDialog(null, "User Logged In");
				
				/*
				 * Enter Quiz Frame
				 */
				
				QuizFrame frame = new QuizFrame();
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
			
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null,e1);
		}
	}
	
	public void setPlayer(){
		try{
			String query = "select age from User where Username='"+userField.getText()+"' ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			query = "Update Player set Name='"+userField.getText()+"' ,Age='"+rs.getString("Age")+"' where rowid = 1 ";
			PreparedStatement pst2 = connection.prepareStatement(query);
			pst2.execute();
			

			pst.close();
			pst2.close();
			rs.close();
			return;
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
	}

}
