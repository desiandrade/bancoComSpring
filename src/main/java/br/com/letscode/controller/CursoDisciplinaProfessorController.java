package br.com.letscode.controller;


import br.com.letscode.entity.CursoDisciplina;
import br.com.letscode.repository.CursoDisciplinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class CursoDisciplinaProfessorController {

    private final CursoDisciplinaRepository cursoDisciplinaRepository;

    @RequestMapping ("/cursoDisciplinas")
    public List<CursoDisciplina> buscarCursoDisciplinas (){
        List <CursoDisciplina> cursosDisciplinas = cursoDisciplinaRepository.findAll();
        return cursosDisciplinas;
    }


}
