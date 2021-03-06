package MailDemo;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail

{
	// reportFileName = TestExecutionResultFileName
	public static void execute() throws Exception

	{
		String path = "C:\\Users\\dhavalsh\\Desktop\\eclipse\\eclipse\\workspace\\Eifu_Aut\\Reports\\Elfuscripts.html";
		//C:\Users\dhavalsh\Desktop\eclipse\eclipse\workspace\Elfu\Reports\Elfuscripts.html
		//C:\\SFDC-Test-Scripts\\com.okta\\Reports
		String[] to = {"dhaval.shah1@intusurg.com"};
		String[] cc = {"dhaval.shah1@intusurg.com"};
		String[] bcc = {"dhaval.shah1@intusurg.com"};

		SendMail.sendMail("dhavalshahpartner@gmail.com",
				"twinkle@1977", "smtp.gmail.com", "465", "true",
				"true", true, "javax.net.ssl.SSLSocketFactory", "false", to,
				cc, bcc, "Status Report", "Please check Test Status by dowloading the report files", path);
	}

	public static boolean sendMail(String userName, String passWord,
			String host, String port, String starttls, String auth,
			boolean debug, String socketFactoryClass, String fallback,
			String[] to, String[] cc, String[] bcc, String subject,
			String text, String attachmentPath) {

		// Object Instantiation of a properties file.
		Properties props = new Properties();

		props.put("mail.smtp.user", userName);

		props.put("mail.smtp.host", host);

		if (!"".equals(port)) {
			props.put("mail.smtp.port", port);
		}

		if (!"".equals(starttls)) {
			props.put("mail.smtp.starttls.enable", starttls);
			props.put("mail.smtp.auth", auth);
		}

		if (debug) {

			props.put("mail.smtp.debug", "true");

		} else {

			props.put("mail.smtp.debug", "false");

		}

		if (!"".equals(port)) {
			props.put("mail.smtp.socketFactory.port", port);
		}
		if (!"".equals(socketFactoryClass)) {
			props.put("mail.smtp.socketFactory.class", socketFactoryClass);
		}
		if (!"".equals(fallback)) {
			props.put("mail.smtp.socketFactory.fallback", fallback);
		}

		try {

			Session session = Session.getDefaultInstance(props, null);

			//session.setDebug(debug);

			MimeMessage msg = new MimeMessage(session);

			msg.setText(text);

			msg.setSubject(subject);

			Multipart multipart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource("C:\\Users\\dhavalsh\\Desktop\\eclipse\\eclipse\\workspace\\Eifu_Aut\\Reports\\Elfuscripts.html");
			//C:\\SFDC-Test-Scripts\\com.okta\\Reports
			//C:\\Users\\dhavalsh\\git\\SFDC-Test-Scripts\\com.okta\\Reports\\Dynamic_Training.html
			
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("Report.html");
			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);
			msg.setFrom(new InternetAddress(userName));

			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to[i]));
			}

			for (int i = 0; i < cc.length; i++) {
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
						cc[i]));
			}

			for (int i = 0; i < bcc.length; i++) {
				msg.addRecipient(Message.RecipientType.BCC,
						new InternetAddress(bcc[i]));
			}

			msg.saveChanges();

			Transport transport = session.getTransport("smtp");

			transport.connect(host, userName, passWord);

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

			return true;

		} catch (Exception mex) {
			mex.printStackTrace();
			return false;
		}
	}
}