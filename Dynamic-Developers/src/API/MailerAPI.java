/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import static javax.mail.Transport.send;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Rayen
 */
public class MailerAPI {
    
        static Session sesh;
        static Properties prop = new Properties();
    
       public static void Mail(String UN, String PW,String to, String sub, String cont) /*throws IOException*/ {

        try {
            prop.put("mail.smtp.auth", "true");
       
             prop.put("mail.smtp.starttls.enable", "true");
        
                 prop.put("mail.smtp.host", "smtp.gmail.com");
                 prop.put("mail.smtp.port", "587");
            sesh = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(UN, PW);
                    }
                });
            
            Message m = new MimeMessage(sesh);
            m.setFrom(new InternetAddress(UN));
            m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            m.setSubject(sub);
            m.setSentDate(new Date());
            m.setContent(cont, "text/plain");
            m.setHeader("EMAIL HEAD", "Reclamation");
            System.out.println("\n \n \n \t >> ??????? " + m.getContentType());
            System.out.println("\n \n \n \t >> ??????? " + m.getDataHandler());
            System.out.println("\n \n \n \t >> ??????? " + m.getSubject());

            Transport t;
           
                t = sesh.getTransport("smtp");
            
            System.out.println(">> ? smtp(s) ---> ## " + t.getURLName() + " \n>> ?");

//            Transport.send(m);  


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } // end try/catch //

        // });

        } // end Mail() //

}