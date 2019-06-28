package jdbcoracle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class register {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
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
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1170, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FIRSTNAME");
		lblNewLabel.setBounds(234, 30, 103, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LASTNAME");
		lblNewLabel_1.setBounds(234, 87, 103, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CUSTOMERID");
		lblNewLabel_2.setBounds(234, 132, 103, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMAILID");
		lblNewLabel_3.setBounds(234, 189, 89, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ADDRESS");
		lblNewLabel_4.setBounds(234, 248, 89, 35);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PINCODE");
		lblNewLabel_5.setBounds(234, 299, 89, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("GENDER");
		lblNewLabel_6.setBounds(234, 361, 103, 20);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PHONE NO");
		lblNewLabel_7.setBounds(234, 413, 89, 27);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("PASSWORD");
		lblNewLabel_8.setBounds(234, 471, 89, 29);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblAccountCreatedBitch = new JLabel("");
		lblAccountCreatedBitch.setBounds(854, 547, 254, 29);
		frame.getContentPane().add(lblAccountCreatedBitch);
		
		textField = new JTextField();
		textField.setBounds(600, 32, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(600, 84, 146, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(600, 134, 146, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(600, 191, 146, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(600, 252, 146, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(600, 301, 146, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(600, 358, 146, 26);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(600, 413, 146, 26);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(600, 472, 146, 26);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 {
					String FNAME=textField.getText().toString();
					String LNAME=textField_1.getText().toString();
					String CUSTID=textField_2.getText().toString();
					String EMAIL=textField_3.getText().toString();
					String ADD=textField_4.getText().toString();
					String PIN=textField_5.getText().toString();
					String GEN=textField_6.getText().toString();
					String PHONE=textField_7.getText().toString();
					String PASS=textField_8.getText().toString();
	               try{
	            	   
	            	   Class.forName("oracle.jdbc.driver.OracleDriver");  
	         		  
	           		//step2 create  the connection object  
	           		Connection con=DriverManager.getConnection(  
	           		"jdbc:oracle:thin:@localhost:1521:xe","database","root");  
	           		  
	           		//step3 create the statement object  
	           		Statement stmt=con.createStatement();  
						PreparedStatement pd=con.prepareStatement("insert into CUSTOMER values(?,?,?,?,?,?,?,?,?)");
						pd.setString(1, FNAME);
						pd.setString(2, LNAME);
						pd.setString(3, CUSTID);
						pd.setString(4, EMAIL);
						pd.setString(5, ADD);
						pd.setString(6, PIN);
						pd.setString(7, GEN);
						pd.setString(8, PHONE);
						pd.setString(9, PASS);

						//pd.setString(3, PASS);
						int i=pd.executeUpdate();
						if(i>0)
						{
							lblAccountCreatedBitch.setText("Account Created!!");	
							
						}
	            	   
	            	   
	            	   
	               }
					catch(Exception ex)
	               {System.out.println(ex);
	               }
				
				}
			}
		});
		btnNewButton.setBounds(393, 547, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				welcome.main(new String[]{});
			}
		});
		btnNewButton_1.setBounds(590, 547, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}
