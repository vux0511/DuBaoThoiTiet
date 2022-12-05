import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.regex.Pattern;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import javax.swing.JSeparator;


public class ThoiTietMain extends JFrame implements ActionListener {
	public ThoiTietMain() {
	}

	public void init() {		
		try {	
			ThoiTietView ttv = new ThoiTietView();
			ttv.setSize(775,520);
			ttv.setVisible(true);
			ttv.setLocationRelativeTo(null);
						
			}catch(Exception e1) {
			System.out.println("Không tìm thấy thành phố này");
		}
	}


	public static void main(String[] args) {
		
		ThoiTietMain ttm = new ThoiTietMain();
		ttm.init();
		ttm.setTitle("Dự Báo Thời Tiết");
		ttm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
