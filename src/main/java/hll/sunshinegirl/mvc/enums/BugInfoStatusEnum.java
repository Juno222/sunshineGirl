package hll.sunshinegirl.mvc.enums;


public enum BugInfoStatusEnum {
    UNCONFIRMED ((byte)1,"未确认"),
    CONFIRMED ((byte)2,"已确认")
    ;

    private Byte type;
    private String msg;

    BugInfoStatusEnum(Byte type, String msg) {
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
    public static BugInfoStatusEnum valueOf(Byte value) {
        for(BugInfoStatusEnum typeEnum : BugInfoStatusEnum.values()) {
            if(typeEnum.value() == value) {
                return typeEnum;
            }
        }
        return null;
    }
}
