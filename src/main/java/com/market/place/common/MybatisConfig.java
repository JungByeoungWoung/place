package com.market.place.common;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@MapperScan(basePackages = "com.market.place.mapper")
public class MybatisConfig {
    private final ApplicationContext context;
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource DataSource() {
        System.out.println("DataSource 생성");
        return DataSourceBuilder.create().build();
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory (DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(context.getResource("classpath:mapper/itemMapper.xml"));

        //vo 로 사용할 패키지 경로
        // mapper 파일에서 result, parameterType의 패키지 경로에 클래스만 작성 가능하도록 해줌
        sqlSessionFactoryBean.setTypeAliasesPackage("com.market.place.domain");
        return sqlSessionFactoryBean.getObject();
    }

    // Mybatis Template
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws CustomException {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);

        sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true);

//        sqlSessionTemplate.getConfiguration().setUseGeneratedKeys(true);
        return sqlSessionTemplate;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
