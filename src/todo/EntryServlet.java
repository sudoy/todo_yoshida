package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.forms.IndexForm;
import todo.services.Service;

@WebServlet("/entry.html")
public class EntryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		//jspから入力された値を取得
		String name = req.getParameter("name");
		String detail = req.getParameter("detail");
		String priority = req.getParameter("priority");
		String timelimit = req.getParameter("timelimit");

		//formに代入
		IndexForm form = new IndexForm(name,detail,priority,timelimit);

		Service s = new Service();
		s.insert(form);
		resp.sendRedirect("index.html");
	}
}
