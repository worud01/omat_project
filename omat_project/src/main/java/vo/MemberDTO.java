package vo;

import java.sql.Date;
/*
CREATE TABLE member (
    id VARCHAR(16) PRIMARY KEY,
    email VARCHAR(50) unique,
    name VARCHAR(15) NOT NULL,
    passwd VARCHAR(16) NOT NULL,
    nick_name VARCHAR(15) NOT NULL,
    birth_date VARCHAR(15) NOT NULL,
    spicy_degree INT default 0,
    hire_date DATE NOT NULL,
    post_code VARCHAR(5),
    address1 varchar(50),
    address2 varchar(50)
);
*/
//멤버 관리 하는 클래스
public class MemberDTO {
	private String id;
	private String email;
	private String name;
	private String passwd;
	private String nick_name;
	private String birth_date;
	private int spicy_degree;
	private Date hire_date;
	private String post_code;
	private String address1;
	private String address2;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public int getSpicy_degree() {
		return spicy_degree;
	}
	public void setSpicy_degree(int spicy_degree) {
		this.spicy_degree = spicy_degree;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	 
	

}
