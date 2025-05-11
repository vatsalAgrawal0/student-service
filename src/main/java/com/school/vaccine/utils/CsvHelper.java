package com.school.vaccine.utils;

import com.school.vaccine.entity.Student;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

public class CsvHelper {
    public static List<Student> parseCSV(MultipartFile file) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : csvParser) {
                Student student = Student.builder()
                        .name(record.get("name"))
                        .studentId(record.get("studentId"))
                        .grade(record.get("grade"))
                        .build();
                students.add(student);
            }
        }
        return students;
    }
}
