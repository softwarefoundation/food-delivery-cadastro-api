package com.softwarefoundation.fooddeliverycadastroapi.entity;

import com.softwarefoundation.fooddeliverycadastroapi.dto.ClienteDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "TB01_CLIENTE")
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    public static Cliente from(ClienteDto dto){
        Cliente cliente = new ModelMapper().map(dto, Cliente.class);
        return cliente;
    }

}
