package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class randevu_sorgula extends JFrame {

	private JPanel contentPane;
	private JTextField tc_txt;
	static String hasta_id;
	private JTable table;
	DefaultTableModel model_1 = new DefaultTableModel();
	Object[] kolonlar = {"Klinik ismi", "Doktor Adý Soyadý", "Randevu Tarihi", "Randevu Saati",};
	Object[] satirlar = new Object[4];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					randevu_sorgula frame = new randevu_sorgula();
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
	public randevu_sorgula() {
		setTitle("Randevu Sorgulama");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(550, 200, 710, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTcNo = new JLabel("T.C. No:");
		lblTcNo.setForeground(Color.BLUE);
		lblTcNo.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		lblTcNo.setBounds(122, 60, 68, 38);
		contentPane.add(lblTcNo);

		tc_txt = new JTextField();
		tc_txt.setColumns(10);
		tc_txt.setBounds(213, 60, 217, 38);
		contentPane.add(tc_txt);

		JButton sorgula_buton = new JButton("SORGULA");
		sorgula_buton.setFont(new Font("Cambria", Font.BOLD, 15));
		sorgula_buton.setBounds(460, 59, 123, 38);
		contentPane.add(sorgula_buton);

		JLabel lblHastaRandevuSorgu = new JLabel("Hasta Randevu Sorgu");
		lblHastaRandevuSorgu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHastaRandevuSorgu.setFont(new Font("Cambria", Font.BOLD, 23));
		lblHastaRandevuSorgu.setBounds(88, 16, 454, 28);
		contentPane.add(lblHastaRandevuSorgu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 130, 622, 265);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model_1.setColumnIdentifiers(kolonlar);
		model_1.addRow(satirlar);
		table.setModel(model_1);
		table.setBounds(61, 151, 592, 224);
		//contentPane.add(table);
		scrollPane.setViewportView(table);

		sorgula_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc,sql_sorgu1;

				tc = tc_txt.getText();

				sql_sorgu1 =	"SELECT hasta_id FROM hastalar WHERE hasta_tc='"+tc+"' ";

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu1);
				

				try {
					while(myRs.next()) {

						hasta_id = myRs.getString("hasta_id");
						
						System.out.println(hasta_id);

					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			
				
				myRs = baglanti.yap4();

				String sql_sorgu = "SELECT randevu_tarihi,randevu_saati,"
						+ "(SELECT klinik_ismi FROM KLINIKLER WHERE KLINIKLER .klinik_id = RANDEVULAR.klinik_id) AS klinik_ismi,"
						+ "(SELECT CONCAT(dr_ad,' ',dr_soyad) FROM DOKTORLAR WHERE DOKTORLAR .dr_id = RANDEVULAR.dr_id) AS dr_ad"
						+ " FROM RANDEVULAR where hasta_id='"+hasta_id+"'";
				myRs = baglanti.sorgula(sql_sorgu);
				
				System.out.println(sql_sorgu);
				model_1.setRowCount(0);
				
				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("klinik_ismi");
						satirlar[1] = myRs.getString("dr_ad");
						satirlar[2] = myRs.getString("randevu_tarihi");
						satirlar[3] = myRs.getString("randevu_saati");
						model_1.addRow(satirlar);
						
					}
				} catch (SQLException e2) {					
					e2.printStackTrace();
				}
		
				table.setModel(model_1);

			}
		});
	}
}
