package com.javawithsprinbootlucas.javawithspringboot.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID =1L;

    private Date timestamp;
    private String mensage;
    private String deatails;

    public ExceptionResponse(Date timestamp, String mensage, String deatails) {
        this.timestamp = timestamp;
        this.mensage = mensage;
        this.deatails = deatails;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensage() {
        return mensage;
    }

    public String getDeatails() {
        return deatails;
    }
}