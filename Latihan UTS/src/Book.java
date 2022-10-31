import java.util.Vector;

public class Book {
	private String lib;
	private String name;
	private String id;
	private int price; 
	private String desc;
	private String coun;
	
	
	
	public Book(String lib, String name, String id, int price, String desc, String coun) {
		super();
		this.lib = lib;
		this.name = name;
		this.id = id;
		this.price = price;
		this.desc = desc;
		this.coun = coun;
	}
	public String getLib() {
		return lib;
	}
	public void setLib(String lib) {
		this.lib = lib;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCoun() {
		return coun;
	}
	public void setCoun(String coun) {
		this.coun = coun;
	}
	
	
	
}
