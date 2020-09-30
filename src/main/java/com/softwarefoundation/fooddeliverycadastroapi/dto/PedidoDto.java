package com.softwarefoundation.fooddeliverycadastroapi.dto;


import com.softwarefoundation.fooddeliverycadastroapi.entity.Cliente;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PedidoDto {

    private Long clientId;

    public static PedidoDto from(Cliente cliente){
        PedidoDto dto = new PedidoDto();
        dto.setClientId(cliente.getId());
        return dto;
    }
}
