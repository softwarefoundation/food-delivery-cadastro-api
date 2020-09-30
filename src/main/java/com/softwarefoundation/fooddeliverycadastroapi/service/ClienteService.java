package com.softwarefoundation.fooddeliverycadastroapi.service;

import com.softwarefoundation.fooddeliverycadastroapi.dto.ClientePedidoDto;
import com.softwarefoundation.fooddeliverycadastroapi.entity.Cliente;
import com.softwarefoundation.fooddeliverycadastroapi.mensagens.ClienteSendMessage;
import com.softwarefoundation.fooddeliverycadastroapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteSendMessage clientSendMessage;


    public Cliente pesquisarPorId(final Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.isPresent() ? cliente.get() : null;
    }

    public Cliente salvar(Cliente cliente) {
        Cliente cl = clienteRepository.save(cliente);
        clientSendMessage.sendMessage(ClientePedidoDto.from(cl));
        return cl;
    }

    public Cliente atualizar(Cliente cliente) {
        Optional<Cliente> optional = clienteRepository.findById(cliente.getId());

        if (optional.isPresent()) {
            return clienteRepository.save(cliente);
        } else {
            return null;
        }
    }

    public boolean excluir(Long id) {
        try {

            Optional<Cliente> cliente = clienteRepository.findById(id);
            if (cliente.isPresent()) {
                clienteRepository.delete(cliente.get());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

}
