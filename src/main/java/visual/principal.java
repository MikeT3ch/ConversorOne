package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Look and Feel, Flatlaf
		FlatLightLaf.setup();
		FlatMaterialLighterIJTheme.setup();
		// Square corners
		UIManager.put( "Button.arc", 0 );
		UIManager.put( "Component.arc", 0 );
		UIManager.put( "CheckBox.arc", 0 );
		UIManager.put( "ProgressBar.arc", 0 );
		// End look and feel.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public principal() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 221, 218));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel content = new JPanel();
		content.setBackground(new Color(255, 255, 255));
		content.setBounds(0, 0, 700, 350);
		contentPane.add(content);
		content.setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(0, 0, 700, 30);
		content.add(panelTitle);
		SpringLayout sl_panelTitle = new SpringLayout();
		panelTitle.setLayout(sl_panelTitle);
		
		JButton btnExit = new JButton("X");
		btnExit.setBorder(null);
		sl_panelTitle.putConstraint(SpringLayout.NORTH, btnExit, 0, SpringLayout.NORTH, panelTitle);
		sl_panelTitle.putConstraint(SpringLayout.WEST, btnExit, -41, SpringLayout.EAST, panelTitle);
		sl_panelTitle.putConstraint(SpringLayout.EAST, btnExit, 0, SpringLayout.EAST, panelTitle);
		btnExit.setPreferredSize(new Dimension(35, 30));
		panelTitle.add(btnExit);
		
		JLabel lblTitle = new JLabel("Conversor de unidades");
		sl_panelTitle.putConstraint(SpringLayout.NORTH, lblTitle, 7, SpringLayout.NORTH, btnExit);
		sl_panelTitle.putConstraint(SpringLayout.WEST, lblTitle, 10, SpringLayout.WEST, panelTitle);
		sl_panelTitle.putConstraint(SpringLayout.EAST, lblTitle, 224, SpringLayout.WEST, panelTitle);
		panelTitle.add(lblTitle);
		
		JPanel panelSide = new JPanel();
		panelSide.setBackground(new Color(198, 219, 167));
		panelSide.setBounds(0, 30, 100, 320);
		content.add(panelSide);
		panelSide.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnDivisas = new JButton("Divisas");
		btnDivisas.setBackground(new Color(193, 225, 145));
		btnDivisas.setForeground(new Color(0, 0, 0));
		panelSide.add(btnDivisas);
		
		JButton btnTemperatura = new JButton("Temp");
		btnTemperatura.setBackground(new Color(193, 225, 145));
		btnTemperatura.setForeground(new Color(0, 0, 0));
		panelSide.add(btnTemperatura);
		
		JButton btnDistancia = new JButton("Distancia");
		btnDistancia.setForeground(new Color(0, 0, 0));
		panelSide.add(btnDistancia);
		
		JButton btnMore = new JButton("Mas");
		btnMore.setForeground(new Color(0, 0, 0));
		panelSide.add(btnMore);
		
		JPanel viewsPanel = new JPanel();
		viewsPanel.setBackground(new Color(198, 219, 167));
		viewsPanel.setBounds(100, 30, 600, 320);
		content.add(viewsPanel);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
}
