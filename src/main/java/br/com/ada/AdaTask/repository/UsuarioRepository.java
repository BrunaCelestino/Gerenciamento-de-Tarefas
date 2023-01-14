package br.com.ada.AdaTask.repository;
import br.com.ada.AdaTask.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
