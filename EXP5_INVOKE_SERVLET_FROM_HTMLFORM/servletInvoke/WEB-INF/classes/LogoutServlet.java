import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("index.html").include(request, response);

        Cookie cookie = new Cookie("name", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        out.print(
            """
            <div class='alert alert-success' role='alert' style='margin: auto;width: 30%;'>
                Logged out successfully!
            </div>
            """
        );
    }
}
