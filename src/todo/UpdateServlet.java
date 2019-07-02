package todo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.forms.UpdateForm;
import todo.services.Service;
import todo.utils.HTMLUtils;

@WebServlet("/update.html")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		Service s = new Service();
		UpdateForm form = new UpdateForm();
		form = s.find(id);
		req.setAttribute("form", form);

		getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String detail = req.getParameter("detail");
		String priority = req.getParameter("priority");
		String timelimit = req.getParameter("timelimit");
		UpdateForm form = new UpdateForm(id,name,detail,priority,timelimit);

		//error処理
		if (!(validate(form).size() == 0)) {

			req.setAttribute("error", validate(form));
			req.setAttribute("form", form);

			getServletContext().getRequestDispatcher("/WEB-INF/update.jsp")
			.forward(req, resp);
			return;

		} else {

			//Serviceのupdateメソッドを利用
			Service s = new Service();
			s.update(form);
			resp.sendRedirect("index.html");
		}
	}


	private List<String> validate(UpdateForm form) {

		//errorメッセージを貯める
		List<String> errorList = new ArrayList<>();
		int priority = Integer.parseInt(form.getPriority());

		//ID
		if(form.getId().equals("")) {
			errorList.add("idの入力は必須です。");
		}

		//題名
		if(form.getName().equals("")) {
			errorList.add("題名の入力は必須です");
		}

		if(100 < form.getName().length()) {
			errorList.add("題名は100文字以内です。");
		}

		//重要度
		if(priority < 1 || 3 < priority) {
			errorList.add("重要度の値が間違っています");
		}

		//期限

		try {

			if(form.getTimelimit().equals("")) {
				form.setTimelimit(null);

			}else if(form.getTimelimit().contains("/")){
				LocalDate.parse(HTMLUtils.change(form.getTimelimit()));
			}else {
				LocalDate.parse(form.getTimelimit());
			}

		}catch(NullPointerException e) {
			return errorList;
		}catch(RuntimeException e) {
			errorList.add("期限は「YYYY/MM/DD」形式で入力してください。");
			return errorList;
		}

		return errorList;

	}

}
