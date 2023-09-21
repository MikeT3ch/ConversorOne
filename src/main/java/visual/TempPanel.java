package visual;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import logic.TempConverter2;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TempPanel extends JPanel {
	private JTextField inputTemp;
	private JTextField outputTemp;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TempPanel() {
		setLayout(null);
		
		JPanel tempPane = new JPanel();
		tempPane.setBounds(0, 0, 600, 320);
		add(tempPane);
		
		JLabel lblTo = new JLabel("To:");
		
		inputTemp = new JTextField();
		inputTemp.setColumns(10);
		
		outputTemp = new JTextField();
		outputTemp.setText("0");
		outputTemp.setEditable(false);
		outputTemp.setColumns(10);
		
		final JComboBox combBoxInputTemp = new JComboBox();
		combBoxInputTemp.setModel(new DefaultComboBoxModel(new String[] {"C°", "F°", "K°"}));
		
		final JComboBox combBoxOutTemp = new JComboBox();
		combBoxOutTemp.setModel(new DefaultComboBoxModel(new String[] {"F°", "K°", "C°"}));
		
		JButton btnConvertirTemp = new JButton("Convertir");
		btnConvertirTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String unit = combBoxInputTemp.getSelectedItem() + "to" + combBoxOutTemp.getSelectedItem();
				double temp = Double.parseDouble(inputTemp.getText());
				
				TempConverter2 converter = new TempConverter2();
				double answer = converter.doTempConvert(temp, unit);
				outputTemp.setText(String.valueOf(String.format("%.2f", answer)));
			}
		});
		btnConvertirTemp.setBorderPainted(false);
		
		
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
							.addComponent(outputTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(outputTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnConvertirTemp)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		tempPane.setLayout(gl_tempPane);

	}
}
