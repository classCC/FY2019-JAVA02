package com.string;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JiHe {

	public void jihe() {
	Map<String,Object> hashMap = new HashMap<>();
    //���Ԫ�ص� Map ��
    hashMap.put("key1", "value1");
    hashMap.put("key2", "value2");
    hashMap.put("key3", "value3");
    hashMap.put("key4", "value4");
    hashMap.put("key5", "value5");
     
    //ɾ�� Map �е�Ԫ��,ͨ�� key ��ֵ
    hashMap.remove("key1");
     
    //ͨ�� get(key) �õ� Map �е�value
    Object str1 = hashMap.get("key1");
     
    //����ͨ�� ��� �������޸� Map �е�Ԫ��
    hashMap.put("key2", "�޸� key2 �� Value");
     
    //ͨ�� map.values() �����õ� Map �е� value ����
    Collection<Object> value = hashMap.values();
    for(Object obj : value){
        //System.out.println(obj);
    }
     
    //ͨ�� map.keySet() �õ� Map ��key �ļ��ϣ�Ȼ�� ͨ�� get(key) �õ� Value
    Set<String> set = hashMap.keySet();
    for(String str : set){
        Object obj = hashMap.get(str);
        //System.out.println(str+"="+obj);
    }
     
    //ͨ�� Map.entrySet() �õ� Map �� Entry���ϣ�Ȼ�����
    Set<Map.Entry<String, Object>> entrys = hashMap.entrySet();
    for(Map.Entry<String, Object> entry: entrys){
        String key = entry.getKey();
        Object value2 = entry.getValue();
        System.out.println(key+"="+value2);
    }
     
    System.out.println(hashMap);
	}
}
