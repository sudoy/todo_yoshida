package todo.forms;

public class IndexForm {
	private String id ;
	private String name ;
	private String detail ;
	private String priority ;
	private String timelimit ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(String timelimit) {
		this.timelimit = timelimit;
	}

	public IndexForm(String id, String name, String detail, String priority, String timelimit) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.priority = priority;
		this.timelimit = timelimit;
	}
}
