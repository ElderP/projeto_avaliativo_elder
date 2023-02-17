package br.com.labparadise.labbeach.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "O Nome não pode ser nulo ou vazio")
    private String nome;
    private Integer idade;
    private Boolean matriculado;
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;


}
