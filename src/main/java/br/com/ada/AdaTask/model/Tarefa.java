package br.com.ada.AdaTask.model;

import br.com.ada.AdaTask.model.enums.Prioridade;
import br.com.ada.AdaTask.model.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String nome;
    private String descricao;
    private Status status;
    private LocalDateTime dataDeCriacao;
    private LocalDateTime dataDeVencimento;
    private Prioridade prioridade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario responsavel;
    private String projeto;
    private String etiquetas;
}
