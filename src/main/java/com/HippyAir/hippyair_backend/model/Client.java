package com.HippyAir.hippyair_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "num_passport")
    private String numPassport;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Book> bookings;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<MilesReward> rewards;

    // getters and setters
    public String getNumPassport() {
        return numPassport;
    }

    public void setNumPassport(String numPassport) {
        this.numPassport = numPassport;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
