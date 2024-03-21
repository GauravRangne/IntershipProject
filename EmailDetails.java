package com.boot.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
 
    // Class data members
    private String recipient;
    private String msgBody;
    private String subject;
}