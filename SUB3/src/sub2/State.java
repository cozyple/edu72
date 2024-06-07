package sub2;

public class State {
	private String name;
	private String type;
	private String url;
	private String[] param;
	
	public State(String name, String type, String url, String[] param) {
		super();
		this.name = name;
		this.type = type;
		this.url = url;
		this.param = param;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}

	public String[] getParam() {
		return param;
	}

	public void setParam(String[] param) {
		this.param = param;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
