package tele;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DobodoBot extends org.telegram.telegrambots.bots.TelegramLongPollingBot{
    @Override
    public String getBotUsername() {

        return "@Dobodobot";
    }

    @Override
    public String getBotToken() {
        return "1608874121:AAEB21mXJ-gJ42UtWrxS0pxZHWCS_L24Cvw";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("Received Message -> " + update.getMessage());

        SendMessage sendCreatedMessage = new SendMessage();
        String createMessage = "Hi " + update.getMessage().getChat().getFirstName() + ". We will reach to you soon";
        System.out.println("createdMessage -> "+ createMessage);

        sendCreatedMessage.setText(createMessage);
        sendCreatedMessage.setChatId(update.getMessage().getChatId().toString());


        try {
            execute(sendCreatedMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
