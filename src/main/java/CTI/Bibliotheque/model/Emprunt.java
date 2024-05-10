package CTI.Bibliotheque.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Emprunt {
    private Ouvrage ouvrageEmprunt;
    private LocalDate dateRetourPrevu;
    private LocalDate dateRetourEffective;
    private String statut;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;
    @ManyToOne
    @JoinColumn(name = "adherent_id")
    private Adherent adherent;
    private LocalDate dateEmprunt;
    private LocalDate dateRestitution;

    @ManyToOne
    @JoinColumn(name = "vente_id")
    private Vente vente;

    @ManyToOne
    @JoinColumn(name = "don_id")
    private Don don;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Emprunt(Ouvrage ouvrageEmprunt, LocalDate dateRetourPrevu, LocalDate dateRetourEffective, String statut, LocalDate dateRestitution, Vente vente, Don don, User user) {

        this.ouvrageEmprunt = ouvrageEmprunt;
        this.dateRetourPrevu = dateRetourPrevu;
        this.dateRetourEffective = dateRetourEffective;
        this.statut = statut;
        this.dateRestitution = dateRestitution;
        this.vente = vente;
        this.don = don;
        this.user = user;
    }


    public Emprunt(Ouvrage ouvrageEmprunt, Long id, Ouvrage ouvrageEmprunte, Adherent adherent, LocalDate dateEmprunt, LocalDate dateRetourPrevu, LocalDate dateRetourEffective, String statut) {
        this.ouvrageEmprunt = ouvrageEmprunt;
        this.id = id;
        this.ouvrageEmprunt = ouvrageEmprunte;
        this.adherent = adherent;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevu = dateRetourPrevu;
        this.dateRetourEffective = dateRetourEffective;
        this.statut = statut;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ouvrage getOuvrageEmprunt() {
        return ouvrageEmprunt;
    }

    public void setOuvrageEmprunt(Ouvrage ouvrageEmprunte) {
        this.ouvrageEmprunt = ouvrageEmprunt;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    public void setDateRetourPrevu(LocalDate dateRetourPrevu) {
        this.dateRetourPrevu = dateRetourPrevu;
    }

    public LocalDate getDateRetourEffective() {
        return dateRetourEffective;
    }

    public void setDateRetourEffective(LocalDate dateRetourEffective) {
        this.dateRetourEffective = dateRetourEffective;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Object getOuvrage() {
        return null;
    }

    public void setOuvrage(Object ouvrage) {
    }
}
