package com.umc_study.mission_server.point.entity;

import com.umc_study.mission_server.common.entity.BaseEntity;
import com.umc_study.mission_server.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "withdrawal_request")
public class WithdrawalRequest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private WithdrawalRequestState state;

    @Column(name = "abs_point")
    private Long absPoint;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

}
