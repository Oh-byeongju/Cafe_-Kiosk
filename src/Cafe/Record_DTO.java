package Cafe;

import java.sql.Date;

public class Record_DTO {

	private int record_Seq;
	private Date record_Date;
	private int total;
	private String packaging;
	private String name;
	private int count;
	private int price;
	private int rank;
	
	public Record_DTO() {
		System.out.println("Record_DTO 생성자 호출");
	}
	
	public int getRecord_Seq() {
		return record_Seq;
	}
	
	public void setRecord_Seq(int record_Seq) {
		this.record_Seq = record_Seq;
	}
	
	public Date getRecord_Date() {
		return record_Date;
	}
	
	public void setRecord_Date(Date record_Date) {
		this.record_Date = record_Date;
	}
	
	public int getTotal()
	{
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public String getPackaging() {
		return packaging;
	}
	
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getRank()
	{
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
