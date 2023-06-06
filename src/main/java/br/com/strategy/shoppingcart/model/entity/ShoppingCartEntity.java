package br.com.strategy.shoppingcart.model.entity;

import br.com.strategy.shoppingcart.service.PaymentStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartEntity {

    private UUID codShoppingCart = UUID.randomUUID();

    private List<ItemEntity> listItemEntities = new ArrayList<>();
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public void addItem(ItemEntity itemEntity) {
        listItemEntities.add(itemEntity);
    }

    public void removeItem(ItemEntity itemEntity) {
        listItemEntities.remove(itemEntity);
    }


    public void shoppingCartPay(PaymentStrategy paymentMethod) {
        BigDecimal amount = calculateTotal();
        paymentMethod.pay(amount);
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = new BigDecimal(0.0);
        total = listItemEntities.stream()
                .map(ItemEntity::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }
}
