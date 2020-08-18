package com.xnote.client.core.handler;

import com.xnote.client.core.exception.NoteNotFoundException;
import com.xnote.client.core.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制器的异常处理类
 */
@ControllerAdvice
public class ControllerExceptionHandler
{
    @ExceptionHandler({
            UserNotExistException.class,
            NoteNotFoundException.class
    })

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerUserNotExistException(UserNotExistException ex)
    {
        Map<String, Object> result = new HashMap<>();
//        result.put("id")
        return result;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerNoteNotFoundException(UserNotExistException ex)
    {
        Map<String, Object> result = new HashMap<>();

        return result;
    }
}
