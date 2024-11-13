package com.aczg.linketinder_microsservice_1.service

import com.aczg.linketinder_microsservice_1.model.Empresa
import com.aczg.linketinder_microsservice_1.repository.EmpresaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmpresaService {

    EmpresaRepository repository

    @Autowired
    EmpresaService(EmpresaRepository repository){
        this.repository = repository
    }

    void save(Empresa empresa){
        repository.save(empresa)
    }

    void delete(UUID uuid){
        repository.deleteById(uuid)
    }

    Empresa getByUUID(UUID uuid){
        repository.findById(uuid)
            .orElseThrow({ new Exception("Empresa não encontrada") })
    }

    List<Empresa> getAll(){
        repository.findAll()
    }
}
