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
    public List<Users> findAll() {
        userDAOimpl.openCurrentSession();
        List<Users> books = userDAOimpl.getAll();
        userDAOimpl.closeCurrentSession();
        return books;
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
}
