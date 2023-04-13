package h_oto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class dr_iki_tariharasi_randevu extends JFrame {

	private JPanel contentPane;
	DefaultTableModel r_liste = new DefaultTableModel();
	Object[] r_kolon = {"Doktor Adý Soyadý","Randevu Sayýsý"};
	Object[] r_satir = new Object[2];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dr_iki_tariharasi_randevu frame = new dr_iki_tariharasi_randevu();
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
	public dr_iki_tariharasi_randevu() {
		setTitle("Doktor \u0130ki Tarih Aras\u0131 Randevu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 200, 591, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTarihlerArasDoktor = new JLabel("Tarihler Aras\u0131 Doktor Randevular\u0131");
		lblTarihlerArasDoktor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTarihlerArasDoktor.setFont(new Font("Cambria", Font.BOLD, 23));
		lblTarihlerArasDoktor.setBounds(0, 13, 573, 28);
		contentPane.add(lblTarihlerArasDoktor);

		JLabel lblB = new JLabel("Baþlangýç Tarihi:");
		lblB.setForeground(Color.BLUE);
		lblB.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblB.setBounds(42, 63, 144, 32);
		contentPane.add(lblB);

		JLabel lblB_1 = new JLabel("Bitiþ Tarihi:");
		lblB_1.setForeground(Color.BLUE);
		lblB_1.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblB_1.setBounds(42, 108, 130, 32);
		contentPane.add(lblB_1);

		JDateChooser baslangic_tarih = new JDateChooser();
		baslangic_tarih.setBounds(190, 70, 198, 25);
		contentPane.add(baslangic_tarih);

		JDateChooser bitis_tarih = new JDateChooser();
		bitis_tarih.setBounds(190, 115, 198, 25);
		contentPane.add(bitis_tarih);

		JTable table = new JTable();
		table.setBounds(42, 175, 487, 178);
		r_liste.setColumnIdentifiers(r_kolon);
		r_liste.addRow(r_satir);
		//contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 167, 487, 186);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);

		JLabel lblAynAy = new JLabel("Ayný ay içinde");
		lblAynAy.setHorizontalAlignment(SwingConstants.CENTER);
		lblAynAy.setForeground(Color.RED);
		lblAynAy.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblAynAy.setBounds(400, 75, 144, 32);
		contentPane.add(lblAynAy);

		JLabel lblOlmaldr = new JLabel("olmalýdýr!");
		lblOlmaldr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOlmaldr.setForeground(Color.RED);
		lblOlmaldr.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblOlmaldr.setBounds(421, 93, 108, 44);
		contentPane.add(lblOlmaldr);

		JButton sorgula = new JButton("SORGULA");
		sorgula.setFont(new Font("Tahoma", Font.BOLD, 15));
		sorgula.setBounds(411, 374, 118, 32);
		contentPane.add(sorgula);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		sorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bsl,bts,sql_sorgu1;
				r_liste.setRowCount(0);				
				bsl = df.format(baslangic_tarih.getDate());
				bts = df.format(bitis_tarih.getDate());

				sql_sorgu1 = "SELECT " + 
						"(SELECT CONCAT(dr_ad,' ',dr_soyad) FROM doktorlar WHERE dr_id = randevular.dr_id) AS dr_ad, " + 
						" count(*) AS r_sayisi " + 
						" FROM randevular " + 
						" WHERE randevu_tarihi between '"+bsl+"' and '"+bts+"' " + 
						" GROUP BY dr_id";
				ResultSet myRs = baglanti.yap4();
				myRs = baglanti.sorgula(sql_sorgu1);

				System.out.println(sql_sorgu1);
				try {
					while(myRs.next()) {
						r_satir[0] = myRs.getString("dr_ad");
						r_satir[1] = myRs.getString("r_sayisi");

						r_liste.addRow(r_satir);
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				table.setModel(r_liste);

				
			}
		});
		
	}

}
