import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.vdurmont.emoji.EmojiParser;

public class Service {

	private String globalSite = "watchhd.online/";
	
	int intTime(String time){
		String hours = time.substring(0,2);
		String minutes = time.substring(3,5);
		return Integer.parseInt(hours+minutes);
		
	}
	
	int getCurrentTimePlus30 (String pattern){
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 30);
		System.out.println(Integer.parseInt(dateFormat.format(calendar.getTime())));
        return Integer.parseInt(dateFormat.format(calendar.getTime()));
	}

	String postgenerator(Event event, String melbetLink){
		String fireEmoji = EmojiParser.parseToUnicode(":fire:");
		String clock = EmojiParser.parseToUnicode(":alarm_clock:");
		String moneyEmoji = EmojiParser.parseToUnicode(":moneybag:");
		String postText = clock+event.getTime() + " "+event.getHeader()+"\n";
		postText = postText +fireEmoji+"*Трансляция:* "+globalSite + event.getLink()+"\n";
		postText = postText +"\n"+moneyEmoji+"*Ставим на матчи с MELBET:* "+melbetLink;
		
		return postText;
	}
	public static void main(String [] args){
		Service s = new Service();
		s.intTime("14:30");
		s.getCurrentTimePlus30("HHmm");
	}
}
