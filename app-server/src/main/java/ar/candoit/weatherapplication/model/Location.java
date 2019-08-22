package ar.candoit.weatherapplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "location")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
//@IdClass(LocationId.class)
public class Location implements Comparable<Location>{
	
	public Location(){
	
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double dist;
	
	private Long lid;
	
	private Long fid;
	
	@JsonProperty("int_number")
	private Long intNumber;
	
	@NotBlank
//	@Id
	private String name;
	
	@NotBlank
//	@Id
	private String province;
	
	private String lat;
	
	private String lon;
	
	private String zoom;
	
	private Long updated;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Weather weather;

	/**
	 * @return the id
	 */
	public Long getId() {
	
		return id;
	}
	
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
	
		this.id = id;
	}
	
	/**
	 * @return the dist
	 */
	public Double getDist() {
	
		return dist;
	}
	
	/**
	 * @param dist
	 *            the dist to set
	 */
	public void setDist(Double dist) {
	
		this.dist = dist;
	}
	
	/**
	 * @return the lid
	 */
	public Long getLid() {
	
		return lid;
	}
	
	/**
	 * @param lid
	 *            the lid to set
	 */
	public void setLid(Long lid) {
	
		this.lid = lid;
	}
	
	/**
	 * @return the fid
	 */
	public Long getFid() {
	
		return fid;
	}
	
	/**
	 * @param fid
	 *            the fid to set
	 */
	public void setFid(Long fid) {
	
		this.fid = fid;
	}
	
	/**
	 * @return the intNumber
	 */
	public Long getIntNumber() {
	
		return intNumber;
	}
	
	/**
	 * @param intNumber
	 *            the intNumber to set
	 */
	public void setIntNumber(Long intNumber) {
	
		this.intNumber = intNumber;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
	
		return name;
	}
	
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
	
		this.name = name;
	}
	
	/**
	 * @return the province
	 */
	public String getProvince() {
	
		return province;
	}
	
	/**
	 * @param province
	 *            the province to set
	 */
	public void setProvince(String province) {
	
		this.province = province;
	}
	
	/**
	 * @return the lat
	 */
	public String getLat() {
	
		return lat;
	}
	
	/**
	 * @param lat
	 *            the lat to set
	 */
	public void setLat(String lat) {
	
		this.lat = lat;
	}
	
	/**
	 * @return the lon
	 */
	public String getLon() {
	
		return lon;
	}
	
	/**
	 * @param lon
	 *            the lon to set
	 */
	public void setLon(String lon) {
	
		this.lon = lon;
	}
	
	/**
	 * @return the zoom
	 */
	public String getZoom() {
	
		return zoom;
	}
	
	/**
	 * @param zoom
	 *            the zoom to set
	 */
	public void setZoom(String zoom) {
	
		this.zoom = zoom;
	}
	
	/**
	 * @return the updated
	 */
	public Long getUpdated() {
	
		return updated;
	}
	
	/**
	 * @param updated
	 *            the updated to set
	 */
	public void setUpdated(Long updated) {
	
		this.updated = updated;
	}
	
	/**
	 * @return the weather
	 */
	public Weather getWeather() {
	
		return weather;
	}
	
	/**
	 * @param weather
	 *            the weather to set
	 */
	public void setWeather(Weather weather) {
	
		this.weather = weather;
	}
	
	@Override
	public String toString() {
	
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Provincia: " + this.getProvince() + "\n");
		buffer.append("Localidad: " + this.getName() + "\n");
		buffer.append("Clima: " + this.getWeather().toString());
		// buffer.append("Prónostico: " + this.getForecast().toString());
		return buffer.toString();
	}

	@Override
	public int compareTo(Location l) {
	
	    if (getName() == null || l.getName() == null) {
	      return 0;
	    }
	    return getName().compareTo(l.getName());
	}
	
}
