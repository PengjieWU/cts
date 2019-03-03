package cn.pj.cts.common;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 0:16 2019/1/24
 * @Modify By:
 **/
public class ErrorsException extends  RuntimeException {



    private static final long serialVersionUID = -6370612186038915645L;

    private final ErrorCodeAndMsg response;


    public ErrorsException(ErrorCodeAndMsg response) {
        this.response = response;
    }
    public ErrorCodeAndMsg getResponse() {
        return response;
    }


}
