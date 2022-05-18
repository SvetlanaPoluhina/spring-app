package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.*;
import com.example.servingwebcontent.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MedReportController {
    @Autowired
    private MedReportRepo medreportRepo;
    @Autowired
    private UserRepo usersRepo;
    @Autowired
    private PlaceRepo placeRepo;
    @Autowired
    private StatusReportRepo statusreportRepo;
    @Autowired
    private DiagnosisRepo diagnosisRepo;
    @Autowired
    private ResearchRepo researchRepo;


    @GetMapping("/userReport/{user}")
    public String userReport(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) MedReport report
    ) {
        List<MedReport> reports = user.getReports();

        model.addAttribute("reports", reports);
        model.addAttribute("report", report);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userReport";
    }

    @PreAuthorize("hasAuthority('DOCTOR')")
    @GetMapping("/report")
    public String report( Map<String, Object> model){
        Iterable<MedReport> reports = medreportRepo.findAll();
        Iterable<StatusReport> statuses = statusreportRepo.findAll();
        Iterable<User> users = usersRepo.findAll();
        Iterable<Place> places = placeRepo.findAll();
        Iterable<Diagnosis> diagnosees = diagnosisRepo.findAll();
        Iterable<Research> researchees = researchRepo.findAll();

        model.put("reports", reports);
        model.put("statuses", statuses);
        model.put("users", users);
        model.put("places", places);
        model.put("diagnosees", diagnosees);
        model.put("researchees", researchees);

        return "report";
    }

    @PreAuthorize("hasAuthority('DOCTOR')")
    @PostMapping("/report")
    public String addReport(
            @RequestParam User patient_rep,
            @RequestParam String date_report,
            @AuthenticationPrincipal User doctor_rep,
            @RequestParam Place policlinic_rep,
            @RequestParam String complaint,
            @RequestParam String treatment,
            @RequestParam String date_repeated_admission,
            @RequestParam StatusReport status_report,
            @RequestParam String diagnoses,
            @RequestParam String researches,
            Map<String, Object> model) {


        MedReport report = new MedReport (patient_rep, doctor_rep, policlinic_rep, date_report, complaint, treatment,
                    date_repeated_admission, status_report, diagnoses, researches);

        medreportRepo.save(report);

        Iterable<MedReport> reports = medreportRepo.findAll();
        Iterable<StatusReport> statuses = statusreportRepo.findAll();
        Iterable<User> users = usersRepo.findAll();
        Iterable<Place> places = placeRepo.findAll();
        Iterable<Diagnosis> diagnosees = diagnosisRepo.findAll();
        Iterable<Research> researchees = researchRepo.findAll();

        model.put("reports", reports);
        model.put("statuses", statuses);
        model.put("users", users);
        model.put("places", places);
        model.put("diagnosees", diagnosees);
        model.put("researchees", researchees);

        return "report";
    }

    @GetMapping("/report/{report}")
    public String userOneReport(Model model, @PathVariable MedReport report) {


        model.addAttribute("patient_repName", report.getPatient_repName());
        model.addAttribute("complaint", report.getComplaint());
        model.addAttribute("treatname", report.getTreatment());
        model.addAttribute("date_repeated_admission", report.getDate_repeated_admission());
        model.addAttribute("doctor_repName", report.getDoctor_repName());
        model.addAttribute("date_report", report.getDate_report());
        model.addAttribute("policlinic_repName", report.getPoliclinic_repName());
        model.addAttribute("status_report", report.getStatusName());
        model.addAttribute("diagnoses", report.getDiagnoses());
        model.addAttribute("researches", report.getResearches());

        return "userOneReport";
    }
}
