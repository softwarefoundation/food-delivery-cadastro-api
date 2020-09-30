package com.softwarefoundation.fooddeliverycadastroapi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuDto {

    private Long id;
    private String nome;
    private Double preco;
    private Long restauranteId;

}
