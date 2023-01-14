package br.com.ada.AdaTask.repository;
import br.com.ada.AdaTask.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findByNomeCompletoOrUsernameContainingIgnoreCase(String filtro);
}
