import javax.persistence.NoResultException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UsersService usersService=new UsersService(new UserDAOimpl());
        Users user=null;
        Scanner in;
        System.out.println("Witaj w ToDoList!!!");
        int a;
        do{
            System.out.println("1.Zaloguj się\n2.Zarejestruj się\n3.Wypisz liste użytkowników aplikacji\n4.Wyjdz");
          a=PobieranieDanych.wybierzLiczbe();
            if(a==1)
            {
                try{
                user=usersService.getByLoginAndPassword(PobieranieDanych.wpiszLogin(), PobieranieDanych.wpiszHaslo());}catch (NoResultException e ){
                    System.out.println("Użytkowik o podanych danych nie istnieje!\nSpróbuj ponownie");
                    Thread.sleep(2000);
                    a=-3;
                }
            }
            else if(a==2)
            {    int b=3;
                do {
                    try {


                    System.out.println("1.Zaloguj z podanie wszystkich danych\n2.Uzupelnie dane pózniej");
                    b = PobieranieDanych.wybierzLiczbe();

                    if (b == 1) {
                        usersService.save(new Users(PobieranieDanych.wpiszImie(), PobieranieDanych.wpiszNazwisko(), PobieranieDanych.wpiszLogin(), PobieranieDanych.wpiszHaslo(), PobieranieDanych.wpiszEmail()));

                        break;
                    } else if (b == 2) {
                        usersService.save(new Users(PobieranieDanych.wpiszLogin(), PobieranieDanych.wpiszHaslo()));
                        break;
                    }}catch   ( javax.persistence.PersistenceException  ex){
                            System.out.println("Uzytkownik istnieje w bazie");
                        usersService.getUserDAOimpl().getCurrentTransaction().rollback();
                            b=-1;

                    }
                    if(b==-1){

                    }else{
                    System.out.println("Wybierz poprawna liczbe");}
                } while(b!=1 &&b!=2);
            }
            else if(a==3)
            {
                for(Users users:usersService.findAll()){
                    System.out.println(users.toString());
                };
            } else if(a==4)
            {
                System.exit(0);
            }
           else if(a!=4 && a!=3 && a!=2 && a!=1)
            {
               System.out.println("Wybierz poprawną liczbę!!!");
            }
    }while(a!=4 && a!=3 && a!=2 && a!=1 ||user==null);
        System.out.println("essa");
    }

}
