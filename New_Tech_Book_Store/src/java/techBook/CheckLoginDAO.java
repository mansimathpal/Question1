/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package techBook;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author vikash.suman
 */
public class CheckLoginDAO {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
     this.sessionFactory = sessionFactory;
 }
 public CheckLoginDAO() {
 Configuration configuration = new Configuration().configure();
  }
public List getCustomer()
 {
       List<Customer> customers=null;
       try
        {
            Session session = sessionFactory.openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from techBook.Customer");
            customers = (List<Customer>) q.list();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return customers;
  }
}
