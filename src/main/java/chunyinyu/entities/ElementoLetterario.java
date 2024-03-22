package chunyinyu.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "elemento")
public abstract class ElementoLetterario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long isbn;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;
    @OneToOne(mappedBy = "elemento",cascade = CascadeType.REMOVE)
    private Libro libro;
    @OneToOne(mappedBy = "elemento",cascade = CascadeType.REMOVE)
    private Rivista rivista;
    public ElementoLetterario(String titolo, int annoPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public ElementoLetterario(){}

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public long getIsbn() {
        return isbn;
    }
}
