import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Box.Filler;

import com.acengiz.database.DatabaseOperation;

public class DetailsPanel extends JPanel {


	public static int layoutVersion = 0;
	public DetailsPanel(int layoutVersion2) {
		layoutVersion = layoutVersion2;


		System.out.print("layoutversion on detailsPanel is: " + layoutVersion2);
		if(layoutVersion == 0){
			Test.accountName = "";
			Test.accountSurname= "";
			Dimension size = getPreferredSize();
			size.width = 300;
			setPreferredSize(size);

			setBorder(BorderFactory.createTitledBorder("Personal Details"));
			JLabel nameLabel = new JLabel("Name: ");
			JLabel occupationJLabel = new JLabel("Occupation: ");

			final JTextField nameField = new JTextField(10);
			final JTextField occupatiJTextField = new JTextField(10);

			JButton loginButtonofStudent = new JButton("Student Login");
			JButton loginButtonofAcademician = new JButton("Academician Login");
			setLayout(new GridBagLayout());
			GridBagConstraints gc = new GridBagConstraints();

			gc.weightx = 0.5;
			gc.weighty = 0.5;

			gc.gridx = 0;
			gc.gridy = 0;
			add(nameLabel, gc);

			gc.gridx = 0;
			gc.gridy = 1;
			add(occupationJLabel, gc);

			gc.gridx = 1;
			gc.gridy = 0;
			add(nameField, gc);

			gc.gridx = 1;
			gc.gridy = 1;
			add(occupatiJTextField, gc);

			gc.weighty = 10;

			gc.anchor = GridBagConstraints.FIRST_LINE_START;
			gc.gridx = 1;
			gc.gridy = 2;
			add(loginButtonofStudent, gc);

			gc.anchor = GridBagConstraints.FIRST_LINE_START;
			gc.gridx = 1;
			gc.gridy = 3;
			add(loginButtonofAcademician, gc);
			
			loginButtonofAcademician.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("student login button is clicked");
					String name = nameField.getText();
					String surname = occupatiJTextField.getText();
					System.out.println(name + " " + surname);
					
				}
			});

			loginButtonofStudent.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("student login button is clicked");
					String name = nameField.getText();
					String surname = occupatiJTextField.getText();
					System.out.println(name + " " + surname);
					checkData(name, surname);


				}

			});
		}else if(layoutVersion == 1){
			Dimension size = getPreferredSize();
			size.width = 400;
			setPreferredSize(size);

			System.out.println("kullanýcý öðrenci layout u oluþturuluyor");
			JButton showNote = new JButton("Show note");
			setLayout(new GridBagLayout());
			GridBagConstraints gc = new GridBagConstraints();

			gc.anchor = GridBagConstraints.FIRST_LINE_START;
			gc.gridx = 1;
			gc.gridy = 3;
			add(showNote, gc);

			showNote.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					DatabaseOperation databaseOperation = new DatabaseOperation();
					databaseOperation.ownNote(Test.accountName,Test.accountSurname);

				}
			});
		}else if(layoutVersion == 2){
			Dimension size = getPreferredSize();
			size.width = 400;
			setPreferredSize(size);

			System.out.println("kullanýcý admin layout u oluþturuluyor");
			JLabel nameLabel = new JLabel("Name: ");
			JLabel surnameLabel = new JLabel("Surname: ");
			JLabel noteLabel = new JLabel("Note: ");
			JLabel StudentIDLabel = new JLabel("StudentID: ");

			final JTextField StudentIDField = new JTextField(10);

			final JTextField nameField = new JTextField(10);
			final JTextField surnameField = new JTextField(10);
			final JTextField noteField = new JTextField(3);
			
			JButton showStudentNote = new JButton("Show Note");
			JButton changeStudentNote = new JButton("Change Note");
			setLayout(new GridBagLayout());
			GridBagConstraints gc = new GridBagConstraints();

			gc.weightx = 0.1;
			gc.weighty = 0.1;

			gc.gridx = 0;
			gc.gridy = 0;
			add(nameLabel, gc);

			gc.gridx = 0;
			gc.gridy = 1;
			add(surnameLabel, gc);
			
			gc.gridx = 0;
			gc.gridy = 2;
			add(noteLabel, gc);
			
			gc.gridx = 0;
			gc.gridy = 4;
			add(showStudentNote,gc);
			
			gc.gridx = 1;
			gc.gridy = 4;
			add(changeStudentNote,gc);
			
			gc.gridx = 0;
			gc.gridy = 3;
			add(StudentIDLabel,gc);
			
			gc.gridx = 1;
			gc.gridy = 3;
			add(StudentIDField,gc);

			gc.gridx = 1;
			gc.gridy = 0;
			add(nameField, gc);

			gc.gridx = 1;
			gc.gridy = 1;
			add(surnameField, gc);
			
			gc.gridx = 1;
			gc.gridy = 2;
			add(noteField, gc);
		
			showStudentNote.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String name = nameField.getText();
					String surname = surnameField.getText();
					DatabaseOperation databaseOperation = new DatabaseOperation();
					databaseOperation.ownNote(name,surname);
					
				}
			});
			
			
			changeStudentNote.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String name = nameField.getText();
					String surname = surnameField.getText();
					String note = noteField.getText();
					String studentID = StudentIDField.getText();
					DatabaseOperation databaseOperation = new DatabaseOperation();
					databaseOperation.changeNote(studentID, name, surname, note);
					
					
				}
			});
			
			
		}

	}

	public int checkData(String name, String surname) {

		DatabaseOperation databaseOperation = new DatabaseOperation();
		databaseOperation.openConnection();
		if(databaseOperation.login(name,surname) == 1){
			Test.accountName = name;
			Test.accountSurname = surname;
			System.out.println("accountName is: " + Test.accountName);
			System.out.println("accountSurname is: " + Test.accountSurname);
			layoutVersion = 1;
			System.out.println("yeni frame oluþturulacak");
			Test.frame.setVisible(false);
			Test.frame = new MainFrame("kullanýcý ekraný", layoutVersion);
			Test.frame.setSize(400, 200);
			Test.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Test.frame.setVisible(true);
		}else if(databaseOperation.login(name, surname) == 2){
			Test.accountName = name;
			Test.accountSurname = surname;
			System.out.println("accountName is: " + Test.accountName);
			System.out.println("accountSurname is: " + Test.accountSurname);
			layoutVersion = 2;
			System.out.println("yeni frame oluþturulacak");
			Test.frame.setVisible(false);
			Test.frame = new MainFrame("kullanýcý ekraný", layoutVersion);
			Test.frame.setSize(400, 200);
			Test.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Test.frame.setVisible(true);
		}


		return 1;
	}
}
