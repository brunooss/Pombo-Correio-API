package com.bossindustries.pombocorreioserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @NotEmpty(message = "Users can't have an empty name")
    private String username;

    @Column(nullable = false)
    @NotEmpty(message = "First name must be filled")
    private String firstName;

    @Column(nullable = false)
    @NotEmpty(message = "Last name must be filled")
    private String lastName;


    private String imageUrl;
}
