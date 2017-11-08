import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JProgressBar;
import javax.swing.JDesktopPane;
import java.awt.Color;


@SuppressWarnings("serial")
public class QuizFrame extends JFrame implements ActionListener {

	/*
	 * Set Global variables
	 */
		
	private JPanel contentPane;
	
	Connection connection = null;
	
	/*
	 * Buttons
	 */
	private JButton btnSkip;
	private JButton btnSub;
	private JButton btnStart;
	private JButton btnExit;
	
	/*
	 * Containers
	 */
	private JTextPane qPane;
	private JLabel lblTimer;
	private JProgressBar pb;
	
	private JRadioButton rBtn1;
	private JRadioButton rBtn2;
	private JRadioButton rBtn3;
	private JRadioButton rBtn4;
	private JRadioButton rBtn5;
	
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private JRadioButton rb4;
	
	
	/*
	 * Variables
	 */
	private int val=0;
	private int vall = 1;
	private double val2;
	private String strNo;
	private int questionNo;
	private int questionNo2;
	private int questionNo3;
	private int Sum;
	private int totalQ;		//Set total set of question
	private int dtImg;
	private int dtQ;// = 16; //Database question
	private int hScore;
	@SuppressWarnings("rawtypes")
	private ArrayList randQ;
	private ArrayList<Integer> randOp;
	@SuppressWarnings("rawtypes")
	private ArrayList randImg;
	private ArrayList<Integer> randImgOp;
	private int imgPick;
	private int pick;
	private int age;
	@SuppressWarnings("unused")
	private int timerS;		//set timer in second
	private int picker;
	
	private JDesktopPane desktopPane;
	private JDesktopPane desktopPane_1;
	private JDesktopPane desktopPane_2;
	private JDesktopPane desktopPane_3;
	private JDesktopPane desktopPane_4;
	
	Timer tm = new Timer(1000,this);
	private final ButtonGroup btnGrp = new ButtonGroup();
	private final ButtonGroup btnGrp2 = new ButtonGroup();
	private JLabel lblNewLabel;
	
	
	
	/*
	 * 
	 * Experimental
	 */
	

	int s=0;
	
	//String ss;
	//byte [] image_detail = null;
	private ImageIcon format = null;
	//String  filename = null;
	//int s = 0;
	//byte[] image = null;
	AbstractButton path;
	
	
	private JLabel Q;
	private JLabel Q1;
	private JLabel Q2;
	private JLabel Q3;
	private JLabel Q4;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizFrame frame = new QuizFrame();
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
	public QuizFrame() 
	{
		setType(Type.UTILITY);
		setTitle("IQ Test");
	
		initialize();
		
	}
	
	/*
	 * Initialize the frame
	 */
	
	public void initialize()
	
	{
		/*
		 * Connection to the database
		 */
		connection = sqliteConnection.dbConnector();
		
		
		
		
		/*
		 * Sets the frame
		 */
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
        
        
        
        
		
		rb1 = new JRadioButton("");
		btnGrp2.add(rb1);
		rb1.setBounds(647, 146, 40, 23);
		contentPane.add(rb1);
		
		rb4 = new JRadioButton("");
		btnGrp2.add(rb4);
		rb4.setBounds(901, 359, 40, 23);
		contentPane.add(rb4);
		
		rb2 = new JRadioButton("");
		btnGrp2.add(rb2);
		rb2.setBounds(901, 146, 40, 23);
		contentPane.add(rb2);
		
		rb3 = new JRadioButton("");
		btnGrp2.add(rb3);
		rb3.setBounds(647, 359, 40, 23);
		contentPane.add(rb3);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(139, 36, 360, 381);
		contentPane.add(desktopPane);
		
		Q = new JLabel("Question");
		Q.setHorizontalAlignment(SwingConstants.CENTER);
		Q.setBounds(0, 0, 371, 381);
		desktopPane.add(Q);
		
		desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(686, 92, 121, 121);
		contentPane.add(desktopPane_1);
		
		Q1 = new JLabel("");
		Q1.setBounds(0, 0, 121, 121);
		desktopPane_1.add(Q1);
		
		desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBounds(941, 92, 121, 121);
		contentPane.add(desktopPane_2);
		
		Q2 = new JLabel("");
		Q2.setBounds(0, 0, 121, 121);
		desktopPane_2.add(Q2);
		
		desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBounds(686, 306, 121, 121);
		contentPane.add(desktopPane_3);
		
		Q3 = new JLabel("");
		Q3.setBounds(0, 0, 121, 121);
		desktopPane_3.add(Q3);
		
		desktopPane_4 = new JDesktopPane();
		desktopPane_4.setBounds(941, 306, 121, 121);
		contentPane.add(desktopPane_4);
		
		Q4 = new JLabel("");
		Q4.setBounds(0, 0, 121, 121);
		desktopPane_4.add(Q4);
		
		
		//Timer label		
		lblTimer = new JLabel("");
		lblTimer.setFont(new Font("DigifaceWide", Font.BOLD, 30));
		lblTimer.setBounds(744, 492, 418, 49);
		contentPane.add(lblTimer);
		

		//Submit button
		
		
		rBtn1 = new JRadioButton("");
		rBtn1.setBackground(Color.WHITE);
		rBtn1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGrp.add(rBtn1);
		rBtn1.setBounds(184, 234, 360, 23);
		contentPane.add(rBtn1);
		
		rBtn2 = new JRadioButton("");
		rBtn2.setBackground(Color.WHITE);
		rBtn2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGrp.add(rBtn2);
		rBtn2.setBounds(184, 295, 360, 23);
		contentPane.add(rBtn2);
		
		rBtn4 = new JRadioButton("");
		rBtn4.setBackground(Color.WHITE);
		rBtn4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGrp.add(rBtn4);
		rBtn4.setBounds(184, 419, 360, 23);
		contentPane.add(rBtn4);
		
		rBtn3 = new JRadioButton("");
		rBtn3.setBackground(Color.WHITE);
		rBtn3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGrp.add(rBtn3);
		rBtn3.setBounds(184, 355, 360, 23);
		contentPane.add(rBtn3);
		
		rBtn5 = new JRadioButton("");
		rBtn5.setBackground(Color.WHITE);
		rBtn5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGrp.add(rBtn5);
		rBtn5.setBounds(184, 482, 360, 23);
		contentPane.add(rBtn5);
		
		pb = new JProgressBar();
		pb.setFont(new Font("Tahoma", Font.BOLD, 16));
		pb.setBounds(568, 585, 299, 49);
		pb.setValue(0);
		pb.setStringPainted(true);
		contentPane.add(pb);
		
		qPane = new JTextPane();
		qPane.setFont(new Font("Tahoma", Font.BOLD, 24));
		qPane.setBounds(131, 41, 946, 128);
		contentPane.add(qPane);
		
		
		
		
		/*
		 * button start
		 */
		
		btnSub = new JButton("Submit");
		btnSub.setIcon(new ImageIcon(QuizFrame.class.getResource("/icon64/accepted-notes.png")));
		btnSub.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		/*
		 * Press on Submit Button
		 */
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(questionNo<=questionNo3){
					matchQ();
				}
				else{
					matchImg();
				}
		}
			
		});
		
		
		
		/*
		 * Exit button
		 */
		btnExit = new JButton("Give Up");
		btnExit.setIcon(new ImageIcon(QuizFrame.class.getResource("/icon64/broken-heart.png")));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));

		//press on exit button
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				quit();
				
			}
		});
		btnExit.setBounds(962, 569, 200, 70);
		contentPane.add(btnExit);
		btnSub.setBounds(108, 569, 200, 70);
		contentPane.add(btnSub);
		
	
		
		
		btnStart = new JButton("");
		btnStart.setIcon(new ImageIcon(QuizFrame.class.getResource("/Image/quiz_start_btn.png")));
		btnStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        //System.out.println("Hello");
			        btnStart.doClick();
			    }
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnStart.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 
				 setInitial();
				 setPage();
				}
		});
		btnStart.setBounds(468, 308, 266, 121);
		contentPane.add(btnStart);
		
		btnSkip = new JButton("Skip");
		btnSkip.setIcon(new ImageIcon(QuizFrame.class.getResource("/icon64/next.png")));
		btnSkip.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, totalQ + " " + dtQ + " " +dtImg+ " "+questionNo+ " "+questionNo2+ " "+questionNo3+ " ");
				skip();
			}
		});
		btnSkip.setBounds(338, 569, 200, 70);
		contentPane.add(btnSkip);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(QuizFrame.class.getResource("/Background/18.png")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel);
		
		/*
		 * Button end
		 */
		
		
		
		 

				qPane.setVisible(false);
				btnSkip.setVisible(false);
				lblTimer.setVisible(false);
				btnSub.setVisible(false);
				lblTimer.setVisible(false);
				btnExit.setVisible(false);
				rBtn1.setVisible(false);
				rBtn2.setVisible(false);
				rBtn3.setVisible(false);
				rBtn4.setVisible(false);
				rBtn5.setVisible(false);
				pb.setVisible(false);
				
				Q.setVisible(false);
				Q1.setVisible(false);
				Q2.setVisible(false);
				Q3.setVisible(false);
				Q4.setVisible(false);
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				rb1.setVisible(false);
				rb2.setVisible(false);
				rb3.setVisible(false);
				rb4.setVisible(false);
				
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Randomizer
	 */
	
	public ArrayList<Integer> arrayrandom(int high, int rand)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		Random randint = new Random();
		int count = 1;
		while(count<=high){
			picker = randint.nextInt(rand)+1;
			if(!al.contains(picker)){
				al.add(picker);
				count++;
			}
		}
		return al;
	}
	
	/**
	 * Random chooser 3 input
	 */
	
	public ArrayList<Integer> arrayrandom(int low, int high, int rand){
        ArrayList<Integer> al = new ArrayList<Integer>(); 
        Random randint = new Random();
        int count = low;
        while(count<=high){
            pick = randint.nextInt(rand) + 1;
            if(!al.contains(pick)){
                al.add(pick);
                count++;
            }
        }
        return al;
    }
	
	

	/**
	 * Age counter
	 */
	
	public int mentalScore(int age)
	{
		double mA = 1 + (double)((20-age)*.01);
		int res = (int) (mA * Sum * hScore / totalQ);
		return res;
	}
	
	
	
	/*
	 * Timer
	 */
	int time;
	
	public void logic()
	{
		time--;
		lblTimer.setText("Remaining Time: "+time);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
				
		if (time > 0)
		{
			logic();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Time UP");
			quit();
			tm.stop();
		}
		
		repaint();
	}
	
	
	
	/*
	 * Set Progress Bar
	 */
	public void progress(){
		val = ((int)val2 * vall);
		pb.setValue(val);
		vall++;
		pb.setString(""+questionNo+" / "+totalQ+"");
		return;
		
	}
	
	
	
	/*
	 * Set initial values
	 */
	void setInitial()
	{
		//Set initial time, high score, total question
		
		try{
			String query = "select * from AdminPanel where rowid = 1";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			totalQ = Integer.parseInt(rs.getString("totalQ"));
			dtQ = Integer.parseInt(rs.getString("dtQ"));
			dtImg = Integer.parseInt(rs.getString("dtImg"));
			time = Integer.parseInt(rs.getString("Time"));
			hScore = Integer.parseInt(rs.getString("highScore"));
			questionNo3 = totalQ/2;
			val2 = ((double)100/totalQ);
				
			pst.close();
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		randQ  =  arrayrandom(questionNo3,dtQ);
		randImg  =  arrayrandom(questionNo3,dtImg);
		
		Sum = 0;
		questionNo = 1;
		questionNo2 = 0;
		
		tm.start();
		
		btnStart.setVisible(false);
		
		qPane.setVisible(true);
		
		btnSkip.setVisible(true);
		lblTimer.setVisible(true);
		btnSub.setVisible(true);;
		lblTimer.setVisible(true);;
		btnExit.setVisible(true);
		pb.setVisible(true);
		
		return;
		//JOptionPane.showMessageDialog(null, "Initialized");
		
		
		
	}
	
	
	
	void setPage()
	{
		progress();
		try{
			
			btnGrp.clearSelection();
			btnGrp2.clearSelection();
			
			int OpNo = 0;
			String strOp;
			strNo = String.valueOf(randQ.get(questionNo-1));
			String query = "select * from Question where rowid = " + strNo;
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
				OpNo = rs.getInt("Op");
				randOp = arrayrandom(OpNo,OpNo);
				//JOptionPane.showMessageDialog(null, randOp);
				
				qPane.setText(String.valueOf(questionNo)+".    "+rs.getString("Ques"));
				if(OpNo == 2){
					strOp = String.valueOf(randOp.get(0));
					rBtn1.setText(rs.getString("Op"+strOp));
					strOp = String.valueOf(randOp.get(1));
					rBtn2.setText(rs.getString("Op"+strOp));
				}
				else if(OpNo == 3){
					strOp = String.valueOf(randOp.get(0));
					rBtn1.setText(rs.getString("Op"+strOp));
					strOp = String.valueOf(randOp.get(1));
					rBtn2.setText(rs.getString("Op"+strOp));
					strOp = String.valueOf(randOp.get(2));
					rBtn3.setText(rs.getString("Op"+strOp));
					
				}
				else if(OpNo == 4){
					strOp = String.valueOf(randOp.get(0));
					rBtn1.setText(rs.getString("Op"+strOp));
					strOp = String.valueOf(randOp.get(1));
					rBtn2.setText(rs.getString("Op"+strOp));
					strOp = String.valueOf(randOp.get(2));
					rBtn3.setText(rs.getString("Op"+strOp));
					strOp = String.valueOf(randOp.get(3));
					rBtn4.setText(rs.getString("Op"+strOp));
					
				}
				else if(OpNo == 5){
					strOp = String.valueOf(randOp.get(0));
					rBtn1.setText(rs.getString("Op"+strOp));
					strOp = String.valueOf(randOp.get(1));
					rBtn2.setText(rs.getString("Op"+strOp));
					strOp = String.valueOf(randOp.get(2));
					rBtn3.setText(rs.getString("Op"+strOp));
					strOp = String.valueOf(randOp.get(3));
					rBtn4.setText(rs.getString("Op"+strOp));
					strOp = String.valueOf(randOp.get(4));
					rBtn5.setText(rs.getString("Op"+strOp));
				}
				
				
				rBtn1.setVisible(true);
				rBtn2.setVisible(true);
				rBtn3.setVisible(true);
				rBtn4.setVisible(true);
				rBtn5.setVisible(true);
				
				
				if(rs.getInt("OP") == 2){
					rBtn3.setVisible(false);
					rBtn4.setVisible(false);
					rBtn5.setVisible(false);
				}
				
				else if(rs.getInt("OP") == 3){
					rBtn4.setVisible(false);
					rBtn5.setVisible(false);
				}
				
				else if(rs.getInt("OP") == 4){
					rBtn5.setVisible(false);
				}

				
				
				pst.close();
				rs.close();
				return;
				//JOptionPane.showMessageDialog(null, "Page Setup");
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
	}
	
	
	
	
	
	void skip(){
		questionNo++;
		
		if(questionNo > totalQ){
			quit();
			return;
			//JOptionPane.showMessageDialog(null, "Maximum Question reached");
		}
		
		else{
			if(questionNo3 == questionNo-1){
				qPane.setVisible(false);
				rBtn1.setVisible(false);
				rBtn2.setVisible(false);
				rBtn3.setVisible(false);
				rBtn4.setVisible(false);
				rBtn5.setVisible(false);
				Q.setVisible(true);
				Q1.setVisible(true);
				Q2.setVisible(true);
				Q3.setVisible(true);
				Q4.setVisible(true);
			
				desktopPane.setVisible(true);
				desktopPane_1.setVisible(true);
				desktopPane_2.setVisible(true);
				desktopPane_3.setVisible(true);
				desktopPane_4.setVisible(true);
			
				setImg();
				return;
			}
			else if(questionNo3<questionNo){
				setImg();
				return;
			}
		
		
		
			else{
				setPage();
				return;
			}
		}
		
	}
	
	

	
	void quit(){
		tm.stop();
		 // Get age from default database
		try{
			String query1 = "select Name, Age from Player where rowid = 1";
			PreparedStatement pst1 = connection.prepareStatement(query1);
			//pst1.execute();
			ResultSet rs1 = pst1.executeQuery();
			
			String sAge = rs1.getString("Age");
			age = Integer.parseInt(sAge);
			String name = rs1.getString("Name");
			String Score = String.valueOf(mentalScore(age));
			
			String query2 = "Update User set Score= '"+Score+"' where Username= '"+name+"' ";
			PreparedStatement pst2 = connection.prepareStatement(query2);
			pst2.execute();
			
			
			//JOptionPane.showMessageDialog(null, "Your Score is: "+Score);
			
			Score frame = new Score();
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			frame.setUndecorated(true);
			frame.setVisible(true);
			dispose();
			
			pst1.close();
			pst2.close();
			rs1.close();
			return;
			//JOptionPane.showMessageDialog(null, "Quitted");
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
	}
	
	public void setImg(){
		/*
		 * Set biography and name field...
		 * 
		 * 
		 */
		progress();
		
		randImgOp = arrayrandom(4,4);

		questionNo2++;
		String strNo2;
		
		strNo = String.valueOf(randImg.get(questionNo2-1));
		//JOptionPane.showMessageDialog(null, "Fuck Yeah");
		rb1.setVisible(true);
		rb2.setVisible(true);
		rb3.setVisible(true);
		rb4.setVisible(true);
		btnGrp2.clearSelection();
		
		try{
			String query = "select * from QImage Where rowid= '"+strNo+"' ";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
			byte[]imagedata = rs.getBytes("Question");
			format =  new ImageIcon (imagedata);
			Q.setIcon(format);
			}
			
			pst.close();
			rs.close();
		}
		catch (Exception ef){
		ef.printStackTrace();
		}
		
		try{
			strNo2 = String.valueOf(randImgOp.get(0));
			String query = "select * from QImage Where rowid='"+strNo+"' ";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
			byte[]imagedata = rs.getBytes("Op"+strNo2);
			format =  new ImageIcon (imagedata);
			Q1.setIcon(format);
			}
			
			pst.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			strNo2 = String.valueOf(randImgOp.get(1));
			String query = "select * from QImage Where rowid='"+strNo+"' ";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
			byte[]imagedata = rs.getBytes("Op"+strNo2);
			format =  new ImageIcon (imagedata);
			Q2.setIcon(format);
			}
			
			pst.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			strNo2 = String.valueOf(randImgOp.get(2));
			String query = "select * from QImage Where rowid='"+strNo+"' ";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
			byte[]imagedata = rs.getBytes("Op"+strNo2);
			format =  new ImageIcon (imagedata);
			Q3.setIcon(format);
			}
			
			pst.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			strNo2 = String.valueOf(randImgOp.get(3));
			String query = "select * from QImage Where rowid='"+strNo+"' ";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
			byte[]imagedata = rs.getBytes("Op"+strNo2);
			format =  new ImageIcon (imagedata);
			Q4.setIcon(format);
			}
			
			pst.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return;
	}
	
	
	public void matchImg()
	{
		
		if(rb1.isSelected() || rb2.isSelected() || rb3.isSelected() || rb4.isSelected()){
			if(rb1.isSelected()){
				imgPick = 1;
			}
			else if(rb2.isSelected()){
				imgPick = 2;
			}
			else if(rb3.isSelected()){
				imgPick = 3;
			}
			else if(rb4.isSelected()){
				imgPick = 4;
			}
			imgPick--;
			int x = randImgOp.get(imgPick);
					
			if(x == 1){
			Sum++;
			//JOptionPane.showMessageDialog(null, "Correct Ans");
			}
			else{
				//JOptionPane.showMessageDialog(null, "Wrong Ans");
			}
		imgPick = 0;
		btnGrp2.clearSelection();
		
		
		skip();
		return;
		}
		else{
			JOptionPane.showMessageDialog(null, "Select an option first");
			return;
		}
	}
	
	public void matchQ()
	{
		
		if(rBtn1.isSelected() || rBtn2.isSelected() || rBtn3.isSelected() || rBtn4.isSelected() || rBtn5.isSelected()){
			if(rBtn1.isSelected()){
				imgPick = 1;
			}
			else if(rBtn2.isSelected()){
				imgPick = 2;
			}
			else if(rBtn3.isSelected()){
				imgPick = 3;
			}
			else if(rBtn4.isSelected()){
				imgPick = 4;
			}
			else if(rBtn5.isSelected()){
				imgPick = 5;
			}
			imgPick--;
			int x = randOp.get(imgPick);
					
			if(x == 1){
				Sum++;
				//JOptionPane.showMessageDialog(null, "Correct Ans");
			}
			else{
				//JOptionPane.showMessageDialog(null, "Wrong Ans");
			}
		imgPick = 0;
		btnGrp.clearSelection();
		
		
		skip();
		return;
		}
		else{
			JOptionPane.showMessageDialog(null, "Select an option first");
			return;
		}
	}
	
}
