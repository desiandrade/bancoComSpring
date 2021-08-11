package br.com.letscode.request;

import br.com.letscode.entity.Curso;
import br.com.letscode.entity.Modalidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoRequestAtualizar {

    private String nomeCurso;
    private int duracao;
    private int numeroAlunos;


    public Curso convert (int codigoCurso){
        return new Curso(codigoCurso, nomeCurso, duracao, numeroAlunos, Modalidade.PRESENCIAL);
    }

}
