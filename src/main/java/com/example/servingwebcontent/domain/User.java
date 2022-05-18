package com.example.servingwebcontent.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;
    private String lastname;
    private String firstname;
    private String patronymic;
    private String birthday;
    private String policy_number;
    private String phone;
    private String email;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User() {
    }

    public User(String lastname, String firstname, String patronymic, String birthday,
                String policy_number, String phone, String email, GroupBlood group_blood) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.policy_number = policy_number;
        this.phone = phone;
        this.email = email;
        this.group_blood = group_blood;
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Analysis> analysises;

    @OneToMany(mappedBy = "patient_vac", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vaccine> vaccines;

    @OneToMany(mappedBy = "patient_rep", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MedReport> reports;

    @OneToMany(mappedBy = "patient_sick", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SickLeave> sickleaves;

    @OneToMany(mappedBy = "patient_app", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> user_appointments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_group_blood")
    private GroupBlood group_blood;

    public String getGroupName() {
        return group_blood!= null ? group_blood.getBloodtype() : "Не указано";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }

    public boolean isDoctor(){
        return roles.contains(Role.DOCTOR);
    }

    public boolean isRegist(){
        return roles.contains(Role.REGIST);
    }

    /*  @ManyToMany
    @JoinTable(
             name = "link_user_analysis",
            joinColumns = { @JoinColumn(name="user_id") },
            inverseJoinColumns = {@JoinColumn(name="idanalysis") }
     )
    private Set<User> analysises = new HashSet<>(); // наш анализ (подписка)*/

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getLastname() {
        return lastname!= null ? lastname : "Не указано";
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname!= null ? firstname : "Не указано";
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic!= null ? patronymic : "Не указано";
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthday() {
        return birthday!= null ? birthday : "Не указано";
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPolicy_number() {
        return policy_number!= null ? policy_number : "Не указано";
    }

    public void setPolicy_number(String policy_number) {
        this.policy_number = policy_number;
    }

    public String getPhone() {
        return phone!= null ? phone : "Не указано";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email!= null ? email : "Не указано";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Analysis> getAnalysises() {
        return analysises;
    }

    public void setAnalysises(List<Analysis> analysises) {
        this.analysises = analysises;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public GroupBlood getGroup_blood() {
        return group_blood;
    }

    public void setGroup_blood(GroupBlood group_blood) {
        this.group_blood = group_blood;
    }

    public List<MedReport> getReports() {
        return reports;
    }

    public void setReports(List<MedReport> reports) {
        this.reports = reports;
    }

    public List<Appointment> getUser_appointments() {
        return user_appointments;
    }

    public void setUser_appointments(List<Appointment> user_appointments) {
        this.user_appointments = user_appointments;
    }

    public List<SickLeave> getSickleaves() {
        return sickleaves;
    }

    public void setSickleaves(List<SickLeave> sickleaves) {
        this.sickleaves = sickleaves;
    }
}