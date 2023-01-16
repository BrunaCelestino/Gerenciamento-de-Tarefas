package br.com.ada.AdaTask.service;

import br.com.ada.AdaTask.model.Tarefa;

import br.com.ada.AdaTask.model.Usuario;
import br.com.ada.AdaTask.repository.TarefaRepository;
import br.com.ada.AdaTask.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;


    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa criar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listar(){
        return (List<Tarefa>) tarefaRepository.findAll();
    }

    public List<Tarefa> buscarPorUsuario(Long id){
        return tarefaRepository.findByResponsavelId(id);
    }

    public String excluir(Long id){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        if (tarefa != null) {
            tarefaRepository.delete(tarefa);
            return "Tarefa: " + tarefa.getNome()  + ", deletada com sucesso!";
        } else {
            return "Tarefa não encontrada!";
        }
    }
    public Tarefa recuperar(Long id){
        return tarefaRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public String atualizar(Tarefa tarefa, Long id){
        Tarefa tarefaFound = tarefaRepository.findById(id).orElseThrow(IllegalArgumentException::new);


        tarefaFound.setStatus(tarefa.getStatus());
        tarefaFound.setDescricao(tarefa.getDescricao());
        tarefaRepository.save(tarefaFound);
        return "Campos atualizados com sucesso!";
    }

}
