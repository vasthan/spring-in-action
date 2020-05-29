package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context;
        context = new ClassPathXmlApplicationContext("s1.xml");
        // context = new FileSystemXmlApplicationContext("D:\\workspace\\code\\spring-in-action\\src\\main\\resources\\s1.xml");
        // context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        HelloService helloService = context.getBean(HelloService.class);

        helloService.hello("abc");
    }
}
