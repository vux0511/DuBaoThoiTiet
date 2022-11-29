import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class ThoiTietView extends JFrame implements ActionListener {
	ImageIcon iconSun = new ImageIcon("C:\\Users\\vu_20\\Desktop\\02n@2x.png", "Lock");
	ImageIcon icon1 = new ImageIcon("C:\\Users\\vu_20\\Desktop\\04n@2x.png", "Lock");
	ImageIcon icon_do_am = new ImageIcon("C:\\Users\\vu_20\\Desktop\\giotnuoc2.png", "Lock");
	ImageIcon icon_location = new ImageIcon("C:\\Users\\vu_20\\Desktop\\location.png", "Lock");

	private JTextField textField_Search;
	JLabel jLabel_NameCityRight, lbl_humidity, lblTempMinmax, lblNewLabel_12, lbl_Status, 
	jLabel_TemperatureRight , lblVision,lblUv,lblWind; 

	
	public ThoiTietView() {
		
		getContentPane().setLayout(null);
		this.setTitle("Dự Báo Thời Tiết");
		JPanel panel_top = new JPanel();
		panel_top.setBounds(8, 10, 741, 46);
		getContentPane().add(panel_top);
		panel_top.setLayout(null);
		
		JButton btn_Search = new JButton("Tìm kiếm");
		btn_Search.addActionListener(this);
		btn_Search.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Search.setBounds(465, 10, 88, 28);
		panel_top.add(btn_Search);
		
		textField_Search = new JTextField();
		textField_Search.setBounds(200, 10, 257, 28);
		panel_top.add(textField_Search);
		textField_Search.setColumns(10);
		
		JLabel lbl_logo = new JLabel("");
		lbl_logo.setIcon(new ImageIcon("C:\\Users\\vu_20\\Desktop\\02d2x.png"));
		lbl_logo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logo.setBounds(0, 0, 72, 46);
		panel_top.add(lbl_logo);
		
		JPanel panel_main_left = new JPanel();
		panel_main_left.setBounds(8, 95, 523, 371);
		getContentPane().add(panel_main_left);
		panel_main_left.setLayout(new GridLayout(2 , 3, 10 , 10));
		
		Handle hd = new Handle();
		
		View jPanel1 = new View();
		jPanel1.setData(hd.getCityWeather(0).getNameCity(), hd.getCityWeather(0).getTemperature(), hd.getCityWeather(0).getStatus());
		View jPanel2 = new View();
		jPanel2.setData(hd.getCityWeather(1).getNameCity(), hd.getCityWeather(1).getTemperature(), hd.getCityWeather(1).getStatus());
		View jPanel3 = new View();
		jPanel3.setData(hd.getCityWeather(2).getNameCity(), hd.getCityWeather(2).getTemperature(), hd.getCityWeather(2).getStatus());
		View jPanel4 = new View();
		jPanel4.setData(hd.getCityWeather(3).getNameCity(), hd.getCityWeather(3).getTemperature(), hd.getCityWeather(3).getStatus());
		View jPanel5 = new View();
		jPanel5.setData(hd.getCityWeather(4).getNameCity(), hd.getCityWeather(4).getTemperature(), hd.getCityWeather(4).getStatus());
		View jPanel6 = new View();
		jPanel6.setData(hd.getCityWeather(5).getNameCity(), hd.getCityWeather(5).getTemperature(), hd.getCityWeather(5).getStatus());
		View jPanel7 = new View();
		jPanel7.setData(hd.getCityWeather(6).getNameCity(), hd.getCityWeather(6).getTemperature(), hd.getCityWeather(6).getStatus());
		View jPanel8 = new View();
		jPanel8.setData(hd.getCityWeather(7).getNameCity(), hd.getCityWeather(7).getTemperature(), hd.getCityWeather(7).getStatus());
		panel_main_left.add(jPanel1);
		panel_main_left.add(jPanel2);
		panel_main_left.add(jPanel3);
		panel_main_left.add(jPanel4);
		panel_main_left.add(jPanel5);
		panel_main_left.add(jPanel6);
		panel_main_left.add(jPanel7);
		panel_main_left.add(jPanel8);
		
		
		for (int i = 0; i < 8; i++) {
			System.out.println(hd.getCityWeather(i).getTemperature());
		}
		
		JPanel panel_main_right = new JPanel();
		panel_main_right.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main_right.setBounds(539, 95, 210, 371);
		getContentPane().add(panel_main_right);
		panel_main_right.setLayout(null);
		
		jLabel_NameCityRight = new JLabel();
		jLabel_NameCityRight.setText("Hà Nội");
		jLabel_NameCityRight.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel_NameCityRight.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabel_NameCityRight.setBounds(8, 10, 182, 27);
		panel_main_right.add(jLabel_NameCityRight);
		
		JLabel jLabel_TimeRight = new JLabel("Đã cập nhật 27 phút trước");
		jLabel_TimeRight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		jLabel_TimeRight.setBounds(8, 36, 182, 13);
		panel_main_right.add(jLabel_TimeRight);
		
		JLabel lblNewLabel_8 = new JLabel(icon1);
		lblNewLabel_8.setBounds(8, 59, 72, 75);
		panel_main_right.add(lblNewLabel_8);
		
		jLabel_TemperatureRight = new JLabel("18° C");
		jLabel_TemperatureRight.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_TemperatureRight.setFont(new Font("Tahoma", Font.BOLD, 30));
		jLabel_TemperatureRight.setBounds(107, 59, 83, 80);
		panel_main_right.add(jLabel_TemperatureRight);
		
		lbl_Status = new JLabel("Cảm giác như 18°.");
		lbl_Status.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_Status.setBounds(8, 144, 168, 13);
		panel_main_right.add(lbl_Status);
		
		JPanel panel = new JPanel();
		panel.setBounds(8, 167, 194, 21);
		panel_main_right.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_TempMinMax = new JLabel("Thấp/Cao");
		lbl_TempMinMax.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TempMinMax.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_TempMinMax.setBounds(8, 5, 87, 13);
		panel.add(lbl_TempMinMax);
		
		lblTempMinmax = new JLabel("17°/31°");
		lblTempMinmax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTempMinmax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTempMinmax.setBounds(128, 5, 58, 13);
		panel.add(lblTempMinmax);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(8, 198, 194, 21);
		panel_main_right.add(panel_1);
		
		JLabel lblNewLabel_12_1 = new JLabel("Độ ẩm");
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12_1.setBounds(8, 5, 87, 13);
		panel_1.add(lblNewLabel_12_1);
		
		lbl_humidity = new JLabel("88%");
		lbl_humidity.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_humidity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_humidity.setBounds(140, 5, 46, 13);
		panel_1.add(lbl_humidity);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(8, 230, 194, 21);
		panel_main_right.add(panel_2);
		
		JLabel lblNewLabel_12_2 = new JLabel("Tầm nhìn");
		lblNewLabel_12_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_12_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12_2.setBounds(8, 5, 87, 13);
		panel_2.add(lblNewLabel_12_2);
		
		lblVision = new JLabel("10 km");
		lblVision.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVision.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVision.setBounds(133, 5, 53, 13);
		panel_2.add(lblVision);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(8, 262, 194, 21);
		panel_main_right.add(panel_3);
		
		JLabel lblNewLabel_12_3 = new JLabel("Gió");
		lblNewLabel_12_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_12_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12_3.setBounds(8, 5, 87, 13);
		panel_3.add(lblNewLabel_12_3);
		
		lblWind = new JLabel("1.03 km/giờ");
		lblWind.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWind.setBounds(113, 5, 73, 13);
		panel_3.add(lblWind);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(8, 293, 194, 21);
		panel_main_right.add(panel_5);
		
		JLabel lblNewLabel_12_5 = new JLabel("Chỉ số UV");
		lblNewLabel_12_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_12_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12_5.setBounds(8, 5, 87, 13);
		panel_5.add(lblNewLabel_12_5);
		
		lblUv = new JLabel("0");
		lblUv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUv.setBounds(156, 5, 30, 13);
		panel_5.add(lblUv);
		
		JLabel lblNewLabel = new JLabel("Dự báo thời tiết các tỉnh / thành phố");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(18, 63, 239, 22);
		getContentPane().add(lblNewLabel);
		setMainRight();
	}
	

	
	public void setThoiTiet(String nhietdo) {
		jLabel_TemperatureRight.setText(nhietdo);
	}
	public void setMainRight() {
		City setDaNang = new Handle().getDaNang(); 
		lbl_humidity.setText(setDaNang.getHumidity());
		jLabel_NameCityRight.setText(setDaNang.getNameCity());
		jLabel_TemperatureRight.setText(setDaNang.getTemperature());
		lbl_Status.setText(setDaNang.getStatus());
		lblVision.setText(setDaNang.getVision());
		lblUv.setText(setDaNang.getUv());
		lblWind.setText(setDaNang.getWind());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String txt_search = textField_Search.getText();
		City city = new Handle().Search(txt_search);
		if (city == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thành phố này!",
                    "ERROR", JOptionPane.ERROR_MESSAGE);		
         } else {
			new Detail0().setDataSearch(city);
		}
		
	}
	
}
