package com.capg.healthcare.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.capg.healthcare.controller.AppointmentCLR;
import com.capg.healthcare.controller.AppointmentController;
import com.capg.healthcare.dao.AppointmentDAOService;
import com.capg.healthcare.entity.Appointment;
import com.capg.healthcare.repository.IAppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private IAppointmentRepository iAppointmentRepository;
	
	@Autowired
	private AppointmentDAOService appointmentDAOService; 
	
	private static final Logger log =
			LoggerFactory.getLogger(AppointmentCLR.class);

	
	public List<Appointment> getAllAppointments() {
		List<Appointment> pList=new ArrayList<Appointment>();
		iAppointmentRepository.findAll().forEach(appointment -> pList.add(appointment));
		return pList;
	}
	
	public Appointment saveAppointments(Appointment app) {
		
		//java.sql.Timestamp ts = AppointmentController.getCurrentTimeStamp();
		//Appointment appointment = new Appointment("U12",ts,"D4C12","D4CT25",0);
		
		return iAppointmentRepository.save(app);
		//log.info("A new appointment has been made"+app);
//		
//		List<Appointment> appointments =iAppointmentRepository.findAll();
//		log.info("All appntmnts "+ appointments);
	//	return appointments;
		
	}
	
	public Appointment saveAppointmentss(Appointment app) {
		
		
		if(checkSlotAvailibility(app.getDateTime()))
		{
			return appointmentDAOService.saveAppointments(app);
		}
		else
		{
			return null;
		}
	}

	/*Checking whether slot is available or not */
	
	public boolean checkSlotAvailibility(Timestamp dateTimeCurrent)
	{
		
		List<Appointment> appointment = appointmentDAOService.showAppointments();
		
		for(Appointment old_appointment : appointment)
		{
			if(old_appointment.getDateTime().equals(dateTimeCurrent))
			{
				return false;
			}
		}
		return true;
	}
	
	/*Fetching of complete list */
	
	public List<Appointment> showAllAppointments()
	{	
		return appointmentDAOService.showAppointments();
	}
	

	
}
