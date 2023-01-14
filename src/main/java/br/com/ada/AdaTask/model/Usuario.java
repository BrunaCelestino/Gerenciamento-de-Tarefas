package br.com.ada.AdaTask.model;
import br.com.ada.AdaTask.model.enums.Genero;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String username;
    private String senha;
    @Column(unique = true)
    private String email;
    private String nomeCompleto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private LocalDate DataDeNascimento;
    private Genero genero;
    private String telefone;
}
