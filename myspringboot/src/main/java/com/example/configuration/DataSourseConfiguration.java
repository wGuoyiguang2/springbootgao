package com.example.configuration;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/*
* 开启事物不但要在启动类添加注解，而且还要配置数据源和事物管理器这样Transanctional才能生效
* */
@Configuration
@MapperScan(basePackages = {DataSourseConfiguration.MAPPER_PACKAGE})
public class DataSourseConfiguration {

    public static final String MAPPER_PACKAGE = "com.example.mapper";

    public static final String MAPPER_XML_PACKAGE = "classpath:mapper/*.xml";

    public static final String MYBATIS_BEAN_PACKAGE = "com.example.entity";


    //数据源
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean(name = "dataSource")
    public DataSource dataSourceConfig() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    //事物管理器
    @Primary
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSourceConfig());
    }



    // session 相关
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceConfig());

        //设置扫描 mybatis-config.xml
        sqlSessionFactoryBean.setConfigLocation(null);

        //设置扫描mapper.xml
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(MAPPER_XML_PACKAGE);
        sqlSessionFactoryBean.setMapperLocations(resources);

        //设置扫描实体类
        sqlSessionFactoryBean.setTypeAliasesPackage(MYBATIS_BEAN_PACKAGE);

        return sqlSessionFactoryBean.getObject();
    }


    @Primary
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate popSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
