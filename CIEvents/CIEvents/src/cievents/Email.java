/**
 * Roberto Cervantes
 * Daniela Miles
 * Brian Ortiz
 * Brian Radomski
 */
package cievents;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author brianortiz
 */
public class Email 
{
   private String user = "teamsaturn350";
   private String pass = "SoT89lozoot";
   
   Email (String to, String sub, String msg)
   {
       Properties prop = new Properties();
       prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
       prop.put("mail.smtp.auth", true);
       prop.put("mail.smtp.starttls.enable", true);
       prop.put("mail.smtp.host", "smtp.gmail.com");
       prop.put("mail.smtp.port", "587");
       
       Session session = Session.getInstance(prop, new javax.mail.Authenticator()
       {
           protected javax.mail.PasswordAuthentication getPasswordAuthentication()
           {
               return new javax.mail.PasswordAuthentication(user, pass);
           }
       });
       
       try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress("no-reply@gmail.com"));
           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
           message.setSubject(sub);
           message.setText(msg);
           Transport.send(message);
           }
       
       catch (Exception ex)
       {
           System.out.print(ex);
       }
   }
    public static boolean isValidEmailAddress(String email)
    {
        boolean result = true;
        try {
           InternetAddress emailAddr = new InternetAddress(email);
           emailAddr.validate();
        } catch (AddressException ex) {
           result = false;
        }
        return result;
     }

    Email() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}


