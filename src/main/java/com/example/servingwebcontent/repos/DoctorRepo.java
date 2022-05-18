package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Doctor;
import com.example.servingwebcontent.domain.Place;
import com.example.servingwebcontent.domain.Specialization;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepo extends CrudRepository<Doctor, Long> {
}
