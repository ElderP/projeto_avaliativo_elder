package br.com.labparadise.labbeach.controllers;

import br.com.labparadise.labbeach.models.Turma;
import br.com.labparadise.labbeach.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<Turma> findAll(){
        List<Turma> turmas = turmaService.findAll();
        return ResponseEntity.ok().body(turmas).getBody();
    }

    @PostMapping
    public Long save(@RequestParam("nome") String nome,
                     @RequestParam("totalAlunos") Integer totalAlunos
    ) {
        return ResponseEntity.ok().body(turmaService.save(nome, totalAlunos)).getBody();
    }

}
