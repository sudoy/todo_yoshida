package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import todo.forms.EntryForm;
import todo.forms.IndexForm;
import todo.forms.UpdateForm;
import todo.utils.DBUtils;
import todo.utils.HTMLUtils;

public class Service{

	public List<IndexForm> findAll () throws ServletException {
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
				String priority = HTMLUtils.priority(rs.getString("priority"));
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

	public void insert(EntryForm form) throws ServletException {

		//EntryServletで使用
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try{
			//DBへinsert
			con = DBUtils.getConnection();
			sql = "INSERT INTO todo (name,detail,priority,timelimit) VALUES (?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, form.getName());
			ps.setString(2, form.getDetail());
			ps.setString(3, form.getPriority());
			ps.setString(4, form.getTimelimit());
			ps.executeUpdate();

		}catch(Exception e){
			throw new ServletException(e);

		}finally{
			try{
				DBUtils.close(con, ps);
			}catch(Exception e){}
		}
	}

	public UpdateForm find (String id) throws ServletException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;
		try{

			//DBと接続する
			con = DBUtils.getConnection();
			//プレースホルダーを使う
			sql = "SELECT id,name,detail,priority,timelimit FROM todo WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			rs = ps.executeQuery();

			UpdateForm f = new UpdateForm();


			//DBの値の取り出し
			while(rs.next()){
				id = rs.getString("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				String priority = rs.getString("priority");
				String timelimit = HTMLUtils.limit(rs.getString("timelimit"));

				//DBの値をセットする
				f = new UpdateForm(id,name,detail,priority,timelimit);

			}

			//値をServletに送信
			return f;

		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			try{
				DBUtils.close(con, rs, ps);
			}catch (Exception e){}

		}
	}

	public void update(UpdateForm form) throws ServletException {
		;
		//EntryServletで使用
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try{
			//DBへinsert
			con = DBUtils.getConnection();
			sql = "UPDATE todo set name=?, detail=?, priority=?, timelimit=? where id = ?";

			ps = con.prepareStatement(sql);
			ps.setString(1, form.getName());
			ps.setString(2, form.getDetail());
			ps.setString(3, form.getPriority());
			ps.setString(4, form.getTimelimit());
			ps.setString(5, form.getId());
			ps.executeUpdate();

		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			try{
				DBUtils.close(con, ps);
			}catch(Exception e){}
		}

	}

}
