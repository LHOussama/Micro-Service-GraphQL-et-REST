package ma.lh.banquedigital.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Compte> comptes=new ArrayList<>();
}
