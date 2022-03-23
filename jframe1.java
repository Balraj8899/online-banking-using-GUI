/*
 * Created by JFormDesigner on Tue Jan 25 09:48:41 IST 2022
 */

package connectingjframes;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;

/**
 * @author balraj
 */
public class jframe1 extends JFrame {
	static int a1;
	static String a,a2,c;
	static Connection con;
	static Statement stmt;
	static ResultSet rst;
	static String query;
	public jframe1() {
		initComponents();
	}
	static  int selectAccount(String e, String f) throws SQLException { 
		 a1 = -1;
		stmt = con.createStatement();
		query = "SELECT * FROM bank WHERE ACNAME = '"+e+ "' and PASSWORD = '"+f+"'";
		rst = stmt.executeQuery(query);
		if(rst.next())
		{
			a1= rst.getInt(1);			
		}
		return a1;
	}

	private void button1(ActionEvent e) throws SQLException {
		// TODO add your code here
		
		a1=selectAccount(textField1.getText(),passwordField1.getText());
		//System.out.println(a1);
		if(a1!=-1) {
			if(textField1.getText().equals("bank")&&passwordField1.getText().equals("123")) {
			setVisible(false);
			jframe3 j3 = new jframe3(con);
			j3.setVisible(true);
			}
			else
			{
				setVisible(false);
				jform2.assign(textField1.getText());
				//jform2.assign2(a1);
				jform2 j2 = new jform2(con);
				j2.setVisible(true);
				
			}
			
		}
		
            else{
            	Component frame = null;
				JOptionPane.showMessageDialog(frame,"ID OR PSWRD INCORRECT","",JOptionPane.INFORMATION_MESSAGE);
			label4.setText("LOGIN ID OR PSWRD IS INCORRECT");
			textField1.setText(null);
			//textField1.requestFocus(true);
			passwordField1.setText(null);
		   }
	}
	

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  
		// Generated using JFormDesigner Evaluation license - balraj
		label1 = new JLabel();
		label2 = new JLabel();
		button1 = new JButton();
		textField1 = new JTextField();
		label3 = new JLabel();
		passwordField1 = new JPasswordField();
		label4 = new JLabel();

		//======== this ========
		var contentPane = getContentPane();

		//---- label1 ----
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setText("LOGIN ID     :");

		//---- label2 ----
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setText("PASSWORD :");

		//---- button1 ----
		button1.setText("LOGIN");
		button1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button1.addActionListener(e -> {
			try {
				button1(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- textField1 ----
		textField1.setFont(new Font("Tahoma", Font.BOLD, 11));

		//---- label3 ----
		label3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label3.setText("LOGIN PAGE");
		label3.setBackground(new Color(255, 255, 51));
		label3.setForeground(Color.red);

		//---- passwordField1 ----
		passwordField1.setFont(new Font("Tahoma", Font.BOLD, 11));

		//---- label4 ----
		label4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label4.setForeground(Color.red);

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(label4, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addComponent(label3, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(label2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
							.addGap(35, 35, 35)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
					.addGap(99, 99, 99))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(label2, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
						.addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addGap(30, 30, 30)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(button1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(label4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// JFormDesigner - End of component initialization  GEN-END:initComponents
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/balraj","root","");
		new jframe1();
		
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - balraj
	private JLabel label1;
	private JLabel label2;
	private JButton button1;
	public static JTextField textField1;
	private JLabel label3;
	public static JPasswordField passwordField1;
	private JLabel label4;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
