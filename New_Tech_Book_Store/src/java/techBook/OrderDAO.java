/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package techBook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author vikash.suman
 */
public class OrderDAO {
private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
     this.sessionFactory = sessionFactory;
 }
 public OrderDAO()
 {
     Configuration configuration = new Configuration().configure();
 }
 public void insertOrder(Orderdetail ord)
 {
        Transaction transaction = null;
        int stock=0;
        try {
             String bookid= ord.getBookid();
             Session session = sessionFactory.openSession();
             transaction = session.beginTransaction();
             Query query = session.createQuery("FROM Book WHERE bookid ='" + bookid + "'");
             List <Book> lst=new ArrayList<Book>();
             lst=query.list();
             for (Iterator it=lst.iterator();it.hasNext();) {
                Book bk = (Book) it.next();
                stock = bk.getStock();
                }
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
