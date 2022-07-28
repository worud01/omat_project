package vo;

import java.sql.Date;

public class MemberDTO {
	private String member_name;
	private String member_id;
	private String member_pass;
	private String member_email;
	private String member_post_code;
	private String member_address1;
	private String member_address2;
	private Date member_hire_date;
	 
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pass() {
		return member_pass;
	}
	public void setMember_pass(String member_pass) {
		this.member_pass = member_pass;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_post_code() {
		return member_post_code;
	}
	public void setMember_post_code(String member_post_code) {
		this.member_post_code = member_post_code;
	}
	public String getMember_address1() {
		return member_address1;
	}
	public void setMember_address1(String member_address1) {
		this.member_address1 = member_address1;
	}
	public String getMember_address2() {
		return member_address2;
	}
	public void setMember_address2(String member_address2) {
		this.member_address2 = member_address2;
	}
	public Date getMember_hire_date() {
		return member_hire_date;
	}
	public void setMember_hire_date(Date member_hire_date) {
		this.member_hire_date = member_hire_date;
	}


}
