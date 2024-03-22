package chunyinyu.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ElementoLetterario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long isbn;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private Date annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;

    public ElementoLetterario(long isbn, String titolo, Date annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Date getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Date annoPubblicazione) {
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
