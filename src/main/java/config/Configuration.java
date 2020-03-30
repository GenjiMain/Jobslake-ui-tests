package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:conf/dev.properties"})
public interface Configuration extends Config {

    String target();

    @Key("url.base")
    String url();

    String timeout();

    @Key("faker.locale")
    String faker();
}
