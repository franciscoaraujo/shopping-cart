package br.com.strategy.shoppingcart.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayCardEntity {

    private String name;
    private String cardNumber;

    private String dateOfExpiry;

    private LocalDateTime payDate;
}
