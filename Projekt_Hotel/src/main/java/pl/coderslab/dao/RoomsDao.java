package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Rooms;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class RoomsDao {
    @PersistenceContext
    EntityManager entityManager;

    public Rooms findById(long id) {
        return entityManager.find(Rooms.class, id);
    }

    public Rooms saveRoom(Rooms entity) {
        entityManager.persist(entity);
        return entity;
    }
    public List<Rooms> getList(){
        Query query = entityManager.createQuery("SELECT b FROM Rooms b");
        List<Rooms> rooms = query.getResultList();
        return rooms;
    }
}
