package com.example.blog.util;

public class RestGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    private static final int RESULT_CODE_SUCCESS = 200;

    private static final int RESULT_CODE_SERVER_ERROR = 500;

    public static RestBean successResult() {
        RestBean result = new RestBean();
        result.setCode(RESULT_CODE_SUCCESS);
        result.setMsg(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static RestBean successResult(String msg) {
        RestBean result = new RestBean();
        result.setCode(RESULT_CODE_SUCCESS);
        result.setMsg(msg);
        return result;
    }

    public static RestBean successResult(Object object) {
        RestBean result = new RestBean();
        result.setCode(RESULT_CODE_SUCCESS);
        result.setMsg(DEFAULT_SUCCESS_MESSAGE);
        result.setData(object);
        return result;
    }


    public static RestBean errorResult(Object object) {
        RestBean result = new RestBean();
        result.setCode(RESULT_CODE_SERVER_ERROR);
        result.setMsg(DEFAULT_FAIL_MESSAGE);
        result.setData(object);
        return result;
    }

    public static RestBean errorResult(String msg) {
        RestBean result = new RestBean();
        result.setCode(RESULT_CODE_SERVER_ERROR);
        result.setMsg(msg);
        return result;
    }

    public static RestBean diyResult(int code,String msg,Object object) {
        RestBean result = new RestBean();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static RestBean diyResult(int code,String msg) {
        RestBean result = new RestBean();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


}
