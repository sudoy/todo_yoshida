package todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.services.Service;

@WebServlet("/delete.html")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		List<String> errorList = new ArrayList<>();
		errorList = validate(id);

		if(!(errorList.size() == 0)) {
			req.setAttribute("error", errorList);
			getServletContext().getRequestDispatcher("/WEB-INF/update.jsp")
			.forward(req, resp);
			return;

		}else {
			//Serviceのdeleteメソッド呼び出し
			Service s = new Service();
			s.delete(id);
			resp.sendRedirect("index.html");
		}
	}

	private List<String> validate(String id) {

		//errorメッセージを貯める
		List<String> errorList = new ArrayList<>();

		//IDのエラーチェック
		if(id.equals("")) {
			errorList.add("idの入力は必須です。");
		}

		return errorList;
	}
}
