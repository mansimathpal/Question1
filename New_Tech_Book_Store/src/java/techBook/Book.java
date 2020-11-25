package techBook;

public class Book  implements java.io.Serializable {


     private String bookid;
     private String bookname;
     private String category;
     private String author;
     private String price;
     private Integer stock;

    public Book() {
    }

	
    public Book(String bookid) {
        this.bookid = bookid;
    }
    public Book(String bookid, String bookname, String category, String author, String price, Integer stock) {
       this.bookid = bookid;
       this.bookname = bookname;
       this.category = category;
       this.author = author;
       this.price = price;
       this.stock = stock;
    }
   
    public String getBookid() {
        return this.bookid;
    }
    
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }
    public String getBookname() {
        return this.bookname;
    }
    
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPrice() {
        return this.price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    public Integer getStock() {
        return this.stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }




}




