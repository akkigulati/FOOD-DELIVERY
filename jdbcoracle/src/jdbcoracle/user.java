package jdbcoracle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class user {
	
	private JFrame frame;
	private JTable table;
	private JButton btnLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user window = new user();
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
	public user() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1271, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 81, 1130, 449);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		JButton btnFood = new JButton("MENU");
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try
			{Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","database","root");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
				PreparedStatement pd=con.prepareStatement("select * from food");
				ResultSet rs=pd.executeQuery();
				//table_1.setModel(DbUtils.resultSetToTableModel(rs));
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception ex)
			{System.out.println(ex);
			}
			}
		});
		btnFood.setBounds(469, 26, 166, 42);
		frame.getContentPane().add(btnFood);
		
		btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome.main(new String[]{});
			}
		});
		btnLogout.setBounds(491, 570, 151, 47);
		frame.getContentPane().add(btnLogout);
	}
}
