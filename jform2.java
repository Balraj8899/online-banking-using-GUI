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
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class jform2 extends JFrame {
	static Connection con;
	static Statement stmt;
	static ResultSet rst;
	static String query,b,x1;
	static int c,x3,x2,x4;
	static int a1=0,b1=0;
	
	
	
	public static void assign(String a) {
		b=a;
	}
	//SELECT OWN ACCOUNT

		public static int sender1(String a7,String b7) throws SQLException
		{
			a1=0;
			stmt = con.createStatement();
			query = "SELECT ID FROM bank WHERE ACNAME = '"+jframe1.textField1.getText()+ "' and PASSWORD = '"+jframe1.passwordField1.getText()+"'";
			rst = stmt.executeQuery(query);
			if(rst.next())
			{
				a1= rst.getInt(1);
			}
			return a1;
		}
		//SELECT RECEIVER ACCOUNT
		public static int sender(String B1) throws SQLException
		{
			b1=0;
			stmt = con.createStatement();
			query = "SELECT * FROM bank WHERE ACNAME ='"+B1+"'";
			rst = stmt.executeQuery(query);
			if(rst.next())
			{
				b1= rst.getInt(1);
			}
			return b1;
		}
		
		//CHANGE
		public static void change(int c12,int a1) throws SQLException {
			stmt=con.createStatement();
			query = "UPDATE bank SET BALANCE ="+c12+" WHERE ID= "+a1;
			stmt.executeUpdate(query);
			
		}
		
		//BALANCE
		public static int balance(int a1) throws SQLException {
			c=0;
			stmt = con.createStatement();
			query = "SELECT BALANCE FROM bank WHERE ID ="+a1;
			rst = stmt.executeQuery(query);
			if(rst.next())
			{
				c=rst.getInt(1);
			}
			return c;
		}
	public jform2(Connection cmt) {
		con = cmt;
		initComponents();
		textField1.setVisible(false);
		button6.setVisible(false);
		button7.setVisible(false);
		label4.setVisible(false);
		textField2.setVisible(false);
		label3.setVisible(false);
		label1.setText("LOGIN SUCCESSFULL!!  "+b);
		
	}

	//GOBACK
	private void button1(ActionEvent e) {
		// TODO add your code here
		setVisible(false);
		jframe1 jframe1 = new jframe1();
		jframe1.setVisible(true);
	}

	//EMAIL BUTTON
	private void button2(ActionEvent e) throws SQLException, ClassNotFoundException {
		// TODO add your code here
		String z;
		a1=sender1(jframe1.textField1.getText(),jframe1.passwordField1.getText());
		if(a1!=-1) {
		stmt = con.createStatement();
		query = "SELECT * FROM bank WHERE ID ="+a1;
		rst = stmt.executeQuery(query);
		while(rst.next())
		{
			
				z=rst.getString(4);
				label2.setText("YOUR MAIL IS "+z);
		}
		}

	}

	//BALANCE BUTTON
	private void button3(ActionEvent e) throws SQLException, ClassNotFoundException {
		// TODO add your code here
		
		c=0;
		a1=sender1(jframe1.textField1.getText(),jframe1.passwordField1.getText());
		if(a1!=-1) {
			c=balance(a1);
			label2.setText("YOUR BALANCE IS "+String.valueOf(c));
	        }
		
	}

	//DEPOSITE BUTTON
	private void button4(ActionEvent e) throws ClassNotFoundException, SQLException {
		// TODO add your code here
		    
			button1.setVisible(false);
			button2.setVisible(false);
			button3.setVisible(false);
			button4.setVisible(false);
			button5.setVisible(false);
			button8.setVisible(false);
			button9.setVisible(false);
			label1.setText(null);
			label2.setText(null);
			label4.setVisible(false);
			textField2.setVisible(false);
			
			label3.setVisible(true);
			textField1.setVisible(true);
			textField1.setText(null);
			button6.setVisible(true);
			button7.setVisible(true);
			x3=1;
			 	
	}

	//WITHDRAW BUTTON
	private void button5(ActionEvent e) throws ClassNotFoundException, SQLException {
		// TODO add your code here
		    
			button1.setVisible(false);
			button2.setVisible(false);
			button3.setVisible(false);
			button4.setVisible(false);
			button5.setVisible(false);
			button8.setVisible(false);
			button9.setVisible(false);
			textField1.setVisible(true);
			button6.setVisible(true);
			button7.setVisible(true);
			label4.setVisible(false);
			textField2.setVisible(false);
			label1.setText(null);
			label2.setText(null);
			label3.setVisible(true);
			textField1.setText(null);
			 x3=2;

	}
		//OK BUTTON
	private void button6(ActionEvent e) throws SQLException, ClassNotFoundException {
		// TODO add your code here
		int cj;
		if(x3==1) {
			//DEPOSITE
			         x2=Integer.parseInt(textField1.getText());
			         a1=sender1(jframe1.textField1.getText(),jframe1.passwordField1.getText());
			         if(a1!=0) {
			             c=balance(a1);
			             cj=0;
			             cj=c+x2;
			             change(cj,a1);
			             label2.setVisible(true);
			             label2.setText("NEW BALANCE IS "+String.valueOf(cj));
			             c=balance(1);
			             cj=0;
			             cj = c+x2;
			             change(cj,1);
			 }
			
			}
			else if(x3==2) {
				//WITHDRAW
			
				
				 x2=Integer.parseInt(textField1.getText());
				 a1=sender1(jframe1.textField1.getText(),jframe1.passwordField1.getText());
				 if(a1!=0) {
				 c=balance(a1);
				 cj=0;
				cj=c-x2;
				change(cj,a1);
				label2.setVisible(true);
				label2.setText("REMAINING BALANCE IS "+String.valueOf(cj));
				c=balance(a1);
				cj=0;
				cj=c-x2;
				change(cj,1);
				 }
				
			}
			else if(x3==3) {
				//TRANSFER
				
				//RECEIVER ACCOUNT
				String B1 = textField2.getText();
				b1=sender(B1);
				if(b1!=0) {
							c=balance(b1);
							 c=c+Integer.parseInt(textField1.getText());
							change(c,b1);
							//label1.setText(String.valueOf(b1));
					}
				//SENDER ACCOUNT
				a1=sender1(jframe1.textField1.getText(),jframe1.passwordField1.getText());
				
				if(a1!=0) {
				            c=balance(a1);
				            c-=Integer.parseInt(textField1.getText());
				            change(c,a1);
					}
				label2.setVisible(true);
				label2.setText("AMOUNT TRANSFERRED SUCCESSFULLY!");	
			}
			button2.setVisible(true);
			button3.setVisible(true);
			button4.setVisible(true);
			button5.setVisible(true);
			button1.setVisible(true);
			button8.setVisible(true);
			button9.setVisible(true);
			button7.setVisible(false);
			button6.setVisible(false);
			label1.setVisible(true);
			
			label3.setVisible(false);
			label4.setVisible(false);
			textField1.setVisible(false);
			textField2.setVisible(false);
			
	}

	//BACK BUTTON
	private void button7(ActionEvent e) throws SQLException {
		// TODO add your code here
		button2.setVisible(true);
		button3.setVisible(true);
		button4.setVisible(true);
		button5.setVisible(true);
		button1.setVisible(true);
		button8.setVisible(true);
		button9.setVisible(true);
		button6.setVisible(false);
		button7.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		label1.setVisible(true);
		label2.setVisible(true);
		label2.setText(null);
		textField1.setVisible(false);
		textField2.setVisible(false);

	}

	//TRANSFER BUTTON
	private void button8(ActionEvent e) throws ClassNotFoundException, SQLException {
		// TODO add your code here
		 
			button1.setVisible(false);
			button2.setVisible(false);
			button3.setVisible(false);
			button4.setVisible(false);
			button5.setVisible(false);
			button8.setVisible(false);
			button9.setVisible(false);
			label1.setVisible(false);
			label2.setVisible(false);
			label3.setVisible(true);
			label4.setVisible(true);
			textField1.setVisible(true);
			textField1.setText(null);
			textField2.setVisible(true);
			textField2.setText(null);
			button6.setVisible(true);
			button7.setVisible(true);
			 x3=3;
	}

	//EXIT BUTTON
	private void button9(ActionEvent e) throws SQLException {
		// TODO add your code here
		con.close();
		System.exit(0);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  
		// Generated using JFormDesigner Evaluation license - balraj
		ResourceBundle bundle = ResourceBundle.getBundle("jframe.frame");
		button1 = new JButton();
		label1 = new JLabel();
		label2 = new JLabel();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		textField1 = new JTextField();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		button9 = new JButton();
		label3 = new JLabel();
		label4 = new JLabel();
		textField2 = new JTextField();

		//======== this ========
		setTitle(bundle.getString("jform2.this.title"));
		var contentPane = getContentPane();

		//---- button1 ----
		button1.setText("GO BACK");
		button1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button1.addActionListener(e -> {
			button1(e);
			button1(e);
		});

		//---- label1 ----
		label1.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- label2 ----
		label2.setFont(new Font("Tahoma", Font.BOLD, 11));

		//---- button2 ----
		button2.setText("EMAIL");
		button2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button2.addActionListener(e -> {
			try {
				button2(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				button2(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- button3 ----
		button3.setText("BALANCE");
		button3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button3.addActionListener(e -> {
			try {
				button3(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				button3(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- button4 ----
		button4.setText("DEPOSITE");
		button4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button4.addActionListener(e -> {
			try {
				button2(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				button4(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				button4(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- button5 ----
		button5.setText("WITHDRAW");
		button5.setFont(new Font("Tahoma", Font.BOLD, 12));
		button5.addActionListener(e -> {
			try {
				button2(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				button5(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- textField1 ----
		textField1.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- button6 ----
		button6.setText("OK");
		button6.setFont(new Font("Tahoma", Font.BOLD, 12));
		button6.addActionListener(e -> {
			try {
				button6(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				button6(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- button7 ----
		button7.setText("BACK");
		button7.setFont(new Font("Tahoma", Font.BOLD, 12));
		button7.addActionListener(e -> {
			try {
				button6(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				button7(e);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				button7(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- button8 ----
		button8.setText("TRANSFER");
		button8.setFont(new Font("Tahoma", Font.BOLD, 12));
		button8.addActionListener(e -> {
			try {
				button2(e);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				button4(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				button8(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- button9 ----
		button9.setText("EXIT");
		button9.setFont(new Font("Tahoma", Font.BOLD, 12));
		button9.addActionListener(e -> {
			try {
				button2(e);
			} catch (ClassNotFoundException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			try {
				button4(e);
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				button9(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- label3 ----
		label3.setText(bundle.getString("jform2.label3.text"));
		label3.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- label4 ----
		label4.setText(bundle.getString("jform2.label4.text"));
		label4.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- textField2 ----
		textField2.setFont(new Font("Tahoma", Font.BOLD, 12));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(33, 33, 33)
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(button2, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(button3, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addGap(58, 58, 58)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(button4, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addComponent(button5, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(button8, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addComponent(button9, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))))
					.addGap(22, 22, 22))
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label2, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(204, 204, 204)
							.addComponent(button6, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addComponent(button7, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label3, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label4, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addComponent(label1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(button4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(button8, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(button5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(button9, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addGap(10, 10, 10)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(button7, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(button1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - balraj
	private JButton button1;
	private JLabel label1;
	private JLabel label2;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JTextField textField1;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JLabel label3;
	private JLabel label4;
	private JTextField textField2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
