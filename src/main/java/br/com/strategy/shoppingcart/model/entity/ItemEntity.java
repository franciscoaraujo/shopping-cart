package br.com.strategy.shoppingcart.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemEntity {
    private BigInteger idItem;
    private BigDecimal price;

}
