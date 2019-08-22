package ar.candoit.weatherapplication.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.candoit.weatherapplication.model.Location;

@Service
public class AppServiceImple implements AppService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public List<Location> getAllLocations() {
	
		Location[] locations = restTemplate.getForObject("https://ws.smn.gob.ar/map_items/weather", Location[].class);
		
		return Arrays.asList(locations);
		
	}

	@Override
	public List<Location> getAllLocationsFromName(String name) {
	
		Location[] result = restTemplate.getForObject("https://ws.smn.gob.ar/map_items/weather", Location[].class);
		
		List <Location> provinceList = Arrays.asList(result).stream().filter(x -> x.getProvince().equalsIgnoreCase(name)).collect(Collectors.toList());
		
		return provinceList;
	}
	
}
