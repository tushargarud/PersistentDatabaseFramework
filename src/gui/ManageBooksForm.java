package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import application.Constants;
import components.ExecutedStack;
import components.UndoneStack;
import controllers.DeleteController;
import controllers.SaveController;
import controllers.SearchController;
import controllers.UndoRedoController;
import logger.ErrorLogger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ManageBooksForm extends JFrame {

	private JPanel contentPane;
	JComboBox<String> cbBookType;
	private JTextField txtBookId;
	private JTextField txtBookName;
	private JTextField txtAuthor;
	private JTextField txtPublisher;
	private JTextField txtIsbn;
	private JTextField txtNumberOfPages;
	private JTextField txtField1;
	
	private SaveController saveController;
	private SearchController searchController;
	private DeleteController deleteController;
	private UndoRedoController undoRedoController;

	/**
	 * Create the frame.
	 */
	public ManageBooksForm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 895);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBookType = new JLabel("Book Type :");
		lblBookType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBookType.setFont(new Font("Calibri", Font.BOLD, 24));
		lblBookType.setBounds(139, 112, 220, 59);
		contentPane.add(lblBookType);

		JLabel lblBookId = new JLabel("Book Id :");
		lblBookId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBookId.setFont(new Font("Calibri", Font.BOLD, 24));
		lblBookId.setBounds(139, 184, 220, 59);
		contentPane.add(lblBookId);

		JLabel lblBookName = new JLabel("Book Name :");
		lblBookName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBookName.setFont(new Font("Calibri", Font.BOLD, 24));
		lblBookName.setBounds(139, 256, 220, 59);
		contentPane.add(lblBookName);

		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAuthor.setFont(new Font("Calibri", Font.BOLD, 24));
		lblAuthor.setBounds(139, 328, 220, 59);
		contentPane.add(lblAuthor);

		JLabel lblPublisher = new JLabel("Publisher :");
		lblPublisher.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPublisher.setFont(new Font("Calibri", Font.BOLD, 24));
		lblPublisher.setBounds(139, 400, 220, 59);
		contentPane.add(lblPublisher);

		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setFont(new Font("Calibri", Font.BOLD, 24));
		lblIsbn.setBounds(139, 472, 220, 59);
		contentPane.add(lblIsbn);

		JLabel lblNumberOfPages = new JLabel("Number of pages :");
		lblNumberOfPages.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfPages.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNumberOfPages.setBounds(139, 544, 220, 59);
		contentPane.add(lblNumberOfPages);

		JLabel lblBookInformation = new JLabel("Book Information");
		lblBookInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookInformation.setFont(new Font("Calibri", Font.BOLD, 33));
		lblBookInformation.setBounds(0, 29, 877, 70);
		contentPane.add(lblBookInformation);		

		JLabel label1 = new JLabel("Number of copies :");
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		label1.setFont(new Font("Calibri", Font.BOLD, 24));
		label1.setBounds(139, 615, 220, 59);
		contentPane.add(label1);

		cbBookType = new JComboBox<String>();
		cbBookType.setFont(new Font("Calibri", Font.PLAIN, 24));
		cbBookType.setBounds(371, 123, 297, 35);
		contentPane.add(cbBookType);

		txtBookId = new JTextField();
		txtBookId.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtBookId.setBounds(371, 197, 297, 35);
		contentPane.add(txtBookId);
		txtBookId.setColumns(10);

		txtBookName = new JTextField();
		txtBookName.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtBookName.setColumns(10);
		txtBookName.setBounds(371, 269, 297, 35);
		contentPane.add(txtBookName);

		txtAuthor = new JTextField();
		txtAuthor.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtAuthor.setColumns(10);
		txtAuthor.setBounds(371, 341, 297, 35);
		contentPane.add(txtAuthor);

		txtPublisher = new JTextField();
		txtPublisher.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtPublisher.setColumns(10);
		txtPublisher.setBounds(371, 413, 297, 35);
		contentPane.add(txtPublisher);

		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(371, 485, 297, 35);
		contentPane.add(txtIsbn);

		txtNumberOfPages = new JTextField();
		txtNumberOfPages.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtNumberOfPages.setColumns(10);
		txtNumberOfPages.setBounds(371, 557, 297, 35);
		contentPane.add(txtNumberOfPages);		

		txtField1 = new JTextField();
		txtField1.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtField1.setColumns(10);
		txtField1.setBounds(371, 628, 297, 35);
		contentPane.add(txtField1);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnSave.setBounds(139, 721, 134, 39);
		contentPane.add(btnSave);

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnSearch.setBounds(299, 721, 134, 39);
		contentPane.add(btnSearch);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnClear.setBounds(459, 721, 134, 39);
		contentPane.add(btnClear);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnDelete.setBounds(622, 721, 134, 39);
		contentPane.add(btnDelete);		

		JButton btnRedo = new JButton("Redo");
		btnRedo.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnRedo.setBounds(622, 788, 134, 39);
		contentPane.add(btnRedo);

		JButton btnUndo = new JButton("Undo");
		btnUndo.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnUndo.setBounds(139, 788, 134, 39);
		contentPane.add(btnUndo);

		JButton btnShowAll = new JButton("Show All Books");
		btnShowAll.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnShowAll.setBounds(299, 788, 294, 39);
		contentPane.add(btnShowAll);
		
		ErrorLogger.initialize();		
		ExecutedStack.initialize();
		UndoneStack.initialize();
		
		saveController = new SaveController();
		searchController = new SearchController();
		deleteController = new DeleteController();
		undoRedoController = new UndoRedoController();

		for(String bookType : Constants.BOOKTYPES)
			cbBookType.addItem(bookType);

		clearFormFields();

		cbBookType.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg)
			{
				if(cbBookType.getSelectedItem().equals(Constants.PRINTBOOK))
					label1.setText("Number of copies :");
				else
					label1.setText("Url :");
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				if(validateForm())
				{
					saveController.saveBook((String)cbBookType.getSelectedItem(), txtBookId.getText(), txtBookName.getText(),txtAuthor.getText(),
							txtPublisher.getText(),txtIsbn.getText(),txtNumberOfPages.getText(),txtField1.getText());
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				if(validateBookId())
				{
					deleteController.deleteBook((String)cbBookType.getSelectedItem(), Integer.parseInt(txtBookId.getText()));
					clearFormFields();
				}
			}
		});
 
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				//	ArrayList<String> strArr = searchController.searchBook((String)cbBookType.getSelectedItem(), Integer.parseInt(txtBookId.getText()));
					
					ArrayList<String> strArr = searchController.searchBook((String)cbBookType.getSelectedItem(), txtBookId.getText(), txtBookName.getText(),txtAuthor.getText(),
							txtPublisher.getText(),txtIsbn.getText(),txtNumberOfPages.getText(),txtField1.getText());					
					
					if(strArr.size()!=0)
					{
						txtBookId.setText(strArr.get(0)); 
						txtBookName.setText(strArr.get(1));
						txtAuthor.setText(strArr.get(2));
						txtPublisher.setText(strArr.get(3));
						txtIsbn.setText(strArr.get(4));
						txtNumberOfPages.setText(strArr.get(5));
						txtField1.setText(strArr.get(6));
					}
					else
					{
						clearFormFields();
					}					
			}
		});		

		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				DefaultTableModel tableModel = searchController.getAllBooks((String)cbBookType.getSelectedItem());
				BookRepositoryForm repository = new BookRepositoryForm(tableModel);				
				Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
				repository.setLocation((screenDimension.width-repository.getWidth())/2, (screenDimension.height-repository.getHeight())/2);		        
				repository.setVisible(true);
			}
		});	

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				clearFormFields();
			}
		});

		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				undoRedoController.undo();
			}
		});	

		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				undoRedoController.redo();
			}
		});	

	}

	public static void main(String[] args)
	{
		ManageBooksForm manageBooksForm  = new ManageBooksForm(); 
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        manageBooksForm.setLocation((screenDimension.width-manageBooksForm.getWidth())/2, (screenDimension.height-manageBooksForm.getHeight())/2);
		manageBooksForm.setVisible(true);		
	}
	
	private void clearFormFields() {

		txtBookId.setText("");
		txtBookName.setText("");
		txtAuthor.setText("");
		txtPublisher.setText("");
		txtIsbn.setText("");
		txtNumberOfPages.setText("");
		txtField1.setText("");

	}

	public boolean validateForm()
	{
		String msg="";

		try
		{
			if(Integer.parseInt(txtBookId.getText())<=0)
			{
				msg = msg + "\nBook id should be greater than 0";
			}			
		}
		catch(NumberFormatException ex)
		{
			msg = msg + "\nBook id should be a number";
		}

		if(txtBookName.getText().equals(""))
			msg = msg + "\nBook name should not be blank";

		if(txtAuthor.getText().equals(""))
			msg = msg + "\nAuthor should not be blank";

		if(txtPublisher.getText().equals(""))
			msg = msg + "\nPublisher should not be blank";

		if(txtIsbn.getText().equals(""))
			msg = msg + "\nISBN should not be blank";		

		try
		{
			if(Integer.parseInt(txtNumberOfPages.getText())<=0)
			{
				msg = msg + "\nNumber of pages should be greater than 0";
			}			
		}
		catch(NumberFormatException ex)
		{
			msg = msg + "\nNumber of pages should be a number";
		}

		if(cbBookType.getSelectedItem().equals(Constants.PRINTBOOK))
		{
			try
			{
				if(Integer.parseInt(txtField1.getText())<=0)
				{
					msg = msg + "\nNumber of copies should be greater than 0";
				}			
			}
			catch(NumberFormatException ex)
			{
				msg = msg + "\nNumber of copies should be a number";
			}			
		}
		else
		{
			if(txtField1.getText().equals(""))
				msg = msg + "\nURL should not be blank";			
		}


		if(msg.length()>0)
		{
			JOptionPane.showMessageDialog(new JFrame(), msg, "Invalid input" ,JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else
		{
			return true;			
		}
	}

	public boolean validateBookId()
	{
		try
		{
			if(Integer.parseInt(txtBookId.getText())<=0)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Book id should be greater than 0", "Invalid input" ,JOptionPane.ERROR_MESSAGE);
				return false;
			}			
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Book id should be a number", "Invalid input" ,JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}
}