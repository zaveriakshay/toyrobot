package org.idlo.puzzle.toyrobot.core.enums;

/**
 * @author akshay.zaveri
 */
public enum ErrorType {

    ERR0001("err.constraint.boundary.1"),

    ERR0002("err.constraint.boundary.2"),

    ERR0003("err.server.1"),

    ERR0004("err.binding.1");

    private String key;

    ErrorType(){

    }

    ErrorType(String key){
        setKey(key);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
