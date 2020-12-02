import javax.mail.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;

public class SendEmail {
    private String to;
    private String from;
    private String user;
    private String passw;
    private String sub;
    private String tex;
    private File fil;


    SendEmail(String from, String to, String user, String passw, String sub, String tex, File ff){
        this.from=from;
        this.to=to;
        this.user=user;
        this.passw=passw;
        this.sub=sub;
        this.tex=tex;
        this.fil=ff;
    }
    public void Send() {
        final String username = user;
        final String password = passw;
        String fromEmail = from;
        String toEmail = to;
        Properties prop = new Properties();
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host","smtp.gmail.com"); //change this
        prop.put("mail.stmp.port","587");

        Session ses = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        MimeMessage msg = new MimeMessage(ses);
        try

        {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            msg.setSubject(sub);

            Multipart emailContent = new MimeMultipart();
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(tex);
            MimeBodyPart attach = new MimeBodyPart();
            emailContent.addBodyPart(textBodyPart);
            if(fil!=null) {
                attach.attachFile(fil);
                emailContent.addBodyPart(attach);
            }


            msg.setContent(emailContent);
            Transport.send(msg);
            System.out.println("Success"+fil);

        } catch(
        AddressException e)

        {
            e.printStackTrace();
        } catch(
        MessagingException e)

        {
            e.printStackTrace();
        } catch(
        IOException e)

        {
            e.printStackTrace();
        }

    }

}
