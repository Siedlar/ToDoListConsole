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
          a=4;
          try {
              Thread.sleep(2000);
          } catch (InterruptedException ex) {
              ex.printStackTrace();
          }
      }
          return a;
    }
}
