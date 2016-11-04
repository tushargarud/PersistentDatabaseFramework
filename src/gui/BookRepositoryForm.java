package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class BookRepositoryForm extends JFrame {

	private JPanel contentPane;
	private JTable repositoryTable;

	/**
	 * Create the frame.
	 */
	public BookRepositoryForm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookRepository = new JLabel("Book Repository");
		lblBookRepository.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookRepository.setFont(new Font("Calibri", Font.BOLD, 33));
		lblBookRepository.setBounds(0, 29, 958, 52);
		contentPane.add(lblBookRepository);
		
		repositoryTable = new JTable();
		repositoryTable.setBounds(12, 106, 934, 589);
		contentPane.add(repositoryTable);
		
		
	}
}
