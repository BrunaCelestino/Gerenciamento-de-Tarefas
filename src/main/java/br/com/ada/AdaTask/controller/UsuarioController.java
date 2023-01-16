package br.com.ada.AdaTask.controller;

import br.com.ada.AdaTask.model.Usuario;
import br.com.ada.AdaTask.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
         this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping("/")
    public List<Usuario> buscarPorNome(@RequestParam String nome) {
        return usuarioService.encontrarPorNome(nome);
    }

    @DeleteMapping("/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        return usuarioService.deletar(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
        return usuarioService.atualizar(usuario, id);
    }

}
