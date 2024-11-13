package com.aczg.linketinder_microsservice_1.controller

import com.aczg.linketinder_microsservice_1.model.Empresa
import com.aczg.linketinder_microsservice_1.service.EmpresaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/empresa")
class EmpresaController {

    private final EmpresaService service;

    @Autowired
    EmpresaController(EmpresaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    ResponseEntity<Empresa> getEmpresa(@PathVariable String id) {
        Empresa empresa = service.getByUUID(UUID.fromString(id));
        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empresa);
    }

    @GetMapping("/all")
    ResponseEntity<List<Empresa>> getAllEmpresas() {
        List<Empresa> empresas = service.getAll();
        if (empresas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empresas);
    }

    @PostMapping
    ResponseEntity<Void> saveEmpresa(@RequestBody @Validated Empresa empresa) {
        service.save(empresa);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateEmpresa(@PathVariable String id, @RequestBody @Validated Empresa empresa) {
        empresa.setId(UUID.fromString(id));
        service.save(empresa);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEmpresa(@PathVariable String id) {
        service.delete(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }

}
