import org.dhanesh.javabrains.messenger.service.MessageService;

public class MessageServiceTest {

	public static void main(String[] args) {
		MessageService msgService = new MessageService();
		
		msgService.getMessagesForYear(2015);
	}

}
