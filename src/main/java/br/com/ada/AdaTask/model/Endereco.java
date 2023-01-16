package br.com.ada.AdaTask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "usuario_id")
//    private Usuario usuario;


}
