package com.hamzic.ihub.incident_service.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// Legt die Klasse als Entity fest welche als Tabelle erstellt wird
@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    //Column Definition Text damit potenziell die beschreibuhng des incidents nicht abgeschnitten wird
    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncidentStatus status;

    @Column(name = "assigned_user_id")
    private Long assignedUserId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Incident() {
    }


}
