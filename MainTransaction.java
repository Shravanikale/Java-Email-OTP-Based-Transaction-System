import java.util.Scanner;

public class MainTransaction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter email to receive OTP: ");
		String email = sc.nextLine();

		System.out.print("Enter WhatsApp number (with +91...): ");
		String phone = sc.nextLine();

		String otp = OTPService.generateOTP();
		OTPService.sendEmailOTP(email, otp);
		OTPService.sendWhatsAppOTP(phone, otp);

		System.out.print("Enter received OTP: ");
		String enteredOtp = sc.nextLine();

		if (!otp.equals(enteredOtp)) {
			System.out.println("❌ Invalid OTP. Exiting.");
			sc.close();
			return;
		}

		System.out.print("Enter recipient name: ");
		String name = sc.nextLine();

		System.out.print("Enter amount to send: ");
		int amt = sc.nextInt();

		BankTransaction transaction = new BankTransaction(name, amt);
		transaction.start();

		sc.close();
	}
}
