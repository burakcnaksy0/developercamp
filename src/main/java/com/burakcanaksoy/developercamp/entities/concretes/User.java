package com.burakcanaksoy.developercamp.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "email")
    @Email(message = "It is not in email format.")
    @NotBlank(message = "Email cannot be blank!")
    @NotNull(message = "Email cannot be null!")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Password cannot be blank!")
    @NotNull(message = "Password cannot be null!")
    private String password;
}
