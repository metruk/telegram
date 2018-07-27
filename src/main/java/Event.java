
public class Event {
	String time;
	String header;
	String link;
	
	
	public Event(String link,String header,String time) {
		
		this.time = time;
		this.header = header;
		this.link = link;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "Event [time=" + time + ", header=" + header + ", link=" + link + "]";
	}
	
	
}
