package h_oto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JSpinner;

public class test extends JFrame {

	private JPanel contentPane;
	private JPasswordField sifre;
	private JCheckBox chckbxErkek;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser kayit_ol_dtarihi = new JDateChooser();
		kayit_ol_dtarihi.setBounds(220, 32, 103, 22);
		contentPane.add(kayit_ol_dtarihi);

		
		sifre = new JPasswordField();
		sifre.setBounds(107, 215, 144, 25);
		contentPane.add(sifre);
		
		chckbxErkek = new JCheckBox("erkek");
		chckbxErkek.setBounds(153, 259, 113, 25);
		contentPane.add(chckbxErkek);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar cal=Calendar.getInstance(); 
				System.out.println("Time is "+cal.getTime()); 
				String str=cal.toString();
				System.out.println("Time is "+str); 
			}
		});
		btnNewButton_2.setBounds(337, 105, 97, 25);
		contentPane.add(btnNewButton_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(64, 348, 127, 25);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(64, 318, 127, 25);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(302, 215, 21, 77);
		contentPane.add(scrollBar);
		
		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setBounds(443, 284, 200, 26);
		contentPane.add(slider);
		
		JList list = new JList();
		list.setBounds(107, 94, 1, 1);
		contentPane.add(list);
		
		JSlider slider_1 = new JSlider();
		slider_1.setBounds(-9, 105, 260, 38);
		contentPane.add(slider_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(475, 48, 91, 77);
		contentPane.add(spinner);
		
		char[] password = sifre.getPassword();
		
		System.out.println(password);
		
		/*JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id,giris,sifre,sql_sorgu;
				id = admin_id.getText();
				giris = admin_giris.getText();
				sifre = admin_sifre.getText();
				
				sql_sorgu = "INSERT INTO admin (admin_id,admin_giris,admin_sifre) VALUES ("+ id +",'" + giris +"'," +"'" + sifre +"')";
				
				System.out.println(sql_sorgu); 
				
					baglanti.yap();
					baglanti.ekle(sql_sorgu);

			}
		}); 
		btnNewButton.setBounds(267, 78, 97, 25);
		contentPane.add(btnNewButton);*/
		
		
	}
}
