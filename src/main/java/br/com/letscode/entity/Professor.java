package br.com.letscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "professor")
public class Professor {

    @Id
    @Column(name = "registro_professor")
    @Getter @Setter private int registroProfessor;
    @Getter @Setter private String nome;


}
