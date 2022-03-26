package com.app.pointsystem.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
@Entity
@Table(name = "point")
public class PointModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 20)
    private String employee;
    @Column(nullable = false, length = 30)
    private String project;
    @Column(nullable = false, length = 20)
    private String activity;
    @Column(length = 30)
    private String note;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime entry;
    @Column(nullable = false)
    private LocalTime exit;
}
