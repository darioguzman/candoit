package ar.candoit.weatherapplication.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "weather")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"id"}, ignoreUnknown = true)
//@IdClass(WeatherId.class)
public class Weather {
	
	private Long humidity;
	
	private Long pressure;
	
	private Double st;
	
	private Long visibility;
	
	@JsonProperty("wind_speed")
	private Long windSpeed;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
//	@Id
	private String description;
	
	private Double temp;
	
	@JsonProperty("wing_deg")
	private String wingDeg;
	
	private String tempDesc;
	
	public Weather(){
	
	}
	
	/**
	 * 
	 * @param id
	 * @param windSpeed
	 * @param humidity
	 * @param pressure
	 * @param wingDeg
	 * @param visibility
	 * @param tempDesc
	 * @param description
	 * @param temp
	 * @param st
	 */
	public Weather(Long humidity, Long pressure, Double st, Long visibility, Long windSpeed, Long id, String description, Double temp, String wingDeg,
			String tempDesc){
	
		super();
		this.humidity = humidity;
		this.pressure = pressure;
		this.st = st;
		this.visibility = visibility;
		this.windSpeed = windSpeed;
		this.id = id;
		this.description = description;
		this.temp = temp;
		this.wingDeg = wingDeg;
		this.tempDesc = tempDesc;
	}

	public Long getHumidity() {
	
		return humidity;
	}
	
	public void setHumidity(Long humidity) {
	
		this.humidity = humidity;
	}
	
	public Long getPressure() {
	
		return pressure;
	}
	
	public void setPressure(Long pressure) {
	
		this.pressure = pressure;
	}
	
	public Double getSt() {
	
		return st;
	}
	
	public void setSt(Double st) {
	
		this.st = st;
	}
	
	public Long getVisibility() {
	
		return visibility;
	}
	
	public void setVisibility(Long visibility) {
	
		this.visibility = visibility;
	}
	
	public Long getWindSpeed() {
	
		return windSpeed;
	}
	
	public void setWindSpeed(Long windSpeed) {
	
		this.windSpeed = windSpeed;
	}
	
	public Long getId() {
	
		return id;
	}
	
	public void setId(Long id) {
	
		this.id = id;
	}
	
	public String getDescription() {
	
		return description;
	}
	
	public void setDescription(String description) {
	
		this.description = description;
	}
	
	public Double getTemp() {
	
		return temp;
	}
	
	public void setTemp(Double temp) {
	
		this.temp = temp;
	}
	
	public String getWingDeg() {
	
		return wingDeg;
	}
	
	public void setWingDeg(String wingDeg) {
	
		this.wingDeg = wingDeg;
	}
	
	public String getTempDesc() {
	
		return tempDesc;
	}
	
	public void setTempDesc(String tempDesc) {
	
		this.tempDesc = tempDesc;
	}
	
	@Override
	public String toString() {
	
		StringBuffer buffer = new StringBuffer();
		
		buffer.append((this.getTemp() != null) ? "Temperatura: " + this.getTempDesc() + "\n" : "");
		buffer.append((this.getWindSpeed() != null) ? "Velocidad del viento: " + this.getWindSpeed() + "\n" : "");
		buffer.append((this.getDescription() != null) ? "Descripción: " + this.getDescription() + "\n" : "");
		buffer.append((this.getPressure() != null) ? "Presión: " + this.getPressure() + "\n" : "");
		buffer.append((this.getHumidity() != null) ? "Húmedad: " + this.getHumidity() + "\n" : "");
		
		return buffer.toString();
	}
	
}
