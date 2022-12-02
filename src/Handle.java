import java.text.Normalizer;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Handle {
	String url ;
	Document doc;
	
	public Handle() {
		try {	
			this.url = "https://thoitiet.vn/";
			doc = Jsoup.connect(url).timeout(5000).get();			
		}catch(Exception e1) {
			System.out.println("Không tìm thấy thành phố này");
		}
	}
	
	public City getCityWeather(int num){
		Element name = doc.select("h3[class=card-city-title]").get(num);
		System.out.println(name.ownText());
		Element temperature1 = doc.select("p[title=Hiện tại]").get(num);
		Element temperature2 = doc.select("p[title=Cảm giác như]").get(num);
		String temperature = temperature1.ownText()+ "/" +temperature2.ownText();
		Element status = doc.select("p[class=mb-0]").get(num);
		Element humidity = doc.select("div[class=precipitation]").get(num);
		
		return new City(name.ownText(),temperature, status.ownText(), humidity.ownText());
	}
	
	public City getDaNang() {
		try {	
			String url = "https://thoitiet.vn/da-nang";
			Document doc = Jsoup.connect(url).timeout(5000).get();
			Element nameCity = doc.select("a[href=/da-nang]").get(1);
			System.out.println(nameCity.ownText());
			Element temperature = doc.select("span[class=current-temperature]").first();
			Element status = doc.select("p[class=overview-caption-item overview-caption-item-detail]").first();
			Element temp_minmax = doc.select("span[class=text-white op-8 fw-bold]").first();
			Element humidity = doc.select("span[class=text-white op-8 fw-bold]").get(1);
			Element vision = doc.select("span[class=text-white op-8 fw-bold]").get(2);
			Element wind = doc.select("span[class=text-white op-8 fw-bold]").get(3);
			Element uv = doc.select("span[class=text-white op-8 fw-bold]").get(5);
			Element air = doc.select("h2[class=air-title]").first();

			return new City(nameCity.ownText(),temperature.ownText(), status.ownText(), humidity.ownText(),
					temp_minmax.ownText(), vision.ownText(), wind.ownText(), uv.ownText(), air.ownText());
			
		}catch(Exception e1) {
			System.out.println("Không tìm thấy thành phố này");
			return null;
		}


	}
	
	public City Search(String txt) {
		try {	
			String city = convert_Url(txt); 
			
			String url = "https://thoitiet.vn/"+city;
			System.out.println(city);
			Document doc = Jsoup.connect(url).timeout(5000).get();
			
			Element nameCity = doc.select("a[href=/"+city+"]").first();
			Element temperature = doc.select("span[class=current-temperature]").first();
			Element status = doc.select("p[class=overview-caption-item overview-caption-item-detail]").first();
			Element temp_minmax = doc.select("span[class=text-white op-8 fw-bold]").first();
			Element humidity = doc.select("span[class=text-white op-8 fw-bold]").get(1);
			Element vision = doc.select("span[class=text-white op-8 fw-bold]").get(2);
			Element wind = doc.select("span[class=text-white op-8 fw-bold]").get(3);
			Element uv = doc.select("span[class=text-white op-8 fw-bold]").get(5);
			Element air = doc.select("h2[class=air-title]").first();

			
			return new City(nameCity.ownText(),temperature.ownText(), status.ownText(), humidity.ownText(),
					temp_minmax.ownText(), vision.ownText(), wind.ownText(), uv.ownText(), air.ownText());
		}catch(Exception e1) {
			System.out.println("Không tìm thấy thành phố này");
			return null;
		}
	}
	
	
	public static String convert_Url(String city) { 
		try {
			System.out.println(city);
            String temp = Normalizer.normalize(city, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
	      } catch (Exception ex) {
	            ex.printStackTrace();
	      }
		return city;
	}
	
	
//	public static void main(String[] args) {
//		Handle hd = new Handle();
//		System.out.println(hd.Search("sdfsdf").getNameCity());
//		hd.getDaNang();
//	}
}
