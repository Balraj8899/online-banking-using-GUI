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


public class jframe4 extends JFrame {
	static Connection con;
	static Statement stmt;
	static ResultSet rst;
	static String query;
	public jframe4(Connection cmt) {
		con=cmt;
		initComponents();
	}

	private void button1(ActionEvent e) {
		setVisible(false);
		jframe3 jframe3 = new jframe3(con);
		// TODO add your code here
		jframe3.setVisible(true);
		label4.setText(null);
	}

	private void button2(ActionEvent e) throws SQLException, ClassNotFoundException {
		// TODO add your code here
		int b = 500;
		stmt = con.createStatement();
		query = "INSERT INTO bank(ACNAME,EMAIL,PASSWORD,BALANCE) Values('"+textField1.getText()+"','"+textField2.getText()+"','"+textField3.getText()+"',"+b+")";
		stmt.executeUpdate(query);
		label5.setText("Account created as "+textField1.getText());
		
	}
	//UPDATE
	private void button3(ActionEvent e) throws SQLException {
		// TODO add your code here
		String bb=jframe3.textField1.getText();
		String bb1,bb2,bb3;
		
		bb2=textField2.getText();
		bb3=textField3.getText();
		stmt = con.createStatement();
		query = "UPDATE bank SET EMAIL= '"+bb2+"',PASSWORD='"+bb3+"' WHERE ACNAME='"+bb+"'";
		stmt.executeUpdate(query);
		label5.setText("ACCOUNT UPDATED  "+bb);
	

	}



	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  
		// Generated using JFormDesigner Evaluation license - balraj
		ResourceBundle bundle = ResourceBundle.getBundle("jframe.frame");
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		button1 = new JButton();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		button2 = new JButton();
		button3 = new JButton();

		//======== this ========
		var contentPane = getContentPane();

		//---- label1 ----
		label1.setText(bundle.getString("jframe4.label1.text"));
		label1.setFont(new Font("Tahoma", Font.BOLD, 16));

		//---- label2 ----
		label2.setText(bundle.getString("jframe4.label2.text"));
		label2.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- label3 ----
		label3.setText(bundle.getString("jframe4.label3.text"));
		label3.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- label4 ----
		label4.setText(bundle.getString("jframe4.label4.text"));
		label4.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- label5 ----
		label5.setFont(new Font("Tahoma", Font.BOLD, 11));

		//---- button1 ----
		button1.setText(bundle.getString("jframe4.button1.text"));
		button1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button1.addActionListener(e -> {
			button1(e);
			button1(e);
		});

		//---- textField1 ----
		textField1.setFont(new Font("Tahoma", Font.BOLD, 11));

		//---- textField2 ----
		textField2.setFont(new Font("Tahoma", Font.BOLD, 11));

		//---- textField3 ----
		textField3.setFont(new Font("Tahoma", Font.BOLD, 11));

		//---- button2 ----
		button2.setText(bundle.getString("jframe4.button2.text"));
		button2.setFont(new Font("Tahoma", Font.BOLD, 14));
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
		});

		//---- button3 ----
		button3.setText(bundle.getString("jframe4.button3.text"));
		button3.setFont(new Font("Tahoma", Font.BOLD, 14));
		button3.addActionListener(e -> {
			try {
				button3(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
							.addGap(46, 46, 46)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(53, 53, 53))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(label3, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(label2, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
									.addGap(39, 39, 39)
									.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
								.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
									.addComponent(label4, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
											.addComponent(button3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(button2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
										.addComponent(textField3, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addComponent(label1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(label2, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(button2, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addComponent(button3, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(button1, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addComponent(label5, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(24, 24, 24))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization 
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  
	// Generated using JFormDesigner Evaluation license - balraj
	public JLabel label1;
	public JLabel label2;
	public JLabel label3;
	public JLabel label4;
	public JLabel label5;
	public JButton button1;
	public JTextField textField1;
	public JTextField textField2;
	public JTextField textField3;
	public static JButton button2;
	public static JButton button3;
	// JFormDesigner - End of variables declaration  
}
