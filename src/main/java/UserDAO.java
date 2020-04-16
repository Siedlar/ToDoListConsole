import java.util.List;

public interface UserDAO {


       Users get(int id);

        List<Users> getAll();

        void save(Users user);

        void update(Users user);

        void delete(Users user);
        void deleteAll();
}
