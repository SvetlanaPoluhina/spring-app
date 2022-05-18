package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Place;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepo extends CrudRepository<Place, Long> {
}
