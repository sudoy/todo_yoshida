package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import todo.HTMLUtils;
import todo.forms.IndexForm;
import todo.utils.DBUtils;

public class Service{

	public List<IndexForm> find () throws ServletException {
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

			List<IndexForm> form = new ArrayList<>();

			//DBの値の取り出し
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				String priority = rs.getString("priority");
				String timelimit = HTMLUtils.limit(rs.getString("timelimit"));

				//DBの値をセットする
				IndexForm f = new IndexForm(id,name,detail,priority,timelimit);
				form.add(f);
			}

			//値をServletに送信
			return form;

		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			try{
				DBUtils.close(con, rs, ps);
			}catch (Exception e){}

		}
	}
}
