import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("index.html").include(request, response);

        Cookie cookie[] = request.getCookies();

        if (cookie != null) {
            String name = cookie[0].getValue();
            if (!name.equals("") || name != null) {
                out.print("<div class='card' style='width: 18rem;margin: auto;>");
                out.print("<img class='card-img-top' src='~/Downloads/apache-tomcat-10.0.14/webapps/parameter/profle.jpeg' alt='Card image cap'>");
                out.print("<div class='card-body'>");
                out.print("<p class='card-text'>This is your profile " + name + ".</p></div></div>");
            }
        } else {
            out.print(
                """
                <div class='alert alert-danger' role='alert' style='margin: auto;width: 30%;'>
                    Please login first!
                </div>
                """
            );
            //request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}
