package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepo extends CrudRepository<Schedule, Long> {
}
