package ar.candoit.weatherapplication.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public class LocationId implements Serializable {

    private static final long serialVersionUID = 1L;
	
	private String name;
    private String province;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((province == null) ? 0 : province.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LocationId other = (LocationId) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (province == null) {
            if (other.province != null)
                return false;
        } else if (!province.equals(other.province))
            return false;
        return true;
    }
	public LocationId(){
	
	}
	
	
	public void setId(Long id) {
	
		this.id = id;
	}
	
	
	public Long getId() {
	
		return id;
	}
	
}
