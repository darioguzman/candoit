package ar.candoit.weatherapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.candoit.weatherapplication.model.Location;
import ar.candoit.weatherapplication.repository.LocationRepository;
import ar.candoit.weatherapplication.service.AppService;

@RestController
@RequestMapping("/api")
public class LocationController {
	
	@Autowired
    private LocationRepository repository;

	@Autowired
	private AppService service;
	
	@GetMapping("/getInfoLocations")
	public List<Location> getAllLocations() {

		List<Location> locations = service.getAllLocations();
		
		return locations;
	}
	
	@GetMapping("/getInfoLocations/{name}")
	public List<Location> getInfoLocationsByName(@PathVariable(value = "name") String name) {

		List<Location> locations = service.getAllLocationsFromName(name);
		
		for (Location location : locations) {
			System.out.println("Saving: " + location.toString());
			repository.save(location);
		}
		
		return locations;
	}
	
	@GetMapping("/getInfoLocation/{name}")
	public Location getInfoLocationByLocationName(@PathVariable(value = "name") String name) {

		Location location = repository.findByName(name);
		
		System.out.println("Found: " + location.toString());
		
		return location;
	}
	
	@GetMapping("/getInfoLocationsFromDb/{name}")
	public List<Location> getInfoLocationsFromDbByName(@PathVariable(value = "name") String name) {

		List<Location> locations = repository.findByProvince(name);
		
		for (Location location : locations) {
			System.out.println("Location: " + location.toString());
		}
//		
		return locations;
	}

}
