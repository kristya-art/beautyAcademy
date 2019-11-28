package org.beauty.bea1.messages;

import org.springframework.web.bind.annotation.ResponseBody;

public class ResponseMessage {
    private String message;

    public ResponseMessage(String message)  {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
