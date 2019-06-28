package jdbcoracle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

public class welcome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome window = new welcome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("welcome");
		frame.setBounds(100, 100, 1135, 709);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("KHAO PIO AISH KARO MITRON");
		lblWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblWelcome.setBounds(315, 107, 533, 43);
		frame.getContentPane().add(lblWelcome);
		
		JButton btnRegistration = new JButton("REGISTER");
		btnRegistration.setBackground(UIManager.getColor("Button.background"));
		btnRegistration.setForeground(Color.BLACK);
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				register.main(new String[]{});
				
				
				
			}
		});
		btnRegistration.setBounds(366, 239, 381, 91);
		frame.getContentPane().add(btnRegistration);
		
		JButton btnNewButton = new JButton("LOGIN"
				);
		
		
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signin.main(new String[]{});
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(366, 354, 381, 91);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				update.main(new String[]{});
				
			}
		});
		btnNewButton_1.setBounds(366, 485, 381, 91);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnEmployeeLogin = new JButton("EMPLOYEE LOGIN");
		btnEmployeeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {EMPLOYEE.main(new String[]{});
			}
		});
		btnEmployeeLogin.setBounds(884, 37, 173, 29);
		frame.getContentPane().add(btnEmployeeLogin);
	}
}
