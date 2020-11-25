/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package techBook;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class BookDetailsHelper {
Session session = null;
public BookDetailsHelper()
{
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();
}
public List getBookByName(String bookName)
 {
        List<Book> booklist=null;
        try
        {
            org.hibernate.Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Book.class)
            .add(Restrictions.eq("bookname", bookName));

            booklist = (List<Book>) criteria.list();
            tx.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return booklist;
  }

}
