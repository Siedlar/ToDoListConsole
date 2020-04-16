import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDAOimpl implements UserDAO {

    private Session currentSession;

    private Transaction currentTransaction;
    public UserDAOimpl(){

    }
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    public void closeCurrentSession() {
        currentSession.close();
    }
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
    private static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Users.class)
                .buildSessionFactory();
        return sessionFactory;
    }
    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    @Override
    public Users get(int id) {
      return (Users)currentSession.get(Users.class,id);
    }

    @Override
    public List<Users> getAll() {
        List<Users> users =  getCurrentSession().createQuery("from Users").list();
        return users;
    }

    @Override
    public Users getByLoginAndPassword(String login, String password) {


        return  (Users) getCurrentSession().createQuery("FROM Users user WHERE user.login = :status AND user.password = :status2")
                .setParameter("status", login)
                .setParameter("status2",password)
                .getSingleResult();
    }

    @Override
    public void save(Users user) {
    getCurrentSession().save(user);
    }

    @Override
    public void deleteAll() {

            List<Users> entityList = getAll();
            for (Users entity : entityList) {
                delete(entity);
            }
    }

    @Override
    public void update(Users user) {
        getCurrentSession().update(user);
    }

    @Override
    public void delete(Users user) {
        getCurrentSession().delete(user);
    }
}
