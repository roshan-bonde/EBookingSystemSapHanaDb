package com.roshan.EBookingSystem.Config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:sap://a2b43b21-d07a-4f51-bccc-426c6208c476.hana.trial-us10.hanacloud.ondemand.com:443/?autocommit=false")
                .username("dbadmin")
                .password("Ebooking-hana-db-0@#%%")
                .driverClassName("com.sap.cloud.db.jdbc.Driver")
                .build();
    }
}

