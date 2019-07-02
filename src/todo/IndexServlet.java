package todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.forms.IndexForm;
import todo.services.Service;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		Service s = new Service();
		List<IndexForm> form = new ArrayList<>();
		form = s.findAll();
		req.setAttribute("form", form);

		//値をjspに送信
		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}


