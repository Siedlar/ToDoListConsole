import java.util.InputMismatchException;
import java.util.Scanner;

public class PobieranieDanych {
    public static int wybierzLiczbe(){
        int a=0;
        Scanner in=new Scanner(System.in);
      try {
          a = in.nextInt();

      }catch (InputMismatchException e){
          System.out.println("Nie wczytuj liter!!!");
          a=-3;
          try {
              Thread.sleep(2000);
          } catch (InterruptedException ex) {
              ex.printStackTrace();
          }
      }
          return a;
    }
    public static String wpiszHaslo(){
        Scanner in=new Scanner(System.in);
        System.out.println("Podaj hasło");
        String haslo=in.nextLine();
        return haslo;
    }
    public static String wpiszLogin(){
        Scanner in=new Scanner(System.in);
        in=new Scanner(System.in);
        System.out.println("Podaj login");
        String login=in.nextLine();
        return login;
    }
    public static String wpiszImie(){
        Scanner in=new Scanner(System.in);
        System.out.println("Podaj imie");
        String haslo=in.nextLine();
        return haslo;
    }
    public static String wpiszNazwisko(){
        Scanner in=new Scanner(System.in);
        System.out.println("Podaj nazwisko");
        String haslo=in.nextLine();
        return haslo;
    }
    public static String wpiszEmail(){
        boolean zmienna;
        String haslo;
        do{
        Scanner in=new Scanner(System.in);
        System.out.println("Podaj email");
         haslo=in.nextLine();
         zmienna=isValid(haslo);
        if(zmienna==true){
        return haslo;}
        else{
            System.out.println("Nie poprawny email");
        }}while(zmienna==false);
            return haslo;
    }
    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
