package com.team10.banchan.service;

import com.team10.banchan.dto.ItemDetailResponse;
import com.team10.banchan.dto.OrderInfo;
import com.team10.banchan.exception.NotFoundException;
import com.team10.banchan.model.Item;
import com.team10.banchan.model.Order;
import com.team10.banchan.repository.ItemRepository;
import com.team10.banchan.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemDetailService {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    public ItemDetailService(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderInfo order(Long itemId, Integer quantity) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new NotFoundException("존재하지 않는 반찬입니다."));
        itemRepository.save(item.order(quantity));
        Order order = orderRepository.save(Order.newOrder(itemId, quantity));
        return OrderInfo.of(order, item);
    }

    public ItemDetailResponse itemDetail(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new NotFoundException("존재하지 않는 반찬입니다."));
        return ItemDetailResponse.of(itemId, item.itemDetail());
    }

    public List<ItemDetailResponse> itemDetails() {
        return itemRepository.findAll().stream()
                .map(item -> ItemDetailResponse.of(item.getId(), item.itemDetail()))
                .collect(Collectors.toList());
    }
}
