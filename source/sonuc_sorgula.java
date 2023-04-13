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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class sonuc_sorgula extends JFrame {

	private JPanel contentPane;
	private JTextField hasta_tc;
	static String h_id;
	DefaultTableModel model_1 = new DefaultTableModel();
	Object[] kolonlar = {"Hasta Ad Soyad", "Doktor Ad Soyad", "Sonuç Tarihi", "Sonuç",};
	Object[] satirlar = new Object[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sonuc_sorgula frame = new sonuc_sorgula();
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
	public sonuc_sorgula() {
		setTitle("Laboratuvar Sonuç Sorgula");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(450, 200, 807, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLaboratuvarSonuSorgula = new JLabel("Laboratuvar Sonuç Sorgula");
		lblLaboratuvarSonuSorgula.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaboratuvarSonuSorgula.setFont(new Font("Cambria", Font.BOLD, 24));
		lblLaboratuvarSonuSorgula.setBounds(0, 13, 827, 29);
		contentPane.add(lblLaboratuvarSonuSorgula);
		
		JLabel label = new JLabel("Hasta Tc No:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		label.setBounds(23, 65, 130, 32);
		contentPane.add(label);
		
		hasta_tc = new JTextField();
		hasta_tc.setColumns(10);
		hasta_tc.setBounds(154, 67, 175, 32);
		contentPane.add(hasta_tc);
		
		JButton sorgula = new JButton("SORGULA");
		sorgula.setBounds(368, 65, 106, 31);
		contentPane.add(sorgula);
		
		JLabel lblSonu = new JLabel("Sonuç:");
		lblSonu.setForeground(Color.BLUE);
		lblSonu.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblSonu.setBounds(23, 120, 130, 32);
		contentPane.add(lblSonu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 129, 585, 208);
		contentPane.add(scrollPane);
		
		JTable table = new JTable();
		model_1.setColumnIdentifiers(kolonlar);
		model_1.addRow(satirlar);
		table.setModel(model_1);
		table.setBounds(61, 151, 592, 224);
		//contentPane.add(table);
		scrollPane.setViewportView(table);
		
		sorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc,sql_sorgu1,sql_sorgu,sonuc_yaz;

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
				
				sql_sorgu =	"SELECT lab_sonuc,sonuc_tarihi," + 
						"(SELECT CONCAT(hasta_ad,' ',hasta_soyad) FROM HASTALAR WHERE HASTALAR .hasta_id = lab.hasta_id) AS hasta_ad," + 
						"(SELECT CONCAT(dr_ad,' ',dr_soyad) FROM DOKTORLAR WHERE DOKTORLAR .dr_id = lab.dr_id) AS dr_ad" + 
						" FROM LAB" + 
						" where hasta_id='"+h_id+"' ";
				System.out.println(sql_sorgu);

				myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);
				
				model_1.setRowCount(0);

				try {
					while(myRs.next()) {

						satirlar[0] = myRs.getString("hasta_ad");
						satirlar[1] = myRs.getString("dr_ad");
						satirlar[2] = myRs.getString("sonuc_tarihi");
						satirlar[3] = myRs.getString("lab_sonuc");
						model_1.addRow(satirlar);
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				
			}
		});
	}

}
