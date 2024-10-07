package ma.lh.banquedigital;
import ma.lh.banquedigital.entities.Client;
import ma.lh.banquedigital.entities.Compte;
import ma.lh.banquedigital.enums.TypeCompte;
import ma.lh.banquedigital.repositories.ClientRepositorie;
import ma.lh.banquedigital.repositories.CompteRepositorie;
import ma.lh.banquedigital.services.BanqueService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@SpringBootApplication
public class BanqueDigitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(BanqueDigitalApplication.class, args);
    }
    CommandLineRunner start(ClientRepositorie clientRepositorie, CompteRepositorie compteRepositorie) {
        return args -> {
            Client client = new Client();
            client.setNom("oussama");
            clientRepositorie.save(client);
            for (int i = 0; i < 2; i++) {
                Compte compte = new Compte();
                compte.setId(UUID.randomUUID().toString());
                compte.setType(Math.random() > 0.5 ? TypeCompte.COMPTE_COURANT : TypeCompte.COMPTE_EPPARGNE);
                compte.setSolde(Math.random() * 1000);
                compte.setDate_creation(new Date());
                compte.setClient(client);
                compteRepositorie.save(compte);
            }
        };
    }
    @Bean
    CommandLineRunner commandLineRunner(BanqueService service){
        return args -> {
            List.of("oussama","yassine","mehdi").forEach(s -> {
                Client client=new Client();
                client.setNom(s);
                service.ajouterClient(client);
                for (int i = 0; i < 3; i++) {
                    Compte compte = new Compte();
                    compte.setType(Math.random() > 0.5 ? TypeCompte.COMPTE_COURANT : TypeCompte.COMPTE_EPPARGNE);
                    compte.setSolde(Math.random() * 1000);
                    compte.setDate_creation(new Date());
                    compte.setClient(client);
                    service.ajouterCompte(compte);
                }
            });
        };
        }



}
