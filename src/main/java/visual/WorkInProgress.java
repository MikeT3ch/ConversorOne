package visual;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class WorkInProgress extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public WorkInProgress() {
		
		setLayout(null);
		
		JPanel wipPanel = new JPanel();
		wipPanel.setBounds(0, 0, 600, 320);
		add(wipPanel);
		
		JLabel lblWorkInProgress = new JLabel("WORK IN PROGRESS");
		GroupLayout gl_wipPanel = new GroupLayout(wipPanel);
		gl_wipPanel.setHorizontalGroup(
			gl_wipPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_wipPanel.createSequentialGroup()
					.addGap(241)
					.addComponent(lblWorkInProgress)
					.addContainerGap(241, Short.MAX_VALUE))
		);
		gl_wipPanel.setVerticalGroup(
			gl_wipPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_wipPanel.createSequentialGroup()
					.addGap(152)
					.addComponent(lblWorkInProgress)
					.addContainerGap(151, Short.MAX_VALUE))
		);
		wipPanel.setLayout(gl_wipPanel);

	}
}
