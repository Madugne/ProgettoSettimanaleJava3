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

    public ElementoLetterario getByAnno(int anno) {
        ElementoLetterario elementoLetterario = entityManager.find(ElementoLetterario.class, anno);
        if (elementoLetterario == null) throw new ElementException();
        return elementoLetterario;
    }

    public ElementoLetterario getByAutore(String autore) {
        ElementoLetterario elementoLetterario = entityManager.find(ElementoLetterario.class, autore);
        if (elementoLetterario == null) throw new ElementException();
        return elementoLetterario;
    }

    public ElementoLetterario getByTitolo(String titolo) {
        ElementoLetterario elementoLetterario = entityManager.find(ElementoLetterario.class, "%"+"titolo"+"%");
        if (elementoLetterario == null) throw new ElementException();
        return elementoLetterario;
    }
}
