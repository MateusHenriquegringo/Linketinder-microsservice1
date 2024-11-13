package com.aczg.linketinder_microsservice_1.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.lang.NonNull

@Entity
@Table(name = "empresa")
class Empresa {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id

        @NonNull
        @Column(name = "empresa_name")
        private String empresa_name

        @Column(name = "description")
        private String description

        @NonNull
        @Column(name = "email", unique = true)
        private String email

        @Column(name = "cnpj", unique = true)
        private String cnpj

        @Column(name = "state")
        private String state

        @Column(name = "city")
        private String city

        @Column(name = "password")
        private String password

        void setId(UUID id) {
                this.id = id
        }
}
