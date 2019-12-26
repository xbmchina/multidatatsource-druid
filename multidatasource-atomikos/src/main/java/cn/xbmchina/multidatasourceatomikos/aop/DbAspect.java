package cn.xbmchina.multidatasourceatomikos.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DbAspect extends DataSourceAspect {

    @Pointcut("execution(* cn.xbmchina.multidatasourceatomikos.mapper.*.*(..))")
    @Override
    protected void datasourceAspect() {
        super.datasourceAspect();
    }
}