package chunyinyu.dao;

import chunyinyu.entities.ElementoLetterario;
import chunyinyu.entities.Prestito;
import chunyinyu.entities.Utente;
import chunyinyu.exceptions.ElementException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Long> getElementoIdByNumeroTesseraScadutiNonRestituiti(long tessera) {
        LocalDate oggi = LocalDate.now();
        List<Prestito> prestiti = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :oggi AND p.dataRestituzioneEffettiva IS NULL", Prestito.class)
                .setParameter("oggi", oggi)
                .getResultList();
        List<Long> listaElementi = new ArrayList<>();
        prestiti.forEach(prestito -> listaElementi.add(prestito.getElementoPrestato().getIsbn()));
        return listaElementi;
    }

    public List<Long> getElementoIdByNumeroTesseraPrestati(long tessera) {
        LocalDate oggi = LocalDate.now();
        List<Prestito> prestiti = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista > :oggi", Prestito.class)
                .setParameter("oggi", oggi)
                .getResultList();
        List<Long> listaElementi = new ArrayList<>();
        prestiti.forEach(prestito -> listaElementi.add(prestito.getElementoPrestato().getIsbn()));
        return listaElementi;
    }
    }
