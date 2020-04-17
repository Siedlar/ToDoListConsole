import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class UsersService {
    private UserDAOimpl userDAOimpl;

    public UsersService(UserDAOimpl userDAOimpl) {
        this.userDAOimpl = userDAOimpl;
    }

    public UserDAOimpl getUserDAOimpl() {
        return userDAOimpl;
    }
    public void save(Users user) {
        userDAOimpl.openCurrentSessionwithTransaction();
        userDAOimpl.save(user);
        userDAOimpl.closeCurrentSessionwithTransaction();
        System.out.println("Uzytkownik pomyslnie został zapisany w bazie danych!!!");
    }


    public void update(Users user) {
        userDAOimpl.openCurrentSessionwithTransaction();
        userDAOimpl.update(user);
        userDAOimpl.closeCurrentSessionwithTransaction();
    }
    public Users findById(int id) {
        userDAOimpl.openCurrentSession();
        Users user = userDAOimpl.get(id);
        userDAOimpl.closeCurrentSession();
        return user;
    }
    public Users getByLoginAndPassword(String login, String password) {
        userDAOimpl.openCurrentSession();
    Users user=userDAOimpl.getByLoginAndPassword(login,password);
        userDAOimpl.closeCurrentSession();
        return user;
    }
    public List<Users> findAll() {
        userDAOimpl.openCurrentSession();
        List<Users> users = userDAOimpl.getAll();
        userDAOimpl.closeCurrentSession();
        return users;
    }
    public void deleteAll() {
        userDAOimpl.openCurrentSessionwithTransaction();
        userDAOimpl.deleteAll();
        userDAOimpl.closeCurrentSessionwithTransaction();
    }

    public void delete(Users user) {
        userDAOimpl.openCurrentSessionwithTransaction();
        userDAOimpl.delete(user);
        userDAOimpl.closeCurrentSessionwithTransaction();
    }
    public void addTasks(){
        userDAOimpl.openCurrentSessionwithTransaction();
        userDAOimpl.add(new Tasks("sprzatanie",new Date(2020-04-20),5));
        userDAOimpl.closeCurrentSessionwithTransaction();
    }
}
