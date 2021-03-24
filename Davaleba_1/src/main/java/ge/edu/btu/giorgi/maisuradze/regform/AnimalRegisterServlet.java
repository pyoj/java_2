package ge.edu.btu.giorgi.maisuradze.regform;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/animal")
public class AnimalRegisterServlet extends HttpServlet {

    public static final String VIEW = "/register-form.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("breed"));
        System.out.println(req.getParameter("gender"));
        System.out.println(req.getParameter("age"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher(VIEW);
        view.forward(req, resp);

    }
}
