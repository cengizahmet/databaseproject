
public class Academician extends Person implements Methods{

	int academicianID;

	public Academician(String firstname, String surname, int age,int TC, int academicianID) {
		super(firstname, surname, age, TC);
		this.academicianID = academicianID;
		
	}

	public int getAcademicianID() {
		return academicianID;
	}

	public void setAcademicianID(int academicianID) {
		this.academicianID = academicianID;
	}

	@Override

	//interface method: to showNotes
	public int showNote(Student student) throws Exception{

		if(student.getNote() == -1){
			throw new Exception("öðrencinin henüz notu yok");
		}else{
			return student.getNote();
		}
	}


	//updateNote: to change Notes

	public void updateNote(Student student, int note){

		student.setNote(note);
	}



	//deleteNote: to delete Notes

	public void deleteNote(Student student){

		student.setNote(-1);

	}

}
