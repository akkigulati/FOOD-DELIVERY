package jdbcoracle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class signin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblTryAgain;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signin window = new signin();
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
	public signin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("LOGIN");
		frame.setBounds(100, 100, 1146, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(331, 242, 167, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(331, 320, 167, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(702, 245, 207, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(702, 324, 207, 37);
		frame.getContentPane().add(passwordField);
		
		lblTryAgain = new JLabel("");
		lblTryAgain.setBounds(233, 160, 76, 14);
		frame.getContentPane().add(lblTryAgain);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String USERNAME=textField.getText().toString();
				
				String PASSWORD=passwordField.getText().toString();
				try{
					  
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","database","root");  
					  
					//step3 create the statement object  
					Statement stmt=con.createStatement();  
						PreparedStatement pd=con.prepareStatement("select * from customer where fname=? and pass=?");
						
						
						pd.setString(1, USERNAME);
						pd.setString(2, PASSWORD);
						ResultSet rs=pd.executeQuery();
					Boolean i=rs.next();
					
					 if(i==true)
					 {
					
						 user.main(new String[]{});
					 }
					 
					 else
					 {		
							lblTryAgain.setText("try again!");}
					 
					
				}
				catch(Exception ex)
				{System.out.println(ex);
				
				}
				
				
				
				
			}
		});
		btnLogin.setBounds(510, 451, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		welcome.main(new String[]{});
			
			}
			
			
			
		});
		btnBack.setBounds(679, 451, 89, 23);
		frame.getContentPane().add(btnBack);
		
		
	}
}
