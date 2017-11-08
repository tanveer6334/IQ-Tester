import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class Comparison extends JFrame {

	private JPanel contentPane;
	private JTable scoreTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comparison frame = new Comparison();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JButton homeBtn;
	private JButton backBtn;
	private JScrollPane scrollPane;
	private JLabel label;
	private JLabel label_1;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Comparison() {
		setTitle("Comparison Chart");
		setType(Type.UTILITY);
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280,720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
        
        
        
		scrollPane = new JScrollPane();
		scrollPane.setBounds(148, 44, 600, 500);
		contentPane.add(scrollPane);
		
		scoreTable = new JTable();
		scoreTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(scoreTable);
		
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setIcon(new ImageIcon(Comparison.class.getResource("/icon32/refresh.png")));
		refreshBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refresh();
			}
		});
		refreshBtn.setBounds(869, 65, 163, 40);
		contentPane.add(refreshBtn);
		
		homeBtn = new JButton("Home");
		homeBtn.setIcon(new ImageIcon(Comparison.class.getResource("/icon32/home.png")));
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
		homeBtn.setBounds(971, 617, 120, 40);
		contentPane.add(homeBtn);
		
		backBtn = new JButton("Back");
		backBtn.setIcon(new ImageIcon(Comparison.class.getResource("/icon32/previous.png")));
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
		backBtn.setBounds(114, 617, 120, 40);
		contentPane.add(backBtn);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Classification     IQ", "Very Superiro     130+", "Superior             120-129", "High Average    110-119", "Average              90-109", "Low Average      80-89", "Borderline           70-79", "Extremely Low    69-"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(815, 176, 250, 250);
		contentPane.add(list);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Comparison.class.getResource("/icon64/comparative.png")));
		label_1.setBounds(57, 65, 64, 64);
		contentPane.add(label_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Comparison.class.getResource("/Background/14.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
		Refresh();
	}
	public void Refresh() {
		try{
			String query = "select Name,Age,Score from User ORDER by Score DESC";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			scoreTable.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
			return;
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
}
