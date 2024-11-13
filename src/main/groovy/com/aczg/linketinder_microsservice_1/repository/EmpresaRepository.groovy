package com.aczg.linketinder_microsservice_1.repository

import com.aczg.linketinder_microsservice_1.model.Empresa
import org.springframework.data.jpa.repository.JpaRepository

interface EmpresaRepository extends JpaRepository<Empresa, UUID>{

}