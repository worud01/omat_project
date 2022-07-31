package vo;
/*
create table  restaurangogi(
	res_name VARCHAR(50),
	foreign key (res_name) REFERENCES restaurant (name)
);
 */
public class RestauranListDTO {
  private String res_name;

public String getRes_name() {
	return res_name;
}

public void setRes_name(String res_name) {
	this.res_name = res_name;
}
}
