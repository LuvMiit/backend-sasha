package org.rusgidro.repos;

import org.rusgidro.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    City findByCityName(String name);
}
