package ma.lh.banquedigital.services;
import lombok.AllArgsConstructor;
import ma.lh.banquedigital.Mapper.BanqueMapper;
import ma.lh.banquedigital.dto.ClientDto;
import ma.lh.banquedigital.entities.Client;
import ma.lh.banquedigital.entities.Compte;
import ma.lh.banquedigital.enums.TypeCompte;
import ma.lh.banquedigital.exceptions.ClientException;
import ma.lh.banquedigital.exceptions.CompteException;
import ma.lh.banquedigital.repositories.ClientRepositorie;
import ma.lh.banquedigital.repositories.CompteRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
@AllArgsConstructor
public class BanqueServiceImpl implements BanqueService {
    private final CompteRepositorie compteRepositorie;
    private final ClientRepositorie clientRepositorie;
    private final BanqueMapper banqueMapper;
    @Override
    public ClientDto ajouterClient(Client client) {
        return banqueMapper.fromClient(clientRepositorie.save(client));
    }

    @Override
    public ClientDto getClientParId(Long id) throws ClientException {
        return banqueMapper.fromClient(clientRepositorie.findById(id).orElseThrow(() -> new ClientException("client introuvable")));
    }
    @Override
    public List<ClientDto> clients() {
        return clientRepositorie.findAll().stream().map(banqueMapper::fromClient).toList();
    }

    @Override
    public void supprimerClient(Client client) {
        clientRepositorie.delete(client);
    }

    @Override
    public ClientDto mettreAjour(Client client, Long id) throws ClientException {
        ClientDto client1=this.getClientParId(id);
        client1.setNom(client.getNom());
        client1.setComptes_dto(client.getComptes().stream().map(banqueMapper::fromCompte).toList());
        return this.ajouterClient(banqueMapper.fromClientDto(client1));
    }

    @Override
    public Compte ajouterCompte(Compte compte) {
        compte.setId(UUID.randomUUID().toString());
        return compteRepositorie.save(compte);
    }

    @Override
    public List<Compte> getCompteByType(TypeCompte type) {
        return compteRepositorie.getComptesByType(type);
    }

    @Override
    public List<Compte> comptes() {
        return compteRepositorie.findAll();
    }

    @Override
    public void supprimer_compte(Compte compte) {
        compteRepositorie.delete(compte);
    }

    @Override
    public Compte mettreAjour(Compte compte, String id) throws CompteException {
        Compte compte1=this.getCompteById(id);
        compte1.setType(compte.getType());
        compte1.setSolde(compte.getSolde());
        compte1.setDate_creation(compte.getDate_creation());
        return compteRepositorie.save(compte1);
    }

    @Override
    public List<Compte> compteClient(Client client) {
        return compteRepositorie.findAll();
    }

    @Override
    public Compte getCompteById(String id) throws CompteException {
        return compteRepositorie.findById(id).orElseThrow(() -> new CompteException("Compte introuvable"));
    }
}
