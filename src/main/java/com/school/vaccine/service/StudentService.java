package com.school.vaccine.service;

import com.school.vaccine.dto.StudentDto;
import com.school.vaccine.dto.VaccinationRecordDto;
import com.school.vaccine.entity.*;
import com.school.vaccine.exception.DuplicateVaccinationException;
import com.school.vaccine.repository.*;
import com.school.vaccine.utils.CsvHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepo;
    private final VaccinationDriveRepository driveRepo;
    private final VaccinationRecordRepository recordRepo;

    public Student addStudent(StudentDto dto) {
        Student student = Student.builder()
                .name(dto.getName())
                .studentId(dto.getStudentId())
                .grade(dto.getGrade())
                .build();
        return studentRepo.save(student);
    }

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    public void bulkUpload(MultipartFile file) throws Exception {
        List<Student> students = CsvHelper.parseCSV(file);
        studentRepo.saveAll(students);
    }

    public void markVaccinated(VaccinationRecordDto dto) {
        Student student = studentRepo.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        VaccinationDrive drive = driveRepo.findById(dto.getDriveId())
                .orElseThrow(() -> new RuntimeException("Drive not found"));

        if (recordRepo.existsByStudentAndDrive(student, drive)) {
            throw new DuplicateVaccinationException("Already vaccinated for this drive");
        }

        VaccinationRecord record = VaccinationRecord.builder()
                .student(student)
                .drive(drive)
                .vaccinationDate(LocalDate.now())
                .build();
        recordRepo.save(record);
    }
}
