package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class supervizor_panel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supervizor_panel frame = new supervizor_panel();
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
	public supervizor_panel() {
		setTitle("S�perviz�r");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 775, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title_1 = new JLabel("T.C. SA�LIK BAKANLI�I");
		title_1.setHorizontalAlignment(SwingConstants.CENTER);
		title_1.setFont(new Font("Cambria", Font.BOLD, 23));
		title_1.setBounds(0, 117, 757, 28);
		contentPane.add(title_1);
		JLabel title_2 = new JLabel("KONYA NUMUNE HASTANES�");
		title_2.setHorizontalAlignment(SwingConstants.CENTER);
		title_2.setFont(new Font("Cambria", Font.BOLD, 23));
		title_2.setBounds(0, 145, 757, 28);
		contentPane.add(title_2);
		JLabel title_3 = new JLabel("Y�NET�M PANEL�");
		title_3.setHorizontalAlignment(SwingConstants.CENTER);
		title_3.setFont(new Font("Cambria", Font.BOLD, 23));
		title_3.setBounds(0, 172, 757, 28);
		contentPane.add(title_3);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Cambria", Font.BOLD, 20));
		menuBar.setBounds(0, 0, 757, 48);
		contentPane.add(menuBar);
		
		JMenu hasta_menu = new JMenu("Hasta");
		hasta_menu.setFont(new Font("Cambria", Font.BOLD, 23));
		hasta_menu.setForeground(Color.BLACK);
		menuBar.add(hasta_menu);
		Image s1 = new ImageIcon(this.getClass().getResource("/hasta.png")).getImage();
		hasta_menu.setIcon(new ImageIcon(s1));
		
		JMenuItem mn�tmNewMenuItem = new JMenuItem("Bilgilerini ��ren(TC)");
		mn�tmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h_bilgi h_bilg = null;
				h_bilg = new h_bilgi();
				h_bilg.setVisible(true);
			}
		});
		mn�tmNewMenuItem.setFont(new Font("Cambria", Font.PLAIN, 18));
		hasta_menu.add(mn�tmNewMenuItem);
		
		JMenuItem mn�tmNewMenuItem_1 = new JMenuItem("Oda Bilgisi Gir");
		mn�tmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h_oda_gir h_oda_g = null;
				h_oda_g = new h_oda_gir();
				h_oda_g.setVisible(true);
			}
		});
		
		JMenuItem mn�tmBilgilerinirenisim = new JMenuItem("Bilgilerini ��ren(�sim)");
		mn�tmBilgilerinirenisim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isim_h_bilgi i_h_bilg = null;
				i_h_bilg = new isim_h_bilgi();
				i_h_bilg.setVisible(true);
			}
		});
		mn�tmBilgilerinirenisim.setFont(new Font("Cambria", Font.PLAIN, 18));
		hasta_menu.add(mn�tmBilgilerinirenisim);
		mn�tmNewMenuItem_1.setFont(new Font("Cambria", Font.PLAIN, 18));
		hasta_menu.add(mn�tmNewMenuItem_1);
		
		JMenuItem mn�tmNewMenuItem_2 = new JMenuItem("Oda No ��ren(TC)");
		mn�tmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h_oda_ogren h_oda_og = null;
				h_oda_og = new h_oda_ogren();
				h_oda_og.setVisible(true);
			}
		});
		mn�tmNewMenuItem_2.setFont(new Font("Cambria", Font.PLAIN, 18));
		hasta_menu.add(mn�tmNewMenuItem_2);
		
		JMenuItem mn�tmOdaNorenisim = new JMenuItem("Oda No ��ren(�sim)");
		mn�tmOdaNorenisim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h_oda_ogren_isim h_oda_isim = null;
				h_oda_isim = new h_oda_ogren_isim();
				h_oda_isim.setVisible(true);
			}
		});
		mn�tmOdaNorenisim.setFont(new Font("Cambria", Font.PLAIN, 18));
		hasta_menu.add(mn�tmOdaNorenisim);
		
		JMenu doktor_menu = new JMenu("Doktor");
		doktor_menu.setForeground(Color.BLACK);
		doktor_menu.setFont(new Font("Cambria", Font.BOLD, 23));
		menuBar.add(doktor_menu);
		Image s2 = new ImageIcon(this.getClass().getResource("/doktor.png")).getImage();
		doktor_menu.setIcon(new ImageIcon(s2));
		
		JMenuItem mn�tmNewMenuItem_4 = new JMenuItem("Doktor Ekle");
		mn�tmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doktor_ekle d_ekle = null;
				d_ekle = new doktor_ekle();
				d_ekle.setVisible(true);
			}
		});
		mn�tmNewMenuItem_4.setFont(new Font("Cambria", Font.PLAIN, 18));
		doktor_menu.add(mn�tmNewMenuItem_4);
		
		JMenu klinik_menu = new JMenu("Klinik");
		klinik_menu.setForeground(Color.BLACK);
		klinik_menu.setFont(new Font("Cambria", Font.BOLD, 23));
		menuBar.add(klinik_menu);
		Image s3 = new ImageIcon(this.getClass().getResource("/klinik.png")).getImage();
		klinik_menu.setIcon(new ImageIcon(s3));
		
		JMenuItem mn�tmKlinikEkle = new JMenuItem("Klinik Ekle");
		mn�tmKlinikEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				klinik_ekle k_ekle = null;
				k_ekle = new klinik_ekle();
				k_ekle.setVisible(true);
			}
		});

		mn�tmKlinikEkle.setFont(new Font("Cambria", Font.PLAIN, 18));
		klinik_menu.add(mn�tmKlinikEkle);
		
		JMenu randevu_menu = new JMenu("Randevu");
		randevu_menu.setForeground(Color.BLACK);
		randevu_menu.setFont(new Font("Cambria", Font.BOLD, 23));
		menuBar.add(randevu_menu);
		Image s4 = new ImageIcon(this.getClass().getResource("/randevuu.png")).getImage();
		randevu_menu.setIcon(new ImageIcon(s4));
		
		JMenuItem mn�tmRandevuSorgula = new JMenuItem("Randevu Sorgula");
		mn�tmRandevuSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randevu_sorgula r_sorgu = null;
				r_sorgu = new randevu_sorgula();
				r_sorgu.setVisible(true);
			}
		});
		mn�tmRandevuSorgula.setFont(new Font("Cambria", Font.PLAIN, 18));
		randevu_menu.add(mn�tmRandevuSorgula);
		
		JMenuItem mn�tmIkiTarihAras = new JMenuItem("�ki Tarih Aras� Randevular");
		mn�tmIkiTarihAras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iki_tarih_aras� iki_tarih = null;
				iki_tarih = new iki_tarih_aras�();
				iki_tarih.setVisible(true);
			}
		});
		mn�tmIkiTarihAras.setFont(new Font("Cambria", Font.PLAIN, 18));
		randevu_menu.add(mn�tmIkiTarihAras);
		
		JMenuItem mn�tmDoktorlaraGreToplam = new JMenuItem("Doktor Randevu Say�s�(Toplam)");
		mn�tmDoktorlaraGreToplam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dr_toplam_randevu dr_toplam = null;
				dr_toplam = new dr_toplam_randevu();
				dr_toplam.setVisible(true);
			}
		});
		mn�tmDoktorlaraGreToplam.setFont(new Font("Cambria", Font.PLAIN, 18));
		randevu_menu.add(mn�tmDoktorlaraGreToplam);
		
		JMenuItem mn�tmDoktorRandevuSays = new JMenuItem("Doktor Randevu Say�s�(2 Tarih)");
		mn�tmDoktorRandevuSays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dr_iki_tariharasi_randevu dr_iki = null;
				dr_iki = new dr_iki_tariharasi_randevu();
				dr_iki.setVisible(true);
			}
		});
		mn�tmDoktorRandevuSays.setFont(new Font("Cambria", Font.PLAIN, 18));
		randevu_menu.add(mn�tmDoktorRandevuSays);
		
		JMenu lab_menu = new JMenu("Laboratuvar");
		lab_menu.setForeground(Color.BLACK);
		lab_menu.setFont(new Font("Cambria", Font.BOLD, 23));
		menuBar.add(lab_menu);
		Image s5 = new ImageIcon(this.getClass().getResource("/lab.png")).getImage();
		lab_menu.setIcon(new ImageIcon(s5));
		
		JMenuItem mn�tmSonuSorgula = new JMenuItem("Sonu� Sorgula");
		mn�tmSonuSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sonuc_sorgula s_sorgu = null;
				s_sorgu = new sonuc_sorgula();
				s_sorgu.setVisible(true);
			}
		});
		mn�tmSonuSorgula.setFont(new Font("Cambria", Font.PLAIN, 18));
		lab_menu.add(mn�tmSonuSorgula);
		
		JMenu cikis_menu = new JMenu("��k��");
		cikis_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				anasayfa_1 cyap = null;
				cyap = new anasayfa_1();
				cyap.setVisible(true);
				setVisible(false);
			}
		});
		cikis_menu.setForeground(Color.BLACK);
		cikis_menu.setFont(new Font("Cambria", Font.BOLD, 23));
		menuBar.add(cikis_menu);
		Image s7 = new ImageIcon(this.getClass().getResource("/cikis.png")).getImage();
		cikis_menu.setIcon(new ImageIcon(s7));
		
		JLabel adminresim = new JLabel("");
		adminresim.setHorizontalAlignment(SwingConstants.CENTER);
		adminresim.setBounds(0, 213, 757, 100);
		contentPane.add(adminresim);
		Image s6 = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		adminresim.setIcon(new ImageIcon(s6));
		
		JLabel txt = new JLabel("Yapmak istedi�iniz i�lemi men�ler aray�c�l��� ile kolayl�kla yapabilirsiniz!");
		txt.setForeground(Color.BLUE);
		txt.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setBounds(0, 351, 757, 41);
		contentPane.add(txt);

	}
}
