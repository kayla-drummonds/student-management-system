package com.sms.springboot.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.sms.springboot.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
