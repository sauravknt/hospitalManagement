package com.example.hospitalManagement.repository;

import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByName(String name);
  //  Patient findByBirthDateOrEmail(LocalDate birthDate,String email);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByNameContaining(String di);

    @Query("SELECT p FROM Patient p WHERE p.bloodGroup=?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate")LocalDate birthDate);

    @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
   // List<Object[]> countEachBloodGroupType(@Param("bloodGroup") BloodGroupType bloodGroupType);
    List<Object[]> countEachBloodGroupType();

    //native query
    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatients();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name= :name where p.id=:id")
    int updateNameWithId(@Param("name") String name,@Param("id") Long id);



}
