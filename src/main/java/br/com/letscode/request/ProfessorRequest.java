package br.com.letscode.request;

import br.com.letscode.entity.Professor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorRequest {

    private int registroProfessor;
    private String nome;

    public Professor convert(){
        return new Professor(registroProfessor,nome);
    }
}
