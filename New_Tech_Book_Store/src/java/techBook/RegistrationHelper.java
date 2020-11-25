package techBook;

import org.hibernate.Session;

public class RegistrationHelper {
Session session = null;

    public RegistrationHelper()
    {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    public void insertStudent(Customer cst)
    {
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(cst);
        tx.commit();
    }
}

