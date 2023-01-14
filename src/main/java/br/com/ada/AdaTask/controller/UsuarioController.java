package br.com.ada.AdaTask.controller;

import br.com.ada.AdaTask.model.Usuario;
import br.com.ada.AdaTask.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping("/usuarios")
    public List<Usuario> buscarPorNomeOuUsuario(@RequestParam String nome) {
        return usuarioService.encontrarPorNomeOuUsuario(nome);
    }

    @DeleteMapping("/usuarios/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        return usuarioService.deletar(id);
    }

    @PutMapping("/usuarios/{id}")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
        return usuarioService.atualizar(usuario, id);
    }

}
