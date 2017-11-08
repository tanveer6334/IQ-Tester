
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;


import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class UserData extends JFrame {

	private JPanel contentPane;
	private JTable userTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserData frame = new UserData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JLabel nameLbl;
	private JLabel ageLbl;
	private JTextField nameField;
	private JTextField ageField;
	private JButton updateBtn;
	private JTextField userField;
	private JButton homeBtn;
	private JButton btnBack;
	private JButton deleteBtn;
	private JLabel lblUser;
	private JLabel label;
	/**
	 * Create the frame.
	 */
	public UserData() {
		setType(Type.UTILITY);
		setTitle("User Data");
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
        
        
        
        
		
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setIcon(new ImageIcon(UserData.class.getResource("/icon32/refresh.png")));
		refreshBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Refresh();
			}
		});
		refreshBtn.setBounds(1055, 26, 140, 40);
		contentPane.add(refreshBtn);
		
		JScrollPane userScroll = new JScrollPane();
		userScroll.setViewportBorder(new CompoundBorder());
		userScroll.setBounds(458, 77, 735, 478);
		contentPane.add(userScroll);
		
		userTable = new JTable();
		userTable.setFont(new Font("Tahoma", Font.BOLD, 16));
		userTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int row = userTable.getSelectedRow();
					String User_=(userTable.getModel().getValueAt(row, 0)).toString();
					
					String query = "select * from User where Username='"+User_+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						userField.setText(rs.getString("Username"));
						nameField.setText(rs.getString("Name"));
						ageField.setText(rs.getString("Age"));
					}
					
					pst.close();
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		userScroll.setViewportView(userTable);
		
		nameLbl = new JLabel("Name");
		nameLbl.setIcon(new ImageIcon(UserData.class.getResource("/icon64/avatar.png")));
		nameLbl.setForeground(Color.BLACK);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameLbl.setBounds(70, 145, 150, 70);
		contentPane.add(nameLbl);
		
		ageLbl = new JLabel("Age");
		ageLbl.setIcon(new ImageIcon(UserData.class.getResource("/icon64/old-man-with-hat-walking-with-cane.png")));
		ageLbl.setForeground(Color.BLACK);
		ageLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		ageLbl.setBounds(70, 250, 150, 70);
		contentPane.add(ageLbl);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.BOLD, 16));
		nameField.setBounds(243, 162, 200, 40);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		ageField = new JTextField();
		ageField.setFont(new Font("Tahoma", Font.BOLD, 16));
		ageField.setBounds(243, 267, 200, 40);
		contentPane.add(ageField);
		ageField.setColumns(10);
		
		updateBtn = new JButton("Update");
		updateBtn.setIcon(new ImageIcon(UserData.class.getResource("/icon64/refresh-cloud.png")));
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "Update user set Username='"+userField.getText()+"' ,Name='"+nameField.getText()+"' ,Age='"+ageField.getText()+"' where Username='"+userField.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					Refresh();
					
					pst.close();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		updateBtn.setBounds(177, 370, 200, 70);
		contentPane.add(updateBtn);
		
		userField = new JTextField();
		userField.setFont(new Font("Tahoma", Font.BOLD, 16));
		userField.setColumns(10);
		userField.setBounds(243, 65, 200, 40);
		contentPane.add(userField);
		
		homeBtn = new JButton("Home");
		homeBtn.setIcon(new ImageIcon(UserData.class.getResource("/icon32/home.png")));
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
		homeBtn.setBounds(1075, 591, 120, 40);
		contentPane.add(homeBtn);
		
		btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(UserData.class.getResource("/icon32/previous.png")));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage frame = new AdminPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(70, 591, 120, 40);
		contentPane.add(btnBack);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setIcon(new ImageIcon(UserData.class.getResource("/icon64/user-1.png")));
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="delete from User where Username='"+userField.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					Refresh();
				
					pst.close();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		deleteBtn.setBounds(177, 474, 200, 70);
		contentPane.add(deleteBtn);
		
		lblUser = new JLabel("Username");
		lblUser.setIcon(new ImageIcon(UserData.class.getResource("/icon64/users.png")));
		lblUser.setForeground(Color.BLACK);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(70, 48, 150, 70);
		contentPane.add(lblUser);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(UserData.class.getResource("/Background/1.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
		Refresh();
	}
	
	public void Refresh() {
		try{
			String query = "select Username,Name,Age,Score from User ORDER by Username ASC";	// replace * with Name,Age,Score to get specific value
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			userTable.setModel(DbUtils.resultSetToTableModel(rs));
			
			rs.close();
			pst.close();
			
			return;
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
}
