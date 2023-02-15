package br.com.labparadise.labbeach.services;

import br.com.labparadise.labbeach.models.Aluno;
import br.com.labparadise.labbeach.models.Turma;
import br.com.labparadise.labbeach.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private TurmaService turmaService;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Long save( String nome,
                      Integer idade,
                      Boolean matriculado){
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setMatriculado(matriculado);
        return alunoRepository.save(aluno).getId();
    }

    public Long save( String nome,
                      Integer idade,
                      Boolean matriculado,
                      Long turmaId){
        Aluno aluno = new Aluno();
        Turma turma = turmaService.findById(turmaId);
        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setMatriculado(matriculado);
        aluno.setTurma(turma);
        return alunoRepository.save(aluno).getId();
    }

    public List<Aluno> findByNome( String nome ){
        return alunoRepository.findByNome(nome);
    }

    public List<Aluno> findByIdade( Integer idade ){
        return alunoRepository.findByIdade(idade);
    }

    public List<Aluno> findByTurma( Long turmaId ) {
        Turma turma = turmaService.findById(turmaId);
        return alunoRepository.findByTurma(turma);
    }

    public List<Aluno> findByTurmaTotalQuery(Integer totalAlunos){
        return alunoRepository.findByTurmaTotalQuery(totalAlunos);
    }

}
