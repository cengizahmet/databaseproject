import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;




public class Test extends JPanel{


	public static MainFrame frame;
	public static String accountName;
	public static String accountSurname;

	public static void main(String[] args) throws Exception {
		Student student1 = new Student("Ahmet", "Cengiz", 24, 388545, 11076002);
		Student student2 = new Student("Hakan", "Dal", 24, 388544, 11076003);
		Student student3 = new Student("Ezgi","Beltasoglu", 24, 388543, 11076001);
		Student student4 = new Student("Merve", "Katar", 24, 388542, 11076004);

		Academician academician1 = new Academician("Burak", "Temizci", 28, 388540, 1107600);
		Academician academician2 = new Academician("Abdullah", "Cengiz", 28, 388539, 1107610);

		student1.setNote(80);
		System.out.println("student1 note is: " +  student1.showNote(student1));

		student2.setNote(60);
		System.out.println("student2 note is: " +  student2.showNote(student1));

		student3.setNote(50);
		academician1.updateNote(student2, 30);

		System.out.println("student2 new note is: " +  student2.showNote(student2));

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				frame = new MainFrame("Hello world swing!",0);
				frame.setSize(400, 200);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
				

			}
		});


	}

}
