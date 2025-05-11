package com.school.vaccine.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationRecordDto {
    private Long studentId;
    private Long driveId;
}
