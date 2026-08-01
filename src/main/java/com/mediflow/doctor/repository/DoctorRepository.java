package com.mediflow.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mediflow.doctor.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}