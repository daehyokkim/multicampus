package mc.sn.bookconnect;

//실습2번 desc를 description 
public class BookDTO {
	
	//생성자 생성
	public BookDTO(int isbn,String title,String author,String publisher,
												int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	
	public BookDTO() {
		
	}
	//1.캡슐화를 적용한 필드 생성
	private int isbn; //도서 번호
	private String title; //도서명
	private String author; //저자 
	private String publisher; //출판사
	private int price; //가격
	private String desc; //상세
	
	
	public int getIsbn() {
		
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
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
	
	//toString()오버라이딩
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.isbn +"\t| "+this.title+"\t| "+this.author+"\t| "+this.publisher
				+"\t| "+this.price+"\t| "+this.desc;
	}

}
