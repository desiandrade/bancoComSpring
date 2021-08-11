package br.com.letscode.entity;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "telefone_professor")
public class TelefoneProfessor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter int numero;

    @ManyToOne
    @JoinColumn(name = "registro_professor", referencedColumnName = "registro_professor")
    @Getter @Setter Professor registroProfessor;




}
