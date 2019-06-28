package jdbcoracle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
public class admin {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
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
	public admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Admin");
		frame.setBounds(100, 100, 1143, 684);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome.main(new String[]{});
				
				
			}
		});
		btnNewButton.setBounds(534, 546, 113, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 81, 1091, 449);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnDetails = new JButton("CUSTOMER DETAILS");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try{	Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","database","root");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
				PreparedStatement pd=con.prepareStatement("select * from customer");
				ResultSet rs=pd.executeQuery();
				//table_1.setModel(DbUtils.resultSetToTableModel(rs));
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception ex)
			{System.out.println(ex);
			}
			}
		});
		btnDetails.setBounds(31, 11, 220, 54);
		frame.getContentPane().add(btnDetails);
		
	
		
	}
}

