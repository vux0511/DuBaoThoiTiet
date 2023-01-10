import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

public class Detail extends JFrame {

	JLabel jLabelTitle, jLabelTempSearch, jLabelTempMinMax, jLabelHuli, jLabelVision, jLabelWind, jLabelUV, jLabelAirSearch,jLabelStatusSearch,jLabelImageSearch;
	
	public Detail() {
		getContentPane().setLayout(null);
		JPanel panelTop = new JPanel();
		panelTop.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelTop.setBounds(10, 10, 468, 201);
		getContentPane().add(panelTop);
		panelTop.setLayout(null);
		
		jLabelTitle = new JLabel("Dự Báo Thời Tiết Hôm Nay");
		jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		jLabelTitle.setHorizontalAlignment(SwingConstants.LEFT);
		jLabelTitle.setBounds(8, 10, 452, 20);
		panelTop.add(jLabelTitle);
		
		jLabelImageSearch = new JLabel("");
		jLabelImageSearch.setBounds(20, 40, 78, 79);
		panelTop.add(jLabelImageSearch);
		
		jLabelTempSearch = new JLabel("28\u00B0C");
		jLabelTempSearch.setFont(new Font("Tahoma", Font.BOLD, 35));
		jLabelTempSearch.setBounds(114, 50, 99, 53);
		panelTop.add(jLabelTempSearch);
		
		jLabelStatusSearch = new JLabel("");
		jLabelStatusSearch.setFont(new Font("Tahoma", Font.BOLD, 17));
		jLabelStatusSearch.setBounds(192, 50, 241, 25);
		panelTop.add(jLabelStatusSearch);
		
		JLabel jLabelMinMaxSearch = new JLabel("Th\u1EA5p/Cao");
		jLabelMinMaxSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabelMinMaxSearch.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelMinMaxSearch.setBounds(8, 132, 62, 13);
		panelTop.add(jLabelMinMaxSearch);
		
		jLabelTempMinMax = new JLabel("23\u00B0/29\u00B0");
		jLabelTempMinMax.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTempMinMax.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabelTempMinMax.setBounds(8, 151, 62, 13);
		panelTop.add(jLabelTempMinMax);
		
		JLabel jLabelHuliSearch = new JLabel("\u0110\u1ED9 \u1EA9m");
		jLabelHuliSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabelHuliSearch.setBounds(105, 132, 62, 13);
		panelTop.add(jLabelHuliSearch);
		
		jLabelHuli = new JLabel("74%");
		jLabelHuli.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelHuli.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabelHuli.setBounds(105, 151, 43, 13);
		panelTop.add(jLabelHuli);
		
		JLabel jLabelVisionSearch = new JLabel("T\u1EA7m nh\u00ECn");
		jLabelVisionSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabelVisionSearch.setBounds(192, 132, 62, 13);
		panelTop.add(jLabelVisionSearch);
		
		JLabel jLabelWindSearch = new JLabel("Gi\u00F3");
		jLabelWindSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabelWindSearch.setBounds(301, 132, 62, 13);
		panelTop.add(jLabelWindSearch);
		
		JLabel jLabelUVSearch = new JLabel("Test");
		jLabelUVSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabelUVSearch.setBounds(381, 132, 62, 13);
		panelTop.add(jLabelUVSearch);
		
		jLabelVision = new JLabel("10 km");
		jLabelVision.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelVision.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabelVision.setBounds(198, 151, 43, 13);
		panelTop.add(jLabelVision);
		
		jLabelWind = new JLabel("2.57 km/gi\u1EDD");
		jLabelWind.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelWind.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabelWind.setBounds(271, 151, 92, 13);
		panelTop.add(jLabelWind);
		
		jLabelUV = new JLabel("0");
		jLabelUV.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelUV.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabelUV.setBounds(391, 151, 43, 13);
		panelTop.add(jLabelUV);
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelBottom.setBounds(10, 221, 468, 40);
		getContentPane().add(panelBottom);
		panelBottom.setLayout(null);
		
		jLabelAirSearch = new JLabel("Ch\u1EA5t l\u01B0\u1EE3ng kh\u00F4ng kh\u00ED: Kh\u00E1");
		jLabelAirSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelAirSearch.setBounds(8, 10, 452, 20);
		jLabelAirSearch.setHorizontalAlignment(SwingConstants.LEFT);
		panelBottom.add(jLabelAirSearch);
		this.setVisible(true);
		this.setSize(500, 310);
		this.setLocationRelativeTo(null);
		
		try {
			BufferedImage bufferImage_hidden = ImageIO.read(new File("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/muavua.png"));
			ImageIcon imageIcon_hidden = new ImageIcon(bufferImage_hidden.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
			jLabelImageSearch.setIcon(imageIcon_hidden);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ImageIcon setIconSearch(String url) {
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(url));
			ImageIcon imageIcon = new ImageIcon(bufferedImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
			return imageIcon;
		} catch (Exception e) {
			e.printStackTrace();
			return null ; 
		}
	}
	
	public void setDataSearch(City city) {
		jLabelTitle.setText(city.getNameCity());
		jLabelTempSearch.setText(city.getTemperature());
		jLabelTempMinMax.setText(city.getTemp_minmax());
		jLabelHuli.setText(city.getHumidity());
		jLabelVision.setText(city.getVision());
		jLabelWind.setText(city.getWind());
		jLabelUV.setText(city.getUv());
		jLabelAirSearch.setText(city.getAir());
		jLabelStatusSearch.setText(city.getStatus());
				
		if (city.getStatus() == "Mây rải rác") {
			jLabelImageSearch.setIcon(setIconSearch("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/mayrairac.png"));
		} else if (city.getStatus() == "Mưa vừa") {
			jLabelImageSearch.setIcon(setIconSearch("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/muavua.png"));
		} else if (city.getStatus() == "Mưa cường độ nặng") {
			jLabelImageSearch.setIcon(setIconSearch("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/muacuongdonang.png"));
		} else if (city.getStatus().equalsIgnoreCase("Nhiều mây")) {
			jLabelImageSearch.setIcon(setIconSearch("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/nhieumay.png"));
		} else if (city.getStatus().equalsIgnoreCase("Sương mờ")) {
			jLabelImageSearch.setIcon(setIconSearch("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/suongmo.png"));
		} else if (city.getStatus().equalsIgnoreCase("Mây thưa")) {
			jLabelImageSearch.setIcon(setIconSearch("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/maythua.png"));
		} else if (city.getStatus().equalsIgnoreCase("Bầu trời quang đãng")) {
			jLabelImageSearch.setIcon(setIconSearch("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/bautroiquangdang.png"));
		} else if (city.getStatus().equalsIgnoreCase("Mây cụm")) {
			jLabelImageSearch.setIcon(setIconSearch("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/maycum.png"));
		}
	}
	
}
