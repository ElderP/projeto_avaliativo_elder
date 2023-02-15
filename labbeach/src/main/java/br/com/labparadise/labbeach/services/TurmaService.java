package br.com.labparadise.labbeach.services;

import br.com.labparadise.labbeach.models.Turma;
import br.com.labparadise.labbeach.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> findAll(){
        return turmaRepository.findAll();
    }

    public Long save(String nome, Integer totalAlunos){
        Turma turma = new Turma();
        turma.setNome(nome);
        turma.setTotalAlunos(totalAlunos);
        return turmaRepository.save(turma).getId();
    }

    public Turma findById(Long id){
        Optional<Turma> turma = turmaRepository.findById(id);
        return (turma.isPresent() ? turma.get() : null);
    }

}
