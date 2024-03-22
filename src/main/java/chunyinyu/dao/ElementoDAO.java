package chunyinyu.dao;

import chunyinyu.entities.ElementoLetterario;
import chunyinyu.entities.Prestito;
import chunyinyu.exceptions.ElementException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ElementoDAO {
    private final EntityManager entityManager;
    public ElementoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(ElementoLetterario elementoLetterario){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(elementoLetterario);
        transaction.commit();
        System.out.println("Elemento letterario " + elementoLetterario.getIsbn() + " rimosso");
    }

    public ElementoLetterario getById(long id){
        ElementoLetterario elementoLetterario = entityManager.find(ElementoLetterario.class, id);
        if (elementoLetterario == null) throw new ElementException();
        return elementoLetterario;
    }

    public void delete(long id) {
        ElementoLetterario elementoLetterario = getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(elementoLetterario);
        transaction.commit();
        System.out.println("Elemento letterario " + elementoLetterario.getIsbn() + " rimosso");
    }
}
