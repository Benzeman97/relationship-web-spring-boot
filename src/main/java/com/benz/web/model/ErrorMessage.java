package com.benz.web.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class ErrorMessage {

    private int error_code;
    private String erroeMsg;
    private String documentation;

    public ErrorMessage(int error_code, String erroeMsg, String documentation) {
        this.error_code = error_code;
        this.erroeMsg = erroeMsg;
        this.documentation = documentation;
    }
}
