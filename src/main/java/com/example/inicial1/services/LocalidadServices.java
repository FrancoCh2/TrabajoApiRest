package com.example.inicial1.services;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.repositories.LocalidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadServices implements BaseService<Localidad>{
    @Autowired
    private LocalidadRepository localidadRepository;
    @Override
    @Transactional
    public List<Localidad> findAll() throws Exception {
        try{
            List<Localidad> entities = localidadRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad findById(Long id) throws Exception {
        try{
            Optional<Localidad> entityOpcional = localidadRepository.findById(id);
            return entityOpcional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad save(Localidad entity) throws Exception {
        try{
            entity = localidadRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad update(Long id, Localidad entity) throws Exception {
        try{
            Optional<Localidad> entityOpcional = localidadRepository.findById(id);
            Localidad localidad = entityOpcional.get();
            localidad = localidadRepository.save(localidad);
            return localidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(localidadRepository.existsById(id)){
                localidadRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
