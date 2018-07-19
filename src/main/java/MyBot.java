import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class MyBot extends TelegramLongPollingBot{
	
	

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
		String message = update.getMessage().getText();
		sendMsg(update.getMessage().getChatId().toString(), message);
		System.out.println(update.getMessage().getChatId().toString());
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
        sendMessage.setChatId("-1001274613302");
        sendMessage.setText(s);
        //-1001274613302
        
        try {
            sendMessage(sendMessage);
            setButtons(sendMessage);
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
