package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class h_oda_gir extends JFrame {

	private JPanel contentPane;
	private JTextField tc_txt;
	private JTextField oda_txt;
	private JTextField yatak_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					h_oda_gir frame = new h_oda_gir();
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
	public h_oda_gir() {
		setTitle("Hasta Oda Kayýt");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(750, 250, 476, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHastaTcNo = new JLabel("Hasta Tc No:");
		lblHastaTcNo.setForeground(Color.BLUE);
		lblHastaTcNo.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblHastaTcNo.setBounds(54, 79, 130, 32);
		contentPane.add(lblHastaTcNo);
		
		JLabel lblHastaOda = new JLabel("Hasta Oda No:");
		lblHastaOda.setForeground(Color.BLUE);
		lblHastaOda.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblHastaOda.setBounds(54, 129, 130, 32);
		contentPane.add(lblHastaOda);
		
		JLabel lblHastaYatak = new JLabel("Hasta Yatak No:");
		lblHastaYatak.setForeground(Color.BLUE);
		lblHastaYatak.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblHastaYatak.setBounds(54, 179, 130, 32);
		contentPane.add(lblHastaYatak);
		
		tc_txt = new JTextField();
		tc_txt.setBounds(196, 79, 175, 32);
		contentPane.add(tc_txt);
		tc_txt.setColumns(10);
		
		oda_txt = new JTextField();
		oda_txt.setColumns(10);
		oda_txt.setBounds(196, 129, 175, 32);
		contentPane.add(oda_txt);
		
		yatak_txt = new JTextField();
		yatak_txt.setColumns(10);
		yatak_txt.setBounds(196, 179, 175, 32);
		contentPane.add(yatak_txt);
		
		JButton bilgi_gir_buton = new JButton("Bilgileri Gir");
		bilgi_gir_buton.setFont(new Font("Cambria", Font.BOLD, 15));
		bilgi_gir_buton.setBounds(249, 236, 122, 37);
		contentPane.add(bilgi_gir_buton);
		
		JLabel label = new JLabel("Hasta Oda Kayýt");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Cambria", Font.BOLD, 23));
		label.setBounds(0, 20, 446, 28);
		contentPane.add(label);
		
		bilgi_gir_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc,oda,yatak,sql_sorgu;
				
				tc = tc_txt.getText();
				oda = oda_txt.getText();
				yatak = yatak_txt.getText();
				
				sql_sorgu = "UPDATE hastalar SET hasta_oda='"+oda+"',hasta_yatak='"+yatak+"' where hasta_tc="+tc+" ";
				
				System.out.println(sql_sorgu);
				
				JOptionPane.showMessageDialog(null, "Hasta oda bilgileri baþarýyla kaydedilmiþtir.", "Kayýt Baþarýlý", JOptionPane.INFORMATION_MESSAGE);

				baglanti.yap3();
				baglanti.update(sql_sorgu);
			}
		});
	}

}
