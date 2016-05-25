package hll.sunshinegirl.mvc.enums;


public enum BugSolveStatusEnum {
    SOLEVD ((byte)1,"已解决"),
    UNSOLEVD ((byte)2,"未解决")
    ;

    private Byte type;
    private String msg;

    BugSolveStatusEnum(Byte type, String msg) {
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
    public static BugSolveStatusEnum valueOf(Byte value) {
        for(BugSolveStatusEnum typeEnum : BugSolveStatusEnum.values()) {
            if(typeEnum.value() == value) {
                return typeEnum;
            }
        }
        return null;
    }
}
