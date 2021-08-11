package br.com.letscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "aluno")
public class Aluno {

    @Id
    @Getter @Setter private int ra;
    @Getter @Setter private String nome;
    @Getter @Setter private String sobrenome;

    @Column(name = "data_nascimento")
    @Getter @Setter private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso")
    @Getter @Setter private Curso codigoCurso;
}
