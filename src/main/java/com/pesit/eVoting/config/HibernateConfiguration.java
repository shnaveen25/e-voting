package com.pesit.eVoting.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This class is used for configuration of hibernate with mysql database
 * 
 * @author 
 * 
 */

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	@Value("#{evotingDataSource}")
	private DataSource evotingDataSource;

	/**
	 * This method sets the mysql hibernate properties and scan the package for
	 * model classes
	 * 
	 * @return session factory after setting hibernate properties
	 * 
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		Properties props = new Properties();
		props.put("hibernate.dialect", MySQLDialect.class.getName());
		//props.put("hibernate.format_sql", "true");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory
				.setPackagesToScan(new String[] { "com.pesit.eVoting" });
		sessionFactory.setHibernateProperties(props);
		sessionFactory.setDataSource(this.evotingDataSource);
		return sessionFactory;
	}

	/**
	 * This configuration is required as we are using @transactional in the
	 * spring hibernate instead of using transaction manager to start and end
	 * the transaction
	 * 
	 * @return hibernate transaction manager
	 */
	@Bean
	public HibernateTransactionManager transactionManager() {
		return new HibernateTransactionManager(sessionFactoryBean().getObject());
	}

}
