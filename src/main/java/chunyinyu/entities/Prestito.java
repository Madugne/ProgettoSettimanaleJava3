package chunyinyu.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Utente utente;
    private ElementoLetterario elementoPrestato;
    private Date dataInizioPrestito;
    private Date dataRestituzionePrevista;
    private Date dataRestituzioneEffettiva;

    public Prestito(Utente utente, ElementoLetterario elementoPrestato, Date dataInizioPrestito, Date dataRestituzionePrevista, Date dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
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
