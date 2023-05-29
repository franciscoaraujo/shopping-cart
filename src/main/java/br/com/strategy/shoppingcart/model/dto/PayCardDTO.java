package br.com.strategy.shoppingcart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayCardDTO {

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;
}
