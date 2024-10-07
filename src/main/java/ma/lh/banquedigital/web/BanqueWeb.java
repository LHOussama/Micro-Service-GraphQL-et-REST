package ma.lh.banquedigital.web;
import lombok.AllArgsConstructor;
import ma.lh.banquedigital.dto.ClientDto;
import ma.lh.banquedigital.entities.Client;
import ma.lh.banquedigital.entities.Compte;
import ma.lh.banquedigital.exceptions.ClientException;
import ma.lh.banquedigital.exceptions.CompteException;
import ma.lh.banquedigital.services.BanqueService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/banque")
public class BanqueWeb {
    private BanqueService service;
    @GetMapping("/clients")
    public List<ClientDto> clients(){
        return service.clients();
    }
    @GetMapping("/comptes")
    public List<Compte>comptes(){
        return service.comptes();
    }
    @GetMapping("/client/{id}")
    public ClientDto getClient(@PathVariable Long id) throws ClientException {
        return service.getClientParId(id);
    }
    @GetMapping("/compte/{id}")
    public Compte getCOpte(String id) throws CompteException {
        return service.getCompteById(id);
    }
    @PostMapping("/addClient")
    public ClientDto addClient(@RequestBody Client client){
        return service.ajouterClient(client);
    }
    @PostMapping("/addCompte")
    public Compte addCompte(@RequestBody Compte compte){
        return service.ajouterCompte(compte);
    }
    @QueryMapping()
    public List<ClientDto> getAllClient(){
        return service.clients();
    }
    @MutationMapping()
    public ClientDto addClientMutation(Client client){
        return service.ajouterClient(client);
    }
}
