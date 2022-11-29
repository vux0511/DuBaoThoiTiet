import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Font;

public class Detail0 extends JFrame {

	JLabel lblNameCity, lbl_Temp, lbl_TempMinMax, lbl_Huli, lbl_Vision, lbl_Wind, lbl_Uv, lbl_Air,lbl_Status;
	
	public Detail0() {
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 10, 468, 201);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNameCity = new JLabel("D\u1EF1 b\u00E1o th\u1EDDi ti\u1EBFt H\u00E0 N\u1ED9i");
		lblNameCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNameCity.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameCity.setBounds(8, 10, 452, 20);
		panel.add(lblNameCity);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\vu_20\\Desktop\\02d2x.png"));
		lblNewLabel_1.setBounds(20, 40, 78, 79);
		panel.add(lblNewLabel_1);
		
		lbl_Temp = new JLabel("28\u00B0C");
		lbl_Temp.setFont(new Font("Tahoma", Font.BOLD, 35));
		lbl_Temp.setBounds(85, 50, 99, 53);
		panel.add(lbl_Temp);
		
		lbl_Status = new JLabel("B\u1EA7u tr\u1EDDi quang \u0111\u00E3ng");
		lbl_Status.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Status.setBounds(192, 50, 241, 25);
		panel.add(lbl_Status);
		
		JLabel lblNewLabel_5 = new JLabel("Th\u1EA5p/Cao");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(8, 132, 62, 13);
		panel.add(lblNewLabel_5);
		
		lbl_TempMinMax = new JLabel("23\u00B0/29\u00B0");
		lbl_TempMinMax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_TempMinMax.setBounds(18, 151, 52, 13);
		panel.add(lbl_TempMinMax);
		
		JLabel lblNewLabel_7 = new JLabel("\u0110\u1ED9 \u1EA9m");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(105, 132, 62, 13);
		panel.add(lblNewLabel_7);
		
		lbl_Huli = new JLabel("74%");
		lbl_Huli.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Huli.setBounds(105, 151, 43, 13);
		panel.add(lbl_Huli);
		
		JLabel lblNewLabel_9 = new JLabel("T\u1EA7m nh\u00ECn");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(192, 132, 62, 13);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Gi\u00F3");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9_1.setBounds(301, 132, 62, 13);
		panel.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_2 = new JLabel("Ch\u1EC9 s\u1ED1 UV");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9_2.setBounds(371, 132, 62, 13);
		panel.add(lblNewLabel_9_2);
		
		lbl_Vision = new JLabel("10 km");
		lbl_Vision.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Vision.setBounds(198, 151, 43, 13);
		panel.add(lbl_Vision);
		
		lbl_Wind = new JLabel("2.57 km/gi\u1EDD");
		lbl_Wind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Wind.setBounds(286, 151, 66, 13);
		panel.add(lbl_Wind);
		
		lbl_Uv = new JLabel("0");
		lbl_Uv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Uv.setBounds(390, 151, 43, 13);
		panel.add(lbl_Uv);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(10, 221, 468, 40);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lbl_Air = new JLabel("Ch\u1EA5t l\u01B0\u1EE3ng kh\u00F4ng kh\u00ED: Kh\u00E1");
		lbl_Air.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Air.setBounds(8, 10, 452, 20);
		lbl_Air.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lbl_Air);
		this.setVisible(true);
		this.setSize(500, 310);
		this.setLocationRelativeTo(null);
	}
	
	public void setDataSearch(City city) {
		lblNameCity.setText(city.getNameCity());
		lbl_Temp.setText(city.getTemperature());
		lbl_TempMinMax.setText(city.getTemp_minmax());
		lbl_Huli.setText(city.getHumidity());
		lbl_Vision.setText(city.getVision());
		lbl_Wind.setText(city.getWind());
		lbl_Uv.setText(city.getUv());
		lbl_Air.setText(city.getAir());
		lbl_Status.setText(city.getStatus());
	}
	
//	public static void main(String[] args) {
//		Detail0 dt = new Detail0();
//		City city = new Handle().Search("hà tĩnh");
//		dt.setDataSearch(city);
//	}
}
