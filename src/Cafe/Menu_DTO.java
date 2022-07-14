package Cafe;

public class Menu_DTO {

	private String name;
	private int price;
	private String Caffeine;
	
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
	
}
