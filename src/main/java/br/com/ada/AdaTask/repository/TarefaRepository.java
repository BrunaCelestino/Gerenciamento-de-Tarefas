package br.com.ada.AdaTask.repository;

import br.com.ada.AdaTask.model.Tarefa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {


    List<Tarefa> findByResponsavelId(Long id);
}
