package br.com.letscode.request;

import br.com.letscode.entity.Professor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorRequestAtualizar {

    private String nome;

    public Professor convert (int registroProfessor){
        return new Professor(registroProfessor, nome);
    }
}
