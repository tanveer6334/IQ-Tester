import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Settings extends JFrame {

	private JPanel contentPane;
	private JTextField fieldTime;
	private JTextField fieldTQ;
	private JTextField fieldHS;
	int q;
	int dti;
	int dtq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	
	/**
	 * Create the frame.
	 */
	public Settings() {
		setTitle("Settings");
		setType(Type.UTILITY);
		connection = sqliteConnection.dbConnector();
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
        
        
        
        
		
		fieldTime = new JTextField();
		fieldTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		fieldTime.setBounds(628, 86, 207, 43);
		contentPane.add(fieldTime);
		fieldTime.setColumns(10);
		
		fieldTQ = new JTextField();
		fieldTQ.setFont(new Font("Tahoma", Font.BOLD, 16));
		fieldTQ.setColumns(10);
		fieldTQ.setBounds(628, 187, 207, 43);
		contentPane.add(fieldTQ);
		
		fieldHS = new JTextField();
		fieldHS.setFont(new Font("Tahoma", Font.BOLD, 16));
		fieldHS.setColumns(10);
		fieldHS.setBounds(628, 294, 207, 43);
		contentPane.add(fieldHS);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setIcon(new ImageIcon(Settings.class.getResource("/icon64/stopwatch.png")));
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTime.setBounds(429, 72, 200, 70);
		contentPane.add(lblTime);
		
		JLabel lblTQ = new JLabel("Total Question");
		lblTQ.setIcon(new ImageIcon(Settings.class.getResource("/icon64/question-class-note-symbol.png")));
		lblTQ.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTQ.setBounds(418, 173, 200, 70);
		contentPane.add(lblTQ);
		
		JLabel lblHS = new JLabel("High Score");
		lblHS.setIcon(new ImageIcon(Settings.class.getResource("/icon64/scoreboard.png")));
		lblHS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHS.setBounds(429, 280, 200, 70);
		contentPane.add(lblHS);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(Settings.class.getResource("/icon64/refresh-cloud.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				test();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(560, 384, 200, 70);
		contentPane.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(Settings.class.getResource("/icon64/cancel-button.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldTime.setText("");
				fieldTQ.setText("");
				fieldHS.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(560, 461, 200, 70);
		contentPane.add(btnReset);
		
		JButton button = new JButton("Back");
		button.setIcon(new ImageIcon(Settings.class.getResource("/icon32/previous.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage frame = new AdminPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(77, 592, 120, 40);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Home");
		button_1.setIcon(new ImageIcon(Settings.class.getResource("/icon32/home.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage frame = new MainPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBounds(1058, 592, 120, 40);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Settings.class.getResource("/Background/16.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
	}
	
	
	public void setData()
	{
		try{
			if(fieldTime.getText().length()!=0){
				String query = "update AdminPanel set Time='"+fieldTime.getText()+"' where rowid = 1";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.execute();
				
				pst.close();
			}
			if(fieldTQ.getText().length()!=0){
				String query = "update AdminPanel set totalQ='"+fieldTQ.getText()+"' where rowid = 1";
				PreparedStatement pst2 = connection.prepareStatement(query);
				pst2.execute();
				
				pst2.close();
			}
			if(fieldHS.getText().length()!=0){
				String query = "update AdminPanel set highScore='"+fieldHS.getText()+"' where rowid = 1";
				PreparedStatement pst3 = connection.prepareStatement(query);
				pst3.execute();
				
				pst3.close();
			}
			
			JOptionPane.showMessageDialog(null, "Data Updated");
			fieldTime.setText("");
			fieldHS.setText("");
			fieldTQ.setText("");
			return;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void test(){
		try{
		String query = "select * from AdminPanel where rowid=1";
		PreparedStatement pst = connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		dtq = rs.getInt("dtQ");
		dti = rs.getInt("dtImg");
		
		pst.close();
		rs.close();
		
		if(fieldTQ.getText().length()!=0){
		
			q = Integer.parseInt(fieldTQ.getText());
			int q1 = q /2;
			
			if(q%2 !=0){
				JOptionPane.showMessageDialog(null, "Please, set even number of question");
				return;
			}
			else if(dtq < q1){
				JOptionPane.showMessageDialog(null, "Text Question Database is too short for this much question. Add more question or decrease total question");
				//JOptionPane.showMessageDialog(null, "total question: "+q+" available question: "+String.valueOf(dtq)+" ");
				return;
			}
			else if(dti < q1){
				JOptionPane.showMessageDialog(null, "Image Question Database is too short for this much question. Add more question or decrease total question");
				return;
			}
			else{
				setData();
				return;
			}
		}
		else{
			setData();
			return;
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
