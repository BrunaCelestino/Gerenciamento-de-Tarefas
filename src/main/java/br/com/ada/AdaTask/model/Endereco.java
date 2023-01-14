package br.com.ada.AdaTask.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {
    private Long idEndereco;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Id
    public Long getIdEndereco() {
        return idEndereco;
    }
}
