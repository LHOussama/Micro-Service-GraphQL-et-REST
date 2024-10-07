package ma.lh.banquedigital.Mapper;
import ma.lh.banquedigital.dto.ClientDto;
import ma.lh.banquedigital.dto.CompteDto;
import ma.lh.banquedigital.entities.Client;
import ma.lh.banquedigital.entities.Compte;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BanqueMapper {
    ModelMapper modelMapper = new ModelMapper();

    public ClientDto fromClient(Client client) {
        ClientDto clientDto = modelMapper.map(client, ClientDto.class);
        List<CompteDto> compteDtos = modelMapper.map(client.getComptes(), new TypeToken<List<CompteDto>>() {}.getType());
        clientDto.setComptes_dto(compteDtos);
        return clientDto;
    }

    public CompteDto fromCompte(Compte compte) {
        return modelMapper.map(compte, CompteDto.class);
    }

    public Client fromClientDto(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }

    public Compte fromCompteDto(CompteDto compteDto) {
        return modelMapper.map(compteDto, Compte.class);
    }
}
