package br.com.labparadise.labbeach.repositories;

import br.com.labparadise.labbeach.models.Aluno;
import br.com.labparadise.labbeach.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    public List<Aluno> findByNome(String nome);

    public List<Aluno> findByIdade(Integer idade);

    public List<Aluno> findByTurma(Turma turma);

    @Query("SELECT a FROM Aluno a " +
            "LEFT JOIN Turma t on ( a.turma = t ) " +
            "WHERE t.totalAlunos <= :num")
    public List<Aluno> findByTurmaTotalQuery(@Param("num") Integer totalAlunos);

}
