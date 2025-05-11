package com.school.vaccine.repository;

import com.school.vaccine.entity.VaccinationDrive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationDriveRepository extends JpaRepository<VaccinationDrive, Long> {
}
