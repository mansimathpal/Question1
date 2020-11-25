package techBook;

public class Orderdetail  implements java.io.Serializable {


     private int orderid;
     private String bookid;
     private Integer qty;
     private String shippingaddress;

    public Orderdetail() {
    }

	
    public Orderdetail(int orderid) {
        this.orderid = orderid;
    }
    public Orderdetail(int orderid, String bookid, Integer qty, String shippingaddress) {
       this.orderid = orderid;
       this.bookid = bookid;
       this.qty = qty;
       this.shippingaddress = shippingaddress;
    }
   
    public int getOrderid() {
        return this.orderid;
    }
    
    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
    public String getBookid() {
        return this.bookid;
    }
    
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }
    public Integer getQty() {
        return this.qty;
    }
    
    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public String getShippingaddress() {
        return this.shippingaddress;
    }
    
    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }




}


