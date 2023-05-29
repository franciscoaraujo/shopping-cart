package br.com.strategy.shoppingcart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayPaypalDTO {

    private String emailId;
    private String password;

}
