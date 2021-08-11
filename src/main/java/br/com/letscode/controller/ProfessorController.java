package br.com.letscode.controller;

import br.com.letscode.entity.Professor;
import br.com.letscode.repository.ProfessorRepository;
import br.com.letscode.request.ProfessorRequest;
import br.com.letscode.request.ProfessorRequestAtualizar;
import br.com.letscode.response.ProfessorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorRepository professorRepository;

    @GetMapping
    public List<ProfessorResponse> buscarProfessores(){
        List <Professor> professors = professorRepository.findAll();
        return ProfessorResponse.convert(professors);
    }

    @PostMapping
    public ResponseEntity<ProfessorResponse> cadastrar
            (@RequestBody ProfessorRequest professorRequest,
             UriComponentsBuilder uriComponentsBuilder){
        Professor professor = professorRequest.convert();
        professorRepository.save(professor);
        URI uri = uriComponentsBuilder.path("/professores/{registroProfessor}").buildAndExpand(professor.getRegistroProfessor()).toUri();
        return ResponseEntity.created(uri).body(new ProfessorResponse(professor));
    }

    @GetMapping("/{registroProfessor}")
    public ProfessorResponse buscarProfessorPorRegistro(@PathVariable int registroProfessor){
        Professor professor = professorRepository.getById(registroProfessor);
        return new ProfessorResponse(professor);
    }

    @PutMapping("/{registroProfessor}")
    public ResponseEntity<ProfessorResponse> atualizar(
            @PathVariable int registroProfessor, @RequestBody ProfessorRequestAtualizar professorRequestAtualizar
            ){
        Professor professor = professorRequestAtualizar.convert(registroProfessor);
        professorRepository.save(professor);
        return ResponseEntity.ok(new ProfessorResponse(professor));
    }

    @DeleteMapping("/{registroProfessor}")
    public ResponseEntity<?> remover(@PathVariable int registroProfessor){
        professorRepository.deleteById(registroProfessor);
        return ResponseEntity.ok().build();
    }

}
