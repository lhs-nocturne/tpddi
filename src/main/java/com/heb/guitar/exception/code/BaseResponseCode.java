package com.heb.guitar.exception.code;

public enum BaseResponseCode implements ResponseCodeInterface{
    /**
     * 这个要约定好
     *code=0：服务器已成功处理了请求。 通常，这表示服务器提供了请求的网页。
     *code=4010001：（授权异常） 请求要求身份验证。 客户端需要跳转到登录页面重新登录
     *code=4010002：(凭证过期) 客户端请求刷新凭证接口
     *code=4030001：没有权限禁止访问
     *code=400xxxx：系统主动抛出的业务异常
     *code=5000001：系统异常
     *
     */
    SUCCESS(0,"操作成功"),
    SYSTEM_ERROR(5000001,"系统异常"),
    DATA_ERROR(4000001,"数据异常"),
    VALIDATOR_ERROR(4000002,"校验异常"),
    NOT_ACCOUNT(4000003,"账号不存在"),
    USER_LOCK(4000004,"该账号已被锁定，请联系系统管理员"),
    PASSWORD_ERROR(4000005,"密码错误"),
    EXIST_ACCOUNT(4000006,"账号已存在"),
    TOKEN_ERROR(4010001,"用户未登录，请重新登录"),
    TOKEN_NOT_NULL(4010001,"token认证不能为空，请重新登录获取token"),
    SHIRO_AUTHENTICATION_ERROR(4010001,"token认证失败，请重新登录获取最新token"),
    ACCOUNT_HAS_DELETED_ERROR(4010001,"账号已被删除"),
    TOKEN_PASS_DUE(4010002,"token失效，请重新刷新token"),
    NOT_PERMISSION(4030001,"没有权限禁止访问"),
    OPERATION_ERROR(4000005,"操作失败"),
    OPERATION_MENU_PERMISSION_CATALOG_ERROR(4000006,"操作后的菜单类型是目录，所属菜单必须为默认顶级菜单或者目录"),
    OPERATION_MENU_PERMISSION_MENU_ERROR(4000007,"操作后的菜单类型是菜单，所属菜单必须为目录类型"),
    OPERATION_MENU_PERMISSION_BTN_ERROR(4000008,"操作后的菜单类型是按钮，所属菜单必须为菜单类型"),
    OPERATION_MENU_PERMISSION_URL_NOT_NULL(4000009,"菜单权限的url不能为空"),
    OPERATION_MENU_PERMISSION_URL_PERMS_NULL(4000010,"菜单权限的标识符不能为空"),
    OPERATION_MENU_PERMISSION_URL_METHOD_NULL(4000011,"菜单权限的请求方式不能为空"),
    OPERATION_MENU_PERMISSION_UPDATE(4010013,"操作的菜单权限存在子集关联不允许变更"),
    ROLE_PERMISSION_RELATION(4010014, "该菜单权限存在子集关联，不允许删除"),
    NOT_PERMISSION_DELETED_DEPT(4010015,"该组织机构下还关联着用户，不允许删除"),
    OLD_PASSWORD_ERROR(4010016,"旧密码不正确"),
    LOG_ERROR(4010017,"日志写入异常"),
    CONNECT_ERROR(4010018,"数据源连接失败"),
    DELETE_ERROR(4010019,"该数据正在使用中，不允许删除。"),
    /**
     * 接口服务相关错误提示
     */
    VIEW_NOTNULL(4000050,"无效的服务ID"),
    PARAMS_NOTNULL(4000051,"未传参数"),
    NOT_MATCH_COLUMN(4000052,"无匹配查询列"),
    STOP_SERVER(4000053,"该服务已被停用"),
    NO_PARSE_JSON(4000054,"参数解析失败"),
    NO_USER_VIEW(4000055,"未授权的视图"),
    ;

    BaseResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //响应状态
    private final int code;
    //响应提示
    private final String msg;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
