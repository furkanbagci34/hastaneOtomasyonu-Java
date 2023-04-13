package h_oto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JTable;

public class isim_h_bilgi extends JFrame {

	static String tc,ad,soyad,dtarihi,dyeri,adres,il,ilce,cins,anne,baba,sgk,mail,sifre;
	private JTextField isim_al_txt;
	private JTable table;
	DefaultTableModel r_liste = new DefaultTableModel();
	Object[] r_kolon = {"Hasta TC", "Adý", "Soyadý", "Doðum Yeri", "Doðum Tarihi", "Adres", "Ýl", "Ýlçe", "Cinsiyet", "Telefon", "Anne Adý", "Baba Adý", "SGK", "Mail", "Þifre"};
	Object[] r_satir = new Object[15];


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					isim_h_bilgi frame = new isim_h_bilgi();
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
	public isim_h_bilgi() {
		setTitle("Hasta Bilgilerini Öðren");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1473, 455);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		isim_al_txt = new JTextField();
		isim_al_txt.setBounds(555, 23, 329, 38);
		contentPane.add(isim_al_txt);
		isim_al_txt.setColumns(10);
		
		JButton sorgula_buton = new JButton("SORGULA");
		sorgula_buton.setFont(new Font("Cambria", Font.BOLD, 15));
		sorgula_buton.setBounds(968, 22, 123, 38);
		contentPane.add(sorgula_buton);
		
		JLabel tc_lbl = new JLabel("Hasta Ýsim:");
		tc_lbl.setForeground(Color.BLUE);
		tc_lbl.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		tc_lbl.setBounds(382, 23, 131, 38);
		contentPane.add(tc_lbl);
		
		table = new JTable();
		table.setBounds(179, 106, 761, 204);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hasta TC", "Adý", "Soyadý", "Doðum Yeri", "Doðum Tarihi", "Adres", "Ýl", "Ýlçe", "Cinsiyet", "Telefon", "Anne Adý", "Baba Adý", "SGK", "Mail", "Þifre"
			}
		));
		table.setModel(r_liste);
		r_liste.setColumnIdentifiers(r_kolon);
		r_liste.addRow(r_satir);
		//contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 106, 1367, 237);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);

		sorgula_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String isim_al = isim_al_txt.getText();
				
				String sql_sorgu = "select hasta_tc,hasta_ad,hasta_soyad,hasta_dyeri,hasta_dogum,hasta_adres,hasta_il,hasta_ilce,hasta_cins,hasta_tel,"
						+ "hasta_anne,hasta_baba,hasta_sgk,hasta_mail,hasta_sifre from hastalar where hasta_ad='"+isim_al+"' ";

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);

				r_liste.setRowCount(0);
					
				try {
					while(myRs.next()) {

						r_satir[0] = myRs.getString("hasta_tc");
						r_satir[1] = myRs.getString("hasta_ad");
						r_satir[2] = myRs.getString("hasta_soyad");
						r_satir[3] = myRs.getString("hasta_dogum");
						r_satir[4] = myRs.getString("hasta_dyeri");
						r_satir[5] = myRs.getString("hasta_adres");
						r_satir[6] = myRs.getString("hasta_il");
						r_satir[7] = myRs.getString("hasta_ilce");
						r_satir[8] = myRs.getString("hasta_cins");
						r_satir[9] = myRs.getString("hasta_tel");
						r_satir[10] = myRs.getString("hasta_anne");
						r_satir[11] = myRs.getString("hasta_baba");
						r_satir[12] = myRs.getString("hasta_sgk");
						r_satir[13] = myRs.getString("hasta_mail");
						r_satir[14] = myRs.getString("hasta_sifre");

						r_liste.addRow(r_satir);

					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}
		});
	}
}
