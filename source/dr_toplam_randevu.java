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
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class dr_toplam_randevu extends JFrame {

	private JPanel contentPane;
	DefaultTableModel r_liste = new DefaultTableModel();
	Object[] r_kolon = {"Doktor Adý Soyadý","Toplam Randevu Sayýsý"};
	Object[] r_satir = new Object[2];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dr_toplam_randevu frame = new dr_toplam_randevu();
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
	public dr_toplam_randevu() {
		setTitle("Doktorlar Toplam Randevu Say\u0131s\u0131 Sorgula");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 200, 591, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTarihlerArasDoktor = new JLabel("Doktorlarýn Toplam Randevu Sayýlarý");
		lblTarihlerArasDoktor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTarihlerArasDoktor.setFont(new Font("Cambria", Font.BOLD, 23));
		lblTarihlerArasDoktor.setBounds(0, 26, 573, 28);
		contentPane.add(lblTarihlerArasDoktor);

		JTable table = new JTable();
		table.setBounds(42, 175, 487, 178);
		r_liste.setColumnIdentifiers(r_kolon);
		r_liste.addRow(r_satir);
		//contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 92, 487, 186);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);

		JButton sorgula = new JButton("SORGULA");
		sorgula.setFont(new Font("Tahoma", Font.BOLD, 15));
		sorgula.setBounds(407, 325, 118, 32);
		contentPane.add(sorgula);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		sorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bsl,bts,sql_sorgu1;
				r_liste.setRowCount(0);				

				sql_sorgu1 = "SELECT " + 
						"(SELECT CONCAT(dr_ad,' ',dr_soyad) FROM doktorlar WHERE dr_id = randevular.dr_id) AS dr_ad, " + 
						" count(*) AS r_sayisi " + 
						" FROM randevular " + 
						" WHERE randevu_tarihi " + 
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
