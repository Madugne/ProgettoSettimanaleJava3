package chunyinyu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "libri")
public class Libro extends ElementoLetterario{
    private String autore;
    private String genere;
    @OneToOne
    private ElementoLetterario elemento;
    public Libro(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro(){}

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + super.getTitolo() + '\'' +
                "pagine='" + super.getNumeroPagine() + '\'' +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
