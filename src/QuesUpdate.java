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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextPane;



@SuppressWarnings("serial")
public class QuesUpdate extends JFrame {

	private JPanel contentPane;
	//private JTextField qPane;
	private JTextField opField1;
	private JTextField opField2;
	private JTextField opField3;
	private JTextField opField4;
	private JTextField opField5;
	JTextPane qPane;
	private int qNo;
	private int dtQ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuesUpdate frame = new QuesUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JLabel label;
	private JLabel lblQNo;
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton button;

	/**
	 * Create the frame.
	 */
	public QuesUpdate() {
		setTitle("Update Question");
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
		opField1.setBounds(719, 299, 130, 40);
		contentPane.add(opField1);
		opField1.setColumns(10);
		
		opField2 = new JTextField();
		opField2.setFont(new Font("Tahoma", Font.BOLD, 20));
		opField2.setColumns(10);
		opField2.setBounds(166, 345, 130, 40);
		contentPane.add(opField2);
		
		opField3 = new JTextField();
		opField3.setFont(new Font("Tahoma", Font.BOLD, 20));
		opField3.setColumns(10);
		opField3.setBounds(166, 396, 130, 40);
		contentPane.add(opField3);
		
		opField4 = new JTextField();
		opField4.setFont(new Font("Tahoma", Font.BOLD, 20));
		opField4.setColumns(10);
		opField4.setBounds(166, 447, 130, 40);
		contentPane.add(opField4);
		
		opField5 = new JTextField();
		opField5.setFont(new Font("Tahoma", Font.BOLD, 20));
		opField5.setColumns(10);
		opField5.setBounds(166, 498, 130, 40);
		contentPane.add(opField5);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refresh();
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRefresh.setBounds(738, 26, 120, 40);
		contentPane.add(btnRefresh);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
				qNo--;
				refresh();
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPrevious.setBounds(548, 521, 120, 40);
		contentPane.add(btnPrevious);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPrevious.setEnabled(true);
				qNo++;
				refresh();
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNext.setBounds(825, 521, 120, 40);
		contentPane.add(btnNext);
		
		JLabel lblQ = new JLabel("Question");
		lblQ.setIcon(new ImageIcon(QuestionSet.class.getResource("/icon64/question-class-note-symbol.png")));
		lblQ.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQ.setBounds(166, 11, 200, 70);
		contentPane.add(lblQ);
		
		JLabel lblEnterOption = new JLabel("Options");
		lblEnterOption.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterOption.setIcon(new ImageIcon(QuestionSet.class.getResource("/icon64/question-mark.png")));
		lblEnterOption.setBounds(155, 218, 200, 70);
		contentPane.add(lblEnterOption);
		
		JLabel lblSub = new JLabel("Correct Ans");
		lblSub.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSub.setIcon(new ImageIcon(QuestionSet.class.getResource("/icon64/accepted-notes.png")));
		lblSub.setBounds(694, 218, 219, 70);
		contentPane.add(lblSub);
		
		JButton btnSub = new JButton("Update");
		btnSub.setIcon(new ImageIcon(QuesUpdate.class.getResource("/icon64/refresh-cloud.png")));
		btnSub.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Add Question in database
				 */
				update();
				
				
			}
		});
		btnSub.setBounds(524, 382, 200, 70);
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
		btnReset.setBounds(759, 382, 200, 70);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(QuestionSet.class.getResource("/icon32/previous.png")));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPage frame = new AdminPage();
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
		
		lblQNo = new JLabel("Question No: ");
		lblQNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQNo.setBounds(942, 11, 219, 70);
		contentPane.add(lblQNo);
		
		button = new JButton("Insert New");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QuestionSet frame = new QuestionSet();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		button.setBounds(997, 383, 200, 70);
		contentPane.add(button);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(QuestionSet.class.getResource("/Background/14.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
		qNo = 1;
		try{
			String query = "SELECT * FROM AdminPanel where rowid = 1" ;
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			dtQ = rs.getInt("dtQ");
			
			pst.close();
			rs.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Admin panel total question read error!");
		}
		//JOptionPane.showMessageDialog(null, dtQ);
		refresh();
		
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
	
	public void refresh(){
		
		if(qNo == 0){
			qNo = 1;
			JOptionPane.showMessageDialog(null, "Minimum Question reached");
			btnPrevious.setEnabled(false);
			return;
		}
		else if(qNo > dtQ){
			qNo = dtQ;
			JOptionPane.showMessageDialog(null, "Maximum Question reached!");
			btnNext.setEnabled(false);
			return;
		}
		else{
			//JOptionPane.showMessageDialog(null, qNo);
			try {
				
				String query = "select * from Question where rowid = "+qNo+" ";
				
				PreparedStatement pst = connection.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery();
				qPane.setText(rs.getString("Ques"));
				opField1.setText(rs.getString("Op1"));
				opField2.setText(rs.getString("Op2"));
				opField3.setText(rs.getString("Op3"));
				opField4.setText(rs.getString("Op4"));
				opField5.setText(rs.getString("Op5"));
				
				pst.close();
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "REFRESH Error");
			}
			lblQNo.setText("Question No: "+String.valueOf(qNo)+" / "+ String.valueOf(dtQ));
		}
	}
	public void update(){
		try{
			String query = "UPDATE Question set Ques='"+qPane.getText()+"', Op1='"+opField1.getText()+"', Op2='"+opField2.getText()+"', Op3='"+opField3.getText()+"', Op4='"+opField4.getText()+"', Op5='"+opField5.getText()+"' where rowid = "+qNo+" ";
			
			PreparedStatement pst = connection.prepareStatement(query);
			
			pst.execute();
			
			pst.close();
			JOptionPane.showMessageDialog(null, "Question Updated");
		}catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Update Error");
		}
	}
}
