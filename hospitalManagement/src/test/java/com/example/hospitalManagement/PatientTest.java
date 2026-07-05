package com.example.hospitalManagement;

import com.example.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.entity.type.BloodGroupType;
import com.example.hospitalManagement.repository.PatientRepository;
import com.example.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void  testPatientRepository()
    {
    /*    List<Patient> patientList=patientRepository.findAll();
        System.out.println(patientList);

        Patient p1=new Patient();

        p1.setName("TestPate33");
        p1.setEmail("test@gmail.com");
        patientRepository.save(p1); */
       // List<Patient> patientList=patientRepository.findByBirthDateOrEmail(LocalDate.of(1988,3,15),"diya.patel@example.com");
      //  List<Patient> patientList=patientRepository.findByNameContaining("Di");
        List<Patient> patientList=patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
        for(Patient patient:patientList)
        {
            System.out.println(patient);
        }
    }

    @Test
    public void testTransactionMethods() {
        // Patient patient=patientService.getPatientById(1L);
        // System.out.println(patient);
        //   Patient patient=patientRepository.findByName("Diya Patel");
        // Patient patient1=patientRepository.findByBirthDate("sa");
        //  System.out.println(patient);
      //  List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1993, 3, 14));
      /*  List<Patient> patientList=patientRepository.findAllPatients();
        for (Patient patient : patientList) {
            System.out.println(patient);
        }

        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
        for (Object[] objects : bloodGroupList) {
            System.out.println(objects[0] + " " + objects[1]);
        } */
//
//        int rowsUpdated=patientRepository.updateNameWithId("Arabi Sharma",1L);
//        System.out.println(rowsUpdated);
        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
        for (BloodGroupCountResponseEntity bloodGroupCountResponse : bloodGroupList) {
            System.out.println(bloodGroupCountResponse);
        }


    }
    }

