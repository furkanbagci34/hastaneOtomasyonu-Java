package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class randevu_gecmisi extends JFrame {

	DefaultTableModel r_liste = new DefaultTableModel();
	private JPanel contentPane;
	private JTable table;
	static String id,k_isim,d_isim,k_id,d_id;
	Object[] r_kolon = {"Klinik Ýsmi","Doktor Adý Soyadý","Randevu Tarihi","Randevu Saati"};
	Object[] r_satir = new Object[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					randevu_gecmisi frame = new randevu_gecmisi();
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
	public randevu_gecmisi() {
		setTitle("Randevu Geçmiþi");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(550, 200, 703, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton yenile = new JButton("Yenile");
		yenile.setFont(new Font("Tahoma", Font.BOLD, 15));
		yenile.setBounds(275, 389, 133, 39);
		contentPane.add(yenile);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
					"Klinik Ýsmi","Doktor Adý Soyadý","Randevu Tarihi","Randevu Saati"
			}
		));
		table.setBounds(35, 30, 487, 254);
		//contentPane.add(table);
		
		r_liste.setColumnIdentifiers(r_kolon);
		r_liste.addRow(r_satir);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 86, 612, 276);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JLabel lblRandevuGemiim = new JLabel("Randevu Ge\u00E7mi\u015Fim");
		lblRandevuGemiim.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandevuGemiim.setFont(new Font("Cambria", Font.BOLD, 23));
		lblRandevuGemiim.setBounds(0, 32, 685, 28);
		contentPane.add(lblRandevuGemiim);
		
		String sql_sorgu = "SELECT hasta_id from hastalar where hasta_tc='"+anasayfa_1.tc+"' ";
		ResultSet myRs = baglanti.yap();
		myRs = baglanti.sorgula(sql_sorgu);

		try {
			while(myRs.next()) {
				id = myRs.getString("hasta_id");

			}
		} catch (SQLException e1) {					
			e1.printStackTrace();
		}
		
		yenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				r_liste.setRowCount(0);
				
				ResultSet myRs = baglanti.yap4();

				String sql_sorgu1 = "SELECT randevu_tarihi,randevu_saati,(SELECT klinik_ismi FROM KLINIKLER WHERE KLINIKLER .klinik_id = RANDEVULAR.klinik_id) AS klinik_ismi,(SELECT CONCAT(dr_ad,' ',dr_soyad) FROM DOKTORLAR WHERE DOKTORLAR .dr_id = RANDEVULAR.dr_id) AS dr_ad FROM RANDEVULAR where hasta_id='"+id+"'";
				myRs = baglanti.sorgula(sql_sorgu1);
				
				try {
					while(myRs.next()) {
						r_satir[0] = myRs.getString("klinik_ismi");
						r_satir[1] = myRs.getString("dr_ad");
						r_satir[2] = myRs.getString("randevu_tarihi");
						r_satir[3] = myRs.getString("randevu_saati");
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
