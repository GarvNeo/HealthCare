package com.capg.healthcare.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capg.healthcare.dao.AppointmentDAOService;
import com.capg.healthcare.entity.Appointment;
import com.capg.healthcare.repository.IAppointmentRepository;

@Component
@RequestMapping("/api/v1")
public class AppointmentCLR implements CommandLineRunner{

	private static final Logger log =
			LoggerFactory.getLogger(AppointmentCLR.class);
	
	@Autowired
	private IAppointmentRepository iAppointmentRepository;
	
	private static java.sql.Timestamp getCurrentTimeStamp()
	{
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}
	 
	@Override
	public void run(String... args) throws Exception {
//		java.sql.Timestamp ts = AppointmentCLR.getCurrentTimeStamp();
//		Appointment appointment = new Appointment("2451",ts,"Ds7C1","DC4dT2",5);
//		iAppointmentRepository.save(appointment);
//		log.info("A new appointment has been made"+appointment);
//		
//		List<Appointment> app =iAppointmentRepository.findAll();
//		log.info("All appntmnts "+ app);
//	
		}
	
	

}
