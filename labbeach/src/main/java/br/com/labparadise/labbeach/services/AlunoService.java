package br.com.labparadise.labbeach.services;

import br.com.labparadise.labbeach.models.Aluno;
import br.com.labparadise.labbeach.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

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

    public List<Aluno> findByNome( String nome ){
        return alunoRepository.findByNome(nome);
    }

    public List<Aluno> findByIdade( Integer idade ){
        return alunoRepository.findByIdade(idade);
    }


}
