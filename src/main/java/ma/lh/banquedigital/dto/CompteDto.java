package ma.lh.banquedigital.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ma.lh.banquedigital.enums.TypeCompte;
import java.util.Date;
@Data
public class CompteDto {
    private double solde;
    private Date date_creation;
    private TypeCompte type;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ClientDto client_dto;
}
