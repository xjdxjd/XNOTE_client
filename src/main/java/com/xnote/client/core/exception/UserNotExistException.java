package com.xnote.client.core.exception;

public class UserNotExistException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    private String id;

    public UserNotExistException (String id)
    {
        super("");
    }
}
