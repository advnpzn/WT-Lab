import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public class LoginServlet extends HttpServlet {

    protected String queryName(){
        String usrname = "";
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "admin", "admin");
            Statement stmnt = conn.createStatement();

            String query = "SELECT name FROM user";

            ResultSet rs = stmnt.executeQuery(query);
            rs.next();
            usrname += rs.getString("name");

            conn.close();

            }catch (Exception e) {
                System.out.println(e);
            }
            return usrname;

    }


    protected String queryPassword(){
        String passw = "";
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "admin", "admin");
            Statement stmnt = conn.createStatement();

            String query = "SELECT password FROM user";

            ResultSet rs = stmnt.executeQuery(query);
            rs.next();
            passw += rs.getString("password");
            
            conn.close();

            }catch (Exception e) {
                System.out.println(e);
            }
            return passw;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("index.html").include(request, response);

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (name.equals(queryName()) && password.equals(queryPassword())){
            out.print("<div class='alert alert-success' role='alert' style='margin: auto;width: 30%;'>Successfully logged in! Welcome "+ name + "!</div>");

            Cookie cookie = new Cookie("name", name);
            response.addCookie(cookie);
        } else {
            out.print(
                """
                <div class='alert alert-danger' role='alert' style='margin: auto;width: 30%;'>
                    Username or password Incorrect.
                </div>
                """
            );
            request.getRequestDispatcher("link.html").include(request, response);
        }

        out.close();
    }
}