package br.com.ada.AdaTask.service;

import br.com.ada.AdaTask.model.Tarefa;
import br.com.ada.AdaTask.model.enums.Status;
import br.com.ada.AdaTask.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
            return "Usuário: " + tarefa.getNome()  + ", deletada com sucesso!";
        } else {
            return "Usuário não encontrado!";
        }
    }
    public String recuperar(Long id){
        return tarefaRepository.findById(id).toString();
    }

    public String atualizar(Tarefa tarefa){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a nova descricao: ");
        String novaDescricao = sc.nextLine();

        System.out.println("Digite o novo status ");
        String novoStatus = sc.nextLine();
        tarefa.setStatus(Status.valueOf(novoStatus));

        return "Campos atualizados com sucesso!";
    }

}
