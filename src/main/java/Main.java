import java.util.List;

public class Main {
    public static void main(String[] args){
        UsersService usersService=new UsersService(new UserDAOimpl());
        List<Users> listaUser=usersService.findAll();
        listaUser.forEach((x)-> System.out.println(x));
        usersService.save(new Users("Grzegorz","Siedlarski"));
        listaUser=usersService.findAll();
        listaUser.forEach((x)-> System.out.println(x));
        usersService.deleteAll();
    }

}
