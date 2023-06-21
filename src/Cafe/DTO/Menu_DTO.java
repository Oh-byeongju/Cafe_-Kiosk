package Cafe.DTO;

import java.sql.Date;

public class Menu_DTO {

	private String name;
	private int price;
	private String Caffeine;
	private String Type;
	private Date Menu_Date;
	
	public Menu_DTO() {
		System.out.println("Menu_DTO 생성자 호출");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getCaffeine() {
		return Caffeine;
	}
	
	public void setCaffeine(String Caffeine) {
		this.Caffeine = Caffeine;
	}
	
	public String getType() {
		return Type;
	}
	
	public void setType(String Type) {
		this.Type = Type;
	}
	
	public Date getMenu_Date() {
		return Menu_Date;
	}
	
	public void setMenu_Date(Date Menu_Date) {
		this.Menu_Date = Menu_Date;
	}
	
}
