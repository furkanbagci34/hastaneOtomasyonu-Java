package h_oto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class recete_yaz extends JFrame {

	private JPanel contentPane;
	static String d_id,h_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recete_yaz frame = new recete_yaz();
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
	public recete_yaz() {
		setTitle("Re\u00E7ete Yaz");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(650, 200, 513, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Reçete Yaz");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Cambria", Font.BOLD, 24));
		label.setBounds(12, 13, 471, 24);
		contentPane.add(label);
		
		JLabel label1 = new JLabel("Hasta Tc No:");
		label1.setBounds(12, 72, 130, 32);
		label1.setForeground(Color.BLUE);
		label1.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		contentPane.add(label1);
		
		JLabel lblSonu = new JLabel("Re\u00E7ete:");
		lblSonu.setBounds(12, 189, 100, 32);
		lblSonu.setForeground(Color.BLUE);
		lblSonu.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		contentPane.add(lblSonu);
		
		JTextField hasta_tc = new JTextField();
		hasta_tc.setBounds(124, 72, 321, 32);
		hasta_tc.setColumns(10);
		contentPane.add(hasta_tc);
		//contentPane.add(textPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 189, 321, 172);
		contentPane.add(scrollPane);
		
		JTextPane recete_txt = new JTextPane();
		recete_txt.setBounds(124, 137, 329, 153);
		scrollPane.setViewportView(recete_txt);
		
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
		
		JButton yaz_buton = new JButton("YAZ");
		yaz_buton.setFont(new Font("Tahoma", Font.BOLD, 15));
		yaz_buton.setBounds(348, 421, 97, 38);
		contentPane.add(yaz_buton);
		
		JLabel lblTarih = new JLabel("Tarih:");
		lblTarih.setForeground(Color.BLUE);
		lblTarih.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblTarih.setBounds(12, 129, 100, 32);
		contentPane.add(lblTarih);
		
		JDateChooser recete_tarihi = new JDateChooser();
		recete_tarihi.setBounds(124, 129, 321, 32);
		contentPane.add(recete_tarihi);
		
		yaz_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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


				String sql_sorgu,recete,r_tarihi;
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				r_tarihi = df.format(recete_tarihi.getDate());
				
				recete = recete_txt.getText();

				sql_sorgu = "INSERT INTO recete (dr_id,hasta_id,dr_aciklama,recete_tarihi) "
						+ "VALUES ('"+ d_id + "','" + h_id + "'," + "'" + recete + "','"+ r_tarihi + "')";
				
				System.out.println(sql_sorgu);

				baglanti.yap();
				baglanti.ekle(sql_sorgu);

				JOptionPane.showMessageDialog(null, "Reçete baþarýyla yazýlmýþtýr.", "Reçete Yazýldý!", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		

	}
}
