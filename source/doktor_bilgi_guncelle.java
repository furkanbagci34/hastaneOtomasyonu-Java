package h_oto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class doktor_bilgi_guncelle extends JFrame {

	private JPanel contentPane;
	
	private JTextField doktor_txt_ad;
	private JTextField doktor_txt_soyad;
	private JTextField doktor_txt_il;
	private JTextField doktor_txt_alan;
	private JTextField doktor_txt_ilce;

	MaskFormatter tel2;

	String tel;
	static String ad,soyad,dogum,alan,il,ilce,sifre;
	private JTextField doktor_txt_sifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doktor_bilgi_guncelle frame = new doktor_bilgi_guncelle();
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
	public doktor_bilgi_guncelle() throws ParseException {
		setTitle("Doktor Bilgilerimi Güncelle");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(650, 200, 545, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tel2 = new MaskFormatter("(05##)-###-##-##");

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

		JLabel kayit_label_il = new JLabel("Ýl:");
		kayit_label_il.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_il.setBounds(47, 201, 114, 25);
		contentPane.add(kayit_label_il);

		JLabel kayit_label_ilce = new JLabel("Ýlçe:");
		kayit_label_ilce.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_ilce.setBounds(47, 239, 114, 25);
		contentPane.add(kayit_label_ilce);

		JLabel kayit_label_cins = new JLabel("Cinsiyet:");
		kayit_label_cins.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_cins.setBounds(47, 277, 114, 25);
		contentPane.add(kayit_label_cins);

		JLabel kayit_label_tel = new JLabel("Telefon:");
		kayit_label_tel.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_tel.setBounds(47, 315, 114,25);
		contentPane.add(kayit_label_tel);

		JLabel kayit_label_anne = new JLabel("Doktor Bölüm");
		kayit_label_anne.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_anne.setBounds(47, 163, 114, 25);
		contentPane.add(kayit_label_anne);

		JButton dr_guncelle_buton = new JButton("GÜNCELLE");
		dr_guncelle_buton.setFont(new Font("Cambria", Font.PLAIN, 19));
		dr_guncelle_buton.setBounds(346, 418, 130, 31);
		contentPane.add(dr_guncelle_buton);

		JSeparator separator = new JSeparator();
		separator.setBounds(48, 400, 428, 5);
		contentPane.add(separator);

		doktor_txt_ad = new JTextField(ad);
		doktor_txt_ad.setBounds(226, 51, 250, 25);
		contentPane.add(doktor_txt_ad);
		doktor_txt_ad.setColumns(10);

		doktor_txt_soyad = new JTextField(soyad);
		doktor_txt_soyad.setColumns(10);
		doktor_txt_soyad.setBounds(226, 89, 250, 25);
		contentPane.add(doktor_txt_soyad);

		doktor_txt_il = new JTextField(il);
		doktor_txt_il.setColumns(10);
		doktor_txt_il.setBounds(226, 203, 250, 25);
		contentPane.add(doktor_txt_il);

		doktor_txt_alan = new JTextField(alan);
		doktor_txt_alan.setColumns(10);
		doktor_txt_alan.setBounds(226, 165, 250, 25);
		contentPane.add(doktor_txt_alan);

		JFormattedTextField doktor_txt_tel = new JFormattedTextField(tel2);
		doktor_txt_tel.setBounds(226, 319, 250, 25);
		contentPane.add(doktor_txt_tel);

		doktor_txt_ilce = new JTextField(ilce);
		doktor_txt_ilce.setColumns(10);
		doktor_txt_ilce.setBounds(226, 241, 250, 25);
		contentPane.add(doktor_txt_ilce);

		JLabel kayit_label_sifre = new JLabel("Þifre:");
		kayit_label_sifre.setFont(new Font("Cambria", Font.PLAIN, 18));
		kayit_label_sifre.setBounds(47, 353, 114, 25);
		contentPane.add(kayit_label_sifre);

		JComboBox doktor_combo_cins = new JComboBox();
		doktor_combo_cins.setModel(new DefaultComboBoxModel(new String[] {"Cinsiyet Seçiniz...", "Erkek", "Kadýn"}));
		doktor_combo_cins.setBounds(226, 279, 250, 25);
		contentPane.add(doktor_combo_cins);
		
		JDateChooser dr_dogum = new JDateChooser();
		dr_dogum.setBounds(226, 128, 250, 25);
		contentPane.add(dr_dogum);
		
		JLabel doktor_tc = new JLabel(anasayfa_1.tc1);
		doktor_tc.setFont(new Font("Cambria", Font.PLAIN, 18));
		doktor_tc.setBounds(226, 11, 250, 25);
		contentPane.add(doktor_tc);
		
		doktor_txt_sifre = new JTextField(sifre);
		doktor_txt_sifre.setColumns(10);
		doktor_txt_sifre.setBounds(226, 357, 250, 25);
		contentPane.add(doktor_txt_sifre);
		
		JLabel guncelleme_basarili = new JLabel("Bilgileriniz Güncellendi!");
		guncelleme_basarili.setForeground(Color.RED);
		guncelleme_basarili.setFont(new Font("Cambria", Font.BOLD, 21));
		guncelleme_basarili.setBounds(47, 419, 238, 27);
		contentPane.add(guncelleme_basarili);
		guncelleme_basarili.setVisible(false);
		
		
		  String sql_sorgu = "select dr_ad,dr_soyad,dr_dogum,dr_alan,dr_il,dr_ilce,dr_tel,dr_sifre from doktorlar where dr_tc='"+anasayfa_1.tc1+"' ";

		ResultSet myRs = baglanti.yap();
		myRs = baglanti.sorgula(sql_sorgu);

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");


		try {
			while(myRs.next()) {

				ad = myRs.getString("dr_ad");
				soyad = myRs.getString("dr_soyad");
				dogum = myRs.getString("dr_dogum");
				il = myRs.getString("dr_il");
				ilce = myRs.getString("dr_ilce");
				tel = myRs.getString("dr_tel");
				sifre = myRs.getString("dr_sifre");


				doktor_tc.setText(anasayfa_1.tc1);
				doktor_txt_ad.setText(ad);
				doktor_txt_soyad.setText(soyad);
				doktor_txt_tel.setText(tel);
				doktor_txt_il.setText(il);
				doktor_txt_ilce.setText(ilce);
				doktor_txt_sifre.setText(sifre);


			}
		} catch (SQLException e1) {					
			e1.printStackTrace();
		} 
		
		dr_guncelle_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String tc,ad,soyad,dogum,dyeri,adres,il,ilce,cins,tel2,sifre2,sql_sorgu;
				

				ad =doktor_txt_ad.getText();
				soyad = doktor_txt_soyad.getText();
				dogum = df.format(dr_dogum.getDate());
				il = doktor_txt_il.getText();
				ilce = doktor_txt_ilce.getText();
				cins =	doktor_combo_cins.getSelectedItem().toString();	
				tel2=  doktor_txt_tel.getText();
				sifre2 = doktor_txt_sifre.getText();

				//hasta_ad,hasta_soyad,hasta_dyeri,hasta_dogum,hasta_adres,hasta_il,hasta_ilce,hasta_cins,hasta_tel,hasta_anne,hasta_baba,hasta_sgk,hasta_mail,hasta_sifre

				sql_sorgu = "UPDATE doktorlar SET dr_ad='"+ad+"',"+"dr_soyad='"+soyad+"',dr_dogum='"+dogum+"',"
						+ "dr_il='"+il+"',dr_ilce='"+ilce+"',dr_cins='"+cins+"',dr_tel="+tel2+",dr_sifre='"+sifre2+"' where dr_tc="+anasayfa_1.tc1+" ";
	
				guncelleme_basarili.setVisible(true);
				dr_guncelle_buton.setVisible(false);
				
				baglanti.yap();
				baglanti.update(sql_sorgu);
				
			}
		});
	}
}
