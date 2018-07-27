import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class MyBot extends TelegramLongPollingBot{
	
	String filePath = "publicator_files/translationtable.csv";
	
	Service service = new Service ();
	FileWorker fileworker = new FileWorker();
	
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "footHDBot";
	}

	public void onUpdateReceived(Update update) {
		//String message = update.getMessage().getText()+"rak";
		
		/*if(update.getMessage().getText().equals("Login")){
			sendMsg(update.getMessage().getChatId().toString(), "Enter password");
			if(update.getMessage().getText().equals("footballhd")){
				sendMsg(update.getMessage().getChatId().toString(), "Success");
			}
		}*/
		String melbetLink = update.getMessage().getText();

		sendMsg(update.getMessage().getChatId().toString(), "Started");
	
		List<Event> events = new ArrayList<Event>();
		
		try {
			events = fileworker.readFile(filePath);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(events);
		System.out.println(update.getMessage().getChatId().toString());
			
		for(;;){
			int currentTime = service.getCurrentTimePlus30("HHmm");
			if(currentTime>=2331){
				System.out.println("Exit..");
				System.exit(1);
			}
			
			for(int i=0;i<events.size();i++){
				Event event = events.get(i);
				System.out.println(event.getHeader());
				Integer eventTime = service.intTime(event.getTime());
				System.out.println(eventTime-currentTime+"Result ");
				
				if(eventTime==currentTime){
					
					String postText = service.postgenerator(event, melbetLink);
					sendMsg("-1001274613302", postText);
					sendMsg("420449716", event.header+"\n Через 30 матч! треба спамить\n Силка: "+event.link);
					events.remove(i);
				}
				System.out.println(eventTime+ " and "+currentTime);
				
			}
		System.out.println(events);
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		}
	}
		


	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "583922331:AAFO-1xBRaWvb3NXZloverLgabbjydMDC-4";
	}
	//420449716
	public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        
        try {
            sendMessage(sendMessage);
            
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
	
	public synchronized void setButtons(SendMessage sendMessage) {
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("Login"));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
       
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

}
