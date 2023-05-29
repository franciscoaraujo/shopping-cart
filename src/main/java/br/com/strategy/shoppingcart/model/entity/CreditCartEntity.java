package br.com.strategy.shoppingcart.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Log4j2
public class CreditCartEntity {
    private BigInteger id;
    private String name;
    private String cardNumber;
    private String cvv;
    private String dataOfExpricy;

}
