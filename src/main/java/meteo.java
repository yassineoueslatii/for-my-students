
public class meteo {
	
	private int id;
	private String Title;
	private String content;
	public meteo(int id, String title, String content) {
		super();
		this.id = id;
		Title = title;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
