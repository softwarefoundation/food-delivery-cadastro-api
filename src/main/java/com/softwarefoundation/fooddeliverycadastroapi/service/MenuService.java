package com.softwarefoundation.fooddeliverycadastroapi.service;

import com.softwarefoundation.fooddeliverycadastroapi.dto.MenuPedidoDto;
import com.softwarefoundation.fooddeliverycadastroapi.entity.Menu;
import com.softwarefoundation.fooddeliverycadastroapi.entity.Restaurante;
import com.softwarefoundation.fooddeliverycadastroapi.mensagens.MenuSendMessage;
import com.softwarefoundation.fooddeliverycadastroapi.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class MenuService {


    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuSendMessage menuSendMessage;

    @Autowired
    private RestauranteService restauranteService;

    public Menu pesquisarPorId(final Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        return menu.isPresent() ? menu.get() : null;
    }

    public Menu salvar(Menu menu) {
        Menu m = menuRepository.save(menu);
        Restaurante restaurante = restauranteService.pesquisarPorId(menu.getRestaurante().getId());
        if (Objects.nonNull(restaurante)) {
            menuSendMessage.sendMessage(MenuPedidoDto.from(menu));
        }
        return m;
    }

    public Menu atualizar(Menu menu) {
        Optional<Menu> optional = menuRepository.findById(menu.getId());

        if (optional.isPresent()) {
            return menuRepository.save(menu);
        } else {
            return null;
        }
    }

    public boolean excluir(Long id) {
        try {

            Optional<Menu> restaurante = menuRepository.findById(id);
            if (restaurante.isPresent()) {
                menuRepository.delete(restaurante.get());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

}
