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

public class EMPLOYEE {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EMPLOYEE window = new EMPLOYEE();
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
	public EMPLOYEE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1230, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmpid = new JLabel("EMPID");
		lblEmpid.setBounds(265, 173, 69, 20);
		frame.getContentPane().add(lblEmpid);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(265, 274, 120, 20);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblTryAgain = new JLabel("");
		lblTryAgain.setBounds(682, 540, 86, 20);
		frame.getContentPane().add(lblTryAgain);
		
		textField = new JTextField();
		textField.setBounds(587, 170, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(587, 271, 146, 26);
		frame.getContentPane().add(passwordField);
		
	
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String USERNAME=textField.getText().toString();
			
			String PASSWORD=passwordField.getText().toString();
			try{
				  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","database","root");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
					PreparedStatement pd=con.prepareStatement("select * from employee where fname=? and pass=?");
					
					
					pd.setString(1, USERNAME);
					pd.setString(2, PASSWORD);
					ResultSet rs=pd.executeQuery();
				Boolean i=rs.next();
				
				 if(i==true)
				 {
				
					 admin.main(new String[]{});
				 }
				 
				 else
				 {		
					 lblTryAgain.setText("try again!");
				 
				 }
			}
			catch(Exception ex)
			{System.out.println(ex);
			
			}
			
			
			
			
		}
			
		});
		btnLogin.setBounds(376, 458, 115, 29);
		frame.getContentPane().add(btnLogin);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome.main(new String[]{});
			}
		});
		btnBack.setBounds(682, 458, 115, 29);
		frame.getContentPane().add(btnBack);
		
	
	
	}
}
