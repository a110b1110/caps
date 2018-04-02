package auth.service;

public class User {

	private String id;
	private String name;
	private int grade;
	
	public User(String id, String name, int grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getGrade() {
		return grade;
	}
}
