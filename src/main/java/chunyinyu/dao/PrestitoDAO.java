package chunyinyu.dao;

import chunyinyu.entities.Prestito;
import chunyinyu.entities.Utente;
import chunyinyu.exceptions.ElementException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitoDAO {
    private final EntityManager entityManager;
    public PrestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Prestito prestito){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(prestito);
        transaction.commit();
        System.out.println("Prestito salvato");
    }

    public Prestito getById(long id){
        Prestito prestito = entityManager.find(Prestito.class, id);
        if (prestito == null) throw new ElementException();
        return prestito;
    }

    public void delete(long id) {
        Prestito prestito = getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(prestito);
        transaction.commit();
        System.out.println("Prestito rimosso");
    }
}
