package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.forms.UpdateForm;
import todo.services.Service;

@WebServlet("/update.html")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		Service s = new Service();
		UpdateForm form = new UpdateForm();
		form = s.update(id);
		req.setAttribute("form", form);

		getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
	}

}
