package org.rusgidro.Service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.rusgidro.entity.City;
import org.rusgidro.repos.CityRepo;
import org.rusgidro.utils.HibernateUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepo cityRepo;
    public List<City> getAllCities(){
        return cityRepo.findAll();
    }

    public City getCityByName(String name){
        return cityRepo.findByCityName(name);
    }
}
