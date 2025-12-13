package com.HippyAir.hippyair_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numEmp;

    private String profession;
    private String title;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getters and setters
    public Long getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(Long numEmp) {
        this.numEmp = numEmp;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
