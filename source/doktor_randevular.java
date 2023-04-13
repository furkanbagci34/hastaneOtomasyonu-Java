package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class doktor_randevular extends JFrame {

	private JPanel contentPane;
	DefaultTableModel r_liste = new DefaultTableModel();
	private JTable doktor_paneli_randevularim;
	static String d_id;
	Object[] r_kolon = {"Hasta Adý Soyadý","Randevu Tarihi","Randevu Saati"};
	Object[] r_satir = new Object[3];
	private JLabel lblRandevularm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doktor_randevular frame = new doktor_randevular();
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
	public doktor_randevular() {
		setTitle("Randevular\u0131m");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(650, 200, 639, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

		doktor_paneli_randevularim = new JTable();
		doktor_paneli_randevularim.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
					"Hasta Adý Soyadý","Randevu Tarihi","Randevu Saati"
			}
		));
		doktor_paneli_randevularim.setBounds(100, 52, 558, 225);
		//contentPane.add(table);
		r_liste.setColumnIdentifiers(r_kolon);
		r_liste.addRow(r_satir);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 101, 532, 252);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(doktor_paneli_randevularim);
		
		JButton drpanel_yenile = new JButton("Yenile");
		drpanel_yenile.setFont(new Font("Tahoma", Font.BOLD, 15));
		drpanel_yenile.setBounds(247, 375, 130, 56);
		contentPane.add(drpanel_yenile);
		
		lblRandevularm = new JLabel("Randevular\u0131m");
		lblRandevularm.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandevularm.setFont(new Font("Cambria", Font.BOLD, 23));
		lblRandevularm.setBounds(0, 36, 621, 28);
		contentPane.add(lblRandevularm);
		
		String sql_sorgu = "SELECT dr_id from doktorlar where dr_tc='"+anasayfa_1.tc1+"' ";
		ResultSet myRs = baglanti.yap();
		myRs = baglanti.sorgula(sql_sorgu);

		try {
			while(myRs.next()) {
				d_id = myRs.getString("dr_id");

			}
		} catch (SQLException e1) {					
			e1.printStackTrace();
		}
		drpanel_yenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r_liste.setRowCount(0);

				ResultSet myRs = baglanti.yap4();

				String sql_sorgu1 = "SELECT randevu_tarihi,randevu_saati,(SELECT klinik_ismi FROM KLINIKLER WHERE KLINIKLER .klinik_id = RANDEVULAR.klinik_id) AS klinik_ismi,(SELECT CONCAT(hasta_ad,' ',hasta_soyad) FROM HASTALAR WHERE HASTALAR .hasta_id = RANDEVULAR.hasta_id) AS hasta_ad FROM RANDEVULAR where dr_id='"+d_id+"'";
				myRs = baglanti.sorgula(sql_sorgu1);

				try {
					while(myRs.next()) {
						r_satir[0] = myRs.getString("hasta_ad");;
						r_satir[1] = myRs.getString("randevu_tarihi");
						r_satir[2] = myRs.getString("randevu_saati");
						r_liste.addRow(r_satir);
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}

				doktor_paneli_randevularim.setModel(r_liste);
			}
		});
	}

}
