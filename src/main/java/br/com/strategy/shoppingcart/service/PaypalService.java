package br.com.strategy.shoppingcart.service;

import br.com.strategy.shoppingcart.model.entity.PaypalEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Log4j2
@Service
public class PaypalService implements PaymentStrategy {

    private PaypalEntity paypalEntity;
    @Override
    public void pay(BigDecimal amount) {
        paypalEntity = new PaypalEntity();

        log.info("Email cadastrato: "+ paypalEntity.getEmail());

        log.info(amount + " paid using Paypal.");
    }
}
