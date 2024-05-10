package CTI.Bibliotheque.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrageVendu;

    @ManyToOne
    @JoinColumn(name = "adherent_id")
    private Adherent adherent;

    private double prix;

    private LocalDate dateVente;
    private double montant;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Vente(Adherent adherent) {
        this.adherent = adherent;
    }

    public Vente(Ouvrage ouvrageVendu, double prix, LocalDate dateVente) {
        this.ouvrageVendu = ouvrageVendu;
        this.prix = prix;
        this.dateVente = dateVente;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ouvrage getOuvrageVendu() {
        return ouvrageVendu;
    }

    public void setOuvrageVendu(Ouvrage ouvrageVendu) {
        this.ouvrageVendu = ouvrageVendu;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public LocalDate getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDate dateVente) {
        this.dateVente = dateVente;
    }
}
