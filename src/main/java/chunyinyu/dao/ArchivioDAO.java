package chunyinyu.dao;

import chunyinyu.entities.ElementoLetterario;
import chunyinyu.entities.Prestito;
import chunyinyu.entities.Utente;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class ArchivioDAO {
    private final EntityManager entityManager;

    private ElementoDAO elementoDAO;
    private UtenteDAO utenteDAO;
    private PrestitoDAO prestitoDAO;
    public ArchivioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.elementoDAO = new ElementoDAO(entityManager);
        this.utenteDAO = new UtenteDAO(entityManager);
        this.prestitoDAO = new PrestitoDAO(entityManager);
    }

    public void aggiungiElemento(ElementoLetterario elementoLetterario) {
        elementoDAO.save(elementoLetterario);
    }

    public void rimuoviElemento(long isbn) {
        elementoDAO.delete(isbn);
    }

    public ElementoLetterario ricercaIsbn(long isbn){
        return elementoDAO.getById(isbn);
    }

    public ElementoLetterario ricercaAnno(int anno){
        return elementoDAO.getByAnno(anno);
    }

    public ElementoLetterario ricercaAutore(String autore){
        return elementoDAO.getByAutore(autore);
    }

    public ElementoLetterario ricercaTitolo(String titolo){
        return elementoDAO.getByTitolo(titolo);
    }

    public List<ElementoLetterario> ricercaElementiPrestati(long numeroTessera) {
        List<ElementoLetterario> listaElementoLetterario = new ArrayList<>();

        List<Long> listaElementiIsbn = prestitoDAO.getElementoIdByNumeroTesseraPrestati(numeroTessera);
        listaElementiIsbn.forEach(elemento -> listaElementoLetterario.add(ricercaIsbn(elemento)));

        return listaElementoLetterario;
    }

    public List<ElementoLetterario> ricercaElementiPrestatiScadutiNonRestituiti(long numeroTessera) {
        List<ElementoLetterario> listaElementoLetterario = new ArrayList<>();

        List<Long> listaElementiIsbn = prestitoDAO.getElementoIdByNumeroTesseraScadutiNonRestituiti(numeroTessera);
        listaElementiIsbn.forEach(elemento -> listaElementoLetterario.add(ricercaIsbn(elemento)));

        return listaElementoLetterario;
    }

    public void save(ElementoLetterario elementoLetterario) {
        elementoDAO.save(elementoLetterario);
    }

    public void save(Utente utente) {
        utenteDAO.save(utente);
    }

    public void save(Prestito prestito) {
        prestitoDAO.save(prestito);
    }
}
