package hll.sunshinegirl.mvc.vo;

import hll.sunshinegirl.mvc.model.BugInfo;
import hll.sunshinegirl.mvc.model.Modle;
import hll.sunshinegirl.mvc.model.User;


public class FullBugVo extends BugInfo {

    private String moName;

    private String uName;

    private Integer uId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getMoName() {
        return moName;
    }

    public void setMoName(String moName) {
        this.moName = moName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}
