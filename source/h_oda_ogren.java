package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class h_oda_ogren extends JFrame {

	private JPanel contentPane;
	private JTextField tc_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					h_oda_ogren frame = new h_oda_ogren();
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
	public h_oda_ogren() {
		setTitle("Hasta Oda Sorgula");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(750, 250, 484, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHastaOdaSorgu = new JLabel("Hasta Oda Sorgu");
		lblHastaOdaSorgu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHastaOdaSorgu.setFont(new Font("Cambria", Font.BOLD, 23));
		lblHastaOdaSorgu.setBounds(0, 13, 454, 28);
		contentPane.add(lblHastaOdaSorgu);

		tc_txt = new JTextField();
		tc_txt.setColumns(10);
		tc_txt.setBounds(86, 60, 217, 38);
		contentPane.add(tc_txt);

		JButton sorgula_buton = new JButton("SORGULA");

		sorgula_buton.setFont(new Font("Cambria", Font.BOLD, 15));
		sorgula_buton.setBounds(322, 59, 123, 38);
		contentPane.add(sorgula_buton);

		JLabel label_1 = new JLabel("Hasta Oda No:");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		label_1.setBounds(88, 146, 130, 32);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Hasta Yatak No:");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		label_2.setBounds(88, 191, 130, 32);
		contentPane.add(label_2);

		JLabel hasta_oda = new JLabel("");
		hasta_oda.setForeground(Color.BLACK);
		hasta_oda.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		hasta_oda.setBounds(230, 146, 95, 32);
		contentPane.add(hasta_oda);

		JLabel hasta_yatak = new JLabel("");
		hasta_yatak.setForeground(Color.BLACK);
		hasta_yatak.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		hasta_yatak.setBounds(230, 191, 95, 32);
		contentPane.add(hasta_yatak);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(88, 186, 220, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("T.C. No:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		label.setBounds(10, 60, 68, 38);
		contentPane.add(label);

		sorgula_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc,oda,yatak,sql_sorgu;

				tc = tc_txt.getText();

				sql_sorgu = "SELECT ifnull(hasta_oda,'') as hasta_oda,ifnull(hasta_yatak,'') as hasta_yatak FROM hastalar WHERE hasta_tc='"+tc+"' ";

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);

				try {
					while(myRs.next()) {

						oda = myRs.getString("hasta_oda");
						yatak = myRs.getString("hasta_yatak");

						if(oda.equals("")) {
							hasta_oda.setText("Kayýt Yok.");
						}
						else {
							hasta_oda.setText(oda);
						}
						
						if(yatak.equals("")) {
							hasta_yatak.setText("Kayýt Yok.");
						}
						else {
							hasta_yatak.setText(yatak);
						}

					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}
		});
	}
}
