package springapp.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages={"springapp"},
        excludeFilters=@ComponentScan.Filter(type=FilterType.REGEX, pattern={"springapp.web.*"}))
@PropertySource(value = { "classpath:application.properties" })
@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

//    @Bean
//    public JavaMailSenderImpl javaMailSenderImpl() {
//        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
//        mailSenderImpl.setHost(env.getProperty("smtp.host"));
//        mailSenderImpl.setPort(env.getProperty("smtp.port", Integer.class));
//        mailSenderImpl.setProtocol(env.getProperty("smtp.protocol"));
//        mailSenderImpl.setUsername(env.getProperty("smtp.username"));
//        mailSenderImpl.setPassword(env.getProperty("smtp.password"));
//
//        Properties javaMailProps = new Properties();
//        javaMailProps.put("mail.smtp.auth", true);
//        javaMailProps.put("mail.smtp.starttls.enable", true);
//
//        mailSenderImpl.setJavaMailProperties(javaMailProps);
//
//        return mailSenderImpl;
//    }

    @Bean
    public CacheManager cacheManager()
    {
        return new ConcurrentMapCacheManager();
    }

}
