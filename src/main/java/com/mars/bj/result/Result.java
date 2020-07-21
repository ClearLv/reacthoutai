package com.mars.bj.result;

import lombok.Data;

@Data
public class Result {
    private Integer code;

    public Result(Integer code) {
        this.code = code;
    }
}
