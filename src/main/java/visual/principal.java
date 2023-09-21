package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.SwingPropertyChangeSupport;

import org.w3c.dom.events.EventTarget;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.ViewportLayout;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;

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
	JPanel viewsPanel = new JPanel();
	int xMouse, yMouse;
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
		
		
		viewsPanel.setBounds(100, 30, 600, 320);
		contentPane.add(viewsPanel);
		viewsPanel.setBackground(new Color(222, 221, 218));
		
		MoneyPanel view = new MoneyPanel();
		view.setBounds(0, 0, 600, 320);		
		
		viewsPanel.removeAll();
		viewsPanel.setLayout(null);
		viewsPanel.add(view);
		viewsPanel.revalidate();
		viewsPanel.repaint();
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(0, 0, 700, 30);
		contentPane.add(panelTitle);
		panelTitle.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});
		panelTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		SpringLayout sl_panelTitle = new SpringLayout();
		panelTitle.setLayout(sl_panelTitle);
		
		JButton btnExit = new JButton("X");
		btnExit.setFont(new Font("Dialog", Font.BOLD, 14));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(252, 72, 79));
		btnExit.setBorder(null);
		sl_panelTitle.putConstraint(SpringLayout.NORTH, btnExit, 0, SpringLayout.NORTH, panelTitle);
		sl_panelTitle.putConstraint(SpringLayout.WEST, btnExit, -41, SpringLayout.EAST, panelTitle);
		sl_panelTitle.putConstraint(SpringLayout.EAST, btnExit, 0, SpringLayout.EAST, panelTitle);
		btnExit.setPreferredSize(new Dimension(35, 30));
		panelTitle.add(btnExit);
		
		JLabel lblTitle = new JLabel("Conversor de unidades");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 14));
		sl_panelTitle.putConstraint(SpringLayout.NORTH, lblTitle, 7, SpringLayout.NORTH, btnExit);
		sl_panelTitle.putConstraint(SpringLayout.WEST, lblTitle, 10, SpringLayout.WEST, panelTitle);
		sl_panelTitle.putConstraint(SpringLayout.EAST, lblTitle, 224, SpringLayout.WEST, panelTitle);
		panelTitle.add(lblTitle);
		
		JPanel panelSide = new JPanel();
		panelSide.setBounds(0, 30, 100, 320);
		contentPane.add(panelSide);
		panelSide.setBackground(new Color(198, 219, 167));
		panelSide.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnDivisas = new JButton("Divisas");
		btnDivisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MoneyPanel moneyPanel = new MoneyPanel();
				switchView(moneyPanel);
			}
		});
		btnDivisas.setBorderPainted(false);
		btnDivisas.setBackground(new Color(193, 225, 145));
		btnDivisas.setForeground(new Color(0, 0, 0));
		panelSide.add(btnDivisas);
		
		JButton btnTemperatura = new JButton("Temp");
		btnTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TempPanel tempPanel = new TempPanel();
				switchView(tempPanel);
			}
		});
		btnTemperatura.setBorderPainted(false);
		btnTemperatura.setBackground(new Color(193, 225, 145));
		btnTemperatura.setForeground(new Color(0, 0, 0));
		panelSide.add(btnTemperatura);
		
		JButton btnDistancia = new JButton("Distancia");
		btnDistancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WorkInProgress wipPanel = new WorkInProgress();
				switchView(wipPanel);
			}
		});
		btnDistancia.setBackground(new Color(193, 225, 145));
		btnDistancia.setBorderPainted(false);
		btnDistancia.setForeground(new Color(0, 0, 0));
		panelSide.add(btnDistancia);
		
		JButton btnMore = new JButton("Mas");
		btnMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WorkInProgress view = new WorkInProgress();
				view.setBounds(0, 0, 600, 320);
				
				viewsPanel.removeAll();
				viewsPanel.setLayout(null);
				viewsPanel.add(view);
				viewsPanel.revalidate();
				viewsPanel.repaint();
			}
		});
		btnMore.setBackground(new Color(193, 225, 145));
		btnMore.setBorderPainted(false);
		btnMore.setForeground(new Color(0, 0, 0));
		panelSide.add(btnMore);
		
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	
	public void switchView(JPanel view) {
		try {
			view.setBounds(0, 0, 600, 320);
			
			viewsPanel.removeAll();
			viewsPanel.setLayout(null);
			viewsPanel.add(view);
			viewsPanel.revalidate();
			viewsPanel.repaint();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
