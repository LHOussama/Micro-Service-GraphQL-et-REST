package ma.lh.banquedigital.services;

import ma.lh.banquedigital.dto.ClientDto;
import ma.lh.banquedigital.entities.Client;
import ma.lh.banquedigital.entities.Compte;
import ma.lh.banquedigital.enums.TypeCompte;
import ma.lh.banquedigital.exceptions.ClientException;
import ma.lh.banquedigital.exceptions.CompteException;

import java.util.List;

public interface BanqueService {
    ClientDto ajouterClient(Client client);
    ClientDto getClientParId(Long id) throws ClientException;
    List<ClientDto> clients();
    void supprimerClient(Client client);
    ClientDto mettreAjour(Client client, Long id) throws ClientException;
    Compte ajouterCompte(Compte compte);
    List<Compte> getCompteByType(TypeCompte type);
    List<Compte> comptes();
    void supprimer_compte(Compte compte);
    Compte mettreAjour(Compte compte,String id) throws CompteException;
    List<Compte> compteClient(Client client);
    Compte getCompteById(String id) throws CompteException;

}
