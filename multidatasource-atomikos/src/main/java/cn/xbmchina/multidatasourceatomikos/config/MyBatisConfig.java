package cn.xbmchina.multidatasourceatomikos.config;

import cn.xbmchina.multidatasourceatomikos.db.CustomSqlSessionTemplate;
import cn.xbmchina.multidatasourceatomikos.db.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = MyBatisConfig.BASE_PACKAGE, sqlSessionTemplateRef = "sqlSessionTemplate")
public class MyBatisConfig extends AbstractDataSourceConfig {

    //mapper模式下的接口层
    static final String BASE_PACKAGE = "cn.xbmchina.multidatasourceatomikos.mapper";

    //对接数据库的实体层
    static final String ALIASES_PACKAGE = "ccn.xbmchina.multidatasourceatomikos.domain";

    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";


    @Primary
    @Bean(name = "dataSourceOne")
    public DataSource dataSourceOne(Environment env) {
        String prefix = "spring.datasource.druid.one.";
        return getDataSource(env,prefix,"one");
    }

    @Bean(name = "dataSourceTwo")
    public DataSource dataSourceTwo(Environment env) {
        String prefix = "spring.datasource.druid.two.";
        return getDataSource(env,prefix,"two");
    }



    @Bean("dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("dataSourceOne")DataSource dataSourceOne, @Qualifier("dataSourceTwo")DataSource dataSourceTwo) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("one",dataSourceOne);
        targetDataSources.put("two",dataSourceTwo);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(dataSourceOne);
        return dataSource;
    }

    @Bean(name = "sqlSessionFactoryOne")
    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("dataSourceOne") DataSource dataSource)
            throws Exception {
        return createSqlSessionFactory(dataSource);
    }

    @Bean(name = "sqlSessionFactoryTwo")
    public SqlSessionFactory sqlSessionFactoryTwo(@Qualifier("dataSourceTwo") DataSource dataSource)
            throws Exception {
        return createSqlSessionFactory(dataSource);
    }




    @Bean(name = "sqlSessionTemplate")
    public CustomSqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryOne")SqlSessionFactory factoryOne, @Qualifier("sqlSessionFactoryTwo")SqlSessionFactory factoryTwo) throws Exception {
        Map<Object,SqlSessionFactory> sqlSessionFactoryMap = new HashMap<>();
        sqlSessionFactoryMap.put("one",factoryOne);
        sqlSessionFactoryMap.put("two",factoryTwo);

        CustomSqlSessionTemplate customSqlSessionTemplate = new CustomSqlSessionTemplate(factoryOne);
        customSqlSessionTemplate.setTargetSqlSessionFactorys(sqlSessionFactoryMap);
        return customSqlSessionTemplate;
    }

    /**
     * 创建数据源
     * @param dataSource
     * @return
     */
    private SqlSessionFactory createSqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setVfs(SpringBootVFS.class);
        bean.setTypeAliasesPackage(ALIASES_PACKAGE);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }
}