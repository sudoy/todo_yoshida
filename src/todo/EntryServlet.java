package todo;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.forms.EntryForm;
import todo.services.Service;
import todo.utils.HTMLUtils;

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
		EntryForm form = new EntryForm(name,detail,priority,timelimit);

		//error処理
		if(!validate(form).equals("")) {

			resp.sendRedirect("entry.html");

		}else {

			//Serviceのinsertメソッドを利用
			Service s = new Service();
			s.insert(form);
			resp.sendRedirect("index.html");
		}

	}

	//error処理用メソッド
	private String validate(EntryForm form) {
		String error = "";
		String message = "error";
		int priority = Integer.parseInt(form.getPriority());

		//題名
		if(form.getName().equals("")) {
			error += message;
		}

		if(100 < form.getName().length()) {
			error += message;
		}

		//重要度　修正
		if(priority < 1 || 3 < priority) {
			error += message;
		}

		//期限　修正
		try {
			if(form.getTimelimit().equals("")) {
				form.setTimelimit(null);

			}else if(form.getTimelimit().contains("/")){
				LocalDate.parse(HTMLUtils.change(form.getTimelimit()));
			}else {
				LocalDate.parse(form.getTimelimit());
			}

		}catch(RuntimeException e){
			error += message;
		}


		return error;

	}
}
