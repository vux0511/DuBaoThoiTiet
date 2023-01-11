import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.Normalizer;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class View extends JPanel {

	JLabel jLabelNameCity, jLabelTemp, jLabelStatus;
	JLabel jLabelIcon;
	
	public View() {

		setLayout(new BorderLayout(0, 0));
		JPanel panelMain = new JPanel();
		
		// Sự kiện click vào JPanel
		panelMain.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				City city = new Handle().Search(convert_Url(jLabelNameCity.getText()));
				new Detail().setDataSearch(city);
			}

			@Override
			public void mousePressed(MouseEvent e) {				
			}

			@Override
			public void mouseReleased(MouseEvent e) {				
			}

			@Override
			public void mouseEntered(MouseEvent e) {				
			}

			@Override
			public void mouseExited(MouseEvent e) {				
			}
		});
		
		panelMain.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelMain.setLayout(new BorderLayout(0, 0));
		
		jLabelNameCity = new JLabel("Đà Nẵng");
		jLabelNameCity.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelNameCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelMain.add(jLabelNameCity, BorderLayout.NORTH);
		
		jLabelTemp = new JLabel("17° / 17°");
		jLabelTemp.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTemp.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelMain.add(jLabelTemp, BorderLayout.SOUTH);
		
		JPanel panelIcon = new JPanel();
		panelMain.add(panelIcon, BorderLayout.CENTER);
		panelIcon.setLayout(new BorderLayout(0, 0));
		
		jLabelStatus = new JLabel("Nhiều mây");
		jLabelStatus.setVerticalAlignment(SwingConstants.TOP);
		jLabelStatus.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelIcon.add(jLabelStatus, BorderLayout.SOUTH);
		
		jLabelIcon = new JLabel("");
		jLabelIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		try {
			BufferedImage bufferImage_hidden = ImageIO.read(new File("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/muavua.png"));
			ImageIcon imageIcon_hidden = new ImageIcon(bufferImage_hidden.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
			jLabelIcon.setIcon(imageIcon_hidden);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panelIcon.add(jLabelIcon, BorderLayout.CENTER);
		
		this.add(panelMain);
		jLabelIcon.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/maycum.png"));
	}
	
	public static String convert_Url(String city) { 
		try {
            String temp = Normalizer.normalize(city, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
	      } catch (Exception ex) {
	            ex.printStackTrace();
	      }
		return city;
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
	
	public void setData(String namecity,String temp, String infor, String iCon) {
		jLabelNameCity.setText(namecity);
		jLabelTemp.setText(temp);
		jLabelStatus.setText(infor);

		if (infor == "Mưa vừa") {
			jLabelIcon.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/muavua.png"));
		} else if (infor == "Mưa cường độ nặng") {
			jLabelIcon.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/muacuongdonang.png"));
		} else if (infor.equalsIgnoreCase("Nhiều mây")) {
			jLabelIcon.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/nhieumay.png"));
		} else if(infor.equalsIgnoreCase("Mây cụm")) {
			jLabelIcon.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/maycum.png"));
		}  else if(infor.equalsIgnoreCase("Mây thưa")) {
			jLabelIcon.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/maythua.png"));
		} else if(infor.equalsIgnoreCase("Sương mờ")) {
			jLabelIcon.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/suongmo.png"));
		} else if(infor.equalsIgnoreCase("Bầu trời quang đãng")) {
			jLabelIcon.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/bautroiquangdang.png"));
		} else if(infor.equalsIgnoreCase("Mây rải rác")) {
			jLabelIcon.setIcon(setIconMain("/Users/vux/Documents/Java/DuBaoThoiTiet/Image/mayrairac.png"));
		}
	}

}
