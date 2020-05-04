package com.capg.healthcare.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.capg.healthcare.entity.Appointment;
import com.capg.healthcare.repository.IAppointmentRepository;


@Component
public class AppointmentDAOService {

	@Autowired
	private IAppointmentRepository iAppointmentRepository;
	
    /* Making of appointment */
	
    public Appointment saveAppointments(Appointment app) {
		
		return iAppointmentRepository.save(app);
		
	}
    
    /* Fetching list of all appointments */
	
    public List<Appointment> showAppointments()
	{	
		List<Appointment> app = iAppointmentRepository.findAll();
		
		return app;
	}
    
}
