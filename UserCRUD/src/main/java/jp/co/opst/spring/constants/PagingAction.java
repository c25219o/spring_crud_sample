package jp.co.opst.spring.constants;

import java.util.HashMap;
import java.util.Map;

public enum PagingAction {

    NEXT("next"), PREVIOUS("previous"), OTHER("");

    private String action;

    private static Map<String, PagingAction> actionMap = new HashMap<>();

    static {
        for (PagingAction each : PagingAction.values()) {
            actionMap.put(each.action, each);
        }
    }

    private PagingAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return action;
    }

    public static PagingAction of(String selectAction) {
        if (actionMap.containsKey(selectAction)) {
            return actionMap.get(selectAction);
        } else {
            return OTHER;
        }
    }

}
