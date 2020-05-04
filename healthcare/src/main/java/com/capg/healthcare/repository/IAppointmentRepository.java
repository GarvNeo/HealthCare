package com.capg.healthcare.repository;
import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.healthcare.entity.*;



public interface IAppointmentRepository extends JpaRepository<Appointment,BigInteger>{

}
