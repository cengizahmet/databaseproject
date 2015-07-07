
public class Person {
	String firstname;
	String surname;
	int age;
	int TC;
	
	public int getTC() {
		return TC;
	}

	public void setTC(int tC) {
		TC = tC;
	}
	
	public Person(){
		
	}

	public Person(String firstname, String surname, int age, int TC){
		this.firstname = firstname;
		this.surname = surname;
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
