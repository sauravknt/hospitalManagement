package com.example.hospitalManagement.service;

import com.example.hospitalManagement.entity.Appointment;
import com.example.hospitalManagement.entity.Doctor;
import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.repository.AppointmentRepository;
import com.example.hospitalManagement.repository.DoctorRepository;
import com.example.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
     private final AppointmentRepository appointmentRepository;
     private final DoctorRepository doctorRepository;
     private final PatientRepository patientRepository;

     @Transactional
     public Appointment createNewAppointment(Appointment appointment,Long doctorId,Long patientId)
     {
         Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
         Patient patient=patientRepository.findById(patientId).orElseThrow();

         if(appointment.getId()!=null) throw new IllegalArgumentException("Appointment should not have ID");

         appointment.setPatient(patient);
         appointment.setDoctor(doctor);

         patient.getAppointments().add(appointment); //to maintain bidirectional consistency
         return appointmentRepository.save(appointment);

     }

     @Transactional
     public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId,Long doctorId)
     {
         Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow();
         Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();

         appointment.setDoctor(doctor); // this will automatically call the update, because it is dirty

         doctor.getAppointments().add(appointment); //just for bidirectional consistency
         return appointment;

     }

}
