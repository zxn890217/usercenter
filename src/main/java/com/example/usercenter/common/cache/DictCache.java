package com.example.usercenter.common.cache;

import com.alibaba.fastjson.JSONObject;
import com.example.usercenter.sys.entity.Dict;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ZXN on 2018/7/15.
 */
public class DictCache {
    private static Map<String, ConcurrentHashMap<String, Dict>> dictMap = new ConcurrentHashMap<String, ConcurrentHashMap<String, Dict>>();
    private static Map<String, ConcurrentHashMap<String, Dict>> dictScriptMap = new ConcurrentHashMap<String, ConcurrentHashMap<String, Dict>>();

    public static void init(List<Dict> list){
        dictMap.clear();
        dictScriptMap.clear();
        list.forEach(dict -> {
            String type = dict.getType();
            ConcurrentHashMap<String, Dict> eDictMap = dictMap.get(type);
            if(eDictMap == null){
                eDictMap = new ConcurrentHashMap<String, Dict>();
                dictMap.put(type, eDictMap);
            }
            eDictMap.put(dict.getCode(), dict);
            if("1".equals(dict.getDownLoad())){
                ConcurrentHashMap<String, Dict> eDictScriptMap = dictScriptMap.get(type);
                if(eDictScriptMap == null){
                    eDictScriptMap = new ConcurrentHashMap<String, Dict>();
                    dictScriptMap.put(type, eDictScriptMap);
                }
                eDictScriptMap.put(dict.getCode(), dict);
            }
        });
    }

    public static Dict getDict(String type, String code){
        Map<String, Dict> map = dictMap.get(type);
        if(map != null)
            return map.get(code);
        return null;
    }

    public static String getValue(String type, String code){
        Map<String, Dict> map = dictMap.get(type);
        if(map != null){
            Dict dict = map.get(code);
            if(dict != null){
                return dict.getValue();
            }
        }
        return null;
    }

    public static Collection<Dict> getDicts(String type){
        ArrayList<Dict> list = new ArrayList<Dict>(dictMap.get(type).values());
        Collections.sort(list, new Comparator<Dict>() {
            @Override
            public int compare(Dict o1, Dict o2) {
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        return list;
    }

    public static String getScript(){
        return JSONObject.toJSONString(dictScriptMap);
    }
}
