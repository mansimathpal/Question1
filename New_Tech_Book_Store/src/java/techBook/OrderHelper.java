
package techBook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderHelper {
Session session = null;
public OrderHelper()
    {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    public void insertOrder(Orderdetail ord)
    {
        Transaction transaction = null;
        int stock=0;
        try {
             String bookid= ord.getBookid();
             System.out.println(bookid);
             transaction = session.beginTransaction();
             Query query = session.createQuery("FROM Book WHERE bookid ='" + bookid + "'");
             List <Book> lst=new ArrayList<Book>();
             lst=query.list();
             for (Iterator it=lst.iterator();it.hasNext();) {
                Book bk = (Book) it.next();
                stock = bk.getStock();
                }
             System.out.println(stock);
            int updatedStock = stock - ord.getQty();            
            String strQuery = "UPDATE Book SET stock =:updatedStock WHERE bookid =:bookid";
            query = session.createQuery(strQuery);
            query.setString("bookid", bookid);
            query.setInteger("updatedStock", updatedStock);
            int updatedRowCount = query.executeUpdate();
            Serializable sz=session.save(ord);
            transaction.commit();
        }
        catch (Exception e)
        {
            if (transaction != null) {
                  transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
      }
}
