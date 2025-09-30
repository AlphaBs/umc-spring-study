package com.umc_study.mission_server.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256)
    private String name;

    @Column(length = 256)
    private String address1;

    @Column(length = 256)
    private String address2;

    @Lob
    @Column(name = "operating_table", columnDefinition = "TEXT")
    private String operatingTable;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "food_type_id")
    private FoodType foodType;
}
