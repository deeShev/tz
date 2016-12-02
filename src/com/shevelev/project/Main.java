package com.shevelev.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0423\u0447\u0435\u0442 \u043C\u0435\u0442\u0440\u043E\u043B\u043E\u0433\u0438\u0447\u0435\u0441\u043A\u043E\u0433\u043E \u043E\u0431\u043E\u0440\u0443\u0434\u043E\u0432\u0430\u043D\u0438\u044F");
		frame.setBounds(100, 100, 828, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton button = new JButton("\u041F\u0440\u043E\u0441\u043C\u043E\u0442\u0440/\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435/\u0423\u0434\u0430\u043B\u0435\u043D\u0438\u0435");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListDeviceOne f = new ListDeviceOne();
				f.setVisible(true);
				desktopPane.add(f);
			}
		});
		button.setBounds(92, 29, 257, 38);
		desktopPane.add(button);
		
		JButton button_1 = new JButton("\u0414\u043E\u0431\u0430\u0432\u043B\u0435\u043D\u0438\u0435");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListDeviceTwo f = new ListDeviceTwo();
				f.setVisible(true);
				desktopPane.add(f);
			}
		});
		button_1.setBounds(464, 29, 257, 38);
		desktopPane.add(button_1);
	}
}
