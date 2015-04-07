package foo.bar.day02.lab08;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Component("fiveMinScope")
public class FiveMinScope implements Scope, TimeScope {

    //public static final int FIVE_MINUTES = 60 * 1000 * 5;
    public static final int FIVE_MINUTES = 1000;

    private Map<String, Object> objectMap = Collections.synchronizedMap(new HashMap<String, Object>());
    private Map<String, Long> timeMap = Collections.synchronizedMap(new HashMap<String, Long>());

    /**
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.config.Scope#get(java.lang.String,
     * org.springframework.beans.factory.ObjectFactory)
     */
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!objectMap.containsKey(name) || isExpired(name)) {
            objectMap.put(name, objectFactory.getObject());
            timeMap.put(name, System.currentTimeMillis());
        }
        return objectMap.get(name);
    }

    private boolean isExpired(String name) {
        Long wroteTime = timeMap.get(name);
        if (wroteTime == null || (System.currentTimeMillis() - wroteTime < FIVE_MINUTES)) {
            return false;
        }
        return true;
    }

    /**
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.config.Scope#remove(java.lang.String)
     */
    public Object remove(String name) {
        return objectMap.remove(name);
    }

    /**
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.config.Scope#registerDestructionCallback
     * (java.lang.String, java.lang.Runnable)
     */
    public void registerDestructionCallback(String name, Runnable callback) {
        // do nothing
    }

    /**
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.config.Scope#resolveContextualObject(java.lang.String)
     */
    public Object resolveContextualObject(String key) {
        return null;
    }

    /**
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.config.Scope#getConversationId()
     */
    public String getConversationId() {
        return "FiveMinScope";
    }

    /**
     * clear the beans
     */
    public void clearBean() {
        objectMap.clear();
    }

    @Override
    public long getLiveTime() {
        return FIVE_MINUTES;
    }
}
