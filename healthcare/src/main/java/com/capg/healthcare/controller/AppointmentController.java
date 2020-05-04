package com.capg.healthcare.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.healthcare.entity.Appointment;
import com.capg.healthcare.repository.IAppointmentRepository;
import com.capg.healthcare.service.AppointmentService;

@RestController
@RequestMapping("/api")
public class AppointmentController {
	
	private static final Logger log =
			LoggerFactory.getLogger(AppointmentCLR.class);
	
	@Autowired
	private IAppointmentRepository iAppointmentRepository;
	
	@Autowired
	private AppointmentService service;
	
	/**********************************Making of appointment*************************************/

	@PostMapping("/saveAppointments")
	public String saveApppointment(@RequestBody Appointment app)
	{
		Appointment appointment = service.saveAppointmentss(app);
		if(appointment == null)
		{
			return "Oops ! Sorry, this slot is already booked choose another ";
		}
		return "Hey !! Your appointment is booked, Please wait for a confirmation email";
	}

	/*******************************Showing of All the Appointments**********************************************/
	
	@RequestMapping("/showAppointments") 
	public List<Appointment> showAllAppointments(@ModelAttribute Appointment prod) 
	throws ResourceNotFoundException
	{	
		List<Appointment> appointment_list = service.showAllAppointments();
		
		if(appointment_list == null)
		{
			throw new ResourceNotFoundException("No Records Available ");
		}
		
		return appointment_list;
	}
	
	
	 
	/*********************************************Auto insertion *****************************************/
	
	@PostMapping("/saveAppointment")
	public List<Appointment> saveProduct(@RequestBody Appointment prod)
	{
		
    	java.sql.Timestamp ts = AppointmentController.getCurrentTimeStamp() ;			
		Appointment appointment = new Appointment("U14",ts,"Da4C12","D4CT25",0);
		iAppointmentRepository.save(appointment);
		log.info("A new appointment has been made"+appointment);
		
		List<Appointment> app =iAppointmentRepository.findAll();
		log.info("All appntmnts "+ app);
		return app;
	}
	
	private static java.sql.Timestamp getCurrentTimeStamp()
	{
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}
			
}
