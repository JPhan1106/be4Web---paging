package coding.mentor.entity;

public class Book {
	
	private int id;
	private String name;
	private int categoryId;
	private String title;
	private String author;
	private int stock;
	private int price;
	
	public Book ( ) {
		
	}
	
	
	public Book(int id, String name, int categoryId, String title, String author, int stock, int price) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.title = title;
		this.author = author;
		this.stock = stock;
		this.price = price;
	}

	public Book(int id, String name, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
}
