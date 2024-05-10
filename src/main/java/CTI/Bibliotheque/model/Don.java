package CTI.Bibliotheque.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Don {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "adherent_id")
    private Adherent adherentDonateur;

    private double montant;

    private LocalDate dateDon;


    public Don() {
    }


    public Don(Adherent adherentDonateur, double montant, LocalDate dateDon) {
        this.adherentDonateur = adherentDonateur;
        this.montant = montant;
        this.dateDon = dateDon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Adherent getAdherentDonateur() {
        return adherentDonateur;
    }

    public void setAdherentDonateur(Adherent adherentDonateur) {
        this.adherentDonateur = adherentDonateur;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDateDon() {
        return dateDon;
    }

    public void setDateDon(LocalDate dateDon) {
        this.dateDon = dateDon;
    }
}
