package com.team10.banchan.controller;

import com.team10.banchan.dto.ItemDetailResponse;
import com.team10.banchan.dto.OrderInfo;
import com.team10.banchan.dto.OrderRequest;
import com.team10.banchan.model.Order;
import com.team10.banchan.response.ResponseBody;
import com.team10.banchan.service.ItemDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detail")
public class ItemDetailController {

    private final ItemDetailService itemDetailService;

    public ItemDetailController(ItemDetailService itemDetailService) {
        this.itemDetailService = itemDetailService;
    }

    @GetMapping("/{itemId}")
    public ItemDetailResponse itemDetail(@PathVariable Long itemId) {
        return itemDetailService.itemDetail(itemId);
    }

    @GetMapping
    public ResponseBody<List<ItemDetailResponse>> itemDetails() {
        return ResponseBody.ok(itemDetailService.itemDetails());
    }

    @PostMapping("/{itemId}/order")
    public ResponseBody<OrderInfo> order(@PathVariable Long itemId, @RequestBody OrderRequest orderRequest) {
        return ResponseBody.ok(itemDetailService.order(itemId, orderRequest.getQuantity()));
    }
}
