package com.umc_study.mission_server.member.entity;

import com.umc_study.mission_server.store.entity.FoodType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "member_prefer_food_type")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberFoodType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "food_type_id", nullable = false)
    private FoodType foodType;
}
