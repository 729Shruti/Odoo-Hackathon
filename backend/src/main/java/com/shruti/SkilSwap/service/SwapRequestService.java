package com.shruti.SkilSwap.service;


import com.shruti.SkilSwap.dto.SwapRequestDto;
import com.shruti.SkilSwap.entities.SwapRequest;
import com.shruti.SkilSwap.entities.User;
import com.shruti.SkilSwap.enums.SwapStatus;
import com.shruti.SkilSwap.repository.SwapRequestRepository;
import com.shruti.SkilSwap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SwapRequestService {

    @Autowired
    private SwapRequestRepository swapRequestRepo;

    @Autowired
    private UserRepository userRepo;

    public String sendSwapRequest(Long requesterId, Long receiverId) {
        if (requesterId.equals(receiverId)) return "Cannot request yourself";

        User requester = userRepo.findById(requesterId)
                .orElseThrow(() -> new RuntimeException("Requester not found"));
        User receiver = userRepo.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        boolean exists = swapRequestRepo.existsByRequesterAndReceiverAndStatus(
                requester, receiver, SwapStatus.PENDING);
        if (exists) return "Pending request already exists";

        SwapRequest request = new SwapRequest();
        request.setRequester(requester);
        request.setReceiver(receiver);
        request.setStatus(SwapStatus.PENDING);

        swapRequestRepo.save(request);
        return "Swap request sent";
    }

    public String acceptSwapRequest(Long requestId, Long userId) {
        SwapRequest request = getValidRequest(requestId);
        if (!request.getReceiver().getId().equals(userId))
            return "Not authorized to accept this request";

        request.setStatus(SwapStatus.ACCEPTED);
        swapRequestRepo.save(request);
        return "Swap request accepted";
    }

    public String rejectSwapRequest(Long requestId, Long userId) {
        SwapRequest request = getValidRequest(requestId);
        if (!request.getReceiver().getId().equals(userId))
            return "Not authorized to reject this request";

        request.setStatus(SwapStatus.REJECTED);
        swapRequestRepo.save(request);
        return "Swap request rejected";
    }

    public String cancelSwapRequest(Long requestId, Long userId) {
        SwapRequest request = getValidRequest(requestId);
        if (!request.getRequester().getId().equals(userId))
            return "Not authorized to cancel this request";

        request.setStatus(SwapStatus.CANCELLED);
        swapRequestRepo.save(request);
        return "Swap request cancelled";
    }

    public List<SwapRequestDto> getSentRequests(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return swapRequestRepo.findByRequester(user).stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<SwapRequestDto> getReceivedRequests(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return swapRequestRepo.findByReceiver(user).stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    private SwapRequest getValidRequest(Long id) {
        return swapRequestRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Swap request not found"));
    }

    private SwapRequestDto convertToDTO(SwapRequest swap) {
        SwapRequestDto dto = new SwapRequestDto();
        dto.setId(swap.getId());
        dto.setRequesterId(swap.getRequester().getId());
        dto.setRequesterName(swap.getRequester().getName());
        dto.setReceiverId(swap.getReceiver().getId());
        dto.setReceiverName(swap.getReceiver().getName());
        dto.setStatus(swap.getStatus());
        dto.setCreatedAt(swap.getCreatedAt());
        return dto;
    }
}

