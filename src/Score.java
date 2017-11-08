import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Score extends JFrame {

	@SuppressWarnings("unused")
	private int[] cat1 = new int[]{1};
	@SuppressWarnings("unused")
	private int[] cat2 = new int[]{2};
	private int[] cat3 = new int[]{3,4};
	@SuppressWarnings("unused")
	private int[] cat4 = new int[]{5};
	@SuppressWarnings("unused")
	private int[] cat5 = new int[]{6};
	private int[] cat6 = new int[]{7,8,9};
	private int[] cat7 = new int[]{10,12,13,14};
	private int[] cat8 = new int[]{15,16};
	private int[] cat9 = new int[]{17,18};
	
	private JPanel contentPane;
	private String name;
	private int score;
	JLabel lblImage;
	JDesktopPane desktopPane;
	private String selection;
	private JLabel lblName;
	private JLabel lblScore;
	
	
	String ss;
	byte [] image_detail = null;
	private ImageIcon format = null;
	String  filename = null;
	int s = 0;
	byte[] image = null;
	AbstractButton path;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Score frame = new Score();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * Randomizer
	 */
	
	public int randomizer( int high){
		Random randint = new Random();
		int	x =randint.nextInt(high);
				
		return x;
	}
	
	
	Connection conn = null;
	private JLabel lblNewLabel;
	private JLabel lblQuote;
	private JTextPane bioPane;
	private JTextPane quotePane;
	private JLabel label;
	/**
	 * Create the frame.
	 */
	
	public Score() {
		setTitle("Score");
		setType(Type.UTILITY);
		
		conn = sqliteConnection.dbConnector();
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
        
        
        
        
		
		quotePane = new JTextPane();
		quotePane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		quotePane.setBounds(161, 509, 931, 82);
		contentPane.add(quotePane);
		
		
		bioPane = new JTextPane();
		bioPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		bioPane.setBounds(431, 74, 661, 410);
		contentPane.add(bioPane);
		
		lblScore = new JLabel("Score");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(499, 11, 459, 52);
		contentPane.add(lblScore);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setIcon(new ImageIcon(Score.class.getResource("/icon32/exit.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Comparison frame = new Comparison();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(965, 618, 127, 38);
		contentPane.add(btnNewButton);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(161, 11, 260, 270);
		contentPane.add(desktopPane);
		
		lblImage = new JLabel("Image");
		lblImage.setBounds(10, 11, 240, 250);
		desktopPane.add(lblImage);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(150, 345, 278, 46);
		contentPane.add(lblName);
		
		lblQuote = new JLabel("Famous Quote");
		lblQuote.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuote.setBounds(161, 475, 257, 23);
		contentPane.add(lblQuote);
		
		lblNewLabel = new JLabel("Your Score is as good as:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(161, 296, 261, 38);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Score.class.getResource("/Background/16.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
		
		/*
		 * This code will run on opening
		 */
		initialize();
		
			
	}
	
	public void initialize()
	{
		/*
		 * Get name from default database
		 */
		try{
			String query = "select Name from Player Where rowid=1";
			PreparedStatement pst1 = conn.prepareStatement(query);
			ResultSet rs1 = pst1.executeQuery();
			
			name = rs1.getString("Name");
			
			pst1.close();
			rs1.close();
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		/*
		 * Get score from Main database
		 */
		try{
			
			String query2 = "select * from user where Username='"+name+"' ";
			PreparedStatement pst2 = conn.prepareStatement(query2);
			ResultSet rs2 = pst2.executeQuery();
			
			score = rs2.getInt("Score");
			lblScore.setText(String.valueOf("Your Score is: "+score));
			
			pst2.close();
			rs2.close();
			
		}catch(Exception e2){
			e2.printStackTrace();
		}
		
		/*
		 * Match the random result with Comparison...
		 */
		
		try{
			if(score <= 79){
				selection = "1";
			}
			else if(score <= 89){
				selection = "2";
			}
			else if(score <= 109){
				int x = randomizer(2);
				int y = cat3[x];
				selection = String.valueOf(y);
			}
			else if(score <= 119){
				selection = "5";
			}
			else if(score <= 129){
				selection = "6";
			}
			else if(score <= 149){
				int x = randomizer(3);
				int y = cat6[x];
				selection = String.valueOf(y);
			}
			else if(score <= 169){
				
				int x = randomizer(4);
				int y = cat7[x];
				selection = String.valueOf(y);
			}
			else if(score <= 189){
				int x = randomizer(2);
				int y = cat8[x];
				selection = String.valueOf(y);
			}
			else if(score > 189){
				int x = randomizer(2);
				int y = cat9[x];
				selection = String.valueOf(y);
			}
			
			
		}catch(Exception e3){
			e3.printStackTrace();
		}
		
		
		/*
		 * Set biography and name field...
		 */
		try{
			String query = "select * from Comparison Where rowid='"+selection+"' ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			bioPane.setText(rs.getString("Details"));
			String z = rs.getString("name");
			lblName.setText(z);
			z = " "+z+"'s Famous quote";
			lblQuote.setText(z);
			
			while(rs.next())
			{
			byte[]imagedata = rs.getBytes("Image");
			format =  new ImageIcon (imagedata);
			lblImage.setIcon(format);
			}
			
			
			pst.close();
			rs.close();
		}
		catch (Exception ef){
		ef.printStackTrace();
		}
		
		/*
		 * Set Random quote
		 */
		try{
			
			String query = "select * from Comparison Where rowid='"+selection+"' ";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			int x = randomizer(10)+1;
			String y = String.valueOf(x);
			y = "qt"+y;
			
			quotePane.setText(rs.getString(y));
			
			pst.close();
			rs.close();
			
		}catch (Exception ef){
			ef.printStackTrace();
		}
		return;
	}
}
