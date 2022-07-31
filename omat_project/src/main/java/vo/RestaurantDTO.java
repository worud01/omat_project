package vo;
/*
create table restaurant(
	name VARCHAR(50) primary key,
	star float default 0,
	phone_number  VARCHAR(15) not null,
	opening_hours VARCHAR(20) not null,
	home_page VARCHAR(50),
	photo VARCHAR(100),
	content VARCHAR(5000) not null,
	re_count INT default 0, 
	post_code VARCHAR(5) not null,
	address1 varchar(50)not null,
	address2 varchar(50)not null
);
*/
//음식점 관리 하는 클래스
public class RestaurantDTO {
	private String name;
	private float star;
	private String phone_number;
	private String opening_hours;
	private String home_page;
	private String photo;
	private String content;
	private int re_count;
	private String post_code;
	private String address1;
	private String address2;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getOpening_hours() {
		return opening_hours;
	}
	public void setOpening_hours(String opening_hours) {
		this.opening_hours = opening_hours;
	}
	public String getHome_page() {
		return home_page;
	}
	public void setHome_page(String home_page) {
		this.home_page = home_page;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRe_count() {
		return re_count;
	}
	public void setRe_count(int re_count) {
		this.re_count = re_count;
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
