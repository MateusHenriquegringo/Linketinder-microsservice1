package com.aczg.linketinder_microsservice_1.service

import com.aczg.linketinder_microsservice_1.model.Candidato
import com.aczg.linketinder_microsservice_1.repository.CandidatoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CandidatoService {

    CandidatoRepository repository

    @Autowired
    CandidatoService(CandidatoRepository repository){
        this.repository = repository
    }

    void save(Candidato candidato){
        repository.save(candidato)
    }

    void delete(UUID uuid){
        repository.deleteById(uuid)
    }

    Candidato getByUUID(UUID uuid){
        repository.findById(uuid)
            .orElseThrow({ new Exception("Candidato não encontrado") })
    }

    List<Candidato> getAll(){
        repository.findAll()
    }
}
