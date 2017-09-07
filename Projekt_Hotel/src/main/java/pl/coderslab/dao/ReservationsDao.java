package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Reservations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class ReservationsDao {
@PersistenceContext
    EntityManager entityManager;
    public Reservations findById(long id) {
        return entityManager.find(Reservations.class, id);
    }

public Reservations saveReservations(Reservations entity) {
    entityManager.persist(entity);
    return entity;
}
public List<Reservations> getList(){
    Query query = entityManager.createQuery("SELECT r FROM Reservations r");
    List<Reservations> reservations = query.getResultList();
    return reservations;
}
}
