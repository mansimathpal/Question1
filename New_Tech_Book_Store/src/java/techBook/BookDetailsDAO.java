/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package techBook;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vikash.suman
 */
public class BookDetailsDAO {
private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
     this.sessionFactory = sessionFactory;
 }
 public BookDetailsDAO() {
 Configuration configuration = new Configuration().configure();
  }
public List getBookByName(String bookName)
 {
        List<Book> booklist=null;
        try
        {
            Session session = sessionFactory.openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Book.class)
            .add(Restrictions.eq("bookname", bookName));

            booklist = (List<Book>) criteria.list();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return booklist;
  }
}
