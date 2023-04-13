package h_oto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class recete_goruntule extends JFrame {

	private JPanel contentPane;
	static String h_id;
	DefaultTableModel model_1 = new DefaultTableModel();
	Object[] kolonlar = {"Hasta Ad Soyad", "Doktor Ad Soyad", "Reçete Tarihi", "Reçete",};
	Object[] satirlar = new Object[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recete_goruntule frame = new recete_goruntule();
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
	public recete_goruntule() {
		setTitle("Reçete Görüntüle");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(650, 200, 776, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLaboratuvarSonuSorgula = new JLabel("Reçete Görüntüle");
		lblLaboratuvarSonuSorgula.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaboratuvarSonuSorgula.setFont(new Font("Cambria", Font.BOLD, 24));
		lblLaboratuvarSonuSorgula.setBounds(0, 13, 783, 29);
		contentPane.add(lblLaboratuvarSonuSorgula);
		
		JLabel label = new JLabel("Hasta Tc No:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		label.setBounds(23, 65, 130, 32);
		contentPane.add(label);
		
		JTextField hasta_tc = new JTextField();
		hasta_tc.setColumns(10);
		hasta_tc.setBounds(154, 67, 175, 32);
		contentPane.add(hasta_tc);
		
		JButton sorgula = new JButton("GÖRÜNTÜLE");
		sorgula.setBounds(368, 65, 106, 31);
		contentPane.add(sorgula);
		
		JLabel lblSonu = new JLabel("Reçete:");
		lblSonu.setForeground(Color.BLUE);
		lblSonu.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblSonu.setBounds(23, 110, 130, 32);
		contentPane.add(lblSonu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 120, 559, 215);
		contentPane.add(scrollPane);
		
		JLabel tarih_label = new JLabel("");
		tarih_label.setFont(new Font("Cambria", Font.PLAIN, 15));
		tarih_label.setBounds(154, 110, 175, 32);
		contentPane.add(tarih_label);
		
		JTable table = new JTable();
		model_1.setColumnIdentifiers(kolonlar);
		model_1.addRow(satirlar);
		table.setModel(model_1);
		table.setBounds(61, 151, 592, 224);
		//contentPane.add(table);
		scrollPane.setViewportView(table);
		
		sorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc,sql_sorgu1,sql_sorgu,r_yaz,r_tarihi;

				tc = hasta_tc.getText();

				sql_sorgu1 =	"SELECT hasta_id FROM hastalar WHERE hasta_tc='"+tc+"' ";

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu1);
				
				try {
					while(myRs.next()) {
						h_id = myRs.getString("hasta_id");
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				
				//sql_sorgu =	"SELECT dr_aciklama,recete_tarihi FROM recete WHERE hasta_id='"+h_id+"' ";

				sql_sorgu = "SELECT dr_aciklama,recete_tarihi," + 
						"(SELECT CONCAT(hasta_ad,' ',hasta_soyad) FROM HASTALAR WHERE HASTALAR .hasta_id = RECETE.hasta_id) AS hasta_ad," + 
						"(SELECT CONCAT(dr_ad,' ',dr_soyad) FROM DOKTORLAR WHERE DOKTORLAR .dr_id = recete.dr_id) AS dr_ad" + 
						" FROM RECETE" + 
						" where hasta_id='"+h_id+"'";
				
				myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);
				
				model_1.setRowCount(0);
 
				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("hasta_ad");
						satirlar[1] = myRs.getString("dr_ad");
						satirlar[2] = myRs.getString("recete_tarihi");
						satirlar[3] = myRs.getString("dr_aciklama");
						model_1.addRow(satirlar);

						
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				
			}
		});
		
	}

}
