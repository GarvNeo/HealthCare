package com.capg.healthcare.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import com.capg.healthcare.entity.Appointment;

public interface IAppointmentService {

	  Appointment saveAppointmentss(Appointment app); 
	 
	  boolean checkSlotAvailibility(Timestamp dateTimeCurrent);
		
	  List<Appointment> showAllAppointments();
	  
	  public Appointment appointmentSearchUpdateById(Appointment new_appointment,String choice);
}
