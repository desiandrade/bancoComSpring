package br.com.letscode.controller;

import br.com.letscode.entity.Disciplina;
import br.com.letscode.repository.DisciplinaRepository;
import br.com.letscode.request.DisciplinaRequest;
import br.com.letscode.request.DisciplinaRequestAtualizar;
import br.com.letscode.response.DisciplinaResponse;
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
@RequestMapping("/disciplina")
public class DisciplinaController {

    private final DisciplinaRepository disciplinaRepository;

    @GetMapping
    public List<DisciplinaResponse> buscarDisciplinas(){
        List <Disciplina> disciplinas = disciplinaRepository.findAll();
        return DisciplinaResponse.convert(disciplinas);
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponse> cadastrar(@RequestBody DisciplinaRequest disciplinaRequest, UriComponentsBuilder uriComponentsBuilder){
        Disciplina disciplina = disciplinaRequest.convert();
        URI uri = uriComponentsBuilder.path("disciplina/{codigoDisciplina}").buildAndExpand(disciplina.getCodigoDisciplina()).toUri();
        return ResponseEntity.created(uri).body(new DisciplinaResponse(disciplina));
    }

    @GetMapping("/{codigoDisciplina}")
    public DisciplinaResponse buscarPorCodigo(@PathVariable int codigoDisciplina){
        Disciplina disciplina = disciplinaRepository.getById(codigoDisciplina);
        return new DisciplinaResponse(disciplina);
    }

    @PutMapping("/codigoDisciplina")
    public ResponseEntity<DisciplinaResponse> atualizar
            (@PathVariable int codigoDisciplina,
             @RequestBody DisciplinaRequestAtualizar disciplinaRequestAtualizar){
        Disciplina disciplina = disciplinaRequestAtualizar.convert(codigoDisciplina);
        disciplinaRepository.save(disciplina);
        return ResponseEntity.ok(new DisciplinaResponse(disciplina));
    }

    @DeleteMapping ("/{codigoDisciplina}")
    public ResponseEntity<?> remover(@PathVariable int codigoDisciplina){
        disciplinaRepository.deleteById(codigoDisciplina);
        return ResponseEntity.ok().build();
    }

}
