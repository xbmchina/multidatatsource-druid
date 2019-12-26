package cn.xbmchina.singledatasource;

import cn.xbmchina.singledatasource.db.DBConfig1;
import cn.xbmchina.singledatasource.db.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
public class SingledatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingledatasourceApplication.class, args);
	}

}
