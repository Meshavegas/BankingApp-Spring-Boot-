package com.vegas.dev.Banking.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "journal")
public class AccountingJournal {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties(
            value = {
                    "users","accountNumber","currency","createdBy","updatedBy",
            }, allowSetters = true
    )
    private Account account;
    @Column(name = "direction", length = 255 )
    private String direction;
    @Column(name = "amount", length = 255)
    private double amount;
    @Column(name = "lastBalance", length = 255)
    private double lastBalance;
    @Column(name = "newBalance", length = 255 )
    private double newBalance;
    @Column(name = "creaedAt", length = 255 )
    private Timestamp creaedAt;
    @Column(name = "updateAt", length = 255 )
    private Timestamp updateAt;
    @Column(name = "createBy", length = 255 )
    private String createBy;
    @Column(name = "updateBy", length = 255)
    private String updateBy;

}
