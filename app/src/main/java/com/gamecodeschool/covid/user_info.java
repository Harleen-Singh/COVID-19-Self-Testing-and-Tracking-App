package com.gamecodeschool.covid;

public class user_info {
    String dName,dGen,dDob,dAdd,dPhn;

    public user_info(String dvAdd, String dName, String dDob, String dAdd, String dPhn){
        this.dName = dName;
        this.dGen = dGen;
        this.dDob=dDob;
        this.dAdd=dAdd;
        this.dPhn=dPhn;
    }
    public String getdName() {
        return dName;
    }
    public String getdGen(){ return dGen; }
    public String getdDob(){ return dDob;}
        public String getdAdd(){return dAdd;}
        public String getdPhn(){return dPhn;}
}


