package ar.candoit.weatherapplication.service;

import java.util.List;

import ar.candoit.weatherapplication.model.Location;


public interface AppService {
	
	List<Location> getAllLocations();
	
	List <Location> getAllLocationsFromName(String name);
}
