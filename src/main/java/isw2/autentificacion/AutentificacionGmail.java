//package isw2.autentificacion;
//
//import java.util.Properties;
//import javax.mail.AuthenticationFailedException;
//import javax.mail.MessagingException;
//import javax.mail.NoSuchProviderException;
//import javax.mail.Session;
//import javax.mail.Store;
//
//public class AutentificacionGmail implements Autentificacion {
//
//	public AutentificacionGmail() {
//	}
//
//	public Boolean credencialesValidos(String user, String password) {
//
//		Properties props = System.getProperties();
//		props.setProperty("mail.store.protocol", "imaps");
//		Boolean result = false;
//		try {
//			Session session = Session.getDefaultInstance(props, null);
//			Store store = session.getStore("imaps");
//			store.connect("imap.gmail.com", user, password);
//			result = store.isConnected();
//		}
//
//		catch (AuthenticationFailedException e) {
//			return false;
//
//		} catch (NoSuchProviderException e) {
//			e.printStackTrace();
//			System.exit(1);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//			System.exit(2);
//		}
//		return result;
//	}
//
//}
