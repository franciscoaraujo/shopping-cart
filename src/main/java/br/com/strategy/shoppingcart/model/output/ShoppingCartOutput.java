package br.com.strategy.shoppingcart.model.output;

import br.com.strategy.shoppingcart.model.dto.ItemDTO;
import br.com.strategy.shoppingcart.model.dto.ShoppingCartDTO;
import br.com.strategy.shoppingcart.model.entity.ShoppingCartEntity;

public class ShoppingCartOutput {

    private ShoppingCartOutput() {
    }

    public static ShoppingCartDTO toDTO(ShoppingCartEntity cartEntity){
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        cartEntity.getListItemEntities().forEach(t->{
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setPrice(t.getPrice());
            itemDTO.setIdItem(t.getIdItem());
            shoppingCartDTO.setDataCriacao(cartEntity.getDataCriacao());
            shoppingCartDTO.getItensDTO().add(itemDTO);
        });

        return shoppingCartDTO;
    }
}
