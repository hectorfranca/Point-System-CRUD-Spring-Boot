package com.app.pointsystem.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class PointDTO {
    @NotBlank
    @Size(max = 20)
    private String employee;
    @NotBlank
    @Size(max = 30)
    private String project;
    @NotBlank
    @Size(max = 20)
    private String activity;
    @Size(max = 30)
    private String note;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NotNull
    private LocalTime entry;
    @NotNull
    private LocalTime exit;
}
