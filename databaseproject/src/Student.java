
public class Student extends Person implements Methods {
	int StudentID;
	int Note = -1;
	
	//Constructor of Student
	public Student(String firstname, String surname, int age, int TC, int StudentID) {
		super(firstname, surname, age, TC);
		this.StudentID = StudentID;
		
	}


	public int getStudentID() {
		return StudentID;
	}


	public void setStudentID(int studentID) {
		StudentID = studentID;
	}


	public int getNote() {
		return Note;
	}


	public void setNote(int note) {
		Note = note;
	}


	@Override
	//to showing note just for own notes.
	public int showNote(Student student) throws Exception {
		if(student.getNote() == -1){
			throw new Exception("öðrencinin henüz notu yok");
		}else{
			return student.getNote();
		}
				
	}

	
	
}
