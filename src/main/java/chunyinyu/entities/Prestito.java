package chunyinyu.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "elementi_prestati")
    private ElementoLetterario elementoPrestato;
    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    public Prestito(Utente utente, ElementoLetterario elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = this.dataInizioPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoLetterario getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(ElementoLetterario elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
