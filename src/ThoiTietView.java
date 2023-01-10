import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class ThoiTietView extends JFrame implements ActionListener {
	ImageIcon iconSun = new ImageIcon("C:\\Users\\vu_20\\Desktop\\02n@2x.png", "Lock");
	ImageIcon icon1 = new ImageIcon("C:\\Users\\vu_20\\Desktop\\04n@2x.png", "Lock");
	ImageIcon icon_do_am = new ImageIcon("C:\\Users\\vu_20\\Desktop\\giotnuoc2.png", "Lock");
	ImageIcon icon_location = new ImageIcon("C:\\Users\\vu_20\\Desktop\\location.png", "Lock");
	JComboBox comboBox;

	private JTextField textFieldSearch;
	JLabel jLabelNameCityRight, jLabelHumiNumber, jLabelTempMinmax, lblNewLabel_12, jLabelStatus ,jLabelIconRight,
	jLabel_TemperatureRight , jLabelVision,jLabelUV,jLabelWind; 
	ObjectInputStream input;
	DataOutputStream output;
	
	public ThoiTietView() {
				
		getContentPane().setLayout(null);
		this.setTitle("Dự Báo Thời Tiết");
		JPanel panelTop = new JPanel();
		panelTop.setBounds(8, 10, 741, 46);
		getContentPane().add(panelTop);
		panelTop.setLayout(null);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(this);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(465, 10, 88, 28);
		panelTop.add(btnSearch);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(200, 10, 257, 28);
		panelTop.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JLabel jLabelLogo = new JLabel("");
		jLabelLogo.setIcon(new ImageIcon("C:\\Users\\vu_20\\Desktop\\02d2x.png"));
		jLabelLogo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelLogo.setBounds(0, 0, 72, 46);
		panelTop.add(jLabelLogo);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"An Giang", "Bà Rịa Vũng Tàu",
				"Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định",
				"Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", 
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai",
				"Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", 
				"Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", 
				"Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
				"Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", 
				"Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Hồ Chí Minh",
				"Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"}));
		comboBox.setBounds(597, 12, 125, 26);
		panelTop.add(comboBox);
		
		// Set AcctionListener cho comboBox
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				
				String txtSearchComboBox = (String) comboBox.getSelectedItem();
				
				try {
					output.writeUTF(txtSearchComboBox);
					output.flush();
					
					City city = (City) input.readObject();
					if (city == null) {
			            JOptionPane.showMessageDialog(null, "Không tìm thấy thành phố này!",
			                    "ERROR", JOptionPane.ERROR_MESSAGE);
			         } else {
						new Detail().setDataSearch(city);
			         }
				} catch (Exception e2) {	
				}
			}
		});
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(8, 95, 523, 371);
		getContentPane().add(panelMain);
		panelMain.setLayout(new GridLayout(2 , 3, 10 , 10));
		
		Handle hd = new Handle();
		
		
		try {
			byte[] byte_read = new byte[9999];
			Scanner sc = new Scanner(System.in);
			Socket socket = new Socket("localhost", 6868);
			System.out.println("Connected" + socket);
			
			input = new ObjectInputStream(socket.getInputStream());
			output = new DataOutputStream( socket.getOutputStream());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			output.writeUTF("setMain");
			output.flush();
			
			ListCity cityArray = (ListCity) input.readObject();
			for (int i=0; i < 8; i++) {
				View jPanel1 = new View();
				jPanel1.setData(cityArray.getCityArray()[i].getNameCity(), cityArray.getCityArray()[i].getTemperature(),
						cityArray.getCityArray()[i].getStatus(),cityArray.getCityArray()[i].getUrlIcon());
				panelMain.add(jPanel1);
			}
		
			JPanel panelMainRight = new JPanel();
			panelMainRight.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelMainRight.setBounds(539, 95, 210, 371);
			getContentPane().add(panelMainRight);
			panelMainRight.setLayout(null);
			
			jLabelNameCityRight = new JLabel();
			jLabelNameCityRight.setText("Hà Nội");
			jLabelNameCityRight.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelNameCityRight.setFont(new Font("Tahoma", Font.BOLD, 14));
			jLabelNameCityRight.setBounds(8, 10, 182, 27);
			panelMainRight.add(jLabelNameCityRight);
			
			jLabelIconRight = new JLabel("");
			jLabelIconRight.setBounds(8, 59, 72, 75);
			panelMainRight.add(jLabelIconRight);
			
			jLabel_TemperatureRight = new JLabel("18° C");
			jLabel_TemperatureRight.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel_TemperatureRight.setFont(new Font("Tahoma", Font.BOLD, 30));
			jLabel_TemperatureRight.setBounds(107, 59, 83, 80);
			panelMainRight.add(jLabel_TemperatureRight);
			
			jLabelStatus = new JLabel("Cảm giác như 18°.");
			jLabelStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelStatus.setBounds(8, 144, 168, 13);
			panelMainRight.add(jLabelStatus);
			
			JPanel panel = new JPanel();
			panel.setBounds(8, 167, 194, 21);
			panelMainRight.add(panel);
			panel.setLayout(null);
			
			JLabel jLabelMinMaxRight = new JLabel("Thấp/Cao");
			jLabelMinMaxRight.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelMinMaxRight.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelMinMaxRight.setBounds(8, 5, 87, 13);
			panel.add(jLabelMinMaxRight);
			
			jLabelTempMinmax = new JLabel("17°/31°");
			jLabelTempMinmax.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTempMinmax.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jLabelTempMinmax.setBounds(128, 5, 58, 13);
			panel.add(jLabelTempMinmax);
			
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBounds(8, 198, 194, 21);
			panelMainRight.add(panel_1);
			
			JLabel jLabelHumiRight = new JLabel("Độ ẩm");
			jLabelHumiRight.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelHumiRight.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelHumiRight.setBounds(8, 5, 87, 13);
			panel_1.add(jLabelHumiRight);
			
			jLabelHumiNumber = new JLabel("88%");
			jLabelHumiNumber.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelHumiNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jLabelHumiNumber.setBounds(140, 5, 46, 13);
			panel_1.add(jLabelHumiNumber);
			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBounds(8, 230, 194, 21);
			panelMainRight.add(panel_2);
			
			JLabel jLabelVisionRight = new JLabel("Tầm nhìn");
			jLabelVisionRight.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelVisionRight.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelVisionRight.setBounds(8, 5, 87, 13);
			panel_2.add(jLabelVisionRight);
			
			jLabelVision = new JLabel("10 km");
			jLabelVision.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelVision.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jLabelVision.setBounds(133, 5, 53, 13);
			panel_2.add(jLabelVision);
			
			JPanel panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBounds(8, 262, 194, 21);
			panelMainRight.add(panel_3);
			
			JLabel jLabelWindRight = new JLabel("Gió");
			jLabelWindRight.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelWindRight.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelWindRight.setBounds(8, 5, 87, 13);
			panel_3.add(jLabelWindRight);
			
			jLabelWind = new JLabel("1.03 km/giờ");
			jLabelWind.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelWind.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jLabelWind.setBounds(113, 5, 73, 13);
			panel_3.add(jLabelWind);
			
			JPanel panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.setBounds(8, 293, 194, 21);
			panelMainRight.add(panel_5);
			
			JLabel jLabelUVRight = new JLabel("Chỉ số UV");
			jLabelUVRight.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelUVRight.setFont(new Font("Tahoma", Font.BOLD, 12));
			jLabelUVRight.setBounds(8, 5, 87, 13);
			panel_5.add(jLabelUVRight);
			
			jLabelUV = new JLabel("0");
			jLabelUV.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelUV.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jLabelUV.setBounds(156, 5, 30, 13);
			panel_5.add(jLabelUV);
			
			JLabel jLabelTitleMain = new JLabel("Dự báo thời tiết các tỉnh / thành phố");
			jLabelTitleMain.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jLabelTitleMain.setBounds(18, 63, 239, 22);
			getContentPane().add(jLabelTitleMain);
		
			} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			BufferedImage bufferImage_hidden = ImageIO.read(new File("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/muavua.png"));
			ImageIcon imageIcon_hidden = new ImageIcon(bufferImage_hidden.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
			jLabelIconRight.setIcon(imageIcon_hidden);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMainRight();
		comboOptionActionPerformed();
	}
	

	public void setThoiTiet(String nhietdo) {
		jLabel_TemperatureRight.setText(nhietdo);
	}
	
	public void setMainRight() {
		try {
			output.writeUTF("setMainRight");
			output.flush();
			City setDaNang = (City) input.readObject();
			
			jLabelHumiNumber.setText(setDaNang.getHumidity());
			jLabelNameCityRight.setText(setDaNang.getNameCity());
			jLabel_TemperatureRight.setText(setDaNang.getTemperature());
			jLabelStatus.setText(setDaNang.getStatus());
			jLabelVision.setText(setDaNang.getVision());
			jLabelUV.setText(setDaNang.getUv());
			jLabelWind.setText(setDaNang.getWind());
			
			if (setDaNang.getStatus() == "Mây rải rác") {
				jLabelIconRight.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/mayrairac.png"));
			} else if (setDaNang.getStatus() == "Mưa vừa") {
				jLabelIconRight.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/muavua.png"));
			} else if (setDaNang.getStatus() == "Mưa cường độ nặng") {
				jLabelIconRight.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/muacuongdonang.png"));
			} else if (setDaNang.getStatus() == "Nhiều mây") {
				jLabelIconRight.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/nhieumay.png"));
			} else if (setDaNang.getStatus().equalsIgnoreCase("Sương mờ")) {
				jLabelIconRight.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/suongmo.png"));
			} else if (setDaNang.getStatus().equalsIgnoreCase("Trời quang mây đãng")) {
				jLabelIconRight.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/troiquangmaydang.png"));
			} else if(setDaNang.getStatus().equalsIgnoreCase("Mây cụm")) {
				jLabelIconRight.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/maycum.png"));
			} else if(setDaNang.getStatus().equalsIgnoreCase("Mây thua")) {
				jLabelIconRight.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/maythua.png"));
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public ImageIcon setIconMain(String url) {
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(url));
			ImageIcon imageIcon = new ImageIcon(bufferedImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
			return imageIcon;
		} catch (Exception e) {
			e.printStackTrace();
			return null ; 
		}
	}

	//Set Search
	@Override
	public void actionPerformed(ActionEvent e) {
		String txt_search = textFieldSearch.getText();
		try {
			output.writeUTF(txt_search);
			output.flush();
			
			City city = (City) input.readObject();
			if (city == null) {
	            JOptionPane.showMessageDialog(this, "Không tìm thấy thành phố này!",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);		
	         } else {
				new Detail().setDataSearch(city);
	         }
		} catch (Exception e2) {	
		}
	}
	
	public void comboOptionActionPerformed() {
		comboBox.addActionListener(comboBox);
		String selected = comboBox.getSelectedItem().toString();
		System.out.println("Selected Item  = " + selected);
		
		try {
			if ("An Giang".equals(selected)) {
				System.out.println(selected);
			} else {
				System.out.println("Sai rùi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
