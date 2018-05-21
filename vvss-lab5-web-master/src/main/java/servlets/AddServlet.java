package servlets;
import controller.NoteController;
import model.Nota;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    private NoteController ctrl;

    @Override
    public void init() throws ServletException {
        ctrl = new NoteController();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nr_matricol = Integer.parseInt(req.getParameter("nr_matricol"));
        String materie = req.getParameter("materie");
        Double nota = Double.parseDouble(req.getParameter("nota"));
        RequestDispatcher rd = null;
        rd = req.getRequestDispatcher("/success.jsp");
        HttpSession session = req.getSession();
        try{
            ctrl.addNota(new Nota(nr_matricol,materie,nota));
            session.setAttribute("result","Added");
        }catch(Exception e) {
            session.setAttribute("result", "Not added");
        }
        rd.forward(req,resp);
    }
}
