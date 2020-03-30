import java.sql.*;

public class Main {
    public static void main(String[] args){
        Connection conn=null;
        Statement statement=null;
        try {

            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist?serverTimezone=UTC","root","soad666");
            statement=conn.createStatement();
            ResultSet wyynik=statement.executeQuery("Select * from users");
            while (wyynik.next()){
                System.out.println(wyynik.getString(2));
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }

    }

}
