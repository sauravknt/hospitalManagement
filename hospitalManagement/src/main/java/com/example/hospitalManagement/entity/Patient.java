package com.example.hospitalManagement.entity;

import com.example.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Table(
        name="patient",
       uniqueConstraints = {
                @UniqueConstraint(name="1unique_patient_email",columnNames = {"email"}),
               @UniqueConstraint(name="1unique_patient_name_birthdate",columnNames = {"name","birth_date"})
       },
    indexes = {
              @Index(name="idx_patient_birth_date1",columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 40)
    private String name;

  //  @ToString.Exclude
    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(unique = true,nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne
    @JoinColumn(name = "patient_insurance_id")  //owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;


    }

