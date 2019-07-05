package todo;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.forms.UserForm;
import todo.services.Service;

@WebServlet("/login.html")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		//session開始
		HttpSession session = req.getSession();

		//sessionを終了
		session.invalidate();

		getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		//ログインボタンを押すとDBと照合してリダイレクトする機能


		//jspからメールアドレス、パスワード取得
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserForm user = new UserForm();

		//エラーメッセージを貯めるList
		List<String> errorList = new ArrayList<>();

		//空白があるかチェック
		errorList = validation(email,password);

			//最終的にエラーがないか確認
			if(errorList.size() != 0) {

				//エラーありの場合
				session.setAttribute("error", errorList);
				getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);

			}else {

				try {
				//エラーなしの場合
				Service s = new Service();
				s.findUser(email, password);

				String nameUser = user.getName();
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				session.setAttribute("name", nameUser);

				resp.sendRedirect("index.html");

			}catch (Exception e) {
				errorList.add("メールアドレスが間違っています。");
				session.setAttribute("error", errorList);
				getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);

			}

		}

	}

	private List<String> validation(String email,String password) {

		List<String> errorList = new ArrayList<>();

		try {
			if(email.equals("") || password.equals("")) {
				errorList.add("未入力の項目があります。");
			}
		}catch(NullPointerException e) {
			errorList.add("未入力の項目があります。");
		}

		return errorList;

	}

	private List<String> check (UserForm user,String hash){

		List<String> errorList = new ArrayList<>();

		if(!(user.getPassword().equals(hash))) {
			errorList.add("パスワードが違います。");
		}

		return errorList;
	}


	public static String hash(String email) {

        String value = email;
        String sha1 = "";


        // java 標準 でのやり方
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] result = digest.digest(value.getBytes());
            sha1 = String.format("%040x", new BigInteger(1, result));
        } catch (Exception e){
            e.printStackTrace();
        }

        return sha1;
    }


}
