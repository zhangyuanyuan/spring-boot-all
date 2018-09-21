package com.kg.springboot.springbootweb.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource({
        "classpath:config/db.properties"
})
public class DbConfig {

    @Autowired
    private Environment env;

    @Bean(name = "oneDataSource")
    @Qualifier("oneDataSource")
    @Primary
    public DataSource oneDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("source.db1.driverClassName").trim());
        dataSource.setUrl(env.getProperty("source.db1.url").trim());
        dataSource.setUsername(env.getProperty("source.db1.username").trim());
        dataSource.setPassword(env.getProperty("source.db1.password").trim());
        return dataSource;
    }

    @Bean(name = "twoDataSource")
    @Qualifier("twoDataSource")
    public DataSource twoDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("source.db2.driverClassName").trim());
        dataSource.setUrl(env.getProperty("source.db2.url").trim());
        dataSource.setUsername(env.getProperty("source.db2.username").trim());
        dataSource.setPassword(env.getProperty("source.db2.password").trim());
        return dataSource;
    }

    @Bean(name = "oneJdbcTemplate")
    public JdbcTemplate oneJdbcTemplate(@Qualifier("oneDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "twoJdbcTemplate")
    public JdbcTemplate twoJdbcTemplate(@Qualifier("twoDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
