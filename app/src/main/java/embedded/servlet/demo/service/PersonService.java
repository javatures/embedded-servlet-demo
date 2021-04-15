package embedded.servlet.demo.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import embedded.servlet.demo.repository.PersonDao;

public class PersonService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        PersonDao dao = new PersonDao();
        try {
            RestRequest restRequest = new RestRequest(req.getPathInfo());
            int id = restRequest.getId();
            if (id == 0) {
                out.println(dao.getAll());
            } else {
                out.println(dao.getPerson(id));
            }
        } catch (ServletException e) {
            resp.setStatus(400);
            resp.resetBuffer();
            e.printStackTrace();
            out.println(e);
        }
        out.close();
    }
}
