package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class lab_sonuc_gir extends JFrame {

	private JPanel contentPane;
	private JTextField hasta_tc;
	static String h_id,d_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab_sonuc_gir frame = new lab_sonuc_gir();
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
	public lab_sonuc_gir() {
		setTitle("Laboratuvar Sonuç");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(650, 200, 515, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLaboratuvarSonucuGir = new JLabel("Laboratuvar Sonucu Gir");
		lblLaboratuvarSonucuGir.setBounds(0, 24, 497, 24);
		lblLaboratuvarSonucuGir.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaboratuvarSonucuGir.setFont(new Font("Cambria", Font.BOLD, 24));
		contentPane.add(lblLaboratuvarSonucuGir);

		JLabel label = new JLabel("Hasta Tc No:");
		label.setBounds(12, 72, 130, 32);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		contentPane.add(label);

		JLabel lblSonu = new JLabel("Sonu\u00E7:");
		lblSonu.setBounds(12, 189, 130, 32);
		lblSonu.setForeground(Color.BLUE);
		lblSonu.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		contentPane.add(lblSonu);

		hasta_tc = new JTextField();
		hasta_tc.setBounds(124, 72, 321, 32);
		hasta_tc.setColumns(10);
		contentPane.add(hasta_tc);
		//contentPane.add(textPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 189, 321, 172);
		contentPane.add(scrollPane);

		JTextPane sonuc_txt = new JTextPane();
		sonuc_txt.setBounds(124, 137, 329, 153);
		scrollPane.setViewportView(sonuc_txt);
		
		JDateChooser recete_tarihi = new JDateChooser();
		recete_tarihi.setBounds(124, 129, 321, 32);
		contentPane.add(recete_tarihi);

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
		JButton kaydet_buton = new JButton("KAYDET");
		kaydet_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tc,sql_sorgu1;

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


				String sql_sorgu,sonuc,s_tarihi;
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				s_tarihi = df.format(recete_tarihi.getDate());
				sonuc = sonuc_txt.getText();

				sql_sorgu = "INSERT INTO lab (lab_sonuc,hasta_id,dr_id,sonuc_tarihi) "
						+ "VALUES ('"+ sonuc + "','" + h_id + "'," + "'" + d_id + "'," + "'" + s_tarihi + "')";
				
				System.out.println(sql_sorgu);

				baglanti.yap();
				baglanti.ekle(sql_sorgu);

				JOptionPane.showMessageDialog(null, "Laboratuvar sonucu baþarýyla kaydedilmiþtir.", "Sonuç Kaydedildi!", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		kaydet_buton.setFont(new Font("Tahoma", Font.BOLD, 15));
		kaydet_buton.setBounds(348, 396, 97, 38);
		contentPane.add(kaydet_buton);
		
		JLabel lblTarih = new JLabel("Tarih:");
		lblTarih.setForeground(Color.BLUE);
		lblTarih.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblTarih.setBounds(12, 129, 130, 32);
		contentPane.add(lblTarih);
	}
}
