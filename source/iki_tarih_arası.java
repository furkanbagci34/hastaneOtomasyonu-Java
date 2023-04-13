package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class iki_tarih_arasý extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel r_liste = new DefaultTableModel();
	Object[] r_kolon = {"Doktor Adý Soyadý","Hasta Adý Soyadý","Randevu Tarihi","Randevu Saati"};
	Object[] r_satir = new Object[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iki_tarih_arasý frame = new iki_tarih_arasý();
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
	public iki_tarih_arasý() {
		setTitle("Tarihler Arasý Randevu Sorgu");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(650, 200, 605, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Tarihler Arasý Randevu Sorgulama");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Cambria", Font.BOLD, 23));
		label.setBounds(-12, 13, 625, 28);
		contentPane.add(label);

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

		table = new JTable();
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
		lblOlmaldr.setBounds(400, 100, 144, 32);
		contentPane.add(lblOlmaldr);

		JButton sorgula = new JButton("SORGULA");
		sorgula.setFont(new Font("Tahoma", Font.BOLD, 15));
		sorgula.setBounds(412, 448, 117, 30);
		contentPane.add(sorgula);

		JLabel lblToplamAlnanRandevu = new JLabel("Toplam Alýnan Randevu Sayýsý:");
		lblToplamAlnanRandevu.setForeground(Color.BLUE);
		lblToplamAlnanRandevu.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblToplamAlnanRandevu.setBounds(42, 387, 253, 32);
		contentPane.add(lblToplamAlnanRandevu);

		JLabel randevu_sayi = new JLabel("");
		randevu_sayi.setHorizontalAlignment(SwingConstants.LEFT);
		randevu_sayi.setForeground(Color.RED);
		randevu_sayi.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		randevu_sayi.setBounds(293, 387, 144, 32);
		contentPane.add(randevu_sayi);

		JSeparator separator = new JSeparator();
		separator.setBounds(42, 425, 487, 2);
		contentPane.add(separator);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		sorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bsl,bts,sql_sorgu1;
				r_liste.setRowCount(0);				
				bsl = df.format(baslangic_tarih.getDate());
				bts = df.format(bitis_tarih.getDate());

				sql_sorgu1 = "SELECT randevu_tarihi,randevu_saati," + 
						"(SELECT CONCAT(dr_ad,' ',dr_soyad) FROM DOKTORLAR WHERE DOKTORLAR .dr_id = RANDEVULAR.dr_id) AS dr_ad," + 
						"(SELECT CONCAT(hasta_ad,' ',hasta_soyad) FROM HASTALAR WHERE HASTALAR .hasta_id = RANDEVULAR.hasta_id) AS hasta_ad " + 
						"FROM randevular WHERE randevu_tarihi between '"+bsl+"' and '"+bts+"' ";
				ResultSet myRs = baglanti.yap4();
				myRs = baglanti.sorgula(sql_sorgu1);

				System.out.println(sql_sorgu1);
				try {
					while(myRs.next()) {
						r_satir[0] = myRs.getString("dr_ad");
						r_satir[1] = myRs.getString("hasta_ad");
						r_satir[2] = myRs.getString("randevu_tarihi");
						r_satir[3] = myRs.getString("randevu_saati");
						r_liste.addRow(r_satir);
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				table.setModel(r_liste);

				String sayi,sql_sorgu;

				myRs = baglanti.yap4();

				sql_sorgu =	"SELECT COUNT(hasta_id) AS sayi " + 
						"FROM randevular WHERE randevu_tarihi between '"+bsl+"' and '"+bts+"' ";

				myRs = baglanti.sorgula(sql_sorgu);
				System.out.println(sql_sorgu);
				
				try {
					while(myRs.next()) {
						sayi = myRs.getString("sayi");
						randevu_sayi.setText(sayi);
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				} 
			}
		});
	}
}
