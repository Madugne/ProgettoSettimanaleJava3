package chunyinyu.dao;

import chunyinyu.entities.Utente;
import chunyinyu.exceptions.ElementException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {

    private final EntityManager entityManager;
    public UtenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Utente utente){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(utente);
        transaction.commit();
        System.out.println("Utente " + utente.getNome() + " aggiunto.");
    }

    public Utente getById(long id){
        Utente utente = entityManager.find(Utente.class, id);
        if (utente == null) throw new ElementException();
        return utente;
    }

    public void delete(long id) {
        Utente utente = getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(utente);
        transaction.commit();
        System.out.println("Utente " + utente.getNome() + " rimosso.");
    }
}
