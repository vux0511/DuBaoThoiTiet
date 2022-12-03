import java.io.Serializable;

public class ListCity implements Serializable{
	private City[] cityArray = new City[8];
	
	public ListCity() {	
	}
	
	public ListCity(City[] cityArray) {
		this.cityArray = cityArray;
	}

	public City[] getCityArray() {
		return cityArray;
	}

	public void setCityArray(City[] cityArray) {
		this.cityArray = cityArray;
	}
	
	public void addCityArray(City city, int index) {
		this.cityArray[index] = city;
	}
	
}
