package sub1;

public class State {
	private String name;
	private String type;
	private String url;
	
	public State(String name, String type, String url) {
		super();
		this.name = name;
		this.type = type;
		this.url = url;
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
