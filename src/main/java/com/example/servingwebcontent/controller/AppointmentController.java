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


import javax.print.Doc;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

@Controller
public class AppointmentController {
    @Autowired
    private PlaceRepo placeRepo;
    @Autowired
    private SpecializationRepo specializationRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private ScheduleRepo scheduleRepo;
    @Autowired
    private StatusAppointRepo statusesAppRepo;

    @GetMapping("/userAppointment1")
    public String appointment1 (Map<String, Object> model){

        Iterable<Place> places = placeRepo.findAll();
        Iterable<Specialization> specializations = specializationRepo.findAll();

        model.put("places", places);
        model.put("specializations", specializations);

        return "userAppointment1";
    }

    @PostMapping("/userAppointment1")
    public String addAppointment1 (
            @RequestParam Place policlinic_app,
            @RequestParam Specialization usluga,
            Model model,
            Map<String, Object> model1){

        Iterable<Place> places = placeRepo.findAll();
        Iterable<Specialization> specializations = specializationRepo.findAll();

        model1.put("places", places);
        model1.put("specializations", specializations);

        model.addAttribute("policlinic_app", policlinic_app.getIdplace());
        model.addAttribute("usluga", usluga.getId_specialization());

        return "userAppointment1";
    }

    @GetMapping("/userAppointment2/{policlinic_app}/{usluga}")
    public String appointment2 (
            @PathVariable Long policlinic_app,
            @PathVariable Long usluga,
            Map<String, Object> model){

        Iterable<Place> places = placeRepo.findAll();
        Iterable<Specialization> specializations = specializationRepo.findAll();
        Iterable<Doctor> doctors = doctorRepo.findAll();

        model.put("places", places);
        model.put("specializations", specializations);
        model.put("doctors", doctors);

        ArrayList<Doctor> doctorssort = new ArrayList<Doctor>();


        for (Doctor doctori:doctors) {
            if (policlinic_app.equals(doctori.getPoliclinic_doc().getIdplace()) &&
                    usluga.equals(doctori.getSpecialization_doc().getId_specialization())) {

                doctorssort.add(doctori);
            }
        }

        model.put("doctorssort", doctorssort);

        return "userAppointment2";
    }

    @PostMapping("/userAppointment2/{policlinic_app}/{usluga}")
    public String addappointment2 (Map<String, Object> model){

        Iterable<Doctor> doctors = doctorRepo.findAll();

        model.put("doctors", doctors);

        return "userAppointment2";
    }

    @GetMapping("/userAppointment3/{doctori}/{date_app_str}")
    public String appointment3 (
            @PathVariable Long doctori,
            @PathVariable String date_app_str,
            Map<String, Object> model) throws ParseException {

        Iterable<Schedule> schedules = scheduleRepo.findAll();
        Iterable<Appointment> appointments = appointmentRepo.findAll();

        model.put("schedules", schedules);
        model.put("appointments", appointments);

        ArrayList<LocalTime> schedulesort = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date_app;
        date_app = format.parse(date_app_str);
        String week_day = new SimpleDateFormat("EEE", Locale.ENGLISH).format(date_app);

        for (Schedule schedulei:schedules) {
            if(doctori.equals(schedulei.getDoctor_shed().getId_doctor()) && week_day.equals(schedulei.getDay_week())){
                Time i1 = schedulei.getStart_work();
                LocalTime localtimestart = i1.toLocalTime();
                Time i2 = schedulei.getEnd_work();
                LocalTime localtimeend = i2.toLocalTime();

                System.out.println(i1);
                System.out.println(localtimestart);

                LocalTime time = localtimestart;
                schedulesort.add(time);
                for (Appointment appointmenti:appointments) {
                    if (doctori.equals(appointmenti.getDoctor().getId_doctor()) && date_app_str.equals(appointmenti.getDate_app()) && time.equals(appointmenti.getStart_app())){
                        schedulesort.remove(time);
                    }
                }
                while (time != localtimeend){
                        time = time.plusMinutes(schedulei.getInterval());
                        schedulesort.add(time);
                    for (Appointment appointmenti:appointments) {
                        if (doctori.equals(appointmenti.getDoctor().getId_doctor()) && date_app_str.equals(appointmenti.getDate_app()) && time.equals(appointmenti.getStart_app())){
                            schedulesort.remove(time);
                        }
                    }
                }
            }
        }

        model.put("schedulesort", schedulesort);

        return "userAppointment3";
    }

    @PostMapping("/userAppointment3/{doctori}/{date_app_str}")
    public String addappointment3(
            @AuthenticationPrincipal User patient_app,
            @PathVariable String date_app_str,
            @RequestParam LocalTime start_app,
            @RequestParam Doctor doctor,
            @RequestParam StatusAppoint status_appointment,
            Map<String, Object> model) throws ParseException {

        DateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");
        Date date_app;
        date_app = format_date.parse(date_app_str);
        String date_app1 = new SimpleDateFormat("yyyy-MM-dd").format(date_app);

        Appointment appointment = new Appointment (date_app1, start_app, doctor, patient_app, status_appointment);

        appointmentRepo.save(appointment);

        Iterable<Appointment> appointments = appointmentRepo.findAll();
        Iterable<Place> places = placeRepo.findAll();
        Iterable<User> users = userRepo.findAll();
        Iterable<Doctor> doctors = doctorRepo.findAll();
        Iterable<Specialization> specializations = specializationRepo.findAll();

        model.put("appointments", appointments);
        model.put("places", places);
        model.put("users", users);
        model.put("doctors", doctors);
        model.put("specializations", specializations);


        return "redirect:/";
    }

    @GetMapping("/userAppList/{user}")
    public String userAppList(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Appointment appointment
    ) {
        List<Appointment> appointments = user.getUser_appointments();

        model.addAttribute("appointments", appointments);
        model.addAttribute("appointment", appointment);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userAppList";
    }

    @PreAuthorize("hasAuthority('REGIST')")
    @GetMapping("/appointmentList/delete/{appointment}")
    public String deleteAppointment(
            @PathVariable Appointment appointment
    ){

        appointmentRepo.deleteById(appointment.getId_appointment());

        return "redirect:/appointmentList";
    }

    @PreAuthorize("hasAuthority('REGIST')")
    @GetMapping("/appointmentList")
    public String appointmentList(Map<String, Object> model) {

        Iterable<Appointment> appointments = appointmentRepo.findAll();

        model.put("appointments", appointments);

        return "appointmentList";
    }

    public void updateStatusApp(Appointment appointment) {

        if (appointment.getStatus_appointment().getId_app_status()==2) {
            Iterable<StatusAppoint> statuses = statusesAppRepo.findAll();
            StatusAppoint statusup = new StatusAppoint();
            for (StatusAppoint status: statuses){
                if (status.getId_app_status()==1){
                    statusup = status;
                }
            }
            appointment.setStatus_appointment(statusup);
            appointmentRepo.save(appointment);
        }

    }


    @PreAuthorize("hasAuthority('REGIST')")
    @GetMapping("/appointmentList/update/{appointment}")
    public String updateStatus(
            @PathVariable Appointment appointment) {

        updateStatusApp(appointment);

        return "redirect:/appointmentList";
    }

    @PreAuthorize("hasAuthority('REGIST')")
    @GetMapping("/adminAppointment1")
    public String adminappointment1 (Map<String, Object> model){

        Iterable<Place> places = placeRepo.findAll();
        Iterable<Specialization> specializations = specializationRepo.findAll();

        model.put("places", places);
        model.put("specializations", specializations);

        return "adminAppointment1";
    }

    @PreAuthorize("hasAuthority('REGIST')")
    @PostMapping("/adminAppointment1")
    public String addAdminAppointment1 (
            @RequestParam Place policlinic_app,
            @RequestParam Specialization usluga,
            Model model,
            Map<String, Object> model1){

        Iterable<Place> places = placeRepo.findAll();
        Iterable<Specialization> specializations = specializationRepo.findAll();

        model1.put("places", places);
        model1.put("specializations", specializations);

        model.addAttribute("policlinic_app", policlinic_app.getIdplace());
        model.addAttribute("usluga", usluga.getId_specialization());

        return "adminAppointment1";
    }

    @PreAuthorize("hasAuthority('REGIST')")
    @GetMapping("/adminAppointment2/{policlinic_app}/{usluga}")
    public String adminappointment2 (
            @PathVariable Long policlinic_app,
            @PathVariable Long usluga,
            Map<String, Object> model){

        Iterable<Place> places = placeRepo.findAll();
        Iterable<Specialization> specializations = specializationRepo.findAll();
        Iterable<Doctor> doctors = doctorRepo.findAll();

        model.put("places", places);
        model.put("specializations", specializations);
        model.put("doctors", doctors);

        ArrayList<Doctor> doctorssort = new ArrayList<Doctor>();


        for (Doctor doctori:doctors) {
            if (policlinic_app.equals(doctori.getPoliclinic_doc().getIdplace()) &&
                    usluga.equals(doctori.getSpecialization_doc().getId_specialization())) {

                doctorssort.add(doctori);
            }
        }

        model.put("doctorssort", doctorssort);

        return "adminAppointment2";
    }

    @PreAuthorize("hasAuthority('REGIST')")
    @PostMapping("/adminAppointment2/{policlinic_app}/{usluga}")
    public String addAdminappointment2 (Map<String, Object> model){

        Iterable<Doctor> doctors = doctorRepo.findAll();

        model.put("doctors", doctors);

        return "adminAppointment2";
    }

    @PreAuthorize("hasAuthority('REGIST')")
    @GetMapping("/adminAppointment3/{doctori}/{date_app_str}")
    public String adminappointment3 (
            @PathVariable Long doctori,
            @PathVariable String date_app_str,
            Map<String, Object> model) throws ParseException {

        Iterable<Schedule> schedules = scheduleRepo.findAll();
        Iterable<Appointment> appointments = appointmentRepo.findAll();
        Iterable<User> users = userRepo.findAll();

        model.put("schedules", schedules);
        model.put("appointments", appointments);
        model.put("users", users);

        ArrayList<LocalTime> schedulesort = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date_app;
        date_app = format.parse(date_app_str);
        String week_day = new SimpleDateFormat("EEE", Locale.ENGLISH).format(date_app);

        for (Schedule schedulei:schedules) {
            if(doctori.equals(schedulei.getDoctor_shed().getId_doctor()) && week_day.equals(schedulei.getDay_week())){
                Time i1 = schedulei.getStart_work();
                LocalTime localtimestart = i1.toLocalTime();
                Time i2 = schedulei.getEnd_work();
                LocalTime localtimeend = i2.toLocalTime();

                LocalTime time = localtimestart;
                schedulesort.add(time);
                for (Appointment appointmenti:appointments) {
                    if (doctori.equals(appointmenti.getDoctor().getId_doctor()) && date_app_str.equals(appointmenti.getDate_app()) && time.equals(appointmenti.getStart_app())){
                        schedulesort.remove(time);
                    }
                }
                while (time != localtimeend){
                    time = time.plusMinutes(schedulei.getInterval());
                    schedulesort.add(time);
                    for (Appointment appointmenti:appointments) {
                        if (doctori.equals(appointmenti.getDoctor().getId_doctor()) && date_app_str.equals(appointmenti.getDate_app()) && time.equals(appointmenti.getStart_app())){
                            schedulesort.remove(time);
                        }
                    }
                }
            }
        }

        model.put("schedulesort", schedulesort);

        return "adminAppointment3";
    }

    @PreAuthorize("hasAuthority('REGIST')")
    @PostMapping("/adminAppointment3/{doctori}/{date_app_str}")
    public String addAdminappointment3(
            @RequestParam User patient_app_ad,
            @PathVariable String date_app_str,
            @RequestParam LocalTime start_app,
            @RequestParam Doctor doctor,
            @RequestParam StatusAppoint status_appointment,
            Map<String, Object> model) throws ParseException {

        DateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");
        Date date_app;
        date_app = format_date.parse(date_app_str);
        String date_app1 = new SimpleDateFormat("yyyy-MM-dd").format(date_app);

        Appointment appointment = new Appointment (date_app1, start_app, doctor, patient_app_ad, status_appointment);

        appointmentRepo.save(appointment);

        Iterable<Appointment> appointments = appointmentRepo.findAll();
        Iterable<Place> places = placeRepo.findAll();
        Iterable<User> users = userRepo.findAll();
        Iterable<Doctor> doctors = doctorRepo.findAll();
        Iterable<Specialization> specializations = specializationRepo.findAll();

        model.put("appointments", appointments);
        model.put("places", places);
        model.put("users", users);
        model.put("doctors", doctors);
        model.put("specializations", specializations);

        return "redirect:/";
    }

    /*@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/menuAppointment")
    public String menuApp(Map<String, Object> model) {
        return "menuAppointment";
    }*/

    @PreAuthorize("hasAuthority('DOCTOR')")
    @GetMapping("/appointmentDiary")
    public String diaryApp (Map<String, Object> model) {

        ArrayList<Appointment> appointments = new ArrayList<>();

        model.put("appointments", appointments);

        return "appointmentDiary";
    }

    @PreAuthorize("hasAuthority('DOCTOR')")
    @PostMapping("/appointmentDiary")
    public String add_diaryApp (Map<String, Object> model) {

        ArrayList<Appointment> appointments = new ArrayList<>();

        model.put("appointments", appointments);

        return "appointmentDiary";
    }

    @PreAuthorize("hasAuthority('DOCTOR')")
    @GetMapping("/appointmentDiary/{current_date}")
    public String diaryAppDate (
            @PathVariable String current_date,
            @AuthenticationPrincipal User doctor,
            Map<String, Object> model) {

        Iterable<Appointment> appointments_all = appointmentRepo.findAll();

        model.put("appointments_all", appointments_all);

        ArrayList<Appointment> appointments = new ArrayList<>();

        for (Appointment appointment:appointments_all) {
            if (current_date.equals(appointment.getDate_app()) && doctor.getId().equals(appointment.getDoctor().getUser_doctor().getId())) {
                appointments.add(appointment);
            }
        }

        model.put("appointments", appointments);

        return "appointmentDiary";
    }

    @PreAuthorize("hasAuthority('DOCTOR')")
    @GetMapping("/appointment/{appointment}")
    public String userCard(
            @PathVariable Appointment appointment,
            Model model) {
        model.addAttribute("lastname", appointment.getPatient_app().getLastname());
        model.addAttribute("firstname", appointment.getPatient_app().getFirstname());
        model.addAttribute("patronymic", appointment.getPatient_app().getPatronymic());
        model.addAttribute("birthday", appointment.getPatient_app().getBirthday());
        model.addAttribute("policy_number", appointment.getPatient_app().getPolicy_number());
        model.addAttribute("phone", appointment.getPatient_app().getPhone());
        model.addAttribute("group_blood", appointment.getPatient_app().getGroup_blood().getBloodtype());

        List<Analysis> analysises = appointment.getPatient_app().getAnalysises();
        List<MedReport> reports = appointment.getPatient_app().getReports();
        List<Vaccine> vaccines = appointment.getPatient_app().getVaccines();
        List<SickLeave> sickleaves = appointment.getPatient_app().getSickleaves();

        model.addAttribute("analysises", analysises);
        model.addAttribute("reports", reports);
        model.addAttribute("vaccines", vaccines);
        model.addAttribute("sickleaves", sickleaves);

        return "userCard";
    }

}
