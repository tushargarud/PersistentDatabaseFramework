package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class BookRepositoryForm extends JFrame {

	private JPanel contentPane;	

	/**
	 * Create the frame.
	 */
	public BookRepositoryForm(DefaultTableModel tableModel) {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1564, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookRepository = new JLabel("Book Repository");
		lblBookRepository.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookRepository.setFont(new Font("Calibri", Font.BOLD, 33));
		lblBookRepository.setBounds(0, 29, 1558, 52);
		contentPane.add(lblBookRepository);
		
		JTable repositoryTable = new JTable(tableModel);
		repositoryTable.setFont(new Font("Calibri", Font.PLAIN,20));
		repositoryTable.setEnabled(false);
		repositoryTable.setRowHeight(25);
		repositoryTable.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(repositoryTable);
		scrollPane.setBounds(12, 106, 1534, 589);
		contentPane.add(scrollPane);
		
	}
}
