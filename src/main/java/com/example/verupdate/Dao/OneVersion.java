package com.example.verupdate.Dao;

import java.util.*;

public class OneVersion {
    //使用自定义二元组真的很尴尬
//    public String version_no;
//    public String launch_time;
//    public List<TwoTuple<String,String>> update_detail=new ArrayList<>();
//    public List<TwoTuple<String,String>> contributor=new ArrayList<>();
//
//    public Response(UpdateVersion updateVersion){
//        version_no= updateVersion.version_no;
//        launch_time= updateVersion.launch_time;
//
//        for (UpdateInfo tmp:updateVersion.update_infos) {
//            String fir=tmp.updateKindNameMap.kind_key;
//            String sec=tmp.update_content;
//            TwoTuple<String,String> temp=new TwoTuple<>(fir,sec);
//            if(tmp.type=='a'){
//                update_detail.add(temp);
//            } else if (tmp.type=='b') {
//                contributor.add(temp);
//            }
//
//        }
//    };

    public String version_no;
    public String launch_time;
    public Map<String,List<String>> update_detail=new HashMap<>();
    public Map<String,List<String>> contributor=new HashMap<>();

    public OneVersion(UpdateVersion updateVersion){
        version_no= updateVersion.version_no;
        launch_time= updateVersion.launch_time;

        for (UpdateInfo i:updateVersion.update_infos) {
            String key=i.updateKindNameMap.kind_key;
            String name=i.updateKindNameMap.kind_name;
            String content=i.update_content;
            if(i.type=='a'){
                //处理更新内容Map
                if (update_detail.containsKey(key)) {
                    update_detail.get(key).add(content);
                }
                else {
                    List<String> tmplist=new ArrayList<>();
                    tmplist.add(content);
                    update_detail.put(key,tmplist);
                }
            } else if (i.type=='b') {
                if (contributor.containsKey(key)) {
                    contributor.get(key).add(content);
                }
                else {
                    List<String> tmplist=new ArrayList<>();
                    tmplist.add(content);
                    contributor.put(key,tmplist);
                }
            }

        }
    };
}
