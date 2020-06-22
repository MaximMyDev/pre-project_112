package _my_test_1.servlet;

import _my_test_1.model.User;
import _my_test_1.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/maxmax")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        //RequestDispatcher dispatcher = req.getRequestDispatcher("my-user-new.jsp");
        //dispatcher.forward(req, resp);

        if (action.contains("/addnew")) {
            addUser(req, resp);
        }
        if (action.contains("/showall")) {
            showAllUser(req, resp);
        }
        super.doGet(req, resp);
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //throws SQLException, IOException
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/my-user-new.jsp");

        String name = req.getParameter("name");
        User newUser = new User(name);
        userDAO.addUserDAO(newUser);

        dispatcher.forward(req, resp);
    }

    private void showAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Запрос к БД для получения данных
        List allUser = userDAO.showAllUserDAO();
        for(Object name : allUser){
            System.out.println(name.toString());
        }
        // Сохранить данные в атрибут 'alluser' в request.
        req.setAttribute("allUser", allUser);

        // Создать объект RequestDispatcher
        // чтобыForward (перенаправить) запрос к my-user-list.jsp
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/my-user-list.jsp");

        // Forward (перенаправить) запрос, чтобы отобразить данные на странице JSP.
        dispatcher.forward(req, resp);
    }
}
