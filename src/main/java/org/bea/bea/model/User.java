package org.bea.bea.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "users", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {
//                "username"
//        }),
//        @UniqueConstraint(columnNames = {
//                "email"
//        })
//})
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min=3, max=50)
    private String name;

    @Column(nullable = false)
    @Size(min=3, max=50)
    private String username;

    @Column(nullable = false)
    @Size(max=50)
    @Email
    private String email;

    @Column(nullable = false)
   // @Size(min=6, max=50)
    private String password;

    private String activationCode;

    private boolean active;



//    @Column(nullable = false)
//    @Size(min=3, max=50)
//    private String last_name;

//    @Column(nullable = false)
//    private String date_of_Birth;

    private String profile_pict;
//    private String weight;
//    private String height;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
//    private String activation_code;
//    private String registration_date;
//    private String status;

   public User() {}

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = false;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String first_name) {
        this.name = first_name;
    }

//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }

//    public String getDate_of_Birth() {
//        return date_of_Birth;
//    }
//
//    public void setDate_of_Birth(String date_of_Birth) {
//        this.date_of_Birth = date_of_Birth;
//    }

    public String getProfile_pict() {
        return profile_pict;
    }

    public void setProfile_pict(String profile_pict) {
        this.profile_pict = profile_pict;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

//    public String getActivation_code() {
//        return activation_code;
//    }
//
//    public void setActivation_code(String activation_code) {
//        this.activation_code = activation_code;
//    }
//
//    public String getRegistration_date() {
//        return registration_date;
//    }
//
//    public void setRegistration_date(String registration_date) {
//        this.registration_date = registration_date;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }


    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
