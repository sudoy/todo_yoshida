package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.utils.DBUtils;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;
		try{

			//DBと接続する
			con = DBUtils.getConnection();
			sql = "SELECT id,name,detail,priority,timelimit FROM todo ORDER BY id";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			List<String> id = new ArrayList<>();
			List<String> name = new ArrayList<>();
			List<String> detail = new ArrayList<>();
			List<String> priority = new ArrayList<>();
			List<String> timelimit = new ArrayList<>();

			//DBの値の取り出し
			while(rs.next()){
				String i = rs.getString("id");
				String n = rs.getString("name");
				String d = rs.getString("detail");
				String p = rs.getString("priority");
				String t = rs.getString("timelimit");

				id.add(i);
				name.add(n);
				detail.add(d);
				priority.add(p);
				timelimit.add(t);
			}

			//DBの値をセットする
			req.setAttribute("id", id);
			req.setAttribute("name", name);
			req.setAttribute("detail", detail);
			req.setAttribute("priority", priority);
			req.setAttribute("timelimit", timelimit);

		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			try{
				DBUtils.close(con, rs, ps);
			}catch (Exception e){}

		}
		//値をjspに送信
		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}


