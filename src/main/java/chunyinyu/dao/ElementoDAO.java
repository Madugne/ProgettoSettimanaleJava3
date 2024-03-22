package chunyinyu.dao;

import chunyinyu.entities.ElementoLetterario;
import chunyinyu.entities.Prestito;
import chunyinyu.exceptions.ElementException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println("Elemento letterario " + elementoLetterario.getIsbn() + " salvato");
    }

    public ElementoLetterario getById(long isbn){
        ElementoLetterario elementoLetterario = entityManager.find(ElementoLetterario.class, isbn);
        if (elementoLetterario == null) throw new ElementException();
        return elementoLetterario;
    }

    public void delete(long isbn) {
        ElementoLetterario elementoLetterario = getById(isbn);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(elementoLetterario);
        transaction.commit();
        System.out.println("Elemento letterario rimosso");
    }

    public List<ElementoLetterario> getByAnno(int anno) {
        List<ElementoLetterario> elementi = entityManager.createQuery("SELECT e FROM ElementoLetterario e WHERE e.annoPubblicazione = :anno", ElementoLetterario.class)
                .setParameter("anno", anno)
                .getResultList();
        return elementi;
    }

    public List<ElementoLetterario> getByAutore(String autore) {
        List<ElementoLetterario> elementi = entityManager.createQuery("SELECT e FROM ElementoLetterario e WHERE e.autore = :autore", ElementoLetterario.class)
                .setParameter("autore", autore)
                .getResultList();
        return elementi;
    }

    public List<ElementoLetterario> getByTitolo(String titolo) {
        List<ElementoLetterario> elementi = entityManager.createQuery("SELECT e FROM ElementoLetterario e WHERE e.titolo LIKE :titolo", ElementoLetterario.class)
                .setParameter("titolo", titolo + "%")
                .getResultList();
        return elementi;
    }
}
