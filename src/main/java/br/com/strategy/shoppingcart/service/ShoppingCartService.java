package br.com.strategy.shoppingcart.service;

import br.com.strategy.shoppingcart.model.Message;
import br.com.strategy.shoppingcart.model.dto.PayCardDTO;
import br.com.strategy.shoppingcart.model.dto.PayPaypalDTO;
import br.com.strategy.shoppingcart.model.dto.ShoppingCartDTO;
import br.com.strategy.shoppingcart.model.entity.ItemEntity;
import br.com.strategy.shoppingcart.model.entity.PayCardEntity;
import br.com.strategy.shoppingcart.model.entity.ShoppingCartEntity;
import br.com.strategy.shoppingcart.model.exceptions.ShoppingCartException;
import br.com.strategy.shoppingcart.model.input.PayCardInput;
import br.com.strategy.shoppingcart.model.input.ShoppingCartInput;
import br.com.strategy.shoppingcart.model.output.ShoppingCartOutput;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Log4j2
public class ShoppingCartService {

    @Autowired
    private CreditCartService creditCartService;
    @Autowired
    private PaypalService paypalService;
    @Autowired
    private ValidatorPaymentService validatorPaymentService;

    private ShoppingCartEntity shoppingCartEntity;

    public Message addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartEntity = ShoppingCartInput.toEntity(shoppingCartDTO);
        log.info("Persistindo o carrinho de compras no banco de dados : " + shoppingCartEntity);
        return new Message("002", "Incluido com sucesso");
    }

    public Message payWithCard(PayCardDTO payCardDTO) throws ShoppingCartException {
        if (Objects.nonNull(shoppingCartEntity)
                && !shoppingCartEntity.getListItemEntities().isEmpty()) {
            BigDecimal totalValue = shoppingCartEntity.calculateTotal();

            String codValidation = validatorPaymentService.validationDataCardCredit(payCardDTO, totalValue);

            if (!codValidation.equals("E001")) {
                log.info("Total da campra: " + totalValue);
                creditCartService.pay(totalValue);
                log.info("Usuario cadastrado: " + payCardDTO.getName());
            }
        } else {
            return new Message("E099", "Carrinho vazio...");
        }
        return new Message("S004", "Processando pagamento...");
    }

    public Message payWithPaypal(PayPaypalDTO paypalDTO) throws ShoppingCartException {
        if (Objects.nonNull(shoppingCartEntity)
                && !shoppingCartEntity.getListItemEntities().isEmpty()) {
            BigDecimal totalValue = shoppingCartEntity.calculateTotal();
            String codValidation = validatorPaymentService.validationDataPaypal(paypalDTO, totalValue);
            if (!codValidation.equals("E001")) {
                log.info("Total da campra: " + totalValue);
                paypalService.pay(totalValue);
                log.info("Email cadastrado: " + paypalDTO.getEmailId());
            }
        } else {
            return new Message("E099", "Carrinho vazio...");
        }
        return new Message("S004", "Processando pagamento...");
    }
}
