package repo;

import entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Component
public class PersonRepository {

    final EntityManager entityManager;

    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPeople() {
        return entityManager.createQuery("SELECT c FROM Person c", Person.class)
                .getResultList();
    }

    public Person getPersonById(int id) {
        return (Person) entityManager.createQuery("SELECT c FROM Person c WHERE id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }
}
