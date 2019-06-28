package todo;

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
}
