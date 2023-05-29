package br.com.strategy.shoppingcart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private BigInteger idItem;
    private BigDecimal price;
}
