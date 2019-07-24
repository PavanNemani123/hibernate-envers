package com.envers.spring.boot.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.envers.spring.boot.rest.model.City;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer> {

    List<City> findByName(String name);

}
