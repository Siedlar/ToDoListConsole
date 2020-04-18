import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.lang.model.type.ArrayType;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
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
                .addAnnotatedClass(Tasks.class)
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


        return  (Users) getCurrentSession().createQuery("FROM Users user WHERE user.login = :login AND user.password = :haslo")
                .setParameter("login", login)
                .setParameter("haslo",password)
                .getSingleResult();
    }

    @Override
    public void save(Users user)   throws javax.persistence.PersistenceException{

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
  public void add(Tasks tasks,Users user){
     if(user.getListaZadan().isEmpty()){
          user.setListaZadan(new ArrayList<>());
      }
     user.getListaZadan().add(tasks);
      tasks.setUser(user);
     getCurrentSession().save(user);
  }
    public List<Tasks> wypiszZadaniaUser(){

        return  getByLoginAndPassword("Krystian", "qwerty").getListaZadan();
    }
    }

