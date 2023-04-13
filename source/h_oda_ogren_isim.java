package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class h_oda_ogren_isim extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel r_liste = new DefaultTableModel();
	Object[] r_kolon = {"Hasta TC", "Hasta Ad Soyad", "Oda No", "Yatak No",};
	Object[] r_satir = new Object[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					h_oda_ogren_isim frame = new h_oda_ogren_isim();
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
	public h_oda_ogren_isim() {
		setTitle("Ýsme Göre Oda Öðren");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(650, 200, 643, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHastaOdaSorgu = new JLabel("Ýsme Göre Oda Sorgu");
		lblHastaOdaSorgu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHastaOdaSorgu.setFont(new Font("Cambria", Font.BOLD, 23));
		lblHastaOdaSorgu.setBounds(0, 13, 625, 28);
		contentPane.add(lblHastaOdaSorgu);

		JTextField isim_txt = new JTextField();
		isim_txt.setColumns(10);
		isim_txt.setBounds(116, 60, 217, 38);
		contentPane.add(isim_txt);

		JButton sorgula_buton = new JButton("SORGULA");
		sorgula_buton.setFont(new Font("Cambria", Font.BOLD, 15));
		sorgula_buton.setBounds(374, 59, 123, 38);
		contentPane.add(sorgula_buton);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
					"Hasta TC", "Hasta Ad Soyad", "Oda No", "Yatak No"
			}
		));
		table.setModel(r_liste);
		r_liste.setColumnIdentifiers(r_kolon);
		r_liste.addRow(r_satir);
		table.setBounds(66, 134, 428, 178);
		//contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 137, 544, 185);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		sorgula_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String isim,ad_soyad,oda,yatak,tc,sql_sorgu;
				
				isim = isim_txt.getText();
				
				sql_sorgu = "SELECT hasta_tc, concat(hasta_ad,' ',hasta_soyad) as ad_soyad, ifnull(hasta_oda,'Kayýt Yok.') as hasta_oda,"
						+ "ifnull(hasta_yatak,'Kayýt Yok.') as hasta_yatak FROM hastalar WHERE hasta_ad='"+isim+"'";

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);
				r_liste.setRowCount(0);
				try {
					while(myRs.next()) {

						r_satir[2] = myRs.getString("hasta_oda");
						r_satir[3] = myRs.getString("hasta_yatak");
						r_satir[1] = myRs.getString("ad_soyad");
						r_satir[0] = myRs.getString("hasta_tc");
						r_liste.addRow(r_satir);
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				
			}
		});
		
	}
}
