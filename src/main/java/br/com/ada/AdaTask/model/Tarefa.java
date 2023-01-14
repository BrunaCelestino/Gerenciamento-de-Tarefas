package br.com.ada.AdaTask.model;

import br.com.ada.AdaTask.model.enums.Prioridade;
import br.com.ada.AdaTask.model.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String nome;
    private String descricao;
    private Status status;
    private LocalDateTime dataDeCriacao;
    private LocalDateTime dataDeVencimento;
    private Prioridade prioridade;
    private Usuario responsavel;
    private String projeto;
    private String etiquetas;


}
