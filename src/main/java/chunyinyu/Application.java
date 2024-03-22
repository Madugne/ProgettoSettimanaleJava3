package chunyinyu;

import chunyinyu.dao.ArchivioDAO;
import chunyinyu.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProgettoSettimanaleJava3");
    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ArchivioDAO archivioDAO = new ArchivioDAO(entityManager);

        Utente utente1 = new Utente("Chris", "Keya", LocalDate.of(1984, 12, 24));
        Utente utente2 = new Utente("Mario", "Rossi", LocalDate.of(2000, 1, 2));

        ElementoLetterario elemento1 = new Libro("DragonBall", 1984, 500, "Akira Toriyama", "Shonen");
        ElementoLetterario elemento2 = new Libro("DragonBallZ", 1984, 550, "Akira Toriyama", "Shonen");
        ElementoLetterario elemento3 = new Libro("GhostInTheShell", 1992, 100, "Masamune Shirow", "Scifi");
        ElementoLetterario elemento4 = new Libro("GhostInTheShellVol2", 2001, 100, "Masamune Shirow", "Scifi");

        ElementoLetterario elemento5 = new Rivista("ISBN6", 2000, 20, Periodicita.SETTIMANALE);
        ElementoLetterario elemento6 = new Rivista("ISBN7", 2001, 30, Periodicita.MENSILE);
        ElementoLetterario elemento7 = new Rivista("ISBN8", 2002, 40, Periodicita.SEMESTRALE);

        Prestito prestito1 = new Prestito(utente1, elemento1, LocalDate.of(2024, 4, 30), null);
        Prestito prestito2 = new Prestito(utente1, elemento2, LocalDate.of(2024, 4, 22), null);
        Prestito prestito3 = new Prestito(utente1, elemento3, LocalDate.of(2024, 4, 11), null);
        Prestito prestito4 = new Prestito(utente2, elemento4, LocalDate.of(2022, 3, 1), null);
        Prestito prestito5 = new Prestito(utente2, elemento5, LocalDate.of(2023, 3, 1), null);
        Prestito prestito6 = new Prestito(utente2, elemento6, LocalDate.of(2024, 3, 1), null);
        Prestito prestito7 = new Prestito(utente2, elemento7, LocalDate.of(2021, 3, 1), null);

        archivioDAO.save(utente1);
        archivioDAO.save(utente2);

        archivioDAO.save(elemento1);
        archivioDAO.save(elemento2);
        archivioDAO.save(elemento3);
        archivioDAO.save(elemento4);
        archivioDAO.save(elemento5);
        archivioDAO.save(elemento6);
        archivioDAO.save(elemento7);

        archivioDAO.save(prestito1);
        archivioDAO.save(prestito2);
        archivioDAO.save(prestito3);
        archivioDAO.save(prestito4);
        archivioDAO.save(prestito5);
        archivioDAO.save(prestito6);
        archivioDAO.save(prestito7);

        System.out.println("Ricerca per isbn: " + (archivioDAO.ricercaIsbn(1L)));
        System.out.println("Ricerca per anno: " + (archivioDAO.ricercaAnno(1984)));
        System.out.println("Ricerca per autore: " + (archivioDAO.ricercaAutore("Akira Toriyama")));
        System.out.println("Ricerca per titolo: " + (archivioDAO.ricercaTitolo("Dragon")));

        System.out.println("Ricerca elementi in prestito" + (archivioDAO.ricercaElementiPrestati(1L)));
        System.out.println("Ricerca elementi scaduti" + (archivioDAO.ricercaElementiPrestatiScadutiNonRestituiti(2L)));

        archivioDAO.rimuoviElemento(2L);
    }
}