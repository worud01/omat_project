package vo;
/*
create table restaurantreview(
	res_name VARCHAR(50),
	user_id VARCHAR(16),
	photo VARCHAR(50),
	re_content VARCHAR(5000) not null,
	re_ref INT NOT NULL,
	re_lev INT NOT NULL,
	re_seq INT NOT NULL,
	like_up INT default 0,
	like_down INT default 0,
	star FLOAT not null,
	foreign key (res_name) REFERENCES restaurant (name),
	foreign KEY (user_id) REFERENCES member (id)
); 
  
  
*/
public class RestaurantreViewDTO {
	private String res_name;
	private String user_id;
	private String photo;
	private String re_content;
	private int	re_ref;
	private int re_lev;
	private int re_seq;
	private int like_up;
	private int like_down;
	private float star;
	
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public int getRe_ref() {
		return re_ref;
	}
	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}
	public int getRe_lev() {
		return re_lev;
	}
	public void setRe_lev(int re_lev) {
		this.re_lev = re_lev;
	}
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	public int getLike_up() {
		return like_up;
	}
	public void setLike_up(int like_up) {
		this.like_up = like_up;
	}
	public int getLike_down() {
		return like_down;
	}
	public void setLike_down(int like_down) {
		this.like_down = like_down;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
}
