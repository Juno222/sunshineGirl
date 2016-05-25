package hll.sunshinegirl.mvc.vo;

import hll.sunshinegirl.mvc.model.BugInfo;

import java.util.List;


public class SingleManBugsVo {
    private String uName;
    private String moName;
    private List<BugInfo> bugInfos;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getMoName() {
        return moName;
    }

    public void setMoName(String moName) {
        this.moName = moName;
    }

    public List<BugInfo> getBugInfos() {
        return bugInfos;
    }

    public void setBugInfos(List<BugInfo> bugInfos) {
        this.bugInfos = bugInfos;
    }
}
