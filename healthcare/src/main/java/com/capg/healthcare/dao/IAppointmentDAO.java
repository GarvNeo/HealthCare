package com.capg.healthcare.dao;

import java.math.BigInteger;
import java.util.List;

import com.capg.healthcare.entity.Appointment;

public interface IAppointmentDAO {

	int cancelAppointmentById( BigInteger app_id);
	List<Appointment> showAppointments();
	Appointment saveAppointments(Appointment app);
}
