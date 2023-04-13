package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class kayit_ol extends JFrame {

	private JPanel contentPane;
	private JTextField kayitol_txt_ad;
	private JTextField kayitol_txt_soyad;
	private JTextField kayitol_txt_dyeri;
	private JTextField kayitol_txt_il;
	private JTextField kayitol_txt_anneadi;
	private JTextField kayitol_txt_babaadi;
	private JTextField kayitol_txt_ilce;
	private JTextField kayitol_txt_mail;
	private JPasswordField kayitol_txt_sifre;
	private JDateChooser kayit_ol_dtarihi;

	MaskFormatter tel,dtarih;
	private JTextField kayitol_txt_tc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kayit_ol frame = new kayit_ol();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public kayit_ol() throws ParseException {
		setTitle("Kayýt Ol");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 839);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tel = new MaskFormatter("(05##)-###-##-##");
		dtarih = new MaskFormatter("##.##.####");

		JLabel kayit_label_tc = new JLabel("T.C. Kimlik No:");
		kayit_label_tc.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_tc.setBounds(47, 11, 114, 25);
		contentPane.add(kayit_label_tc);

		JLabel kayit_label_ad = new JLabel("Ad:");
		kayit_label_ad.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_ad.setBounds(47, 49, 114, 25);
		contentPane.add(kayit_label_ad);

		JLabel kayit_label_soyad = new JLabel("Soyad:");
		kayit_label_soyad.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_soyad.setBounds(47, 87, 114, 25);
		contentPane.add(kayit_label_soyad);

		JLabel kayit_label_dtarih = new JLabel("Doðum Tarihi:");
		kayit_label_dtarih.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_dtarih.setBounds(47, 125, 114, 25);
		contentPane.add(kayit_label_dtarih);

		JLabel kayit_label_dyeri = new JLabel("Doðum Yeri:");
		kayit_label_dyeri.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_dyeri.setBounds(47, 163, 114, 25);
		contentPane.add(kayit_label_dyeri);

		JLabel kayit_label_adres = new JLabel("Adres:");
		kayit_label_adres.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_adres.setBounds(47, 355, 114, 25);
		contentPane.add(kayit_label_adres);

		JLabel kayit_label_il = new JLabel("Ýl:");
		kayit_label_il.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_il.setBounds(47, 279, 114, 25);
		contentPane.add(kayit_label_il);

		JLabel kayit_label_ilce = new JLabel("Ýlçe:");
		kayit_label_ilce.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_ilce.setBounds(47, 317, 114, 25);
		contentPane.add(kayit_label_ilce);

		JLabel kayit_label_cins = new JLabel("Cinsiyet:");
		kayit_label_cins.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_cins.setBounds(47, 515, 114, 25);
		contentPane.add(kayit_label_cins);

		JLabel kayit_label_tel = new JLabel("Telefon:");
		kayit_label_tel.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_tel.setBounds(47, 593, 114,25);
		contentPane.add(kayit_label_tel);

		JLabel kayit_label_anne = new JLabel("Anne Adý:");
		kayit_label_anne.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_anne.setBounds(47, 201, 114, 25);
		contentPane.add(kayit_label_anne);

		JLabel kayit_label_baba = new JLabel("Baba Adý:");
		kayit_label_baba.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_baba.setBounds(47, 239, 114, 25);
		contentPane.add(kayit_label_baba);

		JLabel kayit_label_sgk = new JLabel("Sigorta:");
		kayit_label_sgk.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_sgk.setBounds(47,553,114,25);
		contentPane.add(kayit_label_sgk);

		JButton kayit_ol_buton = new JButton("KAYIT OL");
		kayit_ol_buton.setFont(new Font("Cambria", Font.PLAIN, 19));
		kayit_ol_buton.setBounds(346, 738, 130, 31);
		contentPane.add(kayit_ol_buton);

		JSeparator separator = new JSeparator();
		separator.setBounds(48, 720, 428, 5);
		contentPane.add(separator);

		kayitol_txt_ad = new JTextField();
		kayitol_txt_ad.setBounds(226, 51, 250, 25);
		contentPane.add(kayitol_txt_ad);
		kayitol_txt_ad.setColumns(10);

		kayitol_txt_soyad = new JTextField();
		kayitol_txt_soyad.setColumns(10);
		kayitol_txt_soyad.setBounds(226, 89, 250, 25);
		contentPane.add(kayitol_txt_soyad);

		kayitol_txt_dyeri = new JTextField();
		kayitol_txt_dyeri.setColumns(10);
		kayitol_txt_dyeri.setBounds(226, 163, 250, 25);
		contentPane.add(kayitol_txt_dyeri);

		kayitol_txt_il = new JTextField();
		kayitol_txt_il.setColumns(10);
		kayitol_txt_il.setBounds(226, 279, 250, 25);
		contentPane.add(kayitol_txt_il);

		kayitol_txt_anneadi = new JTextField();
		kayitol_txt_anneadi.setColumns(10);
		kayitol_txt_anneadi.setBounds(226, 201, 250, 25);
		contentPane.add(kayitol_txt_anneadi);

		kayitol_txt_babaadi = new JTextField();
		kayitol_txt_babaadi.setColumns(10);
		kayitol_txt_babaadi.setBounds(226, 239, 250, 25);
		contentPane.add(kayitol_txt_babaadi);

		JFormattedTextField kayitol_txt_tel = new JFormattedTextField(tel);
		kayitol_txt_tel.setBounds(226, 593, 250, 25);
		contentPane.add(kayitol_txt_tel);

		JLabel kayit_label_mail = new JLabel("E-Posta:");
		kayit_label_mail.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_mail.setBounds(47, 631, 114, 25);
		contentPane.add(kayit_label_mail);

		kayitol_txt_ilce = new JTextField();
		kayitol_txt_ilce.setColumns(10);
		kayitol_txt_ilce.setBounds(226, 317, 250, 25);
		contentPane.add(kayitol_txt_ilce);

		kayitol_txt_mail = new JTextField();
		kayitol_txt_mail.setColumns(10);
		kayitol_txt_mail.setBounds(226, 631, 250, 25);
		contentPane.add(kayitol_txt_mail);

		JLabel kayit_label_sifre = new JLabel("Þifre:");
		kayit_label_sifre.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_sifre.setBounds(47, 670, 114, 25);
		contentPane.add(kayit_label_sifre);

		kayitol_txt_sifre = new JPasswordField();
		kayitol_txt_sifre.setBounds(226, 670, 250, 25);
		contentPane.add(kayitol_txt_sifre);

		JComboBox kayitol_combo_cins = new JComboBox();
		kayitol_combo_cins.setModel(new DefaultComboBoxModel(new String[] {"", "Erkek", "Kadýn"}));
		kayitol_combo_cins.setBounds(226, 518, 250, 25);
		contentPane.add(kayitol_combo_cins);

		JComboBox kayitol_combo_sgk = new JComboBox();
		kayitol_combo_sgk.setModel(new DefaultComboBoxModel(new String[] {"", "SSK", "Baðkur", "Emekli Sandýðý"}));
		kayitol_combo_sgk.setBounds(226, 556, 250, 25);
		contentPane.add(kayitol_combo_sgk);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 355, 250, 150);
		contentPane.add(scrollPane);


		JTextArea kayitol_txt_adres = new JTextArea();
		kayitol_txt_adres.setBounds(226, 355, 250, 150);
		scrollPane.setViewportView(kayitol_txt_adres);

		kayit_ol_dtarihi = new JDateChooser();
		kayit_ol_dtarihi.setBounds(226, 128, 250, 22);
		contentPane.add(kayit_ol_dtarihi);

		JLabel kayit_basarili = new JLabel("Kayýt Baþarýlý!");
		kayit_basarili.setForeground(Color.RED);
		kayit_basarili.setFont(new Font("Cambria", Font.BOLD, 21));
		kayit_basarili.setBounds(58, 742, 164, 22);
		contentPane.add(kayit_basarili);

		kayitol_txt_tc = new JTextField();
		kayitol_txt_tc.setColumns(10);
		kayitol_txt_tc.setBounds(226, 14, 250, 25);
		contentPane.add(kayitol_txt_tc);
		kayit_basarili.setVisible(false);

		kayit_ol_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				//String dtarihi = df.format(kayit_ol_dtarihi.getDate());			

				String tc,ad,soyad,dtarihi,dyeri,adres,il,ilce,cins,tel,anne,baba,sgk,mail,sifre2,sql_sorgu;

				tc =  kayitol_txt_tc.getText();
				ad = kayitol_txt_ad.getText();
				soyad = kayitol_txt_soyad.getText();
				dtarihi = df.format(kayit_ol_dtarihi.getDate());
				dyeri = kayitol_txt_dyeri.getText(); 
				adres = kayitol_txt_adres.getText();
				il = kayitol_txt_il.getText();
				ilce = kayitol_txt_ilce.getText();
				cins = kayitol_combo_cins.getSelectedItem().toString();
				tel =  kayitol_txt_tel.getText();
				anne = kayitol_txt_anneadi.getText();
				baba = kayitol_txt_babaadi.getText();
				sgk = kayitol_combo_sgk.getSelectedItem().toString();
				mail = kayitol_txt_mail.getText();
				char[] sifre = kayitol_txt_sifre.getPassword();
				sifre2 = String.valueOf(sifre);

				
				if (tc.length() != 11) {
					JOptionPane.showMessageDialog(null, "TC Kimlik Numarasý 11 haneli olmalýdýr.", "Hatalý TC Kimlik Numarasý", JOptionPane.ERROR_MESSAGE);
				}
				int[] hane = new int[11];
				int toplam = 0;
				for (int i = 0; i < 11; i++) {
					hane[i] = Integer.parseInt(String.valueOf(tc.charAt(i)));
					toplam += hane[i];
				}
				toplam -= hane[10];
				if ((toplam % 10) != hane[10]) {
					JOptionPane.showMessageDialog(null, "Lütfen Geçerli TC Kimlik Numarasý giriniz.", "Hatalý TC Kimlik Numarasý", JOptionPane.ERROR_MESSAGE);
				}
				if (((hane[0] + hane[2] + hane[4] + hane[6] + hane[8]) * 7 + (hane[1] + hane[3] + hane[5] + hane[7]) * 9) % 10 != hane[9]) {
					JOptionPane.showMessageDialog(null, "Lütfen Geçerli TC Kimlik Numarasý giriniz.", "Hatalý TC Kimlik Numarasý", JOptionPane.ERROR_MESSAGE);
				}
				if (((hane[0] + hane[2] + hane[4] + hane[6] + hane[8]) * 8) % 10 != hane[10]) {
					JOptionPane.showMessageDialog(null, "Lütfen Geçerli TC Kimlik Numarasý giriniz.", "Hatalý TC Kimlik Numarasý", JOptionPane.ERROR_MESSAGE);
				}
				if (mail.equals("") || (ad.equals("") || (soyad.equals("") || (dtarihi.equals("") || (dyeri.equals("") || (adres.equals("") || (il.equals("") || (ilce.equals("")
						|| (cins.equals("") || (tel.equals("") || (anne.equals("") || (baba.equals("") || (sgk.equals("") || (sifre.equals(""))))))))))))))) { 
					JOptionPane.showMessageDialog(null, "Lütfen bütün bilgileri eksiksiz giriniz.", "Ýlgili alanlarý doldurunuz!", JOptionPane.WARNING_MESSAGE);
					} 
				else {
					sql_sorgu = "INSERT INTO hastalar (hasta_tc,hasta_ad,hasta_soyad,hasta_dogum,hasta_dyeri,hasta_adres,hasta_il,hasta_ilce,hasta_cins,hasta_tel,hasta_anne,hasta_baba,hasta_sgk,hasta_mail,hasta_sifre) "
							+ "VALUES ('"+ tc + "','" + ad + "'," + "'" + soyad + "'," + "'" + dtarihi + "'," + "'" + dyeri + "'," + "'" + adres + "'," + "'" + il + "'," + "'" + ilce + "'," 
							+ "'" + cins + "'," + "'" + tel + "'," + "'" + anne + "'," + "'" + baba + "',"+ "'" + sgk + "',"+ "'" + mail + "',"+ "'" + sifre2 + "')";

					kayit_basarili.setVisible(true);
					kayit_ol_buton.setVisible(false);

					baglanti.yap();
					baglanti.ekle(sql_sorgu);
				}
			}
		});
	}
}
