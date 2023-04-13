package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class doktor_ekle extends JFrame {

	DefaultTableModel doktor_liste = new DefaultTableModel();
	DefaultTableModel klinik_liste = new DefaultTableModel();
	
	Object[] dr_kolon = {"Doktor TC","Ad","Soyad","Þifre"};
	Object[] dr_satir = new Object[4];
	
	private JPanel contentPane;
	private JTable admin_doktorlar;
	private JTextField admin_doktorid_ekle;
	private JTextField admin_doktortc_ekle;
	private JTextField admin_doktorsifre_ekle;
	private JTextField admin_doktorad_ekle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doktor_ekle frame = new doktor_ekle();
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
	public doktor_ekle() {
		setTitle("Doktor Ekle");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(650, 200, 762, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Doktorlar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 21));
		lblNewLabel_1.setBounds(26, 13, 680, 32);
		contentPane.add(lblNewLabel_1);
		//contentPane.add(table);
		
		
		admin_doktorlar = new JTable();
		admin_doktorlar.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"Doktor TC", "Ad", "Soyad", "Þifre"
			}
		));
		doktor_liste.setColumnIdentifiers(dr_kolon);
		doktor_liste.addRow(dr_satir);
		admin_doktorlar.setBounds(396, 58, 334, 215);
		
		
		JScrollPane admin_doktor = new JScrollPane();
		admin_doktor.setBounds(26, 58, 691, 214);
		contentPane.add(admin_doktor);
		admin_doktor.setViewportView(admin_doktorlar);
		
		JButton admin_doktorlar_yenile = new JButton("Yenile");
		admin_doktorlar_yenile.setFont(new Font("Cambria", Font.BOLD, 15));
		admin_doktorlar_yenile.setBounds(293, 286, 151, 32);
		contentPane.add(admin_doktorlar_yenile);
		
		JButton admin_doktor_ekle = new JButton("Doktor Ekle");
		admin_doktor_ekle.setFont(new Font("Cambria", Font.BOLD, 15));
		admin_doktor_ekle.setBounds(293, 502, 151, 32);
		contentPane.add(admin_doktor_ekle);
		
		JLabel lblDoktorId = new JLabel("Doktor ID:");
		lblDoktorId.setForeground(Color.BLUE);
		lblDoktorId.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDoktorId.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoktorId.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		lblDoktorId.setBounds(145, 356, 91, 25);
		contentPane.add(lblDoktorId);
		
		JLabel lblDoktorTc = new JLabel("Doktor TC:");
		lblDoktorTc.setForeground(Color.BLUE);
		lblDoktorTc.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDoktorTc.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoktorTc.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		lblDoktorTc.setBounds(145, 385, 91, 25);
		contentPane.add(lblDoktorTc);
		
		JLabel lblDoktorSifre = new JLabel("Doktor Sifre:");
		lblDoktorSifre.setForeground(Color.BLUE);
		lblDoktorSifre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDoktorSifre.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoktorSifre.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		lblDoktorSifre.setBounds(145, 445, 111, 25);
		contentPane.add(lblDoktorSifre);
		
		admin_doktorid_ekle = new JTextField();
		admin_doktorid_ekle.setColumns(10);
		admin_doktorid_ekle.setBounds(270, 356, 198, 25);
		contentPane.add(admin_doktorid_ekle);
		
		admin_doktortc_ekle = new JTextField();
		admin_doktortc_ekle.setColumns(10);
		admin_doktortc_ekle.setBounds(270, 385, 198, 25);
		contentPane.add(admin_doktortc_ekle);
		
		admin_doktorsifre_ekle = new JTextField();
		admin_doktorsifre_ekle.setColumns(10);
		admin_doktorsifre_ekle.setBounds(270, 445, 198, 25);
		contentPane.add(admin_doktorsifre_ekle);
		
		JLabel lblDoktorAlan = new JLabel("Doktor Ad:");
		lblDoktorAlan.setForeground(Color.BLUE);
		lblDoktorAlan.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDoktorAlan.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoktorAlan.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		lblDoktorAlan.setBounds(145, 415, 100, 25);
		contentPane.add(lblDoktorAlan);
		
		admin_doktorad_ekle = new JTextField();
		admin_doktorad_ekle.setColumns(10);
		admin_doktorad_ekle.setBounds(270, 415, 198, 25);
		contentPane.add(admin_doktorad_ekle);
		
		admin_doktorlar_yenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doktor_liste.setRowCount(0);

				ResultSet myRs = baglanti.yap();

				try {
					while(myRs.next()) {
						dr_satir[0] = myRs.getString("dr_tc");
						dr_satir[1] = myRs.getString("dr_ad");
						dr_satir[2] = myRs.getString("dr_soyad");
						dr_satir[3] = myRs.getString("dr_sifre");
						doktor_liste.addRow(dr_satir);
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}

				admin_doktorlar.setModel(doktor_liste);

			}
		});
		admin_doktor_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dr_id,dr_tc,dr_ad,dr_sifre,sql_sorgu;
				
				dr_id = admin_doktorid_ekle.getText();
				dr_tc = admin_doktortc_ekle.getText();
				dr_ad = admin_doktorad_ekle.getText();
				dr_sifre = admin_doktorsifre_ekle.getText();

				sql_sorgu = "INSERT INTO doktorlar (dr_id,dr_tc,dr_ad,dr_sifre) VALUES ("+ dr_id + ",'" + dr_tc + "'," + "'" + dr_ad + "'," + "'" + dr_sifre + "')";

				baglanti.yap();
				baglanti.ekle(sql_sorgu);
				JOptionPane.showMessageDialog(null, "Doktor baþarýyla eklenmiþtir!", "Doktor Eklendi", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
