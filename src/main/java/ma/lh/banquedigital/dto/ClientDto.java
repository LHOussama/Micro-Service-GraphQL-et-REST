package ma.lh.banquedigital.dto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ClientDto {
    private String nom;
    private List<CompteDto> comptes_dto=new ArrayList<>();

}
