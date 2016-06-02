package jp.co.opst.spring.constants;

import java.util.HashMap;
import java.util.Map;

public enum UserType {

    GENERAL("user"),
    ADMIN("admin"),
    OTHER("");

    private String type;

    private UserType(String type) {
        this.type = type;
    }

    private static Map<String, UserType> typeMap = new HashMap<>();

    static {
        for (UserType each : UserType.values()) {
            typeMap.put(each.type, each);
        }
    }

    public static UserType typeof(String type) {
        return typeMap.get(type);
    }

}
