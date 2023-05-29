package br.com.strategy.shoppingcart.model.input;

import br.com.strategy.shoppingcart.model.dto.PayCardDTO;
import br.com.strategy.shoppingcart.model.entity.PayCardEntity;

import java.time.LocalDateTime;

public class PayCardInput {

    public static PayCardEntity toEntity(PayCardDTO payCardDTO){

        PayCardEntity payCardEntity = new PayCardEntity();

        payCardEntity.setCardNumber(payCardDTO.getCardNumber());
        payCardEntity.setPayDate(LocalDateTime.now());
        payCardEntity.setName(payCardEntity.getName());

        return  payCardEntity;
    }
}
