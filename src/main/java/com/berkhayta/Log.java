package com.berkhayta;

import java.time.LocalDateTime;

public class Log {

    private String errorMessage;
    private int errorCode;
    private String className;
    private String methodName;
    private LocalDateTime zaman;
    private String detay;

    public Log(String errorMessage, Integer errorCode, String className, String methodName, LocalDateTime zaman,String detay) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.className = className;
        this.methodName = methodName;
        this.zaman = zaman;
        this.detay = detay;
    }

    @Override
    public String toString() {
        return "Log{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorCode=" + errorCode +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", zaman=" + zaman +
                ", detay='" + detay + '\'' +
                '}';
    }

}

