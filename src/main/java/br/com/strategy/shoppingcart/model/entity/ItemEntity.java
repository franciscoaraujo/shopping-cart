package br.com.strategy.shoppingcart.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemEntity implements Serializable {
    private BigInteger idItem;
    private BigDecimal price;

}
