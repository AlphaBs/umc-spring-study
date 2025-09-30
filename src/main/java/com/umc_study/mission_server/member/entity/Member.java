package com.umc_study.mission_server.member.entity;

import com.umc_study.mission_server.common.entity.BaseEntity;
import com.umc_study.mission_server.store.entity.FoodType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "provider_id", length = 64)
    private String providerId;

    @Column(name = "provider_type", length = 64)
    private String providerType;

    @Column(name = "agree_tos")
    private LocalDateTime agreeTos;

    @Column(name = "agree_privacy")
    private LocalDateTime agreePrivacy;

    @Column(name = "agree_gps")
    private LocalDateTime agreeGps;

    @Column(name = "agree_marketing")
    private LocalDateTime agreeMarketing;

    @Column(length = 16)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private MemberSex sex;

    @Column
    private LocalDate birthday;

    @Column(length = 256)
    private String address1;

    @Column(length = 256)
    private String address2;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(length = 64)
    private String nickname;

    @Column(length = 256)
    private String email;

    @Column(name = "phone_number", length = 32)
    private String phoneNumber;

    @Column(name = "is_verified_phone_number")
    private Boolean verifiedPhoneNumber;

    @Column(name = "notification_new_event")
    private Boolean notificationNewEvent;

    @Column(name = "notification_review_reply")
    private Boolean notificationReviewReply;

    @Column(name = "notification_ask_reply")
    private Boolean notificationAskReply;

    @Column(name = "current_point")
    private Long currentPoint;

    @Column(name = "Field", length = 255)
    private String field;

    @ManyToMany
    @JoinTable(
            name = "member_prefer_food_type",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "food_type_id")
    )
    @Builder.Default
    private Set<FoodType> preferFoodTypes = new HashSet<>();
}
