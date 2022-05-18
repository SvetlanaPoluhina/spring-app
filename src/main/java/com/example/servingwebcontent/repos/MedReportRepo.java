package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.MedReport;
import org.springframework.data.repository.CrudRepository;

public interface MedReportRepo extends CrudRepository<MedReport, Long> {
}
