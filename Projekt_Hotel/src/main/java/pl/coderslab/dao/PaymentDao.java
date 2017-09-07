package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Payment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class PaymentDao {
    @PersistenceContext
    EntityManager entityManager;

    public Payment findById(long id) {
        return entityManager.find(Payment.class, id);
    }

    public Payment saveRoom(Payment entity) {
        entityManager.persist(entity);
        return entity;
    }
    public List<Payment> getList(){
        Query query = entityManager.createQuery("SELECT b FROM Payment b");
        List<Payment> rooms = query.getResultList();
        return rooms;
    }
}