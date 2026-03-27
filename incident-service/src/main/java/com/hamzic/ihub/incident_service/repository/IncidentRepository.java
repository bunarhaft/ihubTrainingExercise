package com.hamzic.ihub.incident_service.repository;

import com.hamzic.ihub.incident_service.entity.Incident;
import com.hamzic.ihub.incident_service.entity.IncidentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident,Long> {
    List<Incident> findByStatus(IncidentStatus status);
}
