package io.wxwobot.admin.itchat4j.beans;

/**
 * @author WesleyOne
 * @create 2018/12/21
 */
public class BaseResponse {

    private Integer Ret;
    private String ErrMsg;

    public Integer getRet() {
        return Ret;
    }

    public void setRet(Integer ret) {
        Ret = ret;
    }

    public String getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(String errMsg) {
        ErrMsg = errMsg;
    }
}
