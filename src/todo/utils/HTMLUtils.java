package todo.utils;

public class HTMLUtils {

	public static String limit(String timelimit) {

		if(timelimit != null) {
			String date;
			String year = timelimit.substring(0, 4) + "/";
			String month = timelimit.substring(5,7) + "/";
			String day = timelimit.substring(8,10);
			date = year + month + day ;
			return date;
		}else {
			return timelimit;
		}

	}

	public static String priority(String priority) {
		if(priority.equals("3")) {
			return "★★★";
		}else if(priority.equals("2")){
			return "★★" ;
		}else if(priority.equals("1")){
			return "★";
		}else {
			return "";
		}
	}
}