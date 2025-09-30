package com.umc_study.mission_server.store.entity;

import jakarta.persistence.*;
import com.umc_study.mission_server.member.entity.MemberFoodType;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "food_type")
public class FoodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_for_user", length = 64, nullable = false)
    private String nameForUser;

    @Column(name = "name_for_store", length = 64, nullable = false)
    private String nameForStore;

    @OneToMany(mappedBy = "foodType")
    @Builder.Default
    private Set<MemberFoodType> preferredByMembers = new HashSet<>();
}
