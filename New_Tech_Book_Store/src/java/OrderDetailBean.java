/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ValueChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import techBook.Book;
import techBook.BookDetailsDAO;
import techBook.OrderHelper;
import techBook.Orderdetail;

public class OrderDetailBean {

    Book book=null;
    private String BookName;
    private HtmlOutputText Stock;
    private int quantity;
    private String shippingaddress;
    static int bkInStock;
    private String stockError;
    private String addressError;
    public OrderDetailBean() { book=new Book();}
    public void BookDetailsAction(ValueChangeEvent vce)
    {
        String bookName = vce.getNewValue().toString();
        StringBuilder bStock=new StringBuilder();
        StringBuilder bID=new StringBuilder();
        performLookup(bID, bookName, bStock);
        getStock().setValue(bStock.toString());        
    }
   void performLookup(StringBuilder bID, String bookName, StringBuilder bStock)
        {
           ApplicationContext apc=new ClassPathXmlApplicationContext("techBook/spring-hibernate.xml");
           BookDetailsDAO helper=(BookDetailsDAO)apc.getBean("bookDetailsDAO");
           List<Book> books=new ArrayList<Book>();
           books=helper.getBookByName(bookName);
           Iterator iterator;
           iterator=books.iterator();
           while(iterator.hasNext())
           {
             book=(Book)iterator.next();
           }
            bID.append(book.getBookid().toString());            
            bStock.append(book.getStock());
            bkInStock=book.getStock();
}
    public String validateOrder()
     {
        int stk=this.getQuantity();
        String shAddress=this.getShippingaddress();
        String val1="OrderDetails";
        String val2="OrderSuccess";
        if (stk==0)
        {
           setStockError("Quantity must be greater than 0");
           if(shAddress.equals(""))
           {
              setAddressError("Shipping address must be provided");
           }
           return val1;
        }
        else if(stk>bkInStock)
        {
           setStockError("Quantity must be less than the available stock");
           if(shAddress.equals(""))
           {
              setAddressError("Shipping address must be provided");
           }
           return val1;
         }
        else if(shAddress.equals(""))
        {
          setAddressError("Shipping address must be provided");
          return val1;
         }
       else
        {
        ApplicationContext apc=new ClassPathXmlApplicationContext("techBook/spring-hibernate.xml");
       BookDetailsDAO helper=(BookDetailsDAO)apc.getBean("bookDetailsDAO");
        List<Book> books=new ArrayList<Book>();
        books=helper.getBookByName(this.getBookName());
        Iterator iterator;
        iterator=books.iterator();
        while(iterator.hasNext())
        {
             book=(Book)iterator.next();
        }
        Orderdetail cst=new Orderdetail();
        OrderHelper rghp=new OrderHelper();
        cst.setBookid(book.getBookid());
        cst.setQty(this.getQuantity());
        cst.setShippingaddress(this.getShippingaddress());
        rghp.insertOrder(cst);
        return val2;
        }
    }
/*public void validateStock(FacesContext fc, UIComponent c, Object value)throws ValidatorException
    {
        int stk= (Integer)value;


       if (stk==0)
         {
           FacesMessage message = new FacesMessage();
           message.setDetail("Quantity must be greater than 0");
           message.setSummary("Quantity must be greater than 0");
           throw new ValidatorException(message);
        }
 else if(stk>bkInStock)
         {
           FacesMessage message = new FacesMessage();
           message.setDetail("Quantity must be less than available stock");
           message.setSummary("Quantity must be less than available stock");
           throw new ValidatorException(message);
        }
    }
  */
    /**
     * @return the BookName
     */
    public String getBookName() {
        return BookName;
    }

    /**
     * @param BookName the BookName to set
     */
    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    /**
     * @return the Stock
     */
    public HtmlOutputText getStock() {
        return Stock;
    }

    /**
     * @param Stock the Stock to set
     */
    public void setStock(HtmlOutputText Stock) {
        this.Stock = Stock;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the shippingaddress
     */
    public String getShippingaddress() {
        return shippingaddress;
    }

    /**
     * @param shippingaddress the shippingaddress to set
     */
    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }

    /**
     * @return the stockError
     */
    public String getStockError() {
        return stockError;
    }

    /**
     * @param stockError the stockError to set
     */
    public void setStockError(String stockError) {
        this.stockError = stockError;
    }

    /**
     * @return the addressError
     */
    public String getAddressError() {
        return addressError;
    }

    /**
     * @param addressError the addressError to set
     */
    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }
 
    
}
