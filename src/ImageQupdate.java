import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ImageQupdate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel img;
	JDesktopPane desktopPane;
	int imgNo;
	int dtImg;
	
	
	String ss;
	byte [] image_detail = null;
	byte [] image_detail1 = null;
	byte [] image_detail2 = null;
	byte [] image_detail3 = null;
	byte [] image_detail4 = null;
	byte [] image_detail5 = null;
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
					ImageQupdate frame = new ImageQupdate();
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
	
	Connection conn = null;
	private JButton btnAdd;
	private JDesktopPane desktopPane1;
	private JLabel img1;
	private JDesktopPane desktopPane2;
	private JLabel img3;
	private JDesktopPane desktopPane3;
	private JLabel img2;
	private JDesktopPane desktopPane4;
	private JLabel img4;
	private JButton btnQ;
	private JButton btnQ1;
	private JButton btnQ2;
	private JButton btnQ3;
	private JButton btnQ4;
	private JLabel Background;
	private JButton btnHome;
	private JButton btnBack;
	private JLabel lblOptionSizex;
	private JButton btnPrevious;
	private JButton btnNext;
	private JLabel lblQNo;
	private JButton btnInsertNew;
	
	
	@SuppressWarnings("serial")
	public ImageQupdate() {
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
        
        
        
		
		btnAdd = new JButton("Update");
		btnAdd.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon64/refresh.png")));
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
					
			}
		});
		
		JLabel lblQuestionSizex = new JLabel("Size: 381x381 px");
		lblQuestionSizex.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon64/picture-size.png")));
		lblQuestionSizex.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuestionSizex.setBounds(100, 421, 250, 50);
		contentPane.add(lblQuestionSizex);
		
		lblOptionSizex = new JLabel("Size: 121x121 px");
		lblOptionSizex.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon64/picture-size.png")));
		lblOptionSizex.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOptionSizex.setBounds(559, 350, 200, 50);
		contentPane.add(lblOptionSizex);
		btnAdd.setBounds(956, 53, 200, 70);
		contentPane.add(btnAdd);
		
		
		btnQ = new JButton("Select Question");
		btnQ.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon32/clipp.png")));
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		        fileChooser.addChoosableFileFilter(filter);
		        int result = fileChooser.showSaveDialog(null);
		        if(result == JFileChooser.APPROVE_OPTION){
		            File selectedFile = fileChooser.getSelectedFile();
		            try {
						@SuppressWarnings("resource")
						FileInputStream fis = new FileInputStream(selectedFile);
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						
						byte [] buf = new byte[1024];
						for(int readNum; (readNum=fis.read(buf))!= -1;)
						{
							bos.write(buf, 0, readNum);
						}
						image_detail = bos.toByteArray();
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		        }
		        else if(result == JFileChooser.CANCEL_OPTION){
		            System.out.println("No Data");
		            return;
		        }
		        
				btnQ.setText(filename);
				return;
			}
		});
		
		btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon32/home.png")));
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
		btnHome.setBounds(989, 596, 120, 40);
		contentPane.add(btnHome);
		
		btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon32/previous.png")));
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
		btnBack.setBounds(128, 596, 120, 40);
		contentPane.add(btnBack);
		btnQ.setForeground(Color.DARK_GRAY);
		btnQ.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQ.setBounds(122, 482, 190, 40);
		contentPane.add(btnQ);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(52, 29, 381, 381);
		contentPane.add(desktopPane);
		
		img = new JLabel("");
		img.setBounds(0, 0, 381, 381);
		desktopPane.add(img);
		
		desktopPane1 = new JDesktopPane();
		desktopPane1.setBounds(481, 133, 121, 121);
		contentPane.add(desktopPane1);
		
		img1 = new JLabel("");
		img1.setBounds(0, 0, 121, 121);
		desktopPane1.add(img1);
		
		desktopPane2 = new JDesktopPane();
		desktopPane2.setBounds(481, 410, 121, 121);
		contentPane.add(desktopPane2);
		
		img3 = new JLabel("");
		img3.setBounds(0, 0, 121, 121);
		desktopPane2.add(img3);
		
		desktopPane3 = new JDesktopPane();
		desktopPane3.setBounds(711, 133, 121, 121);
		contentPane.add(desktopPane3);
		
		img2 = new JLabel("");
		img2.setBounds(0, 0, 121, 121);
		desktopPane3.add(img2);
		
		desktopPane4 = new JDesktopPane();
		desktopPane4.setBounds(711, 410, 121, 121);
		contentPane.add(desktopPane4);
		
		img4 = new JLabel("");
		img4.setBounds(0, 0, 121, 121);
		desktopPane4.add(img4);
		
		btnQ1 = new JButton("Select Answer");
		btnQ1.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon24/clip.png")));
		btnQ1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		        fileChooser.addChoosableFileFilter(filter);
		        int result = fileChooser.showSaveDialog(null);
		        if(result == JFileChooser.APPROVE_OPTION){
		            File selectedFile = fileChooser.getSelectedFile();
		            try {
						@SuppressWarnings("resource")
						FileInputStream fis = new FileInputStream(selectedFile);
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						
						byte [] buf = new byte[1024];
						for(int readNum; (readNum=fis.read(buf))!= -1;)
						{
							bos.write(buf, 0, readNum);
						}
						image_detail1 = bos.toByteArray();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		            
		            
		             }
		        else if(result == JFileChooser.CANCEL_OPTION){
		            System.out.println("No Data");
		            return;
		        }
		        
				btnQ1.setText(filename);
				return;
			}
		});
		btnQ1.setForeground(Color.DARK_GRAY);
		btnQ1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQ1.setBounds(468, 280, 150, 40);
		contentPane.add(btnQ1);
		
		btnQ2 = new JButton("Select Option 2");
		btnQ2.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon24/clip.png")));
		btnQ2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		        fileChooser.addChoosableFileFilter(filter);
		        int result = fileChooser.showSaveDialog(null);
		        if(result == JFileChooser.APPROVE_OPTION){
		            File selectedFile = fileChooser.getSelectedFile();
		            try {
						@SuppressWarnings("resource")
						FileInputStream fis = new FileInputStream(selectedFile);
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						
						byte [] buf = new byte[1024];
						for(int readNum; (readNum=fis.read(buf))!= -1;)
						{
							bos.write(buf, 0, readNum);
						}
						image_detail2 = bos.toByteArray();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		            
		            
		             }
		        else if(result == JFileChooser.CANCEL_OPTION){
		            System.out.println("No Data");
		            return;
		        }
		        
				btnQ2.setText(filename);
				return;
			
			}
		});
		btnQ2.setForeground(Color.DARK_GRAY);
		btnQ2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQ2.setBounds(696, 280, 150, 40);
		contentPane.add(btnQ2);
		
		btnQ3 = new JButton("Select Option 3");
		btnQ3.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon24/clip.png")));
		btnQ3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		        fileChooser.addChoosableFileFilter(filter);
		        int result = fileChooser.showSaveDialog(null);
		        if(result == JFileChooser.APPROVE_OPTION){
		            File selectedFile = fileChooser.getSelectedFile();
		            try {
						@SuppressWarnings("resource")
						FileInputStream fis = new FileInputStream(selectedFile);
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						
						byte [] buf = new byte[1024];
						for(int readNum; (readNum=fis.read(buf))!= -1;)
						{
							bos.write(buf, 0, readNum);
						}
						image_detail3 = bos.toByteArray();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		            
		            
		             }
		        else if(result == JFileChooser.CANCEL_OPTION){
		            System.out.println("No Data");
		            return;
		        }
		        
				btnQ3.setText(filename);
				return;
			}
		});
		btnQ3.setForeground(Color.DARK_GRAY);
		btnQ3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQ3.setBounds(468, 546, 150, 40);
		contentPane.add(btnQ3);
		
		btnQ4 = new JButton("Select Option 4");
		btnQ4.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon24/clip.png")));
		btnQ4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		        fileChooser.addChoosableFileFilter(filter);
		        int result = fileChooser.showSaveDialog(null);
		        if(result == JFileChooser.APPROVE_OPTION){
		            File selectedFile = fileChooser.getSelectedFile();
		            try {
						@SuppressWarnings("resource")
						FileInputStream fis = new FileInputStream(selectedFile);
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						
						byte [] buf = new byte[1024];
						for(int readNum; (readNum=fis.read(buf))!= -1;)
						{
							bos.write(buf, 0, readNum);
						}
						image_detail4 = bos.toByteArray();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		            
		            
		             }
		        else if(result == JFileChooser.CANCEL_OPTION){
		            System.out.println("No Data");
		            return;
		        }
		        
				btnQ4.setText(filename);
				return;
			}
		});
		btnQ4.setForeground(Color.DARK_GRAY);
		btnQ4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQ4.setBounds(696, 546, 150, 40);
		contentPane.add(btnQ4);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon32/pre.png")));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNext.setEnabled(true);
				imgNo--;
				refresh();
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPrevious.setBounds(989, 182, 150, 40);
		contentPane.add(btnPrevious);
		
		btnNext = new JButton("Next");
		btnNext.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon32/next.png")));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPrevious.setEnabled(true);
				imgNo++;
				refresh();
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNext.setBounds(989, 258, 150, 40);
		contentPane.add(btnNext);
		
		lblQNo = new JLabel("Question No: ");
		lblQNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQNo.setBounds(559, 33, 200, 50);
		contentPane.add(lblQNo);
		
		btnInsertNew = new JButton("Insert New");
		btnInsertNew.setIcon(new ImageIcon(ImageQupdate.class.getResource("/icon64/insert-coin.png")));
		btnInsertNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImgQSet frame = new ImgQSet();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnInsertNew.setFont(new Font("Dialog", Font.BOLD, 16));
		btnInsertNew.setBounds(956, 342, 200, 70);
		contentPane.add(btnInsertNew);
		
		Background = new JLabel("");
		Background.setIcon(new ImageIcon(ImageQupdate.class.getResource("/Background/16.jpg")));
		Background.setBounds(0, 0, 1920, 1080);
		contentPane.add(Background);
		
		try{
			String query = "SELECT * FROM AdminPanel where rowid = 1" ;
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			dtImg = rs.getInt("dtQ");
			
			pst.close();
			rs.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Admin panel total question read error!");
		}
		
		
		imgNo = 1;
		refresh();
	}
	
	public void refresh(){
		if(imgNo == 0){
			imgNo = 1;
			JOptionPane.showMessageDialog(null, "Minimum Question reached");
			btnPrevious.setEnabled(false);
			return;
		}
		else if(imgNo > dtImg){
			imgNo = dtImg;
			JOptionPane.showMessageDialog(null, "Maximum Question reached!");
			btnNext.setEnabled(false);
			return;
		}
		else{
	
			try{
				String query = "select * from QImage Where rowid= "+imgNo+" ";
				PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next())
				{
				byte[]imagedata = rs.getBytes("Question");
				format =  new ImageIcon (imagedata);
				img.setIcon(format);
				}
				pst.close();		
				rs.close();
			}
			catch (Exception ef){
			ef.printStackTrace();
			}
			
			try{
				String query = "select * from QImage Where rowid= "+imgNo+" ";
				PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next())
				{
				byte[]imagedata = rs.getBytes("Op1");
				format =  new ImageIcon (imagedata);
				img1.setIcon(format);
				}
				pst.close();	
				rs.close();
			}
			catch (Exception ef){
			ef.printStackTrace();
			}
			
			
			try{
				String query = "select * from QImage Where rowid= "+imgNo+" ";
				PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next())
				{
				byte[]imagedata = rs.getBytes("Op2");
				format =  new ImageIcon (imagedata);
				img2.setIcon(format);
				}
				pst.close();		
				rs.close();
			}
			catch (Exception ef){
			ef.printStackTrace();
			}
			
			try{
				String query = "select * from QImage Where rowid= "+imgNo+" ";
				PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next())
				{
				byte[]imagedata = rs.getBytes("Op3");
				format =  new ImageIcon (imagedata);
				img3.setIcon(format);
				}
				pst.close();	
				rs.close();
			}
			catch (Exception ef){
			ef.printStackTrace();
			}
			
			try{
				String query = "select * from QImage Where rowid= "+imgNo+" ";
				PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next())
				{
				byte[]imagedata = rs.getBytes("Op4");
				format =  new ImageIcon (imagedata);
				img4.setIcon(format);
				}
				pst.close();		
				rs.close();
			}
			catch (Exception ef){
			ef.printStackTrace();
			}
		}
		lblQNo.setText("Question No: "+String.valueOf(imgNo)+" / "+String.valueOf(dtImg));
	}
	
	/*
	 * error in update, can't set pst.setBytes. although set Op1 = image_detail1 incompletely works...
	 */
	public void update(){
		if(image_detail != null){
			try
			{
				String query = "UPDATE QImage SET Question = ? WHERE rowid = "+String.valueOf(imgNo)+" ";
				
				PreparedStatement pst = conn.prepareStatement(query);
				
		
				pst.setBytes(1, image_detail);
		
				pst.execute();
				pst.close();
				
				JOptionPane.showMessageDialog(null, "Question Image Updated");
				
			} catch (Exception es) {
				es.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erron in Qustion image update");
			}
		
		}
		if(image_detail1 != null){
			try
			{
				String query = "UPDATE QImage SET Op1 = ? where rowid = "+String.valueOf(imgNo)+" ";
				
				PreparedStatement pst = conn.prepareStatement(query);
				
		
				pst.setBytes(1, image_detail1);
				
		
				pst.execute();
				pst.close();
				
				JOptionPane.showMessageDialog(null, "Image 1 Updated");
				
			} catch (Exception es) {
				es.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erron in Image 1 update");
			}
		
		}
		if(image_detail2 != null){
			try
			{
				String query = "UPDATE QImage SET Op2 = ? WHERE rowid = "+String.valueOf(imgNo)+" ";
				
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setBytes(1, image_detail2);
	
				pst.execute();
				
				pst.close();
				
				JOptionPane.showMessageDialog(null, "Image 2 Updated");
				
			} catch (Exception es) {
				es.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erron in Image 2 update");
			}
		
		}
		if(image_detail3 != null){
			try
			{
				String query = "UPDATE QImage SET Op3 = ? WHERE rowid = "+String.valueOf(imgNo)+" ";
				
				PreparedStatement pst = conn.prepareStatement(query);
				
		
				pst.setBytes(1, image_detail3);
		
				pst.execute();
				pst.close();
				
				JOptionPane.showMessageDialog(null, "Image 3 Updated");
				
			} catch (Exception es) {
				es.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erron in Image 3 update");
			}
		
		}
		if(image_detail4 != null){
			try
			{
				String query = "UPDATE QImage SET Op4 = ? WHERE rowid = "+String.valueOf(imgNo)+" ";
				
				PreparedStatement pst = conn.prepareStatement(query);
				
		
				pst.setBytes(1, image_detail4);
				
		
				pst.execute();
				pst.close();
				
				JOptionPane.showMessageDialog(null, "Image 4 Updated");
				
			} catch (Exception es) {
				es.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erron in Image 4 update");
			}
		
		}
		image_detail = null;
		image_detail1 = null;
		image_detail2 = null;
		image_detail3 = null;
		image_detail4 = null;
		
		refresh();
	}
}
