package com.aczg.linketinder_microsservice_1.repository

import com.aczg.linketinder_microsservice_1.model.Empresa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmpresaRepository extends JpaRepository<Empresa, UUID>{

}