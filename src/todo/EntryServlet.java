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
import javax.servlet.http.HttpSession;

import todo.forms.EntryForm;
import todo.services.Service;
import todo.utils.HTMLUtils;

@WebServlet("/entry.html")
public class EntryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//entry.jspへ移動
		getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		//session開始
		HttpSession session = req.getSession();

		//jspから入力された値を取得
		String name = req.getParameter("name");
		String detail = req.getParameter("detail");
		String priority = req.getParameter("priority");
		String timelimit = req.getParameter("timelimit");

		//formに代入
		EntryForm form = new EntryForm(name,detail,priority,timelimit);

		//validateメソッド呼び出し
		List<String>validateform = new ArrayList<>();
		validateform = validate(form);

		//errorチェック

		if(!(validateform.size() == 0)) {

			//エラーありの場合
			req.setAttribute("form", form);
			session.setAttribute("error", validateform);

			getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp")
			.forward(req, resp);

			return;

		}else {

			//エラーなしの場合

			//成功メッセージをListに貯める
			List<String> successList = new ArrayList<>();
			successList.add("#todoを追加しました。");
			session.setAttribute("success", successList);

			//Serviceのinsertメソッドを利用
			Service s = new Service();
			s.insert(form);

			resp.sendRedirect("index.html");

		}
	}

	//error処理用メソッド
	private List<String> validate(EntryForm form) {

		//errorメッセージを貯める
		List<String> errorList = new ArrayList<>();
		int priority = Integer.parseInt(form.getPriority());

		//題名必須
		if(form.getName().equals("")) {
			errorList.add("題名の入力は必須です");
		}

		//題名100文字制限
		if(100 < form.getName().length()) {
			errorList.add("題名は100文字以内です。");
		}

		//重要度
		if(priority < 1 || 3 < priority) {
			errorList.add("重要度の値が間違っています");
		}

		//期限
		if(form.getTimelimit().length() != 10 && !(form.getTimelimit().equals(""))) {
			errorList.add("期限は「YYYY/MM/DD」形式で入力してください。");
			return errorList;
		}

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
