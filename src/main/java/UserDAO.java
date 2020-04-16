import java.util.List;

public interface UserDAO {


       Users get(int id);

        List<Users> getAll();

        void save(Users user);

        void update(Users user, String[] params);

        void delete(Users user);

}
