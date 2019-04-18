package cn.ziming.my.shop.commons.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringContext {
    private static final Logger logger = LoggerFactory.getLogger(SpringContext.class);
    public Object getSpringBean(String beanId) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        return context.getBean(beanId);
    }
}
