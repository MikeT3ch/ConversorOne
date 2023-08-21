package visual;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MoneyPanel extends JPanel {
	private JTextField txtInputMoney;
	private JTextField textOutMoney;

	/**
	 * Create the panel.
	 */
	public MoneyPanel() {
		setLayout(null);
		
		JPanel moneyPane = new JPanel();
		moneyPane.setBounds(new Rectangle(0, 0, 600, 320));
		add(moneyPane);
		
		JButton btnConvertirMoney = new JButton("Convertir");
		btnConvertirMoney.setBorderPainted(false);
		
		JLabel lblTest = new JLabel("To:");
		
		txtInputMoney = new JTextField();
		txtInputMoney.setColumns(10);
		
		textOutMoney = new JTextField();
		textOutMoney.setText("0");
		textOutMoney.setEditable(false);
		textOutMoney.setColumns(10);
		
		JComboBox combBoxInputMoney = new JComboBox();
		combBoxInputMoney.setModel(new DefaultComboBoxModel(new String[] {"COP", "USD", "EUR", "CHIL", "ARG"}));
		
		JComboBox combBoxOutMoney = new JComboBox();
		combBoxOutMoney.setModel(new DefaultComboBoxModel(new String[] {"USD", "EUR", "CHIL", "ARG"}));
		GroupLayout gl_moneyPane = new GroupLayout(moneyPane);
		gl_moneyPane.setHorizontalGroup(
			gl_moneyPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_moneyPane.createSequentialGroup()
					.addGap(131)
					.addComponent(combBoxInputMoney, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtInputMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_moneyPane.createSequentialGroup()
					.addGap(186)
					.addComponent(lblTest, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_moneyPane.createSequentialGroup()
					.addGap(131)
					.addComponent(combBoxOutMoney, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textOutMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_moneyPane.createSequentialGroup()
					.addGap(239)
					.addComponent(btnConvertirMoney, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
		);
		gl_moneyPane.setVerticalGroup(
			gl_moneyPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_moneyPane.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_moneyPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_moneyPane.createSequentialGroup()
							.addGap(1)
							.addComponent(combBoxInputMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtInputMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblTest)
					.addGap(18)
					.addGroup(gl_moneyPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_moneyPane.createSequentialGroup()
							.addGap(1)
							.addComponent(combBoxOutMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textOutMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnConvertirMoney, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
		);
		moneyPane.setLayout(gl_moneyPane);

	}
}
