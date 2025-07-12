package com.shruti.SkilSwap.controller;

import com.shruti.SkilSwap.dto.CreateSwapRequestDto;
import com.shruti.SkilSwap.dto.SwapRequestDto;
import com.shruti.SkilSwap.service.SwapRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/swaps")
public class SwapRequestController {

    @Autowired
    private SwapRequestService swapService;

    // Simulating logged-in userId passed as a request param for now
    @PostMapping("/send")
    public String sendSwap(@RequestParam Long requesterId, @RequestBody CreateSwapRequestDto dto) {
        return swapService.sendSwapRequest(requesterId, dto.getReceiverId());
    }

    @PutMapping("/accept/{requestId}")
    public String acceptSwap(@PathVariable Long requestId, @RequestParam Long userId) {
        return swapService.acceptSwapRequest(requestId, userId);
    }

    @PutMapping("/reject/{requestId}")
    public String rejectSwap(@PathVariable Long requestId, @RequestParam Long userId) {
        return swapService.rejectSwapRequest(requestId, userId);
    }

    @DeleteMapping("/cancel/{requestId}")
    public String cancelSwap(@PathVariable Long requestId, @RequestParam Long userId) {
        return swapService.cancelSwapRequest(requestId, userId);
    }

    @GetMapping("/sent")
    public List<SwapRequestDto> sentSwaps(@RequestParam Long userId) {
        return swapService.getSentRequests(userId);
    }

    @GetMapping("/received")
    public List<SwapRequestDto> receivedSwaps(@RequestParam Long userId) {
        return swapService.getReceivedRequests(userId);
    }
}
