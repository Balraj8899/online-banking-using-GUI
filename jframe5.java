/*
 * Created by JFormDesigner on Tue Feb 01 11:48:49 IST 2022
 */

package connectingjframes;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author balraj
 */

public class jframe5 extends JFrame {
	private static final Connection Connection = null;
	static Connection con;
	public jframe5(Connection cmt) {
		con=cmt;
		initComponents();
	}
	


	private void button1(ActionEvent e) {
		// TODO add your code here
		textField1.setText(null);
		setVisible(false);
		jframe3 jframe3 = new jframe3(con);
		jframe3.setVisible(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIF
		// Generated using JFormDesigner Evaluation license - balraj
		ResourceBundle bundle = ResourceBundle.getBundle("jframe.frame");
		button1 = new JButton();
		textField1 = new JTextField();

		//======== this ========
		var contentPane = getContentPane();

		//---- button1 ----
		button1.setText(bundle.getString("jframe5.button1.text"));
		button1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button1.addActionListener(e -> {
			button1(e);
			button1(e);
		});

		//---- textField1 ----
		textField1.addActionListener(e -> textField1(e));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(894, Short.MAX_VALUE)
					.addComponent(button1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18))
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(button1)
					.addGap(19, 19, 19))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	private Object textField1(ActionEvent e) {
		// TODO Auto-generated method stub
		return null;
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - balraj
	private JButton button1;
	public static JTextField textField1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
