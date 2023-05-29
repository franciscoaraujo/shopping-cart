package br.com.strategy.shoppingcart.api.v1.controller;

import br.com.strategy.shoppingcart.model.Message;
import br.com.strategy.shoppingcart.model.dto.PayCardDTO;
import br.com.strategy.shoppingcart.model.dto.PayPaypalDTO;
import br.com.strategy.shoppingcart.model.dto.ShoppingCartDTO;
import br.com.strategy.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/V1/shoppingcart", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping(value = "addcart")
    public ResponseEntity<Message> addShoppingCart(@RequestBody ShoppingCartDTO shoppingCartDTO){

        Message message = shoppingCartService.addShoppingCart(shoppingCartDTO);

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @PostMapping(value = "payment/card")
    public ResponseEntity<Message> payWithCad(@RequestBody PayCardDTO payCardDTO){

        Message message =shoppingCartService.payWithCard(payCardDTO);

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }


    @PostMapping(value = "payment/paypal")
    public ResponseEntity<Message> payWithPaypal(@RequestBody PayPaypalDTO paypalDTO){

        Message message =shoppingCartService.payWithPaypal(paypalDTO);

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }


}
