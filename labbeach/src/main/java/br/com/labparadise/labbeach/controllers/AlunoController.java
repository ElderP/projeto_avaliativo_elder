package br.com.labparadise.labbeach.controllers;

import br.com.labparadise.labbeach.models.Aluno;
import br.com.labparadise.labbeach.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> findAll(){
        List<Aluno> alunos = alunoService.findAll();
        return ResponseEntity.ok().body(alunos).getBody();
    }

//    @PostMapping
//    public Long save(@RequestParam("nome") String nome,
//                     @RequestParam("idade") Integer idade,
//                     @RequestParam("matriculado") Boolean matriculado){
//        return ResponseEntity.ok().body(alunoService.save(nome, idade, matriculado)).getBody();
//    }

    @PostMapping
    public Long save(@RequestParam("nome") String nome,
                     @RequestParam("idade") Integer idade,
                     @RequestParam("matriculado") Boolean matriculado,
                     @RequestParam("turmaid") Long turmaId){
        return ResponseEntity.ok().body(alunoService.save(nome, idade, matriculado, turmaId)).getBody();
    }

    @GetMapping(value = "buscapornome")
    public List<Aluno> findByNome(@RequestParam("nome") String nome){
        List<Aluno> alunos = alunoService.findByNome(nome);
        return ResponseEntity.ok().body(alunos).getBody();
    }


    @GetMapping(value = "buscaporidade")
    public List<Aluno> findByIdade(@RequestParam("idade") Integer idade){
        List<Aluno> alunos = alunoService.findByIdade(idade);
        return ResponseEntity.ok().body(alunos).getBody();
    }

    @GetMapping(value = "buscaporturma")
    public List<Aluno> findByTurma(@RequestParam("turmaid") Long id) {
        List<Aluno> alunos = alunoService.findByTurma(id);
        return ResponseEntity.ok().body(alunos).getBody();
    }

    @GetMapping(value = "buscaportotalalunos")
    public List<Aluno> findByTurmaTotalQuery(@RequestParam("totalalunos") Integer totalAlunos) {
        List<Aluno> alunos = alunoService.findByTurmaTotalQuery(totalAlunos);
        return ResponseEntity.ok().body(alunos).getBody();
    }
}
