package h_oto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class h_bilgi extends JFrame {

	private JPanel contentPane;
	private JTextField kayitguncelle_txt_ad;
	private JTextField kayitguncelle_txt_soyad;
	private JTextField kayitguncelle_txt_dyeri;
	private JTextField kayitguncelle_txt_il;
	private JTextField kayitguncelle_txt_anneadi;
	private JTextField kayitguncelle_txt_babaadi;
	private JTextField kayitguncelle_txt_ilce;
	private JTextField kayitguncelle_txt_mail;
	private JTextField kayitguncelle_txt_sifre;


	MaskFormatter tel2;
	String tel;

	static String tc,ad,soyad,dtarihi,dyeri,adres,il,ilce,cins,anne,baba,sgk,mail,sifre;
	private JTextField tc_al_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					h_bilgi frame = new h_bilgi();
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
	public h_bilgi() {
		setTitle("Hasta Bilgilerini Öðren");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(600, 70, 558, 935);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(18, 91, 506, 793);
		contentPane.add(panel);
		
		//tel2 = new MaskFormatter("(05##)-###-##-##");

		JLabel tc_label = new JLabel("T.C. Kimlik No:");
		tc_label.setFont(new Font("Cambria", Font.PLAIN, 18));
		tc_label.setBounds(47, 11, 114, 25);
		panel.add(tc_label);

		JLabel lblAd = new JLabel("Adý:");
		lblAd.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblAd.setBounds(47, 49, 114, 25);
		panel.add(lblAd);

		JLabel lblSoyad = new JLabel("Soyadý:");
		lblSoyad.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblSoyad.setBounds(47, 87, 114, 25);
		panel.add(lblSoyad);

		JLabel lblDoumTarihi = new JLabel("Doðum Tarihi:");
		lblDoumTarihi.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblDoumTarihi.setBounds(47, 125, 114, 25);
		panel.add(lblDoumTarihi);

		JLabel lblDoumYeri = new JLabel("Doðum Yeri:");
		lblDoumYeri.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblDoumYeri.setBounds(47, 163, 114, 25);
		panel.add(lblDoumYeri);

		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblAdres.setBounds(47, 355, 114, 25);
		panel.add(lblAdres);

		JLabel lblIl = new JLabel("Ýl:");
		lblIl.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblIl.setBounds(47, 279, 114, 25);
		panel.add(lblIl);

		JLabel lblIle = new JLabel("Ýlçe:");
		lblIle.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblIle.setBounds(47, 317, 114, 25);
		panel.add(lblIle);

		JLabel lblCinsiyet = new JLabel("Cinsiyet:");
		lblCinsiyet.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCinsiyet.setBounds(47, 515, 114, 25);
		panel.add(lblCinsiyet);

		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblTelefon.setBounds(47, 593, 114,25);
		panel.add(lblTelefon);

		JLabel lblAnneAd = new JLabel("Anne Adý:");
		lblAnneAd.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblAnneAd.setBounds(47, 201, 114, 25);
		panel.add(lblAnneAd);

		JLabel lblBabaAd = new JLabel("Baba Adý:");
		lblBabaAd.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblBabaAd.setBounds(47, 239, 114, 25);
		panel.add(lblBabaAd);

		JLabel lblSgk = new JLabel("Sigorta:");
		lblSgk.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblSgk.setBounds(47,553,114,25);
		panel.add(lblSgk);

		JButton kayitguncelle_buton = new JButton("GÜNCELLE");
		kayitguncelle_buton.setFont(new Font("Cambria", Font.PLAIN, 19));
		kayitguncelle_buton.setBounds(346, 738, 130, 31);
		panel.add(kayitguncelle_buton);

		JSeparator separator = new JSeparator();
		separator.setBounds(48, 720, 428, 5);
		panel.add(separator);

		kayitguncelle_txt_ad = new JTextField(ad);
		kayitguncelle_txt_ad.setBounds(226, 51, 250, 25);
		panel.add(kayitguncelle_txt_ad);
		kayitguncelle_txt_ad.setColumns(10);

		kayitguncelle_txt_soyad = new JTextField(soyad);
		kayitguncelle_txt_soyad.setColumns(10);
		kayitguncelle_txt_soyad.setBounds(226, 89, 250, 25);
		panel.add(kayitguncelle_txt_soyad);

		kayitguncelle_txt_dyeri = new JTextField(dyeri);
		kayitguncelle_txt_dyeri.setColumns(10);
		kayitguncelle_txt_dyeri.setBounds(226, 163, 250, 25);
		panel.add(kayitguncelle_txt_dyeri);

		kayitguncelle_txt_il = new JTextField(il);
		kayitguncelle_txt_il.setColumns(10);
		kayitguncelle_txt_il.setBounds(226, 279, 250, 25);
		panel.add(kayitguncelle_txt_il);

		kayitguncelle_txt_anneadi = new JTextField(anne);
		kayitguncelle_txt_anneadi.setColumns(10);
		kayitguncelle_txt_anneadi.setBounds(226, 201, 250, 25);
		panel.add(kayitguncelle_txt_anneadi);

		kayitguncelle_txt_babaadi = new JTextField(baba);
		kayitguncelle_txt_babaadi.setColumns(10);
		kayitguncelle_txt_babaadi.setBounds(226, 239, 250, 25);
		panel.add(kayitguncelle_txt_babaadi);
		panel.setLayout(null);

		JFormattedTextField kayitguncelle_txt_tel = new JFormattedTextField(tel);
		kayitguncelle_txt_tel.setBounds(221, 5, -116, 22);
		panel.add(kayitguncelle_txt_tel);

		JLabel lblEposta = new JLabel("E-Posta:");
		lblEposta.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblEposta.setBounds(47, 631, 114, 25);
		panel.add(lblEposta);

		JTextField kayitguncelle_txt_ilce = new JTextField(ilce);
		kayitguncelle_txt_ilce.setColumns(10);
		kayitguncelle_txt_ilce.setBounds(226, 317, 250, 25);
		panel.add(kayitguncelle_txt_ilce);

		kayitguncelle_txt_mail = new JTextField(mail);
		kayitguncelle_txt_mail.setColumns(10);
		kayitguncelle_txt_mail.setBounds(226, 631, 250, 25);
		panel.add(kayitguncelle_txt_mail);

		JLabel lblifre = new JLabel("Þifre:");
		lblifre.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblifre.setBounds(47, 670, 114, 25);
		panel.add(lblifre);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 375, 250, 133);
		panel.add(scrollPane);

		kayitguncelle_txt_sifre = new JTextField(sifre);
		kayitguncelle_txt_sifre.setColumns(10);
		kayitguncelle_txt_sifre.setBounds(226, 669, 250, 25);
		panel.add(kayitguncelle_txt_sifre);

		JLabel kayitguncelle_dtarihi = new JLabel(dtarihi);
		kayitguncelle_dtarihi.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayitguncelle_dtarihi.setBounds(226, 125, 250, 25);
		panel.add(kayitguncelle_dtarihi);

		JLabel kayitguncelle_cins = new JLabel(cins);
		kayitguncelle_cins.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayitguncelle_cins.setBounds(226, 521, 250, 25);
		panel.add(kayitguncelle_cins);

		JLabel kayitguncelle_sgk = new JLabel(sgk);
		kayitguncelle_sgk.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayitguncelle_sgk.setBounds(226, 553, 250, 25);
		panel.add(kayitguncelle_sgk);

		JFormattedTextField kayitguncelle_tel2 = new JFormattedTextField(tel2);
		kayitguncelle_tel2.setBounds(226, 593, 250, 25);
		panel.add(kayitguncelle_tel2);
		
		JTextArea kayitguncelle_txt_adres = new JTextArea();
		kayitguncelle_txt_adres.setBounds(226, 364, 250, 140);
		scrollPane.setViewportView(kayitguncelle_txt_adres);
		
		JLabel kayitguncelle_tc = new JLabel((String) null);
		kayitguncelle_tc.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayitguncelle_tc.setBounds(226, 11, 250, 25);
		panel.add(kayitguncelle_tc);
		
		tc_al_txt = new JTextField();
		tc_al_txt.setBounds(119, 23, 217, 38);
		contentPane.add(tc_al_txt);
		tc_al_txt.setColumns(10);
		
		JButton sorgula_buton = new JButton("SORGULA");
		sorgula_buton.setFont(new Font("Cambria", Font.BOLD, 15));
		sorgula_buton.setBounds(370, 22, 123, 38);
		contentPane.add(sorgula_buton);
		
		JLabel tc_lbl = new JLabel("T.C. No:");
		tc_lbl.setForeground(Color.BLUE);
		tc_lbl.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		tc_lbl.setBounds(32, 21, 68, 38);
		contentPane.add(tc_lbl);


		kayitguncelle_txt_tel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				kayitguncelle_txt_tel.setVisible(false);
				kayitguncelle_tel2.setVisible(true);

			}
		});

		sorgula_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tc_al = tc_al_txt.getText();
				
				String sql_sorgu = "select hasta_tc,hasta_ad,hasta_soyad,hasta_dogum,hasta_dyeri,hasta_adres,hasta_il,hasta_ilce,hasta_cins,hasta_tel,hasta_anne,hasta_baba,hasta_sgk,hasta_mail,hasta_sifre from hastalar where hasta_tc='"+tc_al+"' ";

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);

				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

				try {
					while(myRs.next()) {

						tc = myRs.getString("hasta_tc");
						ad = myRs.getString("hasta_ad");
						soyad = myRs.getString("hasta_soyad");
						dtarihi = myRs.getString("hasta_dogum");
						dyeri = myRs.getString("hasta_dyeri");
						adres = myRs.getString("hasta_adres");
						il = myRs.getString("hasta_il");
						ilce = myRs.getString("hasta_ilce");
						cins= myRs.getString("hasta_cins");
						tel = myRs.getString("hasta_tel");
						anne = myRs.getString("hasta_anne");
						baba = myRs.getString("hasta_baba");
						sgk = myRs.getString("hasta_sgk");
						mail = myRs.getString("hasta_mail");
						sifre = myRs.getString("hasta_sifre");


						kayitguncelle_tc.setText(tc);
						kayitguncelle_txt_ad.setText(ad);
						kayitguncelle_txt_soyad.setText(soyad);
						kayitguncelle_dtarihi.setText(dtarihi);
						kayitguncelle_txt_dyeri.setText(dyeri);
						kayitguncelle_cins.setText(cins);
						kayitguncelle_txt_tel.setText(tel);
						kayitguncelle_txt_anneadi.setText(anne);
						kayitguncelle_txt_babaadi.setText(baba);
						kayitguncelle_txt_adres.setText(adres);
						kayitguncelle_sgk.setText(sgk);
						kayitguncelle_txt_il.setText(il);
						kayitguncelle_txt_ilce.setText(ilce);
						kayitguncelle_txt_sifre.setText(sifre);
						kayitguncelle_txt_mail.setText(mail);

					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}
		});

		kayitguncelle_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tc,ad,soyad,dtarihi,dyeri,adres,il,ilce,cins,anne,baba,sgk,tel2,mail,sifre2,sql_sorgu;

				tc =  kayitguncelle_tc.getText();
				ad = kayitguncelle_txt_ad.getText();
				soyad = kayitguncelle_txt_soyad.getText();
				dtarihi = kayitguncelle_dtarihi.getText();
				dyeri = kayitguncelle_txt_dyeri.getText();
				adres = kayitguncelle_txt_adres.getText();
				il = kayitguncelle_txt_il.getText();
				ilce = kayitguncelle_txt_ilce.getText();
				cins = kayitguncelle_cins.getText();
				tel2=  kayitguncelle_tel2.getText();
				anne = kayitguncelle_txt_anneadi.getText();
				baba = kayitguncelle_txt_babaadi.getText();
				sgk = kayitguncelle_sgk.getText();
				mail = kayitguncelle_txt_mail.getText();
				sifre2 = kayitguncelle_txt_sifre.getText();

				//hasta_ad,hasta_soyad,hasta_dyeri,hasta_dogum,hasta_adres,hasta_il,hasta_ilce,hasta_cins,hasta_tel,hasta_anne,hasta_baba,hasta_sgk,hasta_mail,hasta_sifre

				sql_sorgu = "UPDATE hastalar SET hasta_ad='"+ad+"',"+"hasta_soyad='"+soyad+"',hasta_dyeri='"+dyeri+"',hasta_dogum='"+dtarihi+"',hasta_adres='"+adres+"',"
						+ "hasta_il='"+il+"',hasta_ilce='"+ilce+"',hasta_cins='"+cins+"',hasta_tel='"+tel2+"',hasta_anne='"+anne+"',hasta_baba='"+sgk+"',hasta_mail='"+mail+"',hasta_sifre='"+sifre2+"' where hasta_tc="+tc+" ";

				System.out.println(sql_sorgu);
				JOptionPane.showMessageDialog(null, "Hasta bilgileri baþarýyla güncellenmiþtir.", "Güncelleme Baþarýlý", JOptionPane.INFORMATION_MESSAGE);

				baglanti.yap3();
				baglanti.update(sql_sorgu);
			}
		});
	}
}
