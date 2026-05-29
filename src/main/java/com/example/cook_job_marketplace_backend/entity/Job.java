package com.example.cook_job_marketplace_backend.entity;

import com.example.cook_job_marketplace_backend.audit.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String companyName;

    private String location;

    private Double salary;

    private String experience;

    @Column(length = 5000)
    private String description;

    private String skills;
}