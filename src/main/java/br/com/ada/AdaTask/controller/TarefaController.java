package br.com.ada.AdaTask.controller;

import br.com.ada.AdaTask.model.Tarefa;

import br.com.ada.AdaTask.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return tarefaService.criar(tarefa);
    }
    @GetMapping
    public List<Tarefa> listar() {
        return tarefaService.listar();
    }

    //duvida aqui
    /*
    @GetMapping("/{id}")
    public Usuario buscarPorUsuario(@PathVariable Long id) {
        return tarefaService.buscarPorUsuario(id);
    } */

    @DeleteMapping("{id}")
    public String excluir(@PathVariable Long id) {
        return tarefaService.excluir(id);
    }

    @GetMapping("/{id}")
    public String recuperar(@PathVariable Long id) {
        return tarefaService.recuperar(id);
    }

    @PostMapping
    public String atualizar(@RequestBody Tarefa tarefa){
        return tarefaService.atualizar(tarefa);
    }

}
