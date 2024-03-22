package chunyinyu.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "riviste")
public class Rivista extends ElementoLetterario{

    @Column(name = "periodita'")
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }
}
