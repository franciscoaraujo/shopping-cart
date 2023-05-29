package br.com.strategy.shoppingcart.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Log4j2
public class PaypalEntity {

    private String email;
    private String passWord;

}
