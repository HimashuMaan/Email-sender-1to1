package com.email.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailResponse {
    private String from;
    private List<String> to;
    private String subject;
    private String text;
}
