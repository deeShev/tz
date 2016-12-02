package com.shevelev.project;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Panel;
import javax.swing.table.DefaultTableModel;

import com.shevelev.hibernate.Device;
import com.shevelev.hibernate.DeviceDAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ListDeviceOne extends JInternalFrame {
	private JTextField textFieldid1;
	private JTextField textFieldname2;
	private JTextField textFieldnumer3;
	private JTextField textFielddata4;
	private JTextField textFieldresp5;
	private JTextField textFieldstate6;
	private JTextField textFieldnode7;
	DeviceDAO dd = new DeviceDAO();
	private JTable tableDevice;
	private JTextField textFieldst;
	private JTextField textFieldnames;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListDeviceOne frame = new ListDeviceOne();
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
	private  void LoadData() {
	        DefaultTableModel dtm = new DefaultTableModel();
	        dtm.addColumn("Серийный номер");
	        dtm.addColumn("Название");
	        dtm.addColumn("Инвентарный номер");
	        dtm.addColumn("Дата последней поверки");
	        dtm.addColumn("Ответственный за прибор");
	        dtm.addColumn("Тех Состояние");
	        dtm.addColumn("Примечание");
	        for (Device d : this.dd.findAll()) {
	            dtm.addRow(new Object[]{d.getId(), d.getName(), d.getNumer(),d.getData(), d.getResposible(), d.getState(),d.getNode()});
	        }
	        this.tableDevice.setModel(dtm);
	        this.tableDevice.repaint();	
	        this.tableDevice.revalidate();
	        }
	
	public ListDeviceOne() {
		setTitle("\u041F\u0440\u043E\u0441\u043C\u043E\u0442\u0440 \u043F\u0440\u0438\u0431\u043E\u0440\u043E\u0432");
		setEnabled(false);
		setClosable(true);
		setBounds(100, 100, 748, 435);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 712, 102);
		panel.add(scrollPane);
		
		tableDevice = new JTable();
		tableDevice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = tableDevice.getValueAt(tableDevice.getSelectedRow(),0).toString();
		        Device d = dd.find(id);
		        System.out.println(id);
		        textFieldname2.setText(d.getName());
		        textFieldnumer3.setText(d.getNumer());
		        textFielddata4.setText(d.getData());
		        textFieldresp5.setText(d.getResposible());
		        textFieldstate6.setText(d.getState());
		        textFieldnode7.setText(d.getNode());
		        textFieldid1.setText(d.getId());
		        textFieldnames.setText(d.getName());
				textFieldst.setText(d.getState());
			}
		});
		tableDevice.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\u0421\u0435\u0440\u0438\u0439\u043D\u044B\u0439 \u043D\u043E\u043C\u0435\u0440", "\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435", "\u0418\u043D\u0432\u0435\u043D\u0442\u0430\u0440\u043D\u044B\u0439 \u043D\u043E\u043C\u0435\u0440", "\u0414\u0430\u0442\u0430 \u043F\u043E\u0441\u043B\u0435\u0434\u043D\u0435\u0439 \u043F\u043E\u0432\u0435\u0440\u043A\u0438", "\u041E\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0435\u043D\u043D\u044B\u0439 \u0437\u0430 \u043F\u0440\u0438\u0431\u043E\u0440", "\u0422\u0435\u0445 \u0421\u043E\u0441\u0442\u043E\u044F\u043D\u0438\u0435", "\u041F\u0440\u0438\u043C\u0435\u0447\u0430\u043D\u0438\u0435"
			}
		));
		tableDevice.getColumnModel().getColumn(0).setPreferredWidth(103);
		tableDevice.getColumnModel().getColumn(2).setPreferredWidth(112);
		tableDevice.getColumnModel().getColumn(3).setPreferredWidth(147);
		tableDevice.getColumnModel().getColumn(4).setPreferredWidth(153);
		tableDevice.getColumnModel().getColumn(5).setPreferredWidth(89);
		scrollPane.setViewportView(tableDevice);
		LoadData();
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(22, 119, 418, 284);
		panel_1.setLayout(null);
		panel.add(panel_1);
		
		JLabel label = new JLabel("\u0421\u0435\u0440\u0438\u0439\u043D\u044B\u0439 \u043D\u043E\u043C\u0435\u0440");
		label.setBounds(10, 11, 102, 14);
		panel_1.add(label);
		
		textFieldid1 = new JTextField();
		textFieldid1.setColumns(10);
		textFieldid1.setBounds(258, 8, 134, 20);
		textFieldid1.setEnabled(false);
		panel_1.add(textFieldid1);
		
		JLabel label_1 = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435");
		label_1.setBounds(10, 39, 74, 14);
		panel_1.add(label_1);
		
		textFieldname2 = new JTextField();
		textFieldname2.setColumns(10);
		textFieldname2.setBounds(258, 36, 134, 20);
		textFieldname2.setEnabled(false);
		panel_1.add(textFieldname2);
		
		JLabel label_2 = new JLabel("\u0418\u043D\u0432\u0435\u043D\u0442\u0430\u0440\u043D\u044B\u0439 \u043D\u043E\u043C\u0435\u0440");
		label_2.setBounds(10, 70, 140, 14);
		panel_1.add(label_2);
		
		textFieldnumer3 = new JTextField();
		textFieldnumer3.setColumns(10);
		textFieldnumer3.setBounds(258, 67, 134, 20);
		panel_1.add(textFieldnumer3);
		
		JLabel label_3 = new JLabel("\u0414\u0430\u0442\u0430 \u043F\u043E\u0441\u043B\u0435\u0434\u043D\u0435\u0439 \u043F\u043E\u0432\u0435\u0440\u043A\u0438");
		label_3.setBounds(10, 104, 173, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("\u041E\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0435\u043D\u043D\u044B\u0439 \u0437\u0430 \u043F\u0440\u0438\u0431\u043E\u0440");
		label_4.setBounds(10, 144, 173, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("\u0422\u0435\u0445\u043D\u0438\u0447\u0435\u0441\u043A\u043E\u0435 \u0441\u043E\u0441\u0442\u043E\u044F\u043D\u0438\u0435");
		label_5.setBounds(10, 180, 152, 14);
		panel_1.add(label_5);
		
		textFielddata4 = new JTextField();
		textFielddata4.setColumns(10);
		textFielddata4.setBounds(258, 101, 134, 20);
		panel_1.add(textFielddata4);
		
		textFieldresp5 = new JTextField();
		textFieldresp5.setColumns(10);
		textFieldresp5.setBounds(258, 141, 134, 20);
		panel_1.add(textFieldresp5);
		
		textFieldstate6 = new JTextField();
		textFieldstate6.setColumns(10);
		textFieldstate6.setBounds(258, 177, 134, 20);
		panel_1.add(textFieldstate6);
		
		JLabel label_6 = new JLabel("\u041F\u0440\u0438\u043C\u0435\u0447\u0430\u043D\u0438\u0435");
		label_6.setBounds(10, 211, 102, 14);
		panel_1.add(label_6);
		
		textFieldnode7 = new JTextField();
		textFieldnode7.setColumns(10);
		textFieldnode7.setBounds(258, 208, 134, 20);
		panel_1.add(textFieldnode7);
		
		JButton buttonReview = new JButton("\u041F\u0440\u043E\u0441\u043C\u043E\u0442\u0440");
		buttonReview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadData();
			}
		});
		buttonReview.setBounds(10, 248, 102, 22);
		panel_1.add(buttonReview);
		
		JButton buttonUpdate = new JButton("\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
		buttonUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Device d = new Device();
				d.setId(textFieldid1.getText());
				d.setName(textFieldname2.getText());
				d.setNumer(textFieldnumer3.getText());
				d.setData(textFielddata4.getText());
				d.setResposible(textFieldresp5.getText());
				d.setState(textFieldstate6.getText());
				d.setNode(textFieldnode7.getText());
		        if (dd.update(d)) {
		            JOptionPane.showMessageDialog(null, "Данные о приборе обновлены.");
		           LoadData();
		        } else {
		            JOptionPane.showMessageDialog(null, "Ошибка редактирования!");
		        }
			}
		});
		buttonUpdate.setBounds(122, 248, 134, 23);
		panel_1.add(buttonUpdate);
		
		JButton buttonDelete = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cf = JOptionPane.showConfirmDialog(null, "Вы уверены, что хотите удалить прибор?", "Удаление прибора.", JOptionPane.YES_NO_OPTION);
		        if (cf == JOptionPane.YES_OPTION) {
		            String id = tableDevice.getValueAt(tableDevice.getSelectedRow(), 0).toString();
		            System.out.println(id);
		            if (dd.delete(dd.find(id))) {
		                JOptionPane.showMessageDialog(null, "Прибор удалён.");
		                LoadData();
		            } else {
		                JOptionPane.showMessageDialog(null, "Ошибка, данные о приборе не удалось удалить!");
		            }
		        }
			}
		});
		buttonDelete.setBounds(268, 248, 89, 23);
		panel_1.add(buttonDelete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(505, 124, 185, 262);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton buttonFiltration = new JButton("\u0424\u0438\u043B\u044C\u0442\u0440\u0430\u0446\u0438\u044F");
		buttonFiltration.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				String name = textFieldnames.getText();
				String state = textFieldst.getText();
				DefaultTableModel dtm = new DefaultTableModel();
				dtm.addColumn("Серийный номер");
		        dtm.addColumn("Название");
		        dtm.addColumn("Инвентарный номер");
		        dtm.addColumn("Дата последней поверки");
		        dtm.addColumn("Ответственный за прибор");
		        dtm.addColumn("Тех Состояние");
		        dtm.addColumn("Примечание");
		        for (Device d : dd.Sample(name,state)) {
		            dtm.addRow(new Object[]{d.getId(), d.getName(), d.getNumer(),d.getData(), d.getResposible(), d.getState(),d.getNode()});
		        }
		        tableDevice.setModel(dtm);
		        }
		});
		buttonFiltration.setBounds(33, 202, 114, 23);
		panel_2.add(buttonFiltration);
		
		JLabel label_7 = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435");
		label_7.setBounds(65, 48, 74, 14);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("\u0422\u0435\u0445\u043D\u0438\u0447\u0435\u0441\u043A\u043E\u0435 \u0441\u043E\u0441\u0442\u043E\u044F\u043D\u0438\u0435");
		label_8.setBounds(33, 104, 134, 14);
		panel_2.add(label_8);
		
		textFieldst = new JTextField();
		textFieldst.setColumns(10);
		textFieldst.setBounds(23, 129, 134, 20);
		panel_2.add(textFieldst);
		
		textFieldnames = new JTextField();
		textFieldnames.setColumns(10);
		textFieldnames.setBounds(23, 73, 134, 20);
		panel_2.add(textFieldnames);

		
	}
}
