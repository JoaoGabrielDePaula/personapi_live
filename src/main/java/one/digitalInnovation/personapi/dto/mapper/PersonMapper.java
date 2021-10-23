package one.digitalInnovation.personapi.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import one.digitalInnovation.personapi.dto.request.PersonDTO;
import one.digitalInnovation.personapi.entities.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);

}
