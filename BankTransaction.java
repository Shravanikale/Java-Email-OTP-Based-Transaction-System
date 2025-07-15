import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class BankTransaction extends Thread {
	static int balance = 10000;
	String recipient;
	int amount;

	public BankTransaction(String recipient, int amount) {
		this.recipient = recipient;
		this.amount = amount;
	}

	@Override
	public void run() {
		String transactionID = UUID.randomUUID().toString();

		if (amount <= balance) {
			balance = balance - amount;
			System.out.println("Transaction successful!");
			System.out.println("Transaction ID: " + transactionID);
			System.out.println("Sent Rs " + amount + " to " + recipient);
			System.out.println("Remaining balance: Rs " + balance);
		} else {
			System.out.println("Insufficient balance. Transaction failed.");
			System.out.println("Transaction ID: " + transactionID);
		}
	}

	public static String sendOTP(String toEmail) {
		String otp = String.format("%04d", new Random().nextInt(10000));

		final String from = "kaleshravani84@gmail.com";
		final String password = "scqs bsed pklo uvsu";

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			msg.setSubject("Your OTP for Bank Transaction");
			msg.setText("Your OTP is: " + otp);
			Transport.send(msg);
			System.out.println("OTP sent to: " + toEmail);
		} catch (Exception e) {
			System.out.println("Failed to send OTP: " + e.getMessage());
		}
		return otp;
	}
}
