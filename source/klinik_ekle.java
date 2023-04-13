package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class klinik_ekle extends JFrame {

	DefaultTableModel doktor_liste = new DefaultTableModel();
	DefaultTableModel klinik_liste = new DefaultTableModel();
	
	Object[] klinik_kolon = {"Klinik ID","Klinik Adý"};
	Object[] klinik_satir = new Object[2];
	
	private JPanel contentPane;
	private JTable admin_klinikler;
	private JTextField admin_klinikadi_ekle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					klinik_ekle frame = new klinik_ekle();
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
	public klinik_ekle() {
		setTitle("Klinik Ekle");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(650, 200, 617, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Klinikler");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 21));
		lblNewLabel.setBounds(0, 13, 599, 32);
		contentPane.add(lblNewLabel);
		
		admin_klinikler = new JTable();
		admin_klinikler.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"Klinik ID","Klinik Adý"
			}
		));
		klinik_liste.setColumnIdentifiers(klinik_kolon);
		klinik_liste.addRow(klinik_satir);
		admin_klinikler.setBounds(12, 58, 340, 215);
		//contentPane.add(table_1);
		
		JScrollPane admin_klinik = new JScrollPane();
		admin_klinik.setBounds(77, 58, 458, 215);
		contentPane.add(admin_klinik);
		admin_klinik.setViewportView(admin_klinikler);
		
		JButton admin_klinikler_yenile = new JButton("Yenile");
		admin_klinikler_yenile.setFont(new Font("Cambria", Font.BOLD, 15));
		admin_klinikler_yenile.setBounds(243, 286, 118, 32);
		contentPane.add(admin_klinikler_yenile);
		
		JButton admin_klinik_ekle = new JButton("Klinik Ekle");
		admin_klinik_ekle.setFont(new Font("Cambria", Font.BOLD, 15));
		admin_klinik_ekle.setBounds(243, 463, 118, 32);
		contentPane.add(admin_klinik_ekle);
		
		admin_klinikadi_ekle = new JTextField();
		admin_klinikadi_ekle.setBounds(204, 393, 198, 25);
		contentPane.add(admin_klinikadi_ekle);
		admin_klinikadi_ekle.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Klinik Adý");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(243, 355, 118, 25);
		contentPane.add(lblNewLabel_2);
		admin_klinikler_yenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				klinik_liste.setRowCount(0);

				ResultSet myRs = baglanti.yap2();

				try {
					while(myRs.next()) {
						klinik_satir[0] = myRs.getString("klinik_id");
						klinik_satir[1] = myRs.getString("klinik_ismi");
						klinik_liste.addRow(klinik_satir);
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}

				admin_klinikler.setModel(klinik_liste);

			}
		});
		admin_klinik_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String klinik_adi,sql_sorgu;
				
				klinik_adi = admin_klinikadi_ekle.getText();

				sql_sorgu = "INSERT INTO klinikler (klinik_ismi) VALUES ('" + klinik_adi + "')";

				baglanti.yap();
				baglanti.ekle(sql_sorgu);
				JOptionPane.showMessageDialog(null, "Klinik baþarýyla eklenmiþtir!", "Klinik Eklendi", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
