package com.vegas.dev.Banking.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JournalRequest {
    private Integer account_id;
    private double amount;
    private String createBy;
}
