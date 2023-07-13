package gov.naco.soch.config;

import gov.naco.soch.aop.logging.LoggingAspect;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {

    private static final String SPRING_PROFILE_PRODUCTION = "prod";
    @Bean
//    @Profile(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT)
    @Profile(SPRING_PROFILE_PRODUCTION)
    public LoggingAspect loggingAspect(Environment env) {
        return new LoggingAspect(env);
    }
}
