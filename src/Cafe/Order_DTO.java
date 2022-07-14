package Cafe;

public class Order_DTO {

	private String name;
	private int price;
	
	public Order_DTO() {
		System.out.println("Order_DTO 생성자 호출");
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

}
