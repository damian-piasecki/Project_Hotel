package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.dao.ReservationsDao;
import pl.coderslab.entity.Reservations;

@Service
public class ReservationsServiceImpl implements ReservationsService {

	private final ReservationsDao reservationsDao;
	
	@Autowired
	public ReservationsServiceImpl(ReservationsDao reservationsDao) {
		this.reservationsDao = reservationsDao;
	}

	@Override
	public Reservations create(Reservations reservations) {
		return reservationsDao.saveReservations(reservations);
	}

}
