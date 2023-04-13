package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class anasayfa_1 extends JFrame {

	private JPanel contentPane;
	private JTextField giris_hasta_tc;
	private JPasswordField giris_hasta_sifre;
	private JTextField giris_doktor_tc;
	private JPasswordField giris_doktor_sifre;
	private JTextField giris_admin_id;
	private JPasswordField giris_admin_sifre;
	static String tc,tc1;
	static String sifre2;
	static String giris;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anasayfa_1 frame = new anasayfa_1();
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
	public anasayfa_1() {
		setBackground(new Color(0, 255, 255));
		setTitle("Anasayfa - Giriþ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 848, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(204, 255, 255));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setFont(new Font("Cambria", Font.BOLD, 22));
		tabbedPane.setBounds(188, 274, 440, 266);
		contentPane.add(tabbedPane);

		JPanel hasta_giris = new JPanel();

		hasta_giris.setBackground(new Color(204, 255, 255));
		tabbedPane.addTab("Hasta Giriþi", null, hasta_giris, null);
		hasta_giris.setLayout(null);

		JLabel label = new JLabel("TC Kimlik No:");
		label.setFont(new Font("Cambria", Font.PLAIN, 19));
		label.setBounds(44, 41, 130, 32);
		hasta_giris.add(label);

		JLabel label_1 = new JLabel("Þifre:");
		label_1.setFont(new Font("Cambria", Font.PLAIN, 19));
		label_1.setBounds(44, 86, 85, 24);
		hasta_giris.add(label_1);

		giris_hasta_tc = new JTextField();
		giris_hasta_tc.setColumns(10);
		giris_hasta_tc.setBounds(208, 43, 180, 32);
		hasta_giris.add(giris_hasta_tc);

		giris_hasta_sifre = new JPasswordField();
		giris_hasta_sifre.setBounds(208, 86, 180, 32);
		hasta_giris.add(giris_hasta_sifre);

		JButton kayit_ol_button = new JButton("KAYIT OL");
		kayit_ol_button.setFont(new Font("Cambria", Font.PLAIN, 19));
		kayit_ol_button.setBounds(44, 142, 130, 32);
		hasta_giris.add(kayit_ol_button);

		JButton hasta_giris_buton = new JButton("GÝRÝÞ");
		hasta_giris_buton.setFont(new Font("Cambria", Font.PLAIN, 19));
		hasta_giris_buton.setBounds(246, 142, 130, 32);
		hasta_giris.add(hasta_giris_buton);
		
		JButton sifreunuttum_buton = new JButton("ÞÝFREMÝ UNUTTUM");
		sifreunuttum_buton.setFont(new Font("Cambria", Font.PLAIN, 19));
		sifreunuttum_buton.setBounds(108, 187, 204, 32);
		hasta_giris.add(sifreunuttum_buton);

		JPanel doktor_giris = new JPanel();
		doktor_giris.setBackground(new Color(204, 255, 255));
		tabbedPane.addTab("Doktor Giriþi", null, doktor_giris, null);
		doktor_giris.setLayout(null);

		JLabel label_2 = new JLabel("TC Kimlik No:");
		label_2.setFont(new Font("Cambria", Font.PLAIN, 19));
		label_2.setBounds(44, 39, 130, 32);
		doktor_giris.add(label_2);

		JLabel label_3 = new JLabel("Þifre:");
		label_3.setFont(new Font("Cambria", Font.PLAIN, 19));
		label_3.setBounds(44, 88, 85, 24);
		doktor_giris.add(label_3);

		giris_doktor_tc = new JTextField();
		giris_doktor_tc.setColumns(10);
		giris_doktor_tc.setBounds(214, 41, 180, 32);
		doktor_giris.add(giris_doktor_tc);

		giris_doktor_sifre = new JPasswordField();
		giris_doktor_sifre.setBounds(214, 86, 180, 32);
		doktor_giris.add(giris_doktor_sifre);

		JButton doktor_giris_buton = new JButton("GÝRÝÞ");
		doktor_giris_buton.setFont(new Font("Cambria", Font.PLAIN, 19));
		doktor_giris_buton.setBounds(143, 144, 130, 32);
		doktor_giris.add(doktor_giris_buton);

		JLabel sifre_hata_doktor = new JLabel("ID ya da Þifre Hatalý!");
		sifre_hata_doktor.setForeground(Color.RED);
		sifre_hata_doktor.setFont(new Font("Cambria", Font.BOLD, 20));
		sifre_hata_doktor.setBounds(117, 189, 219, 29);
		doktor_giris.add(sifre_hata_doktor);

		sifre_hata_doktor.setVisible(false);

		JPanel admin_giris = new JPanel();
		admin_giris.setBackground(new Color(204, 255, 255));
		tabbedPane.addTab("Süpervizör", null, admin_giris, null);
		admin_giris.setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Cambria", Font.PLAIN, 19));
		lblId.setBounds(87, 35, 61, 32);
		admin_giris.add(lblId);

		JLabel lblifre = new JLabel("Þifre:");
		lblifre.setFont(new Font("Cambria", Font.PLAIN, 19));
		lblifre.setBounds(87, 80, 69, 32);
		admin_giris.add(lblifre);

		giris_admin_id = new JTextField();
		giris_admin_id.setColumns(10);
		giris_admin_id.setBounds(168, 37, 180, 32);
		admin_giris.add(giris_admin_id);

		giris_admin_sifre = new JPasswordField();
		giris_admin_sifre.setBounds(168, 82, 180, 32);
		admin_giris.add(giris_admin_sifre);

		JButton admin_giris_buton = new JButton("GÝRÝÞ");

		admin_giris_buton.setFont(new Font("Cambria", Font.PLAIN, 19));
		admin_giris_buton.setBounds(155, 140, 130, 32);
		admin_giris.add(admin_giris_buton);

		JLabel sifre_hata_admin = new JLabel("ID ya da Þifre Hatalý!");
		sifre_hata_admin.setForeground(Color.RED);
		sifre_hata_admin.setFont(new Font("Cambria", Font.BOLD, 20));
		sifre_hata_admin.setBounds(131, 184, 219, 29);
		admin_giris.add(sifre_hata_admin);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(12, 13, 806, 160);
		contentPane.add(logo);
		
		JLabel title_1 = new JLabel("T.C. SAÐLIK BAKANLIÐI");
		title_1.setHorizontalAlignment(SwingConstants.CENTER);
		title_1.setFont(new Font("Cambria", Font.BOLD, 23));
		title_1.setBounds(12, 191, 806, 28);
		contentPane.add(title_1);
		JLabel title_2 = new JLabel("KONYA NUMUNE HASTANESÝ");
		title_2.setHorizontalAlignment(SwingConstants.CENTER);
		title_2.setFont(new Font("Cambria", Font.BOLD, 23));
		title_2.setBounds(12, 215, 806, 28);
		contentPane.add(title_2);
		JLabel title_3 = new JLabel("HASTA KAYIT PROGRAMI");
		title_3.setHorizontalAlignment(SwingConstants.CENTER);
		title_3.setFont(new Font("Cambria", Font.BOLD, 23));
		title_3.setBounds(12, 239, 806, 28);
		contentPane.add(title_3);//198, 191, 450, 28
		sifre_hata_admin.setVisible(false);
		


		kayit_ol_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kayit_ol k_ol = null;
				try {
					k_ol = new kayit_ol();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				k_ol.setVisible(true);
			}
		});

		hasta_giris_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tc = giris_hasta_tc.getText();
				char[] sifre = giris_hasta_sifre.getPassword();
				sifre2 = String.valueOf(sifre);

				String sql_sorgu = "select count(hasta_id) as giris from hastalar where hasta_tc='"+tc+"' and hasta_sifre='"+sifre2+"'";

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);

				try {
					while(myRs.next()) {
						if(myRs.getInt("giris")==1) {
							hasta_panel h_panel = null;
							h_panel = new hasta_panel();
							h_panel.setVisible(true);
							setVisible(false);
						}
						else { 
							//sifre_hata_hasta.setVisible(true); 
							JOptionPane.showMessageDialog(null, "TC ya da Þifre Hatalý! Kontrol Ediniz.", "Hatalý Giriþ", JOptionPane.ERROR_MESSAGE); }
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		admin_giris_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				giris = giris_admin_id.getText();
				char[] sifre = giris_admin_sifre.getPassword();
				sifre2 = String.valueOf(sifre);

				String sql_sorgu = "select count(admin_id) as giris from admin where admin_giris='"+giris+"' and admin_sifre='"+sifre2+"'";

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);

				try {
					while(myRs.next()) {
						if(myRs.getInt("giris")==1) {
							supervizor_panel a_panel = null;
							a_panel = new supervizor_panel();
							a_panel.setVisible(true);
							setVisible(false);
						}
						else { 
						JOptionPane.showMessageDialog(null, "ID ya da Þifre Hatalý! Kontrol Ediniz.", "Hatalý Giriþ", JOptionPane.ERROR_MESSAGE); }
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		doktor_giris_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tc1 = giris_doktor_tc.getText();
				char[] sifre = giris_doktor_sifre.getPassword();
				sifre2 = String.valueOf(sifre);

				String sql_sorgu = "select count(dr_id) as giris from doktorlar where dr_tc='"+tc1+"' and dr_sifre='"+sifre2+"'";

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);

				try {
					while(myRs.next()) {
						if(myRs.getInt("giris")==1) {
							doktor_panel d_panel = null;
							d_panel = new doktor_panel();
							d_panel.setVisible(true);
							setVisible(false);
						}
						else { 
							JOptionPane.showMessageDialog(null, "TC ya da Þifre Hatalý! Kontrol Ediniz.", "Hatalý Giriþ", JOptionPane.ERROR_MESSAGE); }
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sifreunuttum_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				test_mail s_mail = null;
				s_mail = new test_mail();
				s_mail.setVisible(true);
			}
		});
	}
}
