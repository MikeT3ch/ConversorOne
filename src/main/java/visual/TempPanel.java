package visual;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TempPanel extends JPanel {
	private JTextField inputTemp;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TempPanel() {
		setLayout(null);
		
		JPanel tempPane = new JPanel();
		tempPane.setBounds(0, 0, 600, 320);
		add(tempPane);
		
		JLabel lblTo = new JLabel("To:");
		
		JComboBox combBoxInputTemp = new JComboBox();
		combBoxInputTemp.setModel(new DefaultComboBoxModel(new String[] {"C°", "F°", "K°"}));
		
		inputTemp = new JTextField();
		inputTemp.setColumns(10);
		
		JComboBox combBoxOutTemp = new JComboBox();
		combBoxOutTemp.setModel(new DefaultComboBoxModel(new String[] {"F°", "K°", "C°"}));
		
		JButton btnConvertirTemp = new JButton("Convertir");
		btnConvertirTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO
			}
		});
		btnConvertirTemp.setBorderPainted(false);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		GroupLayout gl_tempPane = new GroupLayout(tempPane);
		gl_tempPane.setHorizontalGroup(
			gl_tempPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tempPane.createSequentialGroup()
					.addGap(184)
					.addGroup(gl_tempPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tempPane.createSequentialGroup()
							.addComponent(combBoxInputTemp, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(inputTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tempPane.createSequentialGroup()
							.addGap(55)
							.addComponent(lblTo))
						.addGroup(gl_tempPane.createSequentialGroup()
							.addComponent(combBoxOutTemp, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tempPane.createSequentialGroup()
							.addGap(108)
							.addComponent(btnConvertirTemp, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(186, Short.MAX_VALUE))
		);
		gl_tempPane.setVerticalGroup(
			gl_tempPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tempPane.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_tempPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tempPane.createSequentialGroup()
							.addGap(1)
							.addComponent(combBoxInputTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(inputTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblTo)
					.addGap(18)
					.addGroup(gl_tempPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tempPane.createSequentialGroup()
							.addGap(1)
							.addComponent(combBoxOutTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnConvertirTemp)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		tempPane.setLayout(gl_tempPane);

	}
}
