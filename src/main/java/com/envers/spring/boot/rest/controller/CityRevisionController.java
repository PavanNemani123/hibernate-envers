package com.envers.spring.boot.rest.controller;

import com.envers.spring.boot.rest.model.City;
import com.envers.spring.boot.rest.model.EntityWithRevision;
import com.envers.spring.boot.rest.repository.CityRevisionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/cities/history")
public class CityRevisionController {

    @Autowired
    private CityRevisionRepository cityRevisionRepository;


    @RequestMapping("/revisions/{cityCode}")
    public List<EntityWithRevision<City>> getCityRevisions(@PathVariable Integer cityCode) {
        return cityRevisionRepository.listCityRevisions(cityCode);
    }



}
