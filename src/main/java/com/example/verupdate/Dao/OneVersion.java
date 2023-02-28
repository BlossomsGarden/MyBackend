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


    public String version_no;
    public String launch_time;
    public Map<String,List<String>> update_detail=new HashMap<>();
    public Map<String,List<String>> contributor=new HashMap<>();
    public List<UpdateName> updateNames=new ArrayList<>();
    public List<ContributorName> contributorNames=new ArrayList<>();

    public Boolean InUpdateNameList(String kind_name_key){
        System.out.println(kind_name_key);
        for(UpdateName i:updateNames){
            System.out.println(i.id);
            // "变量 s1 指向由“Hello”创建的字符串实例。s2 所指的的对象是以 s1 作为初始化而创建的。
            // 因此这两个字符串对象的内容是一样的。
            // 但它们是不同的对象，这就意味着 s1 和 s2 没有指向同一的对象
            // 因此它们是不==的。
            //
            // 因此，千万不要使用==运算符测试字符串的相等性，以免在程序中出现糟糕的 bug。
            // 从表面上看，这种 bug 很像随机产生的间歇性错误。"
            // 参考：http://c.biancheng.net/view/5808.html
            if(i.id.equals(kind_name_key)) {
                System.out.println("返回1");
                return true;
            }
        }
        System.out.println("返回0");
        return false;
    }
    public Boolean InContributorNameList(String kind_name_key){
        for(ContributorName i:contributorNames){
            if(i.id.equals(kind_name_key)) {
                return true;
            }
        }
        return false;
    }

    public OneVersion(UpdateVersion updateVersion){
        version_no= updateVersion.version_no;
        launch_time= updateVersion.launch_time;

        for (UpdateInfo i:updateVersion.update_infos) {
            String key=i.updateKindNameMap.kind_key;
            String name=i.updateKindNameMap.kind_name;
            String content=i.update_content;
            if(i.type=='a'){
                //先处理更新内容Map
                if (update_detail.containsKey(key)) {
                    update_detail.get(key).add(content);
                }
                else {
                    List<String> tmplist=new ArrayList<>();
                    tmplist.add(content);
                    update_detail.put(key,tmplist);
                }

                //再处理更新名称List
                if(InUpdateNameList(key)==false){
                    updateNames.add(new UpdateName(key,name));
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

                //再处理更新名称List
                if(InContributorNameList(key)==false){
                    contributorNames.add(new ContributorName(key,name));
                }
            }

        }
    };
}
