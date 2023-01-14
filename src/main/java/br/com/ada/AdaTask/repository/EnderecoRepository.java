package br.com.ada.AdaTask.repository;

import br.com.ada.AdaTask.model.Endereco;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
    List<Endereco> findByCEPContainingIgnoreCase(String filtro);
}
