package org.rusgidro.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee")
public class Employee implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private long employeeID;

    @Column(name = "name_em")
    private String employeeName;

    @Column(name = "login_em")
    private String employeeLogin;

    @Column(name = "password_em")
    private String employeePassword;

    @Column(name = "surname_em")
    private String employeeSurname;

    @Column(name = "patronymic_em")
    private String employeePatronymic;

    @ManyToMany
    @JoinTable(
            name="employee_post",
    joinColumns = @JoinColumn(
            name = "id_employee"),
    inverseJoinColumns = @JoinColumn(
            name = "id_post"
    ))
    private Collection<Post> posts;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return posts;
    }

    @Override
    public String getPassword() {
        return employeePassword;
    }

    @Override
    public String getUsername() {
        return employeeLogin;
    }

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
        return true;
    }
}

