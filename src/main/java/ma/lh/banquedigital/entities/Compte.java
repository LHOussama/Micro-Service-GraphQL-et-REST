package ma.lh.banquedigital.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.lh.banquedigital.enums.TypeCompte;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Compte {
    @Id
    private String id;
    private double solde;
    private Date date_creation=new Date();
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
    @ManyToOne(optional=false,fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Client client;
}
