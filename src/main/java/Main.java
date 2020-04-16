import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        UsersService usersService=new UsersService(new UserDAOimpl());
        Scanner in;
        int a;
        do{
            System.out.println("Witaj w ToDoList!!!\n1.Zaloguj się\n2.Zarejestruj się\n3.Wypisz liste użytkowników aplikacji\n4.Wyjdz");
          a=PobieranieDanych.wybierzLiczbe();
            if(a==1)
            {
                System.out.println("Podaj login");
                System.out.println("Podaj hasło");
            }
            else if(a==2)
            {
             Users user=usersService.getByLoginAndPassword("Krystian","Siedlarski");
                System.out.println("Witaj"+user.toString());
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
    }while(a!=4 && a!=3 && a!=2 && a!=1);
        System.out.println("Dziekuje za skorzystanie z programu");
    }

}
