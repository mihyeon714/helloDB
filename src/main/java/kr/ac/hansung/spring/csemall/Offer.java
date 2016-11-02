package kr.ac.hansung.spring.csemall;

public class Offer {
	
	private int id;
	private String name;
	private String email;
	private String text;
	
	//빈 객체 만들때 사용할 생성자
	public Offer(){
		
	}
	
	//id는 DB에서 오토인크리먼트로 성정해서 (알아서 1씩 증가) 따로 저장할 필요없기때문에 id 없는 생성자
	public Offer(String name, String email, String text) {

		this.name = name;
		this.email = email;
		this.text = text;
	}
	
	public Offer(int id, String name, String email, String text) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	//각각 값을 가지고 있는 String을 넘겨주기때문에 출력할 때 활용하겠음
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}

	
	
}
