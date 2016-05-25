package hll.sunshinegirl.mvc.enums;


public enum UserRoleEnum {
    PROJECT_MANAGER((byte)1,"项目经理"),
    TESTING((byte)2,"测试工程师"),
    FRONTEND((byte)3,"前端工程师"),
    BACKEND((byte)4,"后端工程师"),
    OTHER((byte)5,"其他");

    private Byte type;
    private String msg;

    UserRoleEnum(Byte type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public Byte value() {
        return type;
    }
    public String description() {
        return msg;
    }

    // 把整数映射到枚举值
    public static UserRoleEnum valueOf(Byte value) {
        for(UserRoleEnum typeEnum : UserRoleEnum.values()) {
            if(typeEnum.value() == value) {
                return typeEnum;
            }
        }
        return null;
    }
}
