package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
    public static String getWebRemoteDriverUser() {
        return getWebConfig().webRemoteDriverUser();
    }

    public static String getWebRemoteDriverPassword() {
        return getWebConfig().webRemoteDriverPassword();
    }

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}
