package pl.mikigal.cda.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Properties {

    @Value("${delay.time}")
    private int delayTime;

    public int getDelayTime() {
        return delayTime;
    }

}