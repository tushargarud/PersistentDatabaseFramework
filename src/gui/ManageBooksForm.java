package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessObjects.Book;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ManageBooksForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookId;
	private JTextField txtBookName;
	private JTextField txtAuthor;
	private JTextField txtPublisher;
	private JTextField txtIsbn;
	private JTextField txtNumberOfPages;

	/**
	 * Create the frame.
	 */
	public ManageBooksForm(Book book) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book Id :");
		lblBookId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBookId.setFont(new Font("Calibri", Font.BOLD, 24));
		lblBookId.setBounds(139, 129, 220, 59);
		contentPane.add(lblBookId);
		
		JLabel lblBookName = new JLabel("Book Name :");
		lblBookName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBookName.setFont(new Font("Calibri", Font.BOLD, 24));
		lblBookName.setBounds(139, 201, 220, 59);
		contentPane.add(lblBookName);
		
		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAuthor.setFont(new Font("Calibri", Font.BOLD, 24));
		lblAuthor.setBounds(139, 273, 220, 59);
		contentPane.add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher :");
		lblPublisher.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPublisher.setFont(new Font("Calibri", Font.BOLD, 24));
		lblPublisher.setBounds(139, 345, 220, 59);
		contentPane.add(lblPublisher);
		
		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setFont(new Font("Calibri", Font.BOLD, 24));
		lblIsbn.setBounds(139, 417, 220, 59);
		contentPane.add(lblIsbn);
		
		JLabel lblNumberOfPages = new JLabel("Number of pages :");
		lblNumberOfPages.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfPages.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNumberOfPages.setBounds(139, 489, 220, 59);
		contentPane.add(lblNumberOfPages);
		
		JLabel lblBookInformation = new JLabel("Book Information");
		lblBookInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookInformation.setFont(new Font("Calibri", Font.BOLD, 33));
		lblBookInformation.setBounds(0, 29, 877, 70);
		contentPane.add(lblBookInformation);
		
		txtBookId = new JTextField();
		txtBookId.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtBookId.setBounds(371, 142, 297, 35);
		contentPane.add(txtBookId);
		txtBookId.setColumns(10);
		
		txtBookName = new JTextField();
		txtBookName.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtBookName.setColumns(10);
		txtBookName.setBounds(371, 214, 297, 35);
		contentPane.add(txtBookName);
		
		txtAuthor = new JTextField();
		txtAuthor.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtAuthor.setColumns(10);
		txtAuthor.setBounds(371, 286, 297, 35);
		contentPane.add(txtAuthor);
		
		txtPublisher = new JTextField();
		txtPublisher.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtPublisher.setColumns(10);
		txtPublisher.setBounds(371, 358, 297, 35);
		contentPane.add(txtPublisher);
		
		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(371, 430, 297, 35);
		contentPane.add(txtIsbn);
		
		txtNumberOfPages = new JTextField();
		txtNumberOfPages.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtNumberOfPages.setColumns(10);
		txtNumberOfPages.setBounds(371, 502, 297, 35);
		contentPane.add(txtNumberOfPages);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnSave.setBounds(139, 604, 134, 39);
		contentPane.add(btnSave);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnSearch.setBounds(299, 604, 134, 39);
		contentPane.add(btnSearch);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnClear.setBounds(459, 604, 134, 39);
		contentPane.add(btnClear);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnDelete.setBounds(622, 604, 134, 39);
		contentPane.add(btnDelete);
		
		txtBookId.setText(Integer.toString(book.getBookId()));
		txtBookName.setText(book.getBookName());
		txtAuthor.setText(book.getAuthor());
		txtPublisher.setText(book.getPublisher());
		txtIsbn.setText(book.getIsbn());
		txtNumberOfPages.setText(Integer.toString(book.getNoOfPages()));
		
	}
}
