package com.shruti.SkilSwap.repository;



import com.shruti.SkilSwap.entities.SwapRequest;
import com.shruti.SkilSwap.entities.User;
import com.shruti.SkilSwap.enums.SwapStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SwapRequestRepository extends JpaRepository<SwapRequest, Long> {

    List<SwapRequest> findByRequester(User requester);

    List<SwapRequest> findByReceiver(User receiver);

    boolean existsByRequesterAndReceiverAndStatus(User requester, User receiver, SwapStatus status);
}

