package com.softwarefoundation.fooddeliverycadastroapi.dto;

import com.softwarefoundation.fooddeliverycadastroapi.entity.Cliente;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientePedidoDto {

    private String nome;
    private Long clienteId;


    public static ClientePedidoDto from(Cliente cliente){
        ClientePedidoDto dto = new ClientePedidoDto();
        dto.setClienteId(cliente.getId());
        dto.setNome(cliente.getNome());
        return dto;
    }

}
