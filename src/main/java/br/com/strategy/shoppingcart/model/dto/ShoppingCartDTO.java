package br.com.strategy.shoppingcart.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartDTO {

    private UUID codShoppingCart;

    private List<ItemDTO> itensDTO = new ArrayList<>();

    private LocalDateTime dataCriacao;


}
