package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepo extends CrudRepository<Appointment, Long> {
}
