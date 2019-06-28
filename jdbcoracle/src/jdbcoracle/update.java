package jdbcoracle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class update {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	//private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update window = new update();
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
	public update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("UPDATE");
		frame.setBounds(100, 100, 1152, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(42, 67, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblEnterUserName = new JLabel("USERNAME");
		lblEnterUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterUserName.setBounds(284, 225, 147, 35);
		frame.getContentPane().add(lblEnterUserName);
		
		textField = new JTextField();
		textField.setBounds(676, 225, 176, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIncorrect = new JLabel("");
		lblIncorrect.setBounds(52, 187, 86, 35);
		frame.getContentPane().add(lblIncorrect);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(676, 302, 176, 35);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(676, 368, 176, 35);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("CURRENT PASSWORD");
		lblNewLabel.setBounds(284, 302, 161, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterNewPassword = new JLabel("NEW PASSWORD\r\n\r\n");
		lblEnterNewPassword.setBounds(284, 368, 181, 35);
		frame.getContentPane().add(lblEnterNewPassword);
		
		
		

		JButton btnContinue = new JButton("UPDATE");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname=textField.getText().toString();
				String pass=passwordField.getText().toString();
				String passs=passwordField_1.getText().toString();

				try{ Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","database","root");  
				  
				//step3 create the statement object  
			Statement stmt=con.createStatement();  
					PreparedStatement pd=con.prepareStatement("update  customer set  pass=? where fname=? and pass=? ");
					pd.setString(1,passs);	
					pd.setString(2, fname);
				    pd.setString(3, pass);
					
                   int i=pd.executeUpdate();
                 if(i>0)
						
                 {
                	 lblIncorrect.setText("UPDATED!");
                	 
                 }
                 
                 else
                 {lblIncorrect.setText("TRY AGAIN!");
                 }
                 
                 }
				
				
				catch(Exception ex)
				{System.out.println(ex);
				
				}
				
				
				
				
			}
		});
		btnContinue.setBounds(720, 444, 147, 42);
		frame.getContentPane().add(btnContinue);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome.main(new String[]{});
			}
		});
		btnNewButton.setBounds(720, 518, 147, 42);
		frame.getContentPane().add(btnNewButton);
		
		
		
	}
}