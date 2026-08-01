package com.mediflow.doctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediflow.doctor.entity.Doctor;
import com.mediflow.doctor.exception.ResourceNotFoundException;
import com.mediflow.doctor.repository.DoctorRepository;
import com.mediflow.doctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {

        return doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Doctor not found with ID : " + id));
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {

        Doctor existing = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Doctor not found with ID : " + id));

        existing.setName(doctor.getName());
        existing.setSpecialization(doctor.getSpecialization());
        existing.setPhone(doctor.getPhone());
        existing.setEmail(doctor.getEmail());
        existing.setQualification(doctor.getQualification());
        existing.setExperience(doctor.getExperience());
        existing.setAvailability(doctor.getAvailability());

        return doctorRepository.save(existing);
    }

    @Override
    public void deleteDoctor(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Doctor not found with ID : " + id));

        doctorRepository.delete(doctor);
    }
}