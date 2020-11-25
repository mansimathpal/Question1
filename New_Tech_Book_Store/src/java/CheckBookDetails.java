import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ValueChangeEvent;
import techBook.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CheckBookDetails
{
    Book book=null;
    private String BookName;
    private HtmlOutputText BookId, BookAuthor, BookPrice, Category;
    public CheckBookDetails() { book=new Book();   }
    public void BookDetailsAction(ValueChangeEvent vce)
    {
        String bookName = vce.getNewValue().toString();
        StringBuilder bID = new StringBuilder();
        StringBuilder bCategory=new StringBuilder();
        StringBuilder bAuthor=new StringBuilder();
        StringBuilder bPrice=new StringBuilder();
        performLookup(bID, bookName, bCategory, bAuthor, bPrice);
        getBookId().setValue(bID.toString());
        getCategory().setValue(bCategory.toString());
        getBookAuthor().setValue(bAuthor.toString());
        getBookPrice().setValue(bPrice.toString());
    }
void performLookup(StringBuilder bID, String bookName, StringBuilder bCategory, StringBuilder bAuthor, StringBuilder bPrice)
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
            bCategory.append(book.getCategory().toString());
            bAuthor.append(book.getAuthor().toString());
            bPrice.append(book.getPrice().toString());
}

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
     * @return the BookId
     */
    public HtmlOutputText getBookId() {
        return BookId;
    }

    /**
     * @param BookId the BookId to set
     */
    public void setBookId(HtmlOutputText BookId) {
        this.BookId = BookId;
    }

    /**
     * @return the BookAuthor
     */
    public HtmlOutputText getBookAuthor() {
        return BookAuthor;
    }

    /**
     * @param BookAuthor the BookAuthor to set
     */
    public void setBookAuthor(HtmlOutputText BookAuthor) {
        this.BookAuthor = BookAuthor;
    }

    /**
     * @return the BookPrice
     */
    public HtmlOutputText getBookPrice() {
        return BookPrice;
    }

    /**
     * @param BookPrice the BookPrice to set
     */
    public void setBookPrice(HtmlOutputText BookPrice) {
        this.BookPrice = BookPrice;
    }

    /**
     * @return the Category
     */
    public HtmlOutputText getCategory() {
        return Category;
    }

    /**
     * @param Category the Category to set
     */
    public void setCategory(HtmlOutputText Category) {
        this.Category = Category;
    }
 
}
