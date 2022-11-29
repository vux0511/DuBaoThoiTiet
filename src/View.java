import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.Normalizer;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class View extends JPanel {

	ImageIcon iconSun = new ImageIcon("C:\\Users\\vu_20\\Desktop\\02n@2x.png", "Lock");
	ImageIcon icon1 = new ImageIcon("C:\\Users\\vu_20\\Desktop\\04n@2x.png", "Lock");
	JLabel nameCity, temperature, status;
	
	public View() {

		setLayout(new BorderLayout(0, 0));
		JPanel panel_0 = new JPanel();
		
		// sự kiện click vào jpanel
		panel_0.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				City city = new Handle().Search(convert_Url(nameCity.getText()));
				new Detail0().setDataSearch(city);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		panel_0.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_0.setLayout(new BorderLayout(0, 0));
		
		nameCity = new JLabel("Đà Nẵng");
		nameCity.setHorizontalAlignment(SwingConstants.CENTER);
		nameCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_0.add(nameCity, BorderLayout.NORTH);
		
		temperature = new JLabel("17° / 17°");
		temperature.setHorizontalAlignment(SwingConstants.CENTER);
		temperature.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_0.add(temperature, BorderLayout.SOUTH);
		
		JPanel panel_6 = new JPanel();
		panel_0.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		status = new JLabel("Nhiều mây");
		status.setVerticalAlignment(SwingConstants.TOP);
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_6.add(status, BorderLayout.SOUTH);
		
		JLabel lbl_Icon = new JLabel((new ImageIcon("C:\\Users\\vu_20\\Desktop\\02n@2x.png")));
		lbl_Icon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(lbl_Icon, BorderLayout.CENTER);
		
		this.add(panel_0);
		
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

	public void setData(String namecity,String temp, String infor) {
		nameCity.setText(namecity);
		ImageIcon icon3 = new ImageIcon("C:\\Users\\vu_20\\Desktop\\02n@2x.png", "Lock");
		temperature.setText(temp);
		status.setText(infor);
	}

}
