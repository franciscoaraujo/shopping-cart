package br.com.strategy.shoppingcart.service;

import br.com.strategy.shoppingcart.model.dto.PayCardDTO;
import br.com.strategy.shoppingcart.model.dto.PayPaypalDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Log4j2
public class ValidatorPaymentService {

    public String validationDataCardCredit(PayCardDTO payCardDTO, BigDecimal totalValue){
        log.info("iniciando a validacao dos dados de certao e saldo");
        return String.valueOf(UUID.randomUUID());
    }

    public String validationDataPaypal(PayPaypalDTO paypalDT, BigDecimal totalValue){
        log.info("iniciando a validacao dos dados de Paylpal e saldo");
        return String.valueOf(UUID.randomUUID());
    }

}
