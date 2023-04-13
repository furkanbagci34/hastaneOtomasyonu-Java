package h_oto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class doktor_panel extends JFrame {

	private JPanel contentPane;
	DefaultTableModel r_liste = new DefaultTableModel();
	static String d_id,dr_adsoyad;
	Object[] r_kolon = {"Hasta Adý Soyadý","Randevu Tarihi","Randevu Saati"};
	Object[] r_satir = new Object[3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doktor_panel frame = new doktor_panel();
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
	public doktor_panel() {
		setTitle("Doktor Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 200, 705, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JMenuItem mnýtmNewMenuItem = new JMenuItem("Reçete Yaz");
		mnýtmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recete_yaz r_yaz = null;
				r_yaz = new recete_yaz();
				r_yaz.setVisible(true);
			}
		});
		mnýtmNewMenuItem.setFont(new Font("Cambria", Font.PLAIN, 18));
		hasta_menu.add(mnýtmNewMenuItem);
		
		JMenuItem mnýtmNewMenuItem_1 = new JMenuItem("Reçete Görüntüle");
		mnýtmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recete_goruntule r_gor = null;
				r_gor = new recete_goruntule();
				r_gor.setVisible(true);
			}
		});
		mnýtmNewMenuItem_1.setFont(new Font("Cambria", Font.PLAIN, 18));
		hasta_menu.add(mnýtmNewMenuItem_1);
		Image s2 = new ImageIcon(this.getClass().getResource("/doktor.png")).getImage();
		Image s3 = new ImageIcon(this.getClass().getResource("/bilgi.png")).getImage();
		
		JMenu randevu_menu = new JMenu("Randevu");
		randevu_menu.setForeground(Color.BLACK);
		randevu_menu.setFont(new Font("Cambria", Font.BOLD, 23));
		menuBar.add(randevu_menu);
		Image s4 = new ImageIcon(this.getClass().getResource("/randevuu.png")).getImage();
		randevu_menu.setIcon(new ImageIcon(s4));
		
		JMenuItem mnýtmRandevuSorgula = new JMenuItem("Randevularýmý Listele");
		mnýtmRandevuSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doktor_randevular d_rand = null;
				d_rand = new doktor_randevular();
				d_rand.setVisible(true);
			}
		});
		mnýtmRandevuSorgula.setFont(new Font("Cambria", Font.PLAIN, 18));
		randevu_menu.add(mnýtmRandevuSorgula);
		
		JMenu lab_menu = new JMenu("Laboratuvar");
		lab_menu.setForeground(Color.BLACK);
		lab_menu.setFont(new Font("Cambria", Font.BOLD, 23));
		menuBar.add(lab_menu);
		Image s5 = new ImageIcon(this.getClass().getResource("/lab.png")).getImage();
		lab_menu.setIcon(new ImageIcon(s5));
		
		JMenuItem mnýtmSonuSorgula = new JMenuItem("Sonuç Gir");
		mnýtmSonuSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lab_sonuc_gir lab_son = null;
				lab_son = new lab_sonuc_gir();
				lab_son.setVisible(true);
			}
		});
		mnýtmSonuSorgula.setFont(new Font("Cambria", Font.PLAIN, 18));
		lab_menu.add(mnýtmSonuSorgula);
		
		JMenuItem mnýtmNewMenuItem_2 = new JMenuItem("Sonuç Sorgula");
		mnýtmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sonuc_sorgula s_sor = null;
				s_sor = new sonuc_sorgula();
				s_sor.setVisible(true);
			}
		});
		mnýtmNewMenuItem_2.setFont(new Font("Cambria", Font.PLAIN, 18));
		lab_menu.add(mnýtmNewMenuItem_2);
		
		JMenu cikis_menu = new JMenu("Çýkýþ");
		cikis_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				anasayfa_1 cyap = null;
				cyap = new anasayfa_1();
				cyap.setVisible(true);
				setVisible(false);
			}
		});
		
		JMenu klinik_menu = new JMenu("Bilgilerim");
		klinik_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				doktor_bilgi_guncelle d_bilgi = null;
				try {
					d_bilgi = new doktor_bilgi_guncelle();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				d_bilgi.setVisible(true);
			}
		});
		klinik_menu.setForeground(Color.BLACK);
		klinik_menu.setFont(new Font("Cambria", Font.BOLD, 23));
		menuBar.add(klinik_menu);
		klinik_menu.setIcon(new ImageIcon(s3));
		cikis_menu.setForeground(Color.BLACK);
		cikis_menu.setFont(new Font("Cambria", Font.BOLD, 23));
		menuBar.add(cikis_menu);
		Image s7 = new ImageIcon(this.getClass().getResource("/cikis.png")).getImage();
		cikis_menu.setIcon(new ImageIcon(s7));
		
		JLabel label = new JLabel("Yapmak istedi\u011Finiz i\u015Flemi men\u00FCler aray\u0131c\u0131l\u0131\u011F\u0131 ile kolayl\u0131kla yapabilirsiniz!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		label.setBounds(0, 364, 688, 41);
		contentPane.add(label);
		
		JLabel dr_resim = new JLabel("");
		dr_resim.setHorizontalAlignment(SwingConstants.CENTER);
		dr_resim.setBounds(0, 175, 688, 100);
		contentPane.add(dr_resim);
		Image s8 = new ImageIcon(this.getClass().getResource("/dr2.png")).getImage();
		dr_resim.setIcon(new ImageIcon(s8));
		
		
		//contentPane.add(table);
		r_liste.setColumnIdentifiers(r_kolon);
		r_liste.addRow(r_satir);
		
		String sql_sorgu = "SELECT dr_id,CONCAT(dr_ad,' ',dr_soyad) as dr_adsoyad from doktorlar where dr_tc='"+anasayfa_1.tc1+"' ";
		ResultSet myRs = baglanti.yap();
		myRs = baglanti.sorgula(sql_sorgu);

		try {
			while(myRs.next()) {
				d_id = myRs.getString("dr_id");
				dr_adsoyad = myRs.getString("dr_adsoyad");
				
			}
		} catch (SQLException e1) {					
			e1.printStackTrace();
		}
		JLabel lblDoktorYnetimPaneline = new JLabel("Hoþgeldiniz Sayýn " + dr_adsoyad + "!");
		lblDoktorYnetimPaneline.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoktorYnetimPaneline.setFont(new Font("Cambria", Font.BOLD, 23));
		lblDoktorYnetimPaneline.setBounds(0, 123, 688, 28);
		contentPane.add(lblDoktorYnetimPaneline);
	}
}
