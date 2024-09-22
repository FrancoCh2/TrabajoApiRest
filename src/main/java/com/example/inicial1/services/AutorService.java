package com.example.inicial1.services;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.repositories.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class AutorService implements BaseService<Autor>{
    @Autowired
    private AutorRepository autorRepository;
    @Override
    @Transactional
    public List<Autor> findAll() throws Exception {
        try {


        List<Autor> entities = autorRepository.findAll();
        return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor findById(Long id) throws Exception {
        try{
            Optional<Autor> entityOpcional = autorRepository.findById(id);
            return entityOpcional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor save(Autor entity) throws Exception {
        try{
            entity = autorRepository.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor update(Long id, Autor entity) throws Exception {
        try{
            Optional<Autor> entityOpcional = autorRepository.findById(id);
            Autor autor = entityOpcional.get();
            autor = autorRepository.save(autor);
            return autor;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(autorRepository.existsById(id)){
                autorRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
