import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class QuestionSet extends JFrame {

	private JPanel contentPane;
	private JTextPane qPane;
	private JTextField opField1;
	private JTextField opField2;
	private JTextField opField3;
	private JTextField opField4;
	private JTextField opField5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionSet frame = new QuestionSet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public QuestionSet() {
		setTitle("Add Question");
		setType(Type.UTILITY);
		
		connection=sqliteConnection.dbConnector();
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
		
		qPane = new JTextPane();
		qPane.setFont(new Font("Tahoma", Font.BOLD, 24));
		qPane.setBounds(97, 89, 1085, 118);
		contentPane.add(qPane);
		
		opField1 = new JTextField();
		opField1.setFont(new Font("Tahoma", Font.BOLD, 20));
		opField1.setBounds(113, 420, 130, 40);
		contentPane.add(opField1);
		opField1.setColumns(10);
		
		opField2 = new JTextField();
		opField2.setFont(new Font("Tahoma", Font.BOLD, 20));
		opField2.setColumns(10);
		opField2.setBounds(442, 339, 130, 40);
		contentPane.add(opField2);
		
		opField3 = new JTextField();
		opField3.setFont(new Font("Tahoma", Font.BOLD, 20));
		opField3.setColumns(10);
		opField3.setBounds(442, 390, 130, 40);
		contentPane.add(opField3);
		
		opField4 = new JTextField();
		opField4.setFont(new Font("Tahoma", Font.BOLD, 20));
		opField4.setColumns(10);
		opField4.setBounds(442, 441, 130, 40);
		contentPane.add(opField4);
		
		opField5 = new JTextField();
		opField5.setFont(new Font("Tahoma", Font.BOLD, 20));
		opField5.setColumns(10);
		opField5.setBounds(442, 492, 130, 40);
		contentPane.add(opField5);
		
		JLabel lblQ = new JLabel("Enter Question");
		lblQ.setIcon(new ImageIcon(QuestionSet.class.getResource("/icon64/question-class-note-symbol.png")));
		lblQ.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQ.setBounds(166, 11, 200, 70);
		contentPane.add(lblQ);
		
		JLabel lblEnterOption = new JLabel("Enter Options");
		lblEnterOption.setIcon(new ImageIcon(QuestionSet.class.getResource("/icon64/question-mark.png")));
		lblEnterOption.setBounds(417, 248, 200, 70);
		contentPane.add(lblEnterOption);
		
		JLabel lblSub = new JLabel("Enter Correct ans in small letter");
		lblSub.setIcon(new ImageIcon(QuestionSet.class.getResource("/icon64/accepted-notes.png")));
		lblSub.setBounds(97, 309, 219, 70);
		contentPane.add(lblSub);
		
		JButton btnSub = new JButton("Submit");
		btnSub.setIcon(new ImageIcon(QuestionSet.class.getResource("/icon64/ok-like-hand-sign.png")));
		btnSub.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Add Question in database
				 */
				
				addQuestion();
				
			}
		});
		btnSub.setBounds(823, 339, 200, 70);
		contentPane.add(btnSub);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(QuestionSet.class.getResource("/icon64/cancel-button.png")));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qPane.setText("");
				opField1.setText("");
				opField2.setText("");
				opField3.setText("");
				opField4.setText("");
				opField5.setText("");
			}
		});
		btnReset.setBounds(823, 434, 200, 70);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(QuestionSet.class.getResource("/icon32/previous.png")));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QuesUpdate frame = new QuesUpdate();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(166, 575, 120, 40);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(QuestionSet.class.getResource("/icon32/home.png")));
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
		btnHome.setBounds(993, 575, 120, 40);
		contentPane.add(btnHome);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(QuestionSet.class.getResource("/Background/14.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
	}
	
	
	
	
	
	public void addQuestion()
	{
		
		try{
			//test.doClick();
			
			
			String query = "insert into Question (Ques,Op1,Op2,Op3,Op4,Op5,Op) values (?,?,?,?,?,?,?)";
			//String query2 = "insert into Question (Ques,Op1,Op2,Op3,Op4,Op5,Op) values (?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			
			pst.setString(1, qPane.getText());
			pst.setString(2, opField1.getText());
			pst.setString(3, opField2.getText());
			pst.setString(4, opField3.getText());
			pst.setString(5, opField4.getText());
			pst.setString(6, opField5.getText());
			pst.setInt(7, opChecker());
			//JOptionPane.showMessageDialog(null, String.valueOf(opChecker()));
			
			
			pst.execute();
			JOptionPane.showMessageDialog(null, "Ok");
			pst.close();			
		}catch(Exception a1){
			a1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Question add Failed");
		}
		
		/*
		 *Increase question Number in database 
		 */
		try{
			
			String query2 = "select * from AdminPanel where rowid = 1";
			PreparedStatement pst2 = connection.prepareStatement(query2);
			ResultSet rs2 = pst2.executeQuery();
			
			
			int x =rs2.getInt("dtQ");
			x++;
			//String y = String.valueOf(x);
			
			query2 = "Update AdminPanel set dtQ="+x+" where rowid= 1";
			PreparedStatement pst3 = connection.prepareStatement(query2);
			pst3.execute();
			
			pst2.close();
			pst3.close();
			rs2.close();
			
			JOptionPane.showMessageDialog(null, "Question added");
			return;
		}catch(Exception e1){
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Question could not be increased in AdminPanel Database");
		}
		
		
	}
	
	public int opChecker(){
		int count=0;
		if(opField1.getText().length()!=0){
			count++;
		}
		if(opField2.getText().length()!=0){
			count++;
		}
		if(opField3.getText().length()!=0){
			count++;
		}
		if(opField4.getText().length()!=0){
			count++;
		}
		if(opField5.getText().length()!=0){
			count++;
		}
		return count;
	}
}
