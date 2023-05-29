package br.com.strategy.shoppingcart.model.input;

import br.com.strategy.shoppingcart.model.dto.ShoppingCartDTO;
import br.com.strategy.shoppingcart.model.entity.ItemEntity;
import br.com.strategy.shoppingcart.model.entity.ShoppingCartEntity;



public class ShoppingCartInput {

    private ShoppingCartInput(){
    }

    public static ShoppingCartEntity toEntity(ShoppingCartDTO cartDTO){
        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        cartDTO.getItensDTO().forEach( t->{
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setIdItem(t.getIdItem());
            itemEntity.setPrice(t.getPrice());
            shoppingCartEntity.getListItemEntities().add(itemEntity);
        });
        return shoppingCartEntity;
    }
}
