package com.bitc.bbs.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("/classpath:/application.propertices")
public class DatabaseConfiguraion {

	@Autowired
	private ApplicationContext appContext;
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSouce() throws Exception {
		DataSource ds = new HikariDataSource(hikariConfig());
		return ds;
	}
	
	@Bean
	public SqlSessionFactory sqlSessFac(DataSource ds) throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(ds);
		ssfb.setMapperLocations(appContext.getResources("classpath:/sql/**/sql-*.xml"));
		ssfb.setConfiguration(mybatisConfig());
		
		return ssfb.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlsessTemp(SqlSessionFactory ssf) {
		return new SqlSessionTemplate(ssf);
	}
	
	@Bean
	@ConfigurationProperties(prefix="mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig() {
		return new org.apache.ibatis.session.Configuration();
	}
}
