package com.example.hospitalManagement;

import com.example.hospitalManagement.entity.Patient;
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
        List<Patient> patientList=patientRepository.findByNameContaining("Di");
        for(Patient patient:patientList)
        {
            System.out.println(patient);
        }
    }

    @Test
    public void testTransactionMethods()
    {
      // Patient patient=patientService.getPatientById(1L);
      // System.out.println(patient);
        Patient patient=patientRepository.findByName("Diya Patel");
       // Patient patient1=patientRepository.findByBirthDate("sa");
        System.out.println(patient);
    }
}
