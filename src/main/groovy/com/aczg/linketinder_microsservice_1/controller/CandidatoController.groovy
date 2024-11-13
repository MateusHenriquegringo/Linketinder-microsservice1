package com.aczg.linketinder_microsservice_1.controller

import com.aczg.linketinder_microsservice_1.model.Candidato
import com.aczg.linketinder_microsservice_1.service.CandidatoService
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
@RequestMapping("/candidato")
class CandidatoController {

    private final CandidatoService service

    @Autowired
    CandidatoController(CandidatoService service){
        this.service = service
    }

    @GetMapping("/{id}")
    ResponseEntity<Candidato> getCandidato(@PathVariable String id) {
        Candidato candidato = service.getByUUID(UUID.fromString(id));
        if (candidato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(candidato);
    }

    @GetMapping("/all")
    ResponseEntity<List<Candidato>> getAllCandidatos() {
        List<Candidato> candidatos = service.getAll();
        if (candidatos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(candidatos);
    }

    @PostMapping
    ResponseEntity<Void> saveCandidato(@RequestBody @Validated Candidato candidato) {
        service.save(candidato);
        return ResponseEntity.ok().build()
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateCandidato(@PathVariable String id, @RequestBody @Validated Candidato candidato) {
        candidato.setId(UUID.fromString(id));
        service.save(candidato);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCandidato(@PathVariable String id) {
        service.delete(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }

}
