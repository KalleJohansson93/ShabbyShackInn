package com.example.shabbyshackinn.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    private String username;
    private String password;
    private boolean enabled;
    private String resetToken;
    private LocalDateTime resetTokenCreationTime;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;
}
