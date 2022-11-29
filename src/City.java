
public class City {
	private String nameCity;
	private String temperature;
	private String status;
	private String humidity;
	private String temp_minmax;
	private String vision;
	private String wind;
	private String uv;
	private String air;
	
	
	public City(String nameCity, String temperature, String status, String humidity) {
		this.nameCity = nameCity;
		this.temperature = temperature;
		this.status = status;
		this.humidity = humidity;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getTemp_minmax() {
		return temp_minmax;
	}

	public void setTemp_minmax(String temp_minmax) {
		this.temp_minmax = temp_minmax;
	}

	public String getVision() {
		return vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public String getUv() {
		return uv;
	}

	public void setUv(String uv) {
		this.uv = uv;
	}
	
	public String getAir() {
		return air;
	}

	public void setAir(String air) {
		this.air = air;
	}

	public City(String nameCity, String temperature, String status, String humidity, String temp_minmax, String vision,
			String wind, String uv, String air) {
		this.nameCity = nameCity;
		this.temperature = temperature;
		this.status = status;
		this.humidity = humidity;
		this.temp_minmax = temp_minmax;
		this.vision = vision;
		this.wind = wind;
		this.uv = uv;
		this.air = air;
	}
	
}
