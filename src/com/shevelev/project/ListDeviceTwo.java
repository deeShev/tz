package com.shevelev.project;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.shevelev.hibernate.Device;
import com.shevelev.hibernate.DeviceDAO;

import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



@SuppressWarnings("serial")
public class ListDeviceTwo extends JInternalFrame {
	private JTextField textFieldid;
	private JTextField textFieldname;
	private JTextField textFieldnumer;
	private JTextField textFielddata;
	private JTextField textFieldresp;
	private JTextField textFieldstate;
	private JTextField textFieldnode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListDeviceTwo frame = new ListDeviceTwo();
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
	public ListDeviceTwo() {
		setTitle("\u0414\u043E\u0431\u0430\u0432\u043B\u0435\u043D\u0438\u0435 \u043F\u0440\u0438\u0431\u043E\u0440\u0430");
		setClosable(true);
		setBounds(100, 100, 397, 335);
		
		Panel panel = new Panel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0421\u0435\u0440\u0438\u0439\u043D\u044B\u0439 \u043D\u043E\u043C\u0435\u0440");
		lblNewLabel.setBounds(10, 11, 119, 14);
		panel.add(lblNewLabel);
		
		textFieldid = new JTextField();
		textFieldid.setBounds(205, 8, 134, 20);
		panel.add(textFieldid);
		textFieldid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435");
		lblNewLabel_1.setBounds(10, 39, 74, 14);
		panel.add(lblNewLabel_1);
		
		textFieldname = new JTextField();
		textFieldname.setBounds(205, 36, 134, 20);
		panel.add(textFieldname);
		textFieldname.setColumns(10);
		
		JLabel label = new JLabel("\u0418\u043D\u0432\u0435\u043D\u0442\u0430\u0440\u043D\u044B\u0439 \u043D\u043E\u043C\u0435\u0440");
		label.setBounds(10, 70, 119, 14);
		panel.add(label);
		
		textFieldnumer = new JTextField();
		textFieldnumer.setColumns(10);
		textFieldnumer.setBounds(205, 70, 134, 20);
		panel.add(textFieldnumer);
		
		JLabel label_1 = new JLabel("\u0414\u0430\u0442\u0430 \u043F\u043E\u0441\u043B\u0435\u0434\u043D\u0435\u0439 \u043F\u043E\u0432\u0435\u0440\u043A\u0438");
		label_1.setBounds(10, 104, 157, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u041E\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0435\u043D\u043D\u044B\u0439 \u0437\u0430 \u043F\u0440\u0438\u0431\u043E\u0440");
		label_2.setBounds(10, 144, 157, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u0422\u0435\u0445 \u0421\u043E\u0441\u0442\u043E\u044F\u043D\u0438\u0435");
		label_3.setBounds(10, 180, 102, 14);
		panel.add(label_3);
		
		textFielddata = new JTextField();
		textFielddata.setColumns(10);
		textFielddata.setBounds(205, 101, 134, 20);
		panel.add(textFielddata);
		
		textFieldresp = new JTextField();
		textFieldresp.setColumns(10);
		textFieldresp.setBounds(205, 141, 134, 20);
		panel.add(textFieldresp);
		
		textFieldstate = new JTextField();
		textFieldstate.setColumns(10);
		textFieldstate.setBounds(205, 177, 134, 20);
		panel.add(textFieldstate);
		
		JLabel label_4 = new JLabel("\u041F\u0440\u0438\u043C\u0435\u0447\u0430\u043D\u0438\u0435");
		label_4.setBounds(10, 211, 102, 14);
		panel.add(label_4);
		
		textFieldnode = new JTextField();
		textFieldnode.setColumns(10);
		textFieldnode.setBounds(205, 208, 134, 20);
		panel.add(textFieldnode);
		
		Button buttonSave = new Button("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C");
		buttonSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeviceDAO dd = new DeviceDAO();
				Device d = new Device();
				d.setId(textFieldid.getText());
				d.setName(textFieldname.getText());
				d.setNumer(textFieldnumer.getText());
				d.setData(textFielddata.getText());
				d.setResposible(textFieldresp.getText());
				d.setState(textFieldstate.getText());
				d.setNode(textFieldnode.getText());
				if(dd.save(d)){
					JOptionPane.showMessageDialog(null, "Прибор добавлен.");
				}
					else{
						JOptionPane.showMessageDialog(null, "Ошибка, не удалось добавить прибор!");
				}
			}
		});
		
		buttonSave.setBounds(129, 249, 70, 22);
		panel.add(buttonSave);

	}
}
