package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class hasta_panel extends JFrame {

	private JPanel contentPane;
	public kayit_guncelle kguncel = null;
	static String tc,ad,soyad,dyeri,dtarihi,cins,tel,id,saat1,r_tarih,oda,yatak;
	static JToggleButton[] btn = new JToggleButton[25];
	private JDateChooser randevu_tarihi;
	int sayac=0;
	ButtonGroup bg = new ButtonGroup();
	static String dr_id;
	static String hasta_id;
	static String klinik_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hasta_panel frame = new hasta_panel();
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


	public hasta_panel() {
		setTitle("Hasta Kontrol Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 937, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(26, 37, 444, 282);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel hpanel_1 = new JLabel("T.C. Kimlik No:");
		hpanel_1.setFont(new Font("Cambria", Font.BOLD, 19));
		hpanel_1.setBounds(12, 13, 130, 32);
		panel.add(hpanel_1);

		JLabel hpanel_2 = new JLabel("Adý Soyadý:");
		hpanel_2.setFont(new Font("Cambria", Font.BOLD, 19));
		hpanel_2.setBounds(12, 58, 130, 32);
		panel.add(hpanel_2);

		JLabel hpanel_3 = new JLabel("Doðum Yeri/Tarihi:");
		hpanel_3.setFont(new Font("Cambria", Font.BOLD, 19));
		hpanel_3.setBounds(12, 103, 186, 32);
		panel.add(hpanel_3);

		JLabel hpanel_4 = new JLabel("Cinsiyet:");
		hpanel_4.setFont(new Font("Cambria", Font.BOLD, 19));
		hpanel_4.setBounds(12, 148, 130, 32);
		panel.add(hpanel_4);

		JLabel hpanel_5 = new JLabel("Telefon No:");
		hpanel_5.setFont(new Font("Cambria", Font.BOLD, 19));
		hpanel_5.setBounds(12, 193, 130, 32);
		panel.add(hpanel_5);

		JLabel hpanel_tc = new JLabel(tc);
		hpanel_tc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hpanel_tc.setBounds(223, 23, 101, 16);
		panel.add(hpanel_tc);

		JLabel hpanel_adsoyad = new JLabel(ad + soyad);
		hpanel_adsoyad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hpanel_adsoyad.setBounds(223, 68, 163, 16);
		panel.add(hpanel_adsoyad);

		JLabel hpanel_dyeri = new JLabel(dyeri);
		hpanel_dyeri.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hpanel_dyeri.setBounds(223, 103, 90, 32);
		panel.add(hpanel_dyeri);

		JLabel hpanel_cins = new JLabel(cins);
		hpanel_cins.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hpanel_cins.setBounds(223, 158, 56, 16);
		panel.add(hpanel_cins);

		JLabel hpanel_tel = new JLabel(tel);
		hpanel_tel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hpanel_tel.setBounds(223, 203, 131, 16);
		panel.add(hpanel_tel);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 53, 417, 2);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 98, 417, 2);
		panel.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 142, 417, 2);
		panel.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 187, 417, 2);
		panel.add(separator_3);

		JLabel hpanel_dtarih = new JLabel(dtarihi);
		hpanel_dtarih.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hpanel_dtarih.setBounds(325, 113, 104, 16);
		panel.add(hpanel_dtarih);

		JLabel label = new JLabel("/");
		label.setBounds(306, 113, 18, 16);
		panel.add(label);


		JButton yenile = new JButton("");
		Image img4 = new ImageIcon(this.getClass().getResource("/yenile.png")).getImage();
		yenile.setBounds(398, 4, 40, 40);
		panel.add(yenile);
		yenile.setIcon(new ImageIcon(img4));

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(12, 232, 417, 2);
		panel.add(separator_5);

		JLabel hpanel_7 = new JLabel("Oda No:");
		hpanel_7.setFont(new Font("Cambria", Font.BOLD, 19));
		hpanel_7.setBounds(12, 238, 76, 32);
		panel.add(hpanel_7);

		JLabel hpanel_8 = new JLabel("Yatak No:");
		hpanel_8.setFont(new Font("Cambria", Font.BOLD, 19));
		hpanel_8.setBounds(223, 238, 90, 32);
		panel.add(hpanel_8);
		
		JLabel hpanel_oda = new JLabel("Yat\u0131l\u0131 De\u011Fil");
		hpanel_oda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hpanel_oda.setBounds(82, 242, 101, 24);
		panel.add(hpanel_oda);
		
		JLabel hpanel_yatak = new JLabel("Yat\u0131l\u0131 De\u011Fil");
		hpanel_yatak.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hpanel_yatak.setBounds(310, 242, 101, 24);
		panel.add(hpanel_yatak);

		JLabel hpanel_6 = new JLabel("Klinik:");
		hpanel_6.setFont(new Font("Cambria", Font.BOLD, 19));
		hpanel_6.setBounds(501, 35, 84, 24);
		contentPane.add(hpanel_6);

		JLabel lblDoktor = new JLabel("Doktor:");
		lblDoktor.setFont(new Font("Cambria", Font.BOLD, 19));
		lblDoktor.setBounds(501, 72, 84, 24);
		contentPane.add(lblDoktor);

		JLabel lblRandevuTarihi = new JLabel("Randevu Tarihi:");
		lblRandevuTarihi.setFont(new Font("Cambria", Font.BOLD, 19));
		lblRandevuTarihi.setBounds(501, 109, 147, 24);
		contentPane.add(lblRandevuTarihi);

		JLabel lblRandevuSaati = new JLabel("Randevu Saati:");
		lblRandevuSaati.setFont(new Font("Cambria", Font.BOLD, 19));
		lblRandevuSaati.setBounds(501, 146, 128, 24);
		contentPane.add(lblRandevuSaati);

		JComboBox klinik_cbox = new JComboBox();
		klinik_cbox.setBounds(661, 38, 231, 22);
		contentPane.add(klinik_cbox);
		klinik_cbox.setSelectedItem(null);


		JComboBox doktor_cbox = new JComboBox();
		doktor_cbox.setBounds(661, 75, 231, 22);
		contentPane.add(doktor_cbox);

		JDateChooser randevu_tarih = new JDateChooser();

		randevu_tarih.setBounds(660, 109, 232, 22);
		contentPane.add(randevu_tarih);

		Image image = new ImageIcon(this.getClass().getResource("/1randevu.png")).getImage();
		JLabel test_r = new JLabel("Randevu Geçmiþim");
		test_r.setFont(new Font("Cambria", Font.BOLD, 17));
		test_r.setVerticalTextPosition(SwingConstants.BOTTOM);
		test_r.setHorizontalTextPosition(SwingConstants.CENTER);
		test_r.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				randevu_gecmisi rgecmis = null;
				rgecmis = new randevu_gecmisi();
				rgecmis.setVisible(true);
			}
		});
		test_r.setBounds(12, 365, 153, 138);
		contentPane.add(test_r);
		test_r.setIcon(new ImageIcon(image));

		JLabel test_b = new JLabel("Bilgilerimi Güncelle");
		test_b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				kayit_guncelle kguncel = null;
				try {
					kguncel = new kayit_guncelle();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				kguncel.setVisible(true);
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/2bilgi.png")).getImage();
		test_b.setFont(new Font("Cambria", Font.BOLD, 17));
		test_b.setVerticalTextPosition(SwingConstants.BOTTOM);
		test_b.setHorizontalTextPosition(SwingConstants.CENTER);
		test_b.setBounds(177, 371, 153, 126);
		contentPane.add(test_b);
		test_b.setIcon(new ImageIcon(img2));

		JLabel test_c = new JLabel("Çýkýþ");
		test_c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				anasayfa_1 cyap = null;
				cyap = new anasayfa_1();
				cyap.setVisible(true);
				setVisible(false);
			}
		});

		test_c.setFont(new Font("Cambria", Font.BOLD, 17));
		Image img3 = new ImageIcon(this.getClass().getResource("/3cikis.png")).getImage();
		test_c.setVerticalTextPosition(SwingConstants.BOTTOM);
		test_c.setHorizontalTextPosition(SwingConstants.CENTER);
		test_c.setBounds(350, 380, 120, 108);
		contentPane.add(test_c);
		test_c.setIcon(new ImageIcon(img3));

		JButton randevu_al_buton = new JButton("ONAYLA");
		randevu_al_buton.setFont(new Font("Cambria", Font.BOLD, 22));

		randevu_al_buton.setBounds(762, 391, 130, 117);
		contentPane.add(randevu_al_buton);

		JLabel s_tarih = new JLabel("");
		s_tarih.setFont(new Font("Cambria", Font.BOLD, 15));
		s_tarih.setBounds(625, 459, 125, 16);
		contentPane.add(s_tarih);

		JLabel s_saat = new JLabel(""); 
		s_saat.setFont(new Font("Cambria", Font.BOLD, 15));
		s_saat.setBounds(625, 488, 125, 16);
		contentPane.add(s_saat);

		JLabel s_doktor = new JLabel("");
		s_doktor.setFont(new Font("Cambria", Font.BOLD, 15));
		s_doktor.setBounds(625, 430, 125, 16);
		contentPane.add(s_doktor);

		JLabel s_klinik = new JLabel("");
		s_klinik.setFont(new Font("Cambria", Font.BOLD, 15));
		s_klinik.setBounds(625, 401, 125, 16);
		contentPane.add(s_klinik);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(490, 375, 399, 2);
		contentPane.add(separator_4);

		JLabel label_s_klinik = new JLabel("Seçilen Klinik:");
		label_s_klinik.setForeground(Color.BLUE);
		label_s_klinik.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		label_s_klinik.setBounds(503, 401, 110, 16);
		contentPane.add(label_s_klinik);

		JLabel label_s_doktor = new JLabel("Seçilen Doktor:");
		label_s_doktor.setForeground(Color.BLUE);
		label_s_doktor.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		label_s_doktor.setBounds(503, 430, 126, 16);
		contentPane.add(label_s_doktor);

		JLabel label_s_tarih = new JLabel("Seçilen Tarih:");
		label_s_tarih.setForeground(Color.BLUE);
		label_s_tarih.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		label_s_tarih.setBounds(503, 459, 110, 16);
		contentPane.add(label_s_tarih);

		JLabel label_s_saat = new JLabel("Seçilen Saat:");
		label_s_saat.setForeground(Color.BLUE);
		label_s_saat.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		label_s_saat.setBounds(503, 488, 110, 16);
		contentPane.add(label_s_saat);

		JButton saat_goster = new JButton("Uygun Saatleri Göster");
		saat_goster.setFont(new Font("Cambria", Font.BOLD, 15));
		saat_goster.setBounds(661, 146, 231, 25);
		contentPane.add(saat_goster);

		ResultSet myRs2 = baglanti.cbox_veri_klinik();
		try {
			while(myRs2.next()){
				klinik_cbox.addItem(myRs2.getString("klinik_ismi"));
			}
		} catch (SQLException ex) {

		}
		ResultSet myRs3 = baglanti.cbox_veri_doktor();
		try {
			while(myRs3.next()){
				doktor_cbox.addItem(myRs3.getString("dr_ad"));
			}
		} catch (SQLException ex) {

		}
		klinik_cbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (klinik_cbox.getSelectedItem() != null) { 
					s_klinik.setText((String.valueOf(klinik_cbox.getSelectedItem())));
					s_klinik.setText((String.valueOf(klinik_cbox.getSelectedItem())));
					String sql_sorgu3 = "select klinik_id from klinikler where klinik_ismi='"+s_klinik.getText()+"' ";

					ResultSet myRs = baglanti.yap();
					myRs = baglanti.sorgula3(sql_sorgu3);
					try {
						while(myRs.next()) {
							klinik_id = myRs.getString("klinik_id");
						}
					} catch (SQLException e1) {					
						e1.printStackTrace();
					}
				}
			}
		});
		doktor_cbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (doktor_cbox.getSelectedItem() != null) { 
					s_doktor.setText((String.valueOf(doktor_cbox.getSelectedItem())));
					String sql_sorgu1 = "select dr_id from doktorlar where dr_ad='"+s_doktor.getText()+"' ";

					ResultSet myRs = baglanti.yap();
					myRs = baglanti.sorgula3(sql_sorgu1);
					try {
						while(myRs.next()) {
							dr_id = myRs.getString("dr_id");
						}
					} catch (SQLException e1) {					
						e1.printStackTrace();
					} 
				}
			}
		});

		String r_tarihi;
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String doktor = s_doktor.getText();
		String klinik = s_klinik.getText();


		ActionListener s_btn = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btn[0]){
					//btn[0].isSelected();
					s_saat.setText("09.00");
					s_tarih.setText(df.format(randevu_tarih.getDate()));	
				}
				if(e.getSource() == btn[1]){
					s_saat.setText("09.15");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[2]){
					s_saat.setText("09.30");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[3]){
					s_saat.setText("09.45");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[4]){
					s_saat.setText("10.00");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[5]){
					s_saat.setText("10.15");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[6]){
					s_saat.setText("10.30");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[7]){
					s_saat.setText("10.45");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[8]){
					s_saat.setText("11.00");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[9]){
					s_saat.setText("11.15");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[10]){
					s_saat.setText("11.30");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[11]){
					s_saat.setText("11.45");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[12]){
					s_saat.setText("12.00");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[13]){
					s_saat.setText("13.00");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}					
				if(e.getSource() == btn[14]){
					s_saat.setText("13.30");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[15]){
					s_saat.setText("14.00");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[16]){
					s_saat.setText("14.15");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[17]){
					s_saat.setText("14.30");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[18]){
					s_saat.setText("14.45");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[19]){
					s_saat.setText("15.00");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[20]){
					s_saat.setText("15.15");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[21]){
					s_saat.setText("16.00");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[22]){
					s_saat.setText("16.15");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[23]){
					s_saat.setText("16.30");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}
				if(e.getSource() == btn[24]){
					s_saat.setText("16.30");
					s_tarih.setText(df.format(randevu_tarih.getDate()));
				}	
			}
		};
		saat_goster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r_tarih = df.format(randevu_tarih.getDate());

				String sql_sorgu = "select randevu_saati from randevular where randevu_tarihi='"+r_tarih+"' and klinik_id='"+klinik_id+"' and dr_id='"+dr_id+"'";
				//"(select klinik_ad from klinik WHERE klinik_id = randevular.randev_id" ;
				System.out.println(sql_sorgu);

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);

				saat_goster.setEnabled(false);

				String[] saatler = {"09.00","09.15","09.30","09.45","10.00",
						"10.15","10.30","10.45","11.00","11.15",
						"11.30","11.45","12.00","13.00","13.30",
						"14.00","14.15","14.30","14.45","15.00",
						"15.15","15.30","16.00","16.15","16.30"};
				int sayac=0;
				for(int i=0; i<5; i++) {
					for(int j=0; j<5; j++) {

						btn[sayac] = new JToggleButton();
						btn[sayac].setBackground(Color.green);
						btn[sayac].setFont(new Font("Cambria", Font.BOLD, 12));
						btn[sayac].setText(saatler[sayac]);
						btn[sayac].setBounds((500 + j*77), (183+ i*38), 65, 25);
						contentPane.add(btn[sayac]);
						contentPane.revalidate();
						contentPane.repaint();
						sayac++;
					}
				}
				btn[0].addActionListener(s_btn);
				btn[1].addActionListener(s_btn);
				btn[2].addActionListener(s_btn);
				btn[3].addActionListener(s_btn);
				btn[4].addActionListener(s_btn);
				btn[5].addActionListener(s_btn);
				btn[6].addActionListener(s_btn);
				btn[7].addActionListener(s_btn);
				btn[8].addActionListener(s_btn);
				btn[9].addActionListener(s_btn);
				btn[10].addActionListener(s_btn);
				btn[11].addActionListener(s_btn);
				btn[12].addActionListener(s_btn);
				btn[13].addActionListener(s_btn);
				btn[14].addActionListener(s_btn);
				btn[15].addActionListener(s_btn);
				btn[16].addActionListener(s_btn);
				btn[17].addActionListener(s_btn);
				btn[18].addActionListener(s_btn);
				btn[19].addActionListener(s_btn);
				btn[20].addActionListener(s_btn);
				btn[21].addActionListener(s_btn);
				btn[22].addActionListener(s_btn);
				btn[23].addActionListener(s_btn);
				btn[24].addActionListener(s_btn);

				bg.add(btn[0]);
				bg.add(btn[1]);
				bg.add(btn[2]);
				bg.add(btn[3]);
				bg.add(btn[4]);
				bg.add(btn[5]);
				bg.add(btn[6]);
				bg.add(btn[7]);
				bg.add(btn[8]);
				bg.add(btn[9]);
				bg.add(btn[10]);
				bg.add(btn[11]);
				bg.add(btn[12]);
				bg.add(btn[13]);
				bg.add(btn[14]);
				bg.add(btn[15]);
				bg.add(btn[16]);
				bg.add(btn[17]);
				bg.add(btn[18]);
				bg.add(btn[19]);
				bg.add(btn[20]);
				bg.add(btn[21]);
				bg.add(btn[22]);
				bg.add(btn[23]);
				bg.add(btn[24]); 
				try {
					while(myRs.next()) {
						saat1 = myRs.getString("randevu_saati");	

						if(saat1.equals("09.00")) { 
							btn[0].setBackground(Color.RED);
							btn[0].setEnabled(false);
						}
						else if(saat1.equals("09.15")) { 
							btn[1].setBackground(Color.RED);
							btn[1].setEnabled(false);
						}
						else if(saat1.equals("09.30")) { 
							btn[2].setBackground(Color.RED);
							btn[2].setEnabled(false);
						}
						else if(saat1.equals("09.45")) { 
							btn[3].setBackground(Color.RED);
							btn[3].setEnabled(false);
						}
						else if(saat1.equals("10.00")) { 
							btn[4].setBackground(Color.RED);
							btn[4].setEnabled(false);
						}
						else if(saat1.equals("10.15")) { 
							btn[5].setBackground(Color.RED);
							btn[5].setEnabled(false);
						}
						else if(saat1.equals("10.30")) { 
							btn[6].setBackground(Color.RED);
							btn[6].setEnabled(false);
						}
						else if(saat1.equals("10.45")) {
							btn[7].setBackground(Color.RED);
							btn[7].setEnabled(false);
						}
						else if(saat1.equals("11.00")) {
							btn[8].setBackground(Color.RED);
							btn[8].setEnabled(false);
						}
						else if(saat1.equals("11.15")) { 
							btn[9].setBackground(Color.RED);
							btn[9].setEnabled(false);
						}
						else if(saat1.equals("11.30")) { 
							btn[10].setBackground(Color.RED);
							btn[10].setEnabled(false);
						}
						else if(saat1.equals("11.45")) { 
							btn[11].setBackground(Color.RED);
							btn[11].setEnabled(false);
						}
						else if(saat1.equals("12.00")) { 
							btn[12].setBackground(Color.RED);
							btn[12].setEnabled(false);
						}
						else if(saat1.equals("13.00")) { 
							btn[13].setBackground(Color.RED);
							btn[13].setEnabled(false);
						}
						else if(saat1.equals("13.30")) { 
							btn[14].setBackground(Color.RED);
							btn[14].setEnabled(false);
						}
						else if(saat1.equals("14.00")) { 
							btn[15].setBackground(Color.RED);
							btn[15].setEnabled(false);
						}
						else if(saat1.equals("14.15")) { 
							btn[16].setBackground(Color.RED);
							btn[16].setEnabled(false);
						}
						else if(saat1.equals("14.30")) { 
							btn[17].setBackground(Color.RED);
							btn[17].setEnabled(false);
						}
						else if(saat1.equals("14.45")) { 
							btn[18].setBackground(Color.RED);
							btn[18].setEnabled(false);
						}
						else if(saat1.equals("15.00")) { 
							btn[19].setBackground(Color.RED);
							btn[19].setEnabled(false);
						}
						else if(saat1.equals("15.15")) { 
							btn[20].setBackground(Color.RED);
							btn[20].setEnabled(false);
						}
						else if(saat1.equals("15.30")) { 
							btn[21].setBackground(Color.RED);
							btn[21].setEnabled(false);
						}
						else if(saat1.equals("16.00")) { 
							btn[22].setBackground(Color.RED);
							btn[22].setEnabled(false);
						}
						else if(saat1.equals("16.15")) { 
							btn[23].setBackground(Color.RED);
							btn[23].setEnabled(false);
						}
						else if(saat1.equals("16.30")) { 
							btn[24].setBackground(Color.RED);
							btn[24].setEnabled(false);
						}
						else {
							btn[5].setBackground(Color.GREEN);
							btn[5].setEnabled(true);
							System.out.println("yanlýþ");
						} 
					}
				} catch (SQLException e1) {					 
					e1.printStackTrace();
				}
			}
		});

		String sql_sorgu = "select hasta_id,hasta_ad,hasta_soyad,hasta_dyeri,hasta_dogum,hasta_cins,hasta_tel,ifnull(hasta_oda,'') as hasta_oda,ifnull(hasta_yatak,'') as hasta_yatak from hastalar where hasta_tc='"+anasayfa_1.tc+"' ";

		ResultSet myRs = baglanti.yap();
		myRs = baglanti.sorgula(sql_sorgu);

		try {
			while(myRs.next()) {
				id = myRs.getString("hasta_id");
				ad = myRs.getString("hasta_ad");
				soyad = myRs.getString("hasta_soyad");
				dtarihi = myRs.getString("hasta_dogum");
				dyeri = myRs.getString("hasta_dyeri");
				cins= myRs.getString("hasta_cins");
				tel = myRs.getString("hasta_tel");
				oda = myRs.getString("hasta_oda");
				yatak = myRs.getString("hasta_yatak");

				if(oda.equals("")) {
					hpanel_oda.setText("Yatýlý Deðil");
				}
				else {
					hpanel_oda.setText(oda);
				}
				
				if(yatak.equals("")) {
					hpanel_yatak.setText("Yatýlý Deðil");
				}
				else {
					hpanel_yatak.setText(yatak);
				}
				
				hpanel_tc.setText(anasayfa_1.tc);
				hpanel_adsoyad.setText(ad + " " + soyad);
				hpanel_dtarih.setText(dtarihi);
				hpanel_dyeri.setText(dyeri);
				hpanel_cins.setText(cins);
				hpanel_tel.setText(tel);

			}
		} catch (SQLException e1) {					
			e1.printStackTrace();
		}

		yenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql_sorgu = "select hasta_id,hasta_ad,hasta_soyad,hasta_dyeri,hasta_dogum,hasta_cins,hasta_tel,ifnull(hasta_oda,'') as hasta_oda,ifnull(hasta_yatak,'') as hasta_yatak from hastalar where hasta_tc='"+anasayfa_1.tc+"' ";

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);

				try {
					while(myRs.next()) {
						ad = myRs.getString("hasta_ad");
						soyad = myRs.getString("hasta_soyad");
						dtarihi = myRs.getString("hasta_dogum");
						dyeri = myRs.getString("hasta_dyeri");
						cins= myRs.getString("hasta_cins");
						tel = myRs.getString("hasta_tel");
						oda = myRs.getString("hasta_oda");
						yatak = myRs.getString("hasta_yatak");

						if(oda.equals("")) {
							hpanel_oda.setText("Yatýlý Deðil");
						}
						else {
							hpanel_oda.setText(oda);
						}
						
						if(yatak.equals("")) {
							hpanel_yatak.setText("Yatýlý Deðil");
						}
						else {
							hpanel_yatak.setText(yatak);
						}

						hpanel_tc.setText(anasayfa_1.tc);
						hpanel_adsoyad.setText(ad + " " + soyad);
						hpanel_dtarih.setText(dtarihi);
						hpanel_dyeri.setText(dyeri);
						hpanel_cins.setText(cins);
						hpanel_tel.setText(tel);
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}
		});
		randevu_al_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sql_sorgu1 = "select dr_id from doktorlar where dr_ad='"+doktor+"' ";
				String sql_sorgu2 = "select hasta_id from hastalar where hasta_tc='"+anasayfa_1.tc+"' ";
				String sql_sorgu3 = "select klinik_id from klinikler where klinik_ismi='"+klinik+"' ";
				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula3(sql_sorgu1);
				myRs = baglanti.sorgula3(sql_sorgu2);
				myRs = baglanti.sorgula3(sql_sorgu3);

				try {
					while(myRs.next()) {
						dr_id = myRs.getString("dr_id");

					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				} 
				try {
					while(myRs.next()) {
						hasta_id = myRs.getString("hasta_id");
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				try {
					while(myRs.next()) {
						klinik_id = myRs.getString("klinik_id");
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				String sqlsorgu = "INSERT INTO randevular (randevu_tarihi,randevu_saati,dr_id,hasta_id,klinik_id) "
						+ "VALUES ('"+ s_tarih.getText() + "'" + ",'" + s_saat.getText() + "'," + "'" + dr_id + "'," + "'" + id + "'," + "'" + klinik_id + "')";

				baglanti.ekle(sqlsorgu);
				System.out.println(sqlsorgu);

				JOptionPane.showMessageDialog(null, "Randevunuz baþarýyla kaydedilmiþtir. Lütfen randevu saatinden 15dk önce hazýr olunuz.", "Randevu Alma Baþarýlý", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		randevu_tarih.getCalendarButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					saat_goster.setEnabled(true);
					int sayac= 0;
					for(int i=0; i<5; i++) {
						for(int j=0; j<5; j++) {
							contentPane.remove(btn[sayac]);
							contentPane.revalidate();
							contentPane.repaint();
							sayac++;
						}
					}
				}
				catch (NullPointerException e4) {
					System.out.println("");
				}
			}
		});
	}
}
