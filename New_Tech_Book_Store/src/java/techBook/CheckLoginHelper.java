package techBook;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class CheckLoginHelper {
Session session = null;

public CheckLoginHelper()
{
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();
}
 public List getCustomer()
 {
       List<Customer> customers=null;
       try
        {
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
