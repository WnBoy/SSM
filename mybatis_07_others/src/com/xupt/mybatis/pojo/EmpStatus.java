package com.xupt.mybatis.pojo;

/**
 * @author Wnlife
 * @create 2020-04-15 9:55
 */
public enum EmpStatus {
    LOGIN("100", "用户登录"),LOGOUT("200", "用户登出"), REMOVE("300", "用户不存在");

    private String code;
    private String msg;

    EmpStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "EmpStatus{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    /**
     * 根据状态码查找EmpStatus
     * @param code
     * @return
     */
    public static EmpStatus getEmpStatusByCode(String code){
        switch (code){
            case "100":return LOGIN;
            case "200":return LOGOUT;
            case "300":return REMOVE;
            default:return LOGOUT;
        }
    }
}
