package ar.candoit.weatherapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.candoit.weatherapplication.model.Location;


@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	List<Location> findByProvince(String province);
	
	Location findByName(String name);
}
