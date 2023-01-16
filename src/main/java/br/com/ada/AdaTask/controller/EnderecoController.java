package br.com.ada.AdaTask.controller;

import br.com.ada.AdaTask.model.Endereco;
import br.com.ada.AdaTask.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public Endereco salvar(@RequestBody Endereco endereco) {
        return enderecoService.salvar(endereco);
    }

    @GetMapping
    public List<Endereco> listar() {
        return enderecoService.listar();
    }

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable Long id) {
        return enderecoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletarEndereco(@PathVariable Long id) {
        return enderecoService.deletar(id);
    }

    @PutMapping("/{id}")
    public Endereco atualizarEndereco(@RequestBody Endereco endereco, @PathVariable Long id) {
        return enderecoService.atualizar(endereco, id);
    }

    @GetMapping("/")
    public List<Endereco> buscarPorCEP(@RequestParam String cep) {
        return enderecoService.encontrarPorCEP(cep);
    }
}
