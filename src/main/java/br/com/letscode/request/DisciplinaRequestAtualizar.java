package br.com.letscode.request;

import br.com.letscode.entity.Disciplina;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplinaRequestAtualizar {

    private String nomeDisciplina;
    private int cargaPratica;
    private int cargaTeorica;

    public Disciplina convert(int codigoDisciplina){
        return new Disciplina(codigoDisciplina,nomeDisciplina,cargaPratica,cargaTeorica);
    }

}
