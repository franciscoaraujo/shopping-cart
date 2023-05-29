package br.com.strategy.shoppingcart.service;

import java.math.BigDecimal;

public interface PaymentStrategy {

    void pay(BigDecimal amount);
}
