package com.aczg.linketinder_microsservice_1.model

import com.aczg.linketinder_microsservice_1.enums.CompetenciaENUM
import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table
import org.springframework.lang.NonNull


@Entity
@Table(name = "candidato")
class Candidato {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id

        @NonNull
        @Column(name = "first_name")
        private String first_name

        @Column(name = "last_name")
        private String last_name

        @NonNull
        @Column(name = "cpf", unique = true)
        private String cpf

        @Column(name = "description")
        private String description

        @NonNull
        @Column(name = "email", unique = true)
        private String email

        @Column(name = "state")
        private String state

        @Column(name = "city")
        private String city

        @NonNull
        @Column(name = "password")
        private String password

        @ElementCollection(targetClass = CompetenciaENUM.class)
        @CollectionTable(name = "candidato_competences", joinColumns = @JoinColumn(name = "candidato_id"))
        @Column(name = "competences")
        @Enumerated(EnumType.STRING)
        private Set<CompetenciaENUM> competences
}
