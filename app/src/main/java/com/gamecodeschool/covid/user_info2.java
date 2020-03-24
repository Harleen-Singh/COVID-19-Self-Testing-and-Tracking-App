package com.gamecodeschool.covid;

public class user_info2 {
    String dSrc,dDst,dSick,dSymptons;

    public user_info2(String dSrc,String dDst,String dSick,String dSymptons){
        this.dSrc=dSrc;
        this.dDst=dDst;
        this.dSick=dSick;
        this.dSymptons=dSymptons;
    }

    public String getdSrc() {
        return dSrc;
    }
    public String getdDst(){
        return dDst;
    }

    public String getdSick() {
        return dSick;
    }

    public String getdSymptons() {
        return dSymptons;
    }
}
