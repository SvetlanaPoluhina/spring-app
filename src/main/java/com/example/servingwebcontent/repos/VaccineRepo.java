package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Vaccine;
import org.springframework.data.repository.CrudRepository;

public interface VaccineRepo extends CrudRepository<Vaccine, Long> {
}
