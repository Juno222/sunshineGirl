package hll.sunshinegirl.mvc.enums;


public enum StatusEnum {
    SUCCESS(true,"成功"),
    FAILURE(false,"失败");

    private Boolean type;
    private String msg;

    StatusEnum(Boolean type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public Boolean value() {
        return type;
    }
    public String description() {
        return msg;
    }

    // 把整数映射到枚举值
    public static StatusEnum valueOf(Boolean value) {
        for(StatusEnum typeEnum : StatusEnum.values()) {
            if(typeEnum.value() == value) {
                return typeEnum;
            }
        }
        return null;
    }
}
