package CTI.Bibliotheque.model;

import jakarta.persistence.*;

import java.util.List;


@Entity

public class Ouvrage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String auteur;
    private int quantiteDisponible;
    private double prix;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vente> ventes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List <Don> dons;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Emprunt> emprunts;

    public Ouvrage(List ventes, List dons, List emprunts) {
        this.ventes = ventes;
        this.dons = dons;
        this.emprunts = emprunts;
    }

    public Ouvrage(String titre, String auteur, int quantiteDisponible, double prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.quantiteDisponible = quantiteDisponible;
        this.prix = prix;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
