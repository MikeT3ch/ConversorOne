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

import logic.CurrencyConverter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Choice;
import javax.swing.JCheckBox;

public class MoneyPanel extends JPanel {
	private JTextField txtInputMoney;
	private JTextField textOutMoney;

	/**
	 * Create the panel.
	 */
	public MoneyPanel() {
		setLayout(null);
		
		JLabel lblTest = new JLabel("To:");
		
		txtInputMoney = new JTextField();
		txtInputMoney.setColumns(10);
		
		textOutMoney = new JTextField();
		textOutMoney.setText("0");
		textOutMoney.setEditable(false);
		textOutMoney.setColumns(10);
		
		final JComboBox combBoxInputMoney = new JComboBox();
		combBoxInputMoney.setModel(new DefaultComboBoxModel(new String[] {"COP", "USD", "EUR", "CHIL", "ARG"}));
		
		final JComboBox combBoxOutMoney = new JComboBox();
		combBoxOutMoney.setModel(new DefaultComboBoxModel(new String[] {"USD", "EUR", "CHIL", "ARG", "COP"}));
		
		JPanel moneyPane = new JPanel();
		moneyPane.setBounds(new Rectangle(0, 0, 600, 320));
		add(moneyPane);
		
		final JCheckBox chckbxUsarModoOffline = new JCheckBox("Usar modo offline");
		
		JButton btnConvertirMoney = new JButton("Convertir");
		btnConvertirMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String from = String.valueOf(combBoxInputMoney.getSelectedItem());
				String to = String.valueOf(combBoxOutMoney.getSelectedItem());
				double amount = Double.parseDouble(txtInputMoney.getText());
				Boolean offline = chckbxUsarModoOffline.isSelected();
				
				CurrencyConverter converter = new CurrencyConverter();
				double answer = converter.doConvertion(from, to, amount, offline);
				textOutMoney.setText(String.format("%.2f" ,answer));
			}
		});
		btnConvertirMoney.setBorderPainted(false);
		
		
		
		GroupLayout gl_moneyPane = new GroupLayout(moneyPane);
		gl_moneyPane.setHorizontalGroup(
			gl_moneyPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_moneyPane.createSequentialGroup()
					.addGap(149)
					.addGroup(gl_moneyPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_moneyPane.createSequentialGroup()
							.addComponent(combBoxOutMoney, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textOutMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_moneyPane.createSequentialGroup()
							.addComponent(combBoxInputMoney, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtInputMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_moneyPane.createSequentialGroup()
							.addGap(55)
							.addComponent(lblTest, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
							.addComponent(chckbxUsarModoOffline)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_moneyPane.createSequentialGroup()
					.addContainerGap(268, Short.MAX_VALUE)
					.addComponent(btnConvertirMoney, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(210))
		);
		gl_moneyPane.setVerticalGroup(
			gl_moneyPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_moneyPane.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_moneyPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_moneyPane.createSequentialGroup()
							.addGap(1)
							.addComponent(combBoxInputMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtInputMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_moneyPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTest)
						.addComponent(chckbxUsarModoOffline))
					.addGap(30)
					.addGroup(gl_moneyPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_moneyPane.createSequentialGroup()
							.addGap(1)
							.addComponent(combBoxOutMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textOutMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(btnConvertirMoney, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		moneyPane.setLayout(gl_moneyPane);

	}
}
