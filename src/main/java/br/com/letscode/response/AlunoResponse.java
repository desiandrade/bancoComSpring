package br.com.letscode.response;

import br.com.letscode.entity.Aluno;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoResponse {
    @Getter private int ra;
    @Getter private String nome;
    @Getter private String sobrenome;
    @Getter private Date dataNascimento;

    public AlunoResponse(Aluno aluno){
        this.ra = aluno.getRa();
        this.nome = aluno.getNome();
        this.sobrenome = aluno.getSobrenome();
        this.dataNascimento = aluno.getDataNascimento();
    }

    public static List<AlunoResponse> convert(List<Aluno>alunos){
        return alunos.stream().map(AlunoResponse::new).collect(Collectors.toList());
    }
}
