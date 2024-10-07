package ma.lh.banquedigital.repositories;
import ma.lh.banquedigital.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientRepositorie extends JpaRepository<Client,Long> {
}
