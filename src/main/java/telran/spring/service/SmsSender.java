package telran.spring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import telran.spring.dto.*;

@Service
@Component("sms")
public class SmsSender implements Sender {

	@Override
	public String send(Message message) {
		String res = "";
		SmsMessage smsMessage;
		try {
			smsMessage = (SmsMessage) message;
			res = String.format("sms sender text '%s' has been sent to %s\n", smsMessage.text,
					smsMessage.phoneNumber);
		} catch(Exception e) {
			res = "Message Data mismatch sender type";
		}
		return res;
	}
}

