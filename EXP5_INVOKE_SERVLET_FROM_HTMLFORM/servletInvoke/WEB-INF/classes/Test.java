import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;

public class Test {
    static String queryName(){
        String usrname = "";
        try{
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "admin", "admin");
            Statement stmnt = conn.createStatement();

            String query = "SELECT * FROM user";

            ResultSet rs = stmnt.executeQuery(query);
            rs.next();

            usrname += rs.getString("name");
            conn.close();

            }catch (Exception e) {
                System.out.println(e);
            }
            return usrname;

    }

    public static void main(String[] args) {
        System.out.println(queryName());
    }
}
