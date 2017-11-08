import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Credits extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credits frame = new Credits();
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
	public Credits() {
		setTitle("Credits");
		setType(Type.UTILITY);
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
        
        
        
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(Credits.class.getResource("/icon64/previous.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage frame = new MainPage();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(465, 565, 238, 60);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Credits.class.getResource("/Image/Piash 2.jpg")));
		lblNewLabel.setBounds(773, 47, 250, 375);
		contentPane.add(lblNewLabel);
		
		JLabel lblMdAfiqurRahman = new JLabel("Md. Afiqur Rahman Piash");
		lblMdAfiqurRahman.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMdAfiqurRahman.setHorizontalAlignment(SwingConstants.CENTER);
		lblMdAfiqurRahman.setBounds(742, 420, 313, 60);
		contentPane.add(lblMdAfiqurRahman);
		
		JLabel lblBscInCse = new JLabel("BSc in CSE (Running)");
		lblBscInCse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBscInCse.setHorizontalAlignment(SwingConstants.CENTER);
		lblBscInCse.setBounds(773, 479, 250, 39);
		contentPane.add(lblBscInCse);
		
		JLabel lblDaffodilInternationalUniversity = new JLabel("Daffodil International University");
		lblDaffodilInternationalUniversity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDaffodilInternationalUniversity.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaffodilInternationalUniversity.setBounds(773, 509, 250, 39);
		contentPane.add(lblDaffodilInternationalUniversity);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Credits.class.getResource("/Image/Tanveer-Hoque.jpg")));
		lblNewLabel_1.setBounds(211, 47, 280, 375);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMdTanveerHaque = new JLabel("Md. Tanveer Haque");
		lblMdTanveerHaque.setHorizontalAlignment(SwingConstants.CENTER);
		lblMdTanveerHaque.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMdTanveerHaque.setBounds(231, 420, 250, 60);
		contentPane.add(lblMdTanveerHaque);
		
		JLabel label_1 = new JLabel("BSc in CSE (Running)");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(231, 479, 250, 39);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Daffodil International University");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(231, 509, 250, 39);
		contentPane.add(label_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Credits.class.getResource("/Background/14.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
	}
}
