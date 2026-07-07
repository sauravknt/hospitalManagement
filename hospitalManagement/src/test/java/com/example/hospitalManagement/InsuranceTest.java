package com.example.hospitalManagement;

import com.example.hospitalManagement.entity.Appointment;
import com.example.hospitalManagement.entity.Insurance;
import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.service.AppointmentService;
import com.example.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance()
    {
        Insurance insurance=Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient=insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);


    }
    @Test
    public void testCreateAppointment()
    {
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,0,0))
                .reason("Fever")
                .build();

        var t=appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(t);

        var ut =appointmentService.reAssignAppointmentToAnotherDoctor(t.getId(),3L);

        System.out.println(ut);
    }
}
