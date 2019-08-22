package ar.candoit.weatherapplication.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.candoit.weatherapplication.model.Location;
import ar.candoit.weatherapplication.repository.LocationRepository;
import ar.candoit.weatherapplication.service.AppService;


@Controller
public class HomeController {

	@Autowired
	LocationRepository repository ;
	
	@Autowired
	AppService service;
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {

		repository.deleteAll();
		
		List<Location> locations = service.getAllLocationsFromName("Buenos Aires");
		
		
		for (Location location : locations) {
			System.out.println("Saving: " + location.toString());
			repository.save(location);
		}
		
		Collections.sort(locations) ;
		
		model.put("locations", locations);
		
		return "welcome";
	}

}