package foo.bar.day02.lab02;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by ainurminibaev on 07.04.15.
 */
public class StringBuilderFactoryBean implements FactoryBean<StringBuilder> {
    private String start;
    private String middle;
    private String finish;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    @Override
    public StringBuilder getObject() throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append(start).append(middle).append(finish);
        return builder;
    }

    @Override
    public Class<?> getObjectType() {
        return StringBuilder.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
