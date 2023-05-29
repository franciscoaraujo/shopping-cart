package br.com.strategy.shoppingcart.service;

import br.com.strategy.shoppingcart.model.Message;
import br.com.strategy.shoppingcart.model.dto.PayCardDTO;
import br.com.strategy.shoppingcart.model.dto.PayPaypalDTO;
import br.com.strategy.shoppingcart.model.dto.ShoppingCartDTO;
import br.com.strategy.shoppingcart.model.entity.ShoppingCartEntity;
import br.com.strategy.shoppingcart.model.input.PayCardInput;
import br.com.strategy.shoppingcart.model.input.ShoppingCartInput;
import br.com.strategy.shoppingcart.model.output.ShoppingCartOutput;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ShoppingCartService {

    public Message addShoppingCart(ShoppingCartDTO shoppingCartDTO) {

        ShoppingCartEntity shoppingCartEntity = ShoppingCartInput.toEntity(shoppingCartDTO);
        log.info("Persistindo : " + shoppingCartEntity);

        ShoppingCartDTO shoppingCartDTO1 = ShoppingCartOutput.toDTO(shoppingCartEntity);
        log.info("Recuperando : " + shoppingCartDTO1);

        return new Message("002", "Incluido com sucesso");
    }

    public Message payWithCard(PayCardDTO payCardDTO) {
        PayCardInput.toEntity(payCardDTO);
        return new Message("004", "Processando pagamento...");
    }

    public Message payWithPaypal(PayPaypalDTO paypalDTO) {
        return new Message("004", "Processando pagamento...");
    }
}
