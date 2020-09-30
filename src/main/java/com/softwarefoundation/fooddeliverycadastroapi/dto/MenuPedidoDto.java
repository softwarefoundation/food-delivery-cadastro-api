package com.softwarefoundation.fooddeliverycadastroapi.dto;

import com.softwarefoundation.fooddeliverycadastroapi.entity.Menu;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuPedidoDto {

    private Long menuId;
    private Long restauranreId;
    private String nome;

    public static MenuPedidoDto from(final Menu menu){
        MenuPedidoDto dto = new MenuPedidoDto();
        dto.setMenuId(menu.getId());
        dto.setRestauranreId(menu.getRestaurante().getId());
        dto.setNome(menu.getNome());
        return dto;
    }

}
