package com.dmadev.kafka.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class ErrorMessage {
    private Date timestamp;
    private String message;
}
