package ma.lh.banquedigital.repositories;

import ma.lh.banquedigital.entities.Compte;
import ma.lh.banquedigital.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepositorie extends JpaRepository<Compte,String> {
    List<Compte> getComptesByType(TypeCompte type);
}
