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

	ImageIcon iconSun = new ImageIcon("C:\\Users\\vu_20\\Desktop\\02n@2x.png", "Lock");
	ImageIcon icon1 = new ImageIcon("C:\\Users\\vu_20\\Desktop\\04n@2x.png", "Lock");
	ImageIcon iCon;
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
				new Detail0().setDataSearch(city);
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
		
		System.out.println("hrllo");
		
		jLabelIcon = new JLabel("");
		jLabelIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		try {
			BufferedImage bufferImage_hidden = ImageIO.read(new File("image\\muavua.png"));
			ImageIcon imageIcon_hidden = new ImageIcon(bufferImage_hidden.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
			jLabelIcon.setIcon(imageIcon_hidden);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panelIcon.add(jLabelIcon, BorderLayout.CENTER);
		
		this.add(panelMain);
		jLabelIcon.setIcon(setIconMain("image\\maycum.png"));
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

		if(infor.equalsIgnoreCase("Mây cụm")) {
			jLabelIcon.setIcon(setIconMain("image\\maycum.png"));
		} else if (infor == "Mây rải rác") {
			jLabelIcon.setIcon(setIconMain("image\\mayrairac.png"));
		} else if (infor == "Mưa vừa") {
			jLabelIcon.setIcon(setIconMain("image\\muavua.png"));
		} else if (infor == "Mưa cường độ nặng") {
			jLabelIcon.setIcon(setIconMain("image\\muacuongdonang.png"));
		} else if (infor.equalsIgnoreCase("Nhiều mây")) {
			jLabelIcon.setIcon(setIconMain("image\\nhieumay.png"));
		}
	}

}
