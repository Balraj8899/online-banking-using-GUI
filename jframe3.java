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

public class jframe3 extends JFrame {
	static Connection con;
	static Statement stmt;
	static ResultSet rst;
	static String query;
	int x31;
	public jframe3(Connection cmt) {
		
		con=cmt;
		initComponents();
		button10.setVisible(false);
		label3.setVisible(false);
		textField1.setText(null);
		textField1.setVisible(false);
		button9.setVisible(false);
		
		
	}

	private void button6(ActionEvent e) {
		// TODO add your code here
		setVisible(false);
		//jform2.assign2(a1);
		jframe1 j2 = new jframe1();
		j2.setVisible(true);
	}

	private void button7(ActionEvent e) throws SQLException {
		// TODO add your code here
		System.exit(0);
	}

	private void button1(ActionEvent e) {
		
        jframe4 jframe4 = new jframe4(con);
		// TODO add your code here
		jframe4.setVisible(true);
		jframe4.button3.setVisible(false);
		setVisible(false);
	}

	private void button3(ActionEvent e) throws SQLException {
		// TODO add your code here
		int c=0;
		stmt = con.createStatement();
		query = "SELECT BALANCE FROM bank WHERE ID ="+1;
		rst = stmt.executeQuery(query);
		if(rst.next())
		{
			c=rst.getInt(1);
		}
		label2.setText(String.valueOf(c));
	}

	private void button2(ActionEvent e) {
		button10.setVisible(true);
		textField1.setVisible(true);
		label3.setVisible(true);
		button9.setVisible(true);
		x31=1;
	}

	private void button9(ActionEvent e) throws SQLException {
		// TODO add your code here
		if(x31==2) {
			String s1=textField1.getText();
			
			stmt = con.createStatement();
			
			query = "DELETE  FROM bank WHERE ACNAME ='"+s1+"'";
			stmt.executeUpdate(query);
			
			  label2.setText("ACCOUNT DELETED");
		}
			else if(x31==1) {
				String s11=textField1.getText();
				
				stmt = con.createStatement();
				
				query = "SELECT * FROM bank WHERE ACNAME ='"+s11+"'";
				rst = stmt.executeQuery(query);
				if(rst.next())
				{
				  label2.setText("ID:"+rst.getInt(1)+" "+"ACNAME:"+rst.getString(2)+" "+"PASSWORD:"+rst.getString(3)+" "+"EMIL:"+rst.getString(4)+" "+"BALANCE:"+rst.getInt(5));
				}
			}
			else if(x31==4) {
				String z11=textField1.getText();
				
				jframe4 jframe4=new jframe4(con);
				jframe4.setVisible(true);
				jframe4.button2.setVisible(false);
				jframe4.textField1.setVisible(false);
				jframe4.label1.setVisible(false);
				
				setVisible(false);
				
			}
		
			textField1.setVisible(false);
			label3.setVisible(false);
			button9.setVisible(false);
			//textField1.setText(null);
			button10.setVisible(false);
		}
	

	//DELETE CLIENT
	private void button4(ActionEvent e) throws SQLException {
		// TODO add your code here
		x31=2;
		button10.setVisible(true);
		textField1.setVisible(true);
		label3.setVisible(true);
		button9.setVisible(true);	
	}

	private void button10(ActionEvent e) {
		// TODO add your code here
		
		textField1.setVisible(false);
		label3.setVisible(false);
		button9.setVisible(false);
		button10.setVisible(false);
	}

	//UPDATE CLIENT
	private void button8(ActionEvent e) {
		// TODO add your code here
		x31=4;
		button10.setVisible(true);
		textField1.setVisible(true);
		label3.setVisible(true);
		button9.setVisible(true);		
	}
//VIEW ALL CLIENT
	private void button5(ActionEvent e) throws SQLException {
		// TODO add your code here
		jframe5 jframe5=new jframe5(con);
		setVisible(false);
		jframe5.setVisible(true);
		stmt = con.createStatement();
		query = "SELECT * FROM bank";
		rst = stmt.executeQuery(query);
		while(rst.next()) {
			connectingjframes.jframe5.textField1.setText(connectingjframes.jframe5.textField1.getText()+"\n"+"ID:"+rst.getInt(1)+" "+"NAME:"+rst.getString(2)+" "+"PASSWORD:"+rst.getString(3)+" "+"EMAIL:"+rst.getString(4)+" "+"BALANCE:"+rst.getInt(5));
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  
		// Generated using JFormDesigner Evaluation license - balraj
		ResourceBundle bundle = ResourceBundle.getBundle("jframe.frame");
		label1 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		label2 = new JLabel();
		button7 = new JButton();
		button8 = new JButton();
		label3 = new JLabel();
		textField1 = new JTextField();
		button9 = new JButton();
		button10 = new JButton();

		//======== this ========
		var contentPane = getContentPane();

		//---- label1 ----
		label1.setText("BANK MAIN SERVER");
		label1.setFont(new Font("Tahoma", Font.BOLD, 16));

		//---- button1 ----
		button1.setText(bundle.getString("jframe3.button1.text"));
		button1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button1.addActionListener(e -> button1(e));

		//---- button2 ----
		button2.setText(bundle.getString("jframe3.button2.text"));
		button2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button2.addActionListener(e -> button2(e));

		//---- button3 ----
		button3.setText(bundle.getString("jframe3.button3.text"));
		button3.setFont(new Font("Tahoma", Font.BOLD, 14));
		button3.addActionListener(e -> {
			try {
				button3(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- button4 ----
		button4.setText(bundle.getString("jframe3.button4.text"));
		button4.setFont(new Font("Tahoma", Font.BOLD, 14));
		button4.addActionListener(e -> {
			try {
				button4(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- button5 ----
		button5.setText(bundle.getString("jframe3.button5.text"));
		button5.setFont(new Font("Tahoma", Font.BOLD, 14));
		button5.addActionListener(e -> {
			try {
				button5(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});

		//---- button6 ----
		button6.setText(bundle.getString("jframe3.button6.text"));
		button6.setFont(new Font("Tahoma", Font.BOLD, 14));
		button6.addActionListener(e -> button6(e));

		//---- label2 ----
		label2.setFont(new Font("Tahoma", Font.BOLD, 11));

		//---- button7 ----
		button7.setText(bundle.getString("jframe3.button7.text"));
		button7.setFont(new Font("Tahoma", Font.BOLD, 14));
		button7.addActionListener(e -> {
			try {
				button7(e);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});

		//---- button8 ----
		button8.setText(bundle.getString("jframe3.button8.text"));
		button8.setFont(new Font("Tahoma", Font.BOLD, 14));
		button8.addActionListener(e -> button8(e));

		//---- label3 ----
		label3.setText(bundle.getString("jframe3.label3.text"));
		label3.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- textField1 ----
		textField1.setFont(new Font("Tahoma", Font.BOLD, 11));

		//---- button9 ----
		button9.setText(bundle.getString("jframe3.button9.text"));
		button9.setFont(new Font("Tahoma", Font.BOLD, 12));
		button9.addActionListener(e -> {
			try {
				button9(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		//---- button10 ----
		button10.setText(bundle.getString("jframe3.button10.text"));
		button10.setFont(new Font("Tahoma", Font.BOLD, 12));
		button10.addActionListener(e -> button10(e));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(label1, GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(21, 21, 21)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(label2, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(109, Short.MAX_VALUE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(button5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button8, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(button2, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button4, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(button1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
									.addGap(40, 40, 40)
									.addComponent(button3, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(button6, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
								.addComponent(button7, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
							.addGap(26, 26, 26))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(label3, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(85, 85, 85)
									.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGap(0, 0, Short.MAX_VALUE)
									.addComponent(button9, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
							.addGap(18, 18, 18)
							.addComponent(button10, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(63, 63, 63))))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addComponent(label1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(button1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(button3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(contentPaneLayout.createParallelGroup()
							.addComponent(button2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addComponent(button4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addComponent(button6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(button5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(button8, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addComponent(button7, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(button9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(button10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(label2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - balraj
	private JLabel label1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JLabel label2;
	private JButton button7;
	private JButton button8;
	private JLabel label3;
	public static JTextField textField1;
	private JButton button9;
	private JButton button10;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
