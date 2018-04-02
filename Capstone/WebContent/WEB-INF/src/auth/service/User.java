package auth.service;

public class User {

	private int id;
	private String name;
	private int group;
	
	public User(int id, String name, int group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getGroup() {
		return group;
	}
}
