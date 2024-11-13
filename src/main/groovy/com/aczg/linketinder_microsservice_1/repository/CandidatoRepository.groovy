package com.aczg.linketinder_microsservice_1.repository

import com.aczg.linketinder_microsservice_1.model.Candidato
import org.springframework.data.jpa.repository.JpaRepository

interface CandidatoRepository extends JpaRepository<Candidato, UUID>{
}
