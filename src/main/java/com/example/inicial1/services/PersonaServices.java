package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServices implements BaseService<Persona>{

    private PersonaRepository personaRepository;

    public  PersonaServices(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }
    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try {
            List<Persona> entities = personaRepository.findAll();
            return entities;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try{
            Optional<Persona> entityOpcional = personaRepository.findById(id);
            return entityOpcional.get();
        }catch (Exception e ){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try{
            entity = personaRepository.save(entity);
            return  entity;
        }catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try{
            Optional<Persona> entityOpcional = personaRepository.findById(id);
            Persona persona = entityOpcional.get();
            persona = personaRepository.save(persona);
            return  persona;
        }catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return  true;

            } else {
                throw new Exception();
            }
        }catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }
}
