package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Guest;
import pl.coderslab.entity.Reservations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class GuestDao {
    @PersistenceContext
    EntityManager entityManager;
    public Guest findById(long id) {
        return entityManager.find(Guest.class, id);
    }

    public Guest saveGuest(Guest entity) {
        entityManager.persist(entity);
        return entity;
    }
    public List<Guest> getList(){
        Query query = entityManager.createQuery("SELECT r FROM Guest r");
        List<Guest> guests = query.getResultList();
        return guests;
    }
}
