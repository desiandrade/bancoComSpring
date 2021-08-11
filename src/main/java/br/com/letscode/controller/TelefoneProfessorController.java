package br.com.letscode.controller;

import br.com.letscode.entity.TelefoneProfessor;
import br.com.letscode.repository.TelefoneProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class TelefoneProfessorController {

    private final TelefoneProfessorRepository telefoneProfessorRepository;

    @RequestMapping("/telefonesProfessor")
    public List<TelefoneProfessor> buscarTelefoneProfessor (){
        List<TelefoneProfessor> telefonesProfessores = telefoneProfessorRepository.findAll();
        return telefonesProfessores;
    }
}
