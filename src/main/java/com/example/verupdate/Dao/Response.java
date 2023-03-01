package com.example.verupdate.Dao;


import java.util.ArrayList;
import java.util.List;

public class Response {
    public class UpdateName{
        //你这里不加public，你就报错找不到serializer
        // https://blog.csdn.net/ityw520/article/details/111276325
        public String id;
        public String name;
        public UpdateName(String thatid,String thatname){
            id=thatid;
            name=thatname;
        }
    }
    public class ContributorName{
        public String id;
        public String name;
        public ContributorName(String thatid,String thatname){
            id=thatid;
            name=thatname;
        }
    }
    public List<OneVersion> history=new ArrayList<>();
    public List<UpdateName> updateName=new ArrayList<>();
    public List<ContributorName> contributorName=new ArrayList<>();

    public void setHistory(List<OneVersion> thathistory){
        history=thathistory;
    }
    public void setUpdateAndContributorName(List<UpdateKindNameMap> maps){
        for(UpdateKindNameMap i:maps){
            if(i.type=='a'){
                updateName.add(new UpdateName(i.kind_key, i.kind_name));
            } else if (i.type=='b') {
                contributorName.add(new ContributorName(i.kind_key,i.kind_name));
            }
        }
    }
}
