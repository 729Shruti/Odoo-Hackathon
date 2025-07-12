package com.shruti.SkilSwap.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SwapRequest {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private User requester;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private String status; // PENDING, ACCEPTED, REJECTED, CANCELLED

    private String offeredSkill;
    private String requestedSkill;

    private LocalDateTime timestamp;

    public SwapRequest() {
    }
}
