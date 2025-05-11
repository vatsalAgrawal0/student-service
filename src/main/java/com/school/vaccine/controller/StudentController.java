package com.school.vaccine.controller;

import com.school.vaccine.dto.StudentDto;
import com.school.vaccine.dto.VaccinationRecordDto;
import com.school.vaccine.entity.Student;
import com.school.vaccine.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody StudentDto dto) {
        return ResponseEntity.ok(studentService.addStudent(dto));
    }

    @GetMapping
    public ResponseEntity<List<Student>> all() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<Void> bulkUpload(@RequestParam("file") MultipartFile file) throws Exception {
        studentService.bulkUpload(file);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/vaccinate")
    public ResponseEntity<Void> markVaccinated(@RequestBody VaccinationRecordDto dto) {
        studentService.markVaccinated(dto);
        return ResponseEntity.ok().build();
    }
}
