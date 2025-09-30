package com.umc_study.mission_server.mission.entity;

import com.umc_study.mission_server.member.entity.Member;
import com.umc_study.mission_server.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long point;

    @Column(nullable = true)
    private Long money;

    @Column(nullable = true)
    private LocalDateTime due;

    @Enumerated(EnumType.STRING)
    @Column(length = 8, nullable = false)
    private MissionState state;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}
