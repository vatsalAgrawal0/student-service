package com.school.vaccine.repository;

import com.school.vaccine.entity.Student;
import com.school.vaccine.entity.VaccinationDrive;
import com.school.vaccine.entity.VaccinationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VaccinationRecordRepository extends JpaRepository<VaccinationRecord, Long> {
    boolean existsByStudentAndDrive(Student student, VaccinationDrive drive);
}
