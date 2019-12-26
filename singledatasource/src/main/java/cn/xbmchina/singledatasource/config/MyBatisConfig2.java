package cn.xbmchina.singledatasource.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import cn.xbmchina.singledatasource.db.DBConfig2;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atomikos.jdbc.AtomikosDataSourceBean;


@Configuration
@MapperScan(basePackages = "cn.xbmchina.singledatasource.mapper.movies", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class MyBatisConfig2 {

    // 配置数据源
    @Bean(name = "test2DataSource")
    public DataSource testDataSource(DBConfig2 dBConfig2) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dBConfig2.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dBConfig2.getPassword());
        mysqlXaDataSource.setUser(dBConfig2.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("test2DataSource");

        xaDataSource.setMinPoolSize(dBConfig2.getMinPoolSize());
        xaDataSource.setMaxPoolSize(dBConfig2.getMaxPoolSize());
        xaDataSource.setMaxLifetime(dBConfig2.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(dBConfig2.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(dBConfig2.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(dBConfig2.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(dBConfig2.getMaxIdleTime());
        xaDataSource.setTestQuery(dBConfig2.getTestQuery());
        return xaDataSource;
    }

    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}