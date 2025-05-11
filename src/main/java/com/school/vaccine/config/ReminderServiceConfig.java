package com.school.vaccine.config;

import lombok.Data;
import java.util.Map;

@Data
public class ReminderServiceConfig {
    private String scheme;
    private String host;
    private int port;
    private Map<String, String> endpoint;
}