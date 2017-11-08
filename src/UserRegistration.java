import java.awt.EventQueue;
import java.util.Date;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class UserRegistration extends JFrame {

	private JPanel contentPane;
	
	private JTextField userField;
	private JTextField dField;
	private JTextField mField;
	private JTextField yField;
	private JTextField nameField;
	private JPasswordField passField;
	private JPasswordField passField2;
	
	
	private JLabel confirmLbl;
	private JLabel nameLbl;
	private JLabel userLbl;
	private JLabel passLbl;
	private JLabel ageLbl;
	
	private JButton btnSignUp;
	private JButton btnHome;
	private JButton btnBack;
	
	Connection connection = null;
	
	private int age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration frame = new UserRegistration();
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
	public UserRegistration() {
		setType(Type.UTILITY);
		setTitle("Sign Up");
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
		userField.setFont(new Font("Tahoma", Font.BOLD, 16));
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        btnSignUp.doClick();
			    }
			}
		});
		userField.setBackground(Color.WHITE);
		userField.setForeground(Color.BLACK);
		userField.setColumns(10);
		userField.setBounds(593, 167, 250, 40);
		contentPane.add(userField);
		
		dField = new JTextField();
		dField.setFont(new Font("Tahoma", Font.BOLD, 16));
		dField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        btnSignUp.doClick();
			    }
			}
		});
		dField.setForeground(Color.BLACK);
		dField.setBackground(Color.WHITE);
		dField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(dField.getText().equals("DD")){
					dField.setText("");
				}
			}
		});
		dField.setText("DD");
		dField.setHorizontalAlignment(SwingConstants.CENTER);
		dField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(dField.getText().equals("DD")){
					dField.setText("");
				}
			}
		});
		dField.setColumns(10);
		dField.setBounds(593, 260, 50, 40);
		contentPane.add(dField);
		
		mField = new JTextField();
		mField.setFont(new Font("Tahoma", Font.BOLD, 16));
		mField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        btnSignUp.doClick();
			    }
			}
		});
		mField.setForeground(Color.BLACK);
		mField.setBackground(Color.WHITE);
		mField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(mField.getText().equals("MM")){
					mField.setText("");
				}
			}
		});
		mField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(mField.getText().equals("MM")){
					mField.setText("");
				}
			}
		});
		mField.setText("MM");
		mField.setHorizontalAlignment(SwingConstants.CENTER);
		mField.setColumns(10);
		mField.setBounds(668, 260, 50, 40);
		contentPane.add(mField);
		
		yField = new JTextField();
		yField.setFont(new Font("Tahoma", Font.BOLD, 16));
		yField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        btnSignUp.doClick();
			    }
			}
		});
		yField.setForeground(Color.BLACK);
		yField.setBackground(Color.WHITE);
		yField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(yField.getText().equals("YYYY")){
					yField.setText("");
				}
			}
		});
		yField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(yField.getText().equals("YYYY")){
					yField.setText("");
				}
			}
		});
		yField.setText("YYYY");
		yField.setHorizontalAlignment(SwingConstants.CENTER);
		yField.setColumns(10);
		yField.setBounds(743, 260, 100, 40);
		contentPane.add(yField);
		
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.BOLD, 16));
		nameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        btnSignUp.doClick();
			    }
			}
		});
		nameField.setForeground(Color.BLACK);
		nameField.setBackground(Color.WHITE);
		nameField.setColumns(10);
		nameField.setBounds(593, 73, 250, 40);
		contentPane.add(nameField);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Tahoma", Font.BOLD, 16));
		passField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        btnSignUp.doClick();
			    }
			}
		});
		passField.setForeground(Color.BLACK);
		passField.setBackground(Color.WHITE);
		passField.setBounds(593, 341, 250, 40);
		contentPane.add(passField);
		
		nameLbl = new JLabel("Name");
		nameLbl.setIcon(new ImageIcon(UserRegistration.class.getResource("/icon64/avatar.png")));
		nameLbl.setForeground(Color.BLACK);
		nameLbl.setBackground(Color.BLACK);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameLbl.setBounds(360, 56, 200, 70);
		contentPane.add(nameLbl);
		
		userLbl = new JLabel("Username");
		userLbl.setIcon(new ImageIcon(UserRegistration.class.getResource("/icon64/users.png")));
		userLbl.setForeground(Color.BLACK);
		userLbl.setBackground(Color.BLACK);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		userLbl.setBounds(360, 150, 200, 70);
		contentPane.add(userLbl);
		
		passLbl = new JLabel("Password");
		passLbl.setIcon(new ImageIcon(UserRegistration.class.getResource("/icon64/key.png")));
		passLbl.setForeground(Color.BLACK);
		passLbl.setBackground(Color.BLACK);
		passLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		passLbl.setBounds(360, 324, 200, 70);
		contentPane.add(passLbl);
		
		ageLbl = new JLabel("Date Of Birth");
		ageLbl.setIcon(new ImageIcon(UserRegistration.class.getResource("/icon64/birthday-cake.png")));
		ageLbl.setForeground(Color.BLACK);
		ageLbl.setBackground(Color.BLACK);
		ageLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		ageLbl.setBounds(360, 243, 200, 70);
		contentPane.add(ageLbl);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setIcon(new ImageIcon(UserRegistration.class.getResource("/icon64/accepted-notes.png")));
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checker();
			}
		});
		btnSignUp.setBounds(547, 495, 170, 70);
		contentPane.add(btnSignUp);
		
		btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(UserRegistration.class.getResource("/icon32/home.png")));
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
		btnHome.setBounds(1046, 592, 120, 40);
		contentPane.add(btnHome);
		
		btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(UserRegistration.class.getResource("/icon32/previous.png")));
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
		btnBack.setBounds(95, 592, 120, 40);
		contentPane.add(btnBack);
		
		passField2 = new JPasswordField();
		passField2.setFont(new Font("Tahoma", Font.BOLD, 16));
		passField2.setForeground(Color.BLACK);
		passField2.setBackground(Color.WHITE);
		passField2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        btnSignUp.doClick();
			    }
			}
		});
		passField2.setBounds(593, 431, 250, 40);
		contentPane.add(passField2);
		
		confirmLbl = new JLabel("Confirm Password");
		confirmLbl.setIcon(new ImageIcon(UserRegistration.class.getResource("/icon64/Confirm-pass.png")));
		confirmLbl.setForeground(Color.BLACK);
		confirmLbl.setBackground(Color.BLACK);
		confirmLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		confirmLbl.setBounds(360, 414, 200, 70);
		contentPane.add(confirmLbl);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UserRegistration.class.getResource("/Background/16.jpg")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel);
			
	}
	
	
	@SuppressWarnings("deprecation")
	void checker()
	{
		/*
		 * Check if All fields are not Empty
		 */
		if((nameField.getText().length()==0) || (userField.getText().length()==0) || (passField.getText().length()==0) || (passField2.getText().length()==0) ||  (dField.getText().length()==0) ||  (mField.getText().length()==0) ||  (yField.getText().length()==0) || (dField.getText().equals("DD")) || (mField.getText().equals("MM"))|| (yField.getText().equals("YYYY"))){
			JOptionPane.showMessageDialog(null, "Fill all empty Fields");
			return;
		}
	
		else{
			getAge();
			return;
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public void passMatch()
	{
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
				String query="select * from User where Username=?";
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
		/*
		 * 	Set User Registration value
		 */
		
		try{
			String query3 = "insert into User (Name,Username,Password,Age) values (?,?,?,?)";
			PreparedStatement pst3 = connection.prepareStatement(query3);
			pst3.setString(1, nameField.getText());
			pst3.setString(2, userField.getText());
			pst3.setString(3, passField.getText());
			pst3.setString(4, String.valueOf(age));
	
			pst3.execute();
	
			pst3.close();
			
			JOptionPane.showMessageDialog(null, "User Registered");
	
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		
		/*
		 * 	Store new player name
		 */
		try{
			String query4 = "Update Player set Name='"+userField.getText()+"' ,Age='"+String.valueOf(age)+"' where rowid = 1 ";
			PreparedStatement pst4 = connection.prepareStatement(query4);
		
			pst4.execute();
			
			pst4.close();
			
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		/*
		 * Set score = 0 to main database
		 */
		
		try{
			String query5 = "Update user set Score= 0 where Username='"+userField.getText()+"' ";
			PreparedStatement pst5 = connection.prepareStatement(query5);
			pst5.execute();
			
			pst5.close();
		}catch(Exception e8){
			e8.printStackTrace();
		}
		QuizFrame frame = new QuizFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		dispose();
		return;
	}
	
	
	
	/*
	 * Age counter
	 */
	
	@SuppressWarnings("deprecation")
	public void getAge() {
		int day = Integer.valueOf(dField.getText());
		int month = Integer.valueOf(mField.getText());
		int year = Integer.valueOf(yField.getText());
		
	    Date now = new Date();
	    
	    if(Integer.valueOf(dField.getText()) > 31 ){
			JOptionPane.showMessageDialog(null, "Invalid Day");
			return;
		}
			
		else if(Integer.valueOf(mField.getText()) > 12 ){
			JOptionPane.showMessageDialog(null, "Invalid Month");
			return;
		}

		else if((Integer.valueOf(yField.getText()) < 1800 ) || ((Integer.valueOf(yField.getText())) > (now.getYear()+1900))){
			JOptionPane.showMessageDialog(null, "Invalid Year");
			return;
		}

		else{
			int nowMonth = now.getMonth()+1;
			int nowYear = now.getYear()+1900;
			int result = nowYear - year;

			if (month > nowMonth) {
				result--;
			}
			else if (month == nowMonth) {
				int nowDay = now.getDate();

				if (day > nowDay) {
					result--;
				}
			}
	    	age = result;
	    	passMatch();
	    	return;
		}
	}
}
