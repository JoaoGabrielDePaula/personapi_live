package one.digitalInnovation.personapi.service;

import one.digitalInnovation.personapi.dto.MessageResponseDTO;
import one.digitalInnovation.personapi.dto.request.PersonDTO;
import one.digitalInnovation.personapi.entity.Person;
import one.digitalInnovation.personapi.exception.PersonNotFoundException;
import one.digitalInnovation.personapi.mapper.PersonMapper;
import one.digitalInnovation.personapi.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    ///private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = PersonMapper.INSTANCE.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(PersonMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundException(id);
        }
        return PersonMapper.INSTANCE.toDTO(optionalPerson.get());
    }


}
