package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class test_mail extends JFrame {

	private JPanel contentPane;
	private JTextField mail;
	private JTextField tc;
	static String sifre = "";
	static String sifir_mail ="";
	private JLabel lblifremiUnuttum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test_mail frame = new test_mail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test_mail() {
		setTitle("Þifremi Unuttum");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 458, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mail = new JTextField();
		mail.setBounds(169, 86, 209, 32);
		contentPane.add(mail);
		mail.setColumns(10);

		JButton gonder = new JButton("SIFIRLA");
		gonder.setFont(new Font("Cambria", Font.BOLD, 19));

		gonder.setBounds(108, 194, 174, 45);
		contentPane.add(gonder);

		tc = new JTextField();
		tc.setBounds(169, 131, 209, 32);
		contentPane.add(tc);
		tc.setColumns(10);
		
		JLabel lblEposta = new JLabel("E-Posta:");
		lblEposta.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblEposta.setBounds(45, 88, 97, 25);
		contentPane.add(lblEposta);
		
		JLabel lblTcNo = new JLabel("TC Kimlik No:");
		lblTcNo.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblTcNo.setBounds(45, 133, 115, 25);
		contentPane.add(lblTcNo);
		
		lblifremiUnuttum = new JLabel("\u015Eifremi Unuttum");
		lblifremiUnuttum.setHorizontalAlignment(SwingConstants.CENTER);
		lblifremiUnuttum.setFont(new Font("Cambria", Font.BOLD, 23));
		lblifremiUnuttum.setBounds(0, 23, 446, 28);
		contentPane.add(lblifremiUnuttum);
		sifir_mail = mail.getText();
		
		
		String dizi[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","y","z","x",
				"0","1","2","3","4","5","6","7","8","9"};
		
		 for(int i = 0; i < 9; i++){       		 
			 int rastgele = (1+(int)(Math.random()*35));                     
			 sifre += dizi[rastgele];
			 } 

		gonder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql_sorgu;
				try{
					//PROPERTIES
					String from = "konyanumunehst@gmail.com";
					String pass = "axvptdaayhxepmqk";
					String[] to = { mail.getText() };
					String host = "smtp.gmail.com";
					Properties props = System.getProperties();
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", host);
					props.put("mail.smtp.user", from);
					props.put("mail.smtp.password", pass);
					props.put("mail.smtp.port", "587");
					props.put("mail.smtp.auth", "true");

					Session session = Session.getDefaultInstance(props, null);
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(from));
					InternetAddress[] toAddress = new InternetAddress[to.length];
					for (int i = 0; i < to.length; i++) {
						toAddress[i] = new InternetAddress(to[i]);
					}

					for (int i = 0; i < toAddress.length; i++) {
						message.addRecipient(Message.RecipientType.TO, toAddress[i]);
					}
					message.setSubject("Þifreniz Sýfýrlandý!");
					message.setText("Talebiniz üzerine þifreniz sýfýrlanmýþtýr."
							+ "Oluþturulan þifreniz: " + sifre);
					Transport transport = session.getTransport("smtp");
					transport.connect(host, from, pass);
					transport.sendMessage(message, message.getAllRecipients());
					transport.close();
					
					sql_sorgu = "UPDATE hastalar SET hasta_sifre='"+sifre+"' where hasta_tc="+tc.getText()+" ";
					
					baglanti.yap3();
					baglanti.update(sql_sorgu);

					JOptionPane.showMessageDialog(null, "Girdiðiniz bilgilere ait kullanýcý var ise þifre sýfýrlama maili gönderilmiþtir."
							+ " Mail adresinizi kontrol ediniz.", "Þifre Sýfýrlandý!", JOptionPane.INFORMATION_MESSAGE);
					
				}catch(Exception e){
					e.printStackTrace();  
				}
				if (mail.getText().equals("") || (tc.getText().equals(""))) { 
					JOptionPane.showMessageDialog(null, "E-Posta veya TC No boþ býrakýlamaz.", "Ýlgili alanlarý doldurunuz!", JOptionPane.WARNING_MESSAGE);
					} 
				//E-Posta veya TC No boþ býrakýlamaz.
			}
		});
	}
}

