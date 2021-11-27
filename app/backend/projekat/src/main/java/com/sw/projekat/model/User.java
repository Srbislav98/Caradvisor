package com.sw.projekat.model;

import java.sql.Timestamp;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

// POJO koji implementira Spring Security UserDetails interfejs koji specificira
// osnovne osobine Spring korisnika (koje role ima, da li je nalog zakljucan, istekao, da li su kredencijali istekli)
@Entity
@Table(name="KORISNIK")
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @LazyCollection(LazyCollectionOption.FALSE)
    @Column(name = "pretraga")
    @ElementCollection(targetClass=String.class)
    private List<String> pretraga = new ArrayList<String>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "detaljna_pretraga",referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Automobil> detaljna_pretraga = new HashSet<Automobil>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

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
        Timestamp now = new Timestamp(new Date().getTime());
        this.setLastPasswordResetDate(now);
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
    public List<Authority> getListAuthorities() {
        return this.authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public List<String> getPretraga() {
        return pretraga;
    }

    public void setPretraga(List<String> pretraga) {
        this.pretraga = pretraga;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Automobil> getDetaljna_pretraga() {
        return detaljna_pretraga;
    }

    public void setDetaljna_pretraga(Set<Automobil> detaljna_pretraga) {
        this.detaljna_pretraga = detaljna_pretraga;
    }

    public boolean isSearched(String rijec){

        for(String i:pretraga){
            if (i.toLowerCase().contains(rijec.toLowerCase())){
                return true;
            }
        }
        return false;
    }
    public boolean isDetailedSearched(Automobil automobil){

        for(Automobil a:detaljna_pretraga){
            if (automobil.getNaziv().equalsIgnoreCase(a.getNaziv())){
                return true;
            }
        }
        return false;
    }
}
