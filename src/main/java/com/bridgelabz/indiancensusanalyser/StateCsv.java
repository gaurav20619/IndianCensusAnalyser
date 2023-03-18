package com.bridgelabz.indiancensusanalyser;

public class StateCsv {
    public Integer srNo;
    public String stateName;
    public Integer tin;
    public String stateCode;

    public StateCsv() {}

    public StateCsv(Integer srNo,String stateName,Integer tin,String stateCode) {
        this.srNo=srNo;
        this.stateName=stateName;
        this.tin=tin;
        this.stateCode=stateCode;
    }
    public String toString() {
        return "StateCSV [srNo=" + srNo + ", stateName=" + stateName + ", tin=" + tin + ", stateCode=" + stateCode
                + "]";
    }
}
