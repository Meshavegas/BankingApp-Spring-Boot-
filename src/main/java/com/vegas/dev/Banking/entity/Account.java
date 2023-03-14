package com.vegas.dev.Banking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.mapping.Set;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne( optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties(
            value = {
                    "password","createdAt","updateAt","createdBy","updatedBy","email","role","enabled"
                    ,"accountNonExpired","credentialsNonExpired","accountNonLocked","authorities"
            }, allowSetters = true
    )
    private Users users;
    @Column(name = "accountNumber", length = 255, nullable = false)
    private String accountNumber;
    @Column(name = "balance" )
    private double balance;
    @Column(name = "currency",length = 255)
    private String currency;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;
    @Column(name = "createdBy", length = 255)
    private String createdBy;
    @Column(name = "updatedBy", length = 255)
    private String updatedBy;
}
