package h_oto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class anasayfa extends JFrame {

	private JPanel contentPane;
	private JTextField giris_text;
	private JPasswordField sifre_text;
	private JLabel sifre_label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anasayfa frame = new anasayfa();
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
	public anasayfa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox giris_cbox = new JComboBox();
		giris_cbox.setFont(new Font("Cambria", Font.PLAIN, 30));
		giris_cbox.setModel(new DefaultComboBoxModel(new String[] {"Giri\u015F Tipi Se\u00E7iniz...", "Admin Giri\u015Fi", "Doktor Giri\u015Fi", "Hasta Giri\u015Fi"}));
		giris_cbox.setBounds(194, 463, 271, 38);
		contentPane.add(giris_cbox);
		
		giris_text = new JTextField();
		giris_text.setBounds(312, 514, 180, 32);
		contentPane.add(giris_text);
		giris_text.setColumns(10);
		
		sifre_text = new JPasswordField();
		sifre_text.setBounds(312, 566, 180, 32);
		contentPane.add(sifre_text);
		
		JLabel giris_label = new JLabel("TC Kimlik No:");
		giris_label.setFont(new Font("Cambria", Font.PLAIN, 19));
		giris_label.setBounds(156, 519, 130, 32);
		contentPane.add(giris_label);
		
		sifre_label = new JLabel("Þifre:");
		sifre_label.setFont(new Font("Cambria", Font.PLAIN, 19));
		sifre_label.setBounds(156, 568, 85, 24);
		contentPane.add(sifre_label);
		
		JButton giris_buton = new JButton("GÝRÝÞ");
		giris_buton.setFont(new Font("Cambria", Font.PLAIN, 19));
		giris_buton.setBounds(362, 634, 130, 32);
		contentPane.add(giris_buton);
		
		JButton kayit_buton = new JButton("KAYIT OL");
		kayit_buton.setFont(new Font("Cambria", Font.PLAIN, 19));
		kayit_buton.setBounds(156, 634, 130, 32);
		contentPane.add(kayit_buton);
		
		JLabel title_label = new JLabel("T.C. SAÐLIK BAKANLIÐI");
		title_label.setFont(new Font("Tahoma", Font.BOLD, 24));
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_label.setBounds(131, 320, 396, 51);
		contentPane.add(title_label);
		
		JLabel lblKonyaNumuneHastanesi = new JLabel("KONYA NUMUNE HASTANESÝ");
		lblKonyaNumuneHastanesi.setHorizontalAlignment(SwingConstants.CENTER);
		lblKonyaNumuneHastanesi.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblKonyaNumuneHastanesi.setBounds(131, 363, 396, 51);
		contentPane.add(lblKonyaNumuneHastanesi);
		
		JLabel lblHastaKaytProgram = new JLabel("HASTA KAYIT PROGRAMI");
		lblHastaKaytProgram.setHorizontalAlignment(SwingConstants.CENTER);
		lblHastaKaytProgram.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHastaKaytProgram.setBounds(131, 403, 396, 51);
		contentPane.add(lblHastaKaytProgram);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(144, 13, 321, 139);
		contentPane.add(lblNewLabel);
	}
}
