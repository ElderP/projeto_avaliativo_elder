package br.com.labparadise.labbeach.repositories;

import br.com.labparadise.labbeach.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    public List<Aluno> findByNome(String nome);

    public List<Aluno> findByIdade(Integer idade);
    
    public List<Aluno> findByTurmaNome(String turma);

}
