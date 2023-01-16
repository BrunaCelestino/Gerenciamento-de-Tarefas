package br.com.ada.AdaTask.service;


import br.com.ada.AdaTask.model.Endereco;
import br.com.ada.AdaTask.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listar() {
        return (List<Endereco>) enderecoRepository.findAll();
    }

    public Endereco buscarPorId(Long id) {
        return enderecoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public String deletar(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElse(null);

        if (endereco != null) {
            enderecoRepository.delete(endereco);
            return "Endereço: " + endereco.getLogradouro()  + ", " +
                                endereco.getNumero() + ", " +
                                endereco.getBairro() +  ", " +
                                endereco.getCep() +  ", " +
                                endereco.getCidade() +  ", " +
                                endereco.getEstado() +  ", " +
                                " deletado com sucesso!";
        } else {
            return "Endereço não encontrado!";
        }
    }
    public Endereco atualizar(Endereco endereco, Long id){
        Endereco enderecoFound = enderecoRepository.findById(id).orElseThrow(IllegalArgumentException::new);


        enderecoFound.setLogradouro(endereco.getLogradouro());
        enderecoFound.setNumero(endereco.getNumero());
        enderecoFound.setBairro(endereco.getBairro());
        enderecoFound.setCep(endereco.getCep());
        enderecoFound.setCidade(endereco.getCidade());
        enderecoFound.setEstado(endereco.getEstado());

        enderecoRepository.save(enderecoFound);

        return enderecoFound;
    }
    public List<Endereco> encontrarPorCEP(String filtro) {
        return (List<Endereco>) enderecoRepository.findByCepContainingIgnoreCase(filtro);
    }
}
