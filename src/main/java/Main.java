import java.util.List;

public class Main {
    public static void main(String[] args){

    UserDAOimpl userDao=new UserDAOimpl();
    userDao.openCurrentSession();
    List<Users> listaUzytkownikow=userDao.getAll();
    listaUzytkownikow.forEach((x)-> System.out.println(x));
    }

}
