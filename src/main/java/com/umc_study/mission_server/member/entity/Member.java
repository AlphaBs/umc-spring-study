package com.umc_study.mission_server.member.entity;

import com.umc_study.mission_server.common.entity.BaseEntity;
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

    @Column(name = "provider_id", length = 64, nullable = false)
    private String providerId;

    @Column(name = "provider_type", length = 64, nullable = false)
    private String providerType;

    @Column(name = "agree_tos", nullable = true)
    private LocalDateTime agreeTos;

    @Column(name = "agree_privacy", nullable = true)
    private LocalDateTime agreePrivacy;

    @Column(name = "agree_gps", nullable = true)
    private LocalDateTime agreeGps;

    @Column(name = "agree_marketing", nullable = true)
    private LocalDateTime agreeMarketing;

    @Column(length = 16, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = true)
    private MemberGender sex;

    @Column(nullable = true)
    private LocalDate birthday;

    @Column(length = 256, nullable = true)
    private String address1;

    @Column(length = 256, nullable = true)
    private String address2;

    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;

    @Column(name = "last_login", nullable = true)
    private LocalDateTime lastLogin;

    @Column(length = 64, nullable = true)
    private String nickname;

    @Column(length = 256, nullable = true)
    private String email;

    @Column(name = "phone_number", length = 32, nullable = true)
    private String phoneNumber;

    @Column(name = "is_verified_phone_number", nullable = true)
    private Boolean verifiedPhoneNumber;

    @Column(name = "notification_new_event", nullable = true)
    private Boolean notificationNewEvent;

    @Column(name = "notification_review_reply", nullable = true)
    private Boolean notificationReviewReply;

    @Column(name = "notification_ask_reply", nullable = true)
    private Boolean notificationAskReply;

    @Column(name = "current_point", nullable = true)
    private Long currentPoint;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<MemberFoodType> preferFoodTypes = new HashSet<>();
}
