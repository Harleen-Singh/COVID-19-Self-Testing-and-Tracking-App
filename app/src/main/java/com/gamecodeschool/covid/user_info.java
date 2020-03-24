package com.gamecodeschool.covid;

public class user_info {
    String dName,dGen,dDob,dAdd,dPhn,dSrc,dDst,dSick,dSymptons;

    public user_info(String dvAdd, String dName, String dDob, String dAdd, String dPhn,String dSrc,String dDst,String dSick,String dSymptons){
        this.dName = dName;
        this.dGen = dGen;
        this.dDob=dDob;
        this.dAdd=dAdd;
        this.dPhn=dPhn;
        this.dSrc=dSrc;
        this.dDst=dDst;
        this.dSick=dSick;
        this.dSymptons=dSymptons;
    }
    public String getdName() {
        return dName;
    }
    public String getdGen(){ return dGen; }
    public String getdDob(){ return dDob;}
        public String getdAdd(){return dAdd;}
        public String getdPhn(){return dPhn;}
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


