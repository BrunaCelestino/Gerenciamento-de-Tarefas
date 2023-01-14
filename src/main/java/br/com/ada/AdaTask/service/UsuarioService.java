package br.com.ada.AdaTask.service;

import br.com.ada.AdaTask.model.Usuario;
import br.com.ada.AdaTask.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public String deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario != null) {
            usuarioRepository.delete(usuario);
            return "Usuário: " + usuario.getNomeCompleto()  + ", deletado com sucesso!";
        } else {
            return "Usuário não encontrado!";
        }
    }
    public Usuario atualizar(Usuario usuario, Long id){
        Usuario usuarioFound = usuarioRepository.findById(id).orElseThrow(IllegalArgumentException::new);


        usuarioFound.setUsername(usuario.getUsername());
        usuarioFound.setSenha(usuario.getSenha());
        usuarioFound.setEmail(usuario.getEmail());
        usuarioFound.setNomeCompleto(usuario.getNomeCompleto());
        usuarioFound.setDataDeNascimento(usuario.getDataDeNascimento());
        usuarioFound.setGenero(usuario.getGenero());
        usuarioFound.setTelefone(usuario.getTelefone());


        usuarioRepository.save(usuarioFound);

        return usuarioFound;
    }

    public List<Usuario> encontrarPorNomeOuUsuario(String filtro) {
        return (List<Usuario>) usuarioRepository.findByNomeCompletoOrUsernameContainingIgnoreCase(filtro);
    }
}
