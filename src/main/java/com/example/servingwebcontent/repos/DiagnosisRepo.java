package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Diagnosis;
import org.springframework.data.repository.CrudRepository;

public interface DiagnosisRepo extends CrudRepository<Diagnosis, Long> {
}
