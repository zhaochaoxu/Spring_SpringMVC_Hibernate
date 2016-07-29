package com.chaoxu.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by dell on 2016/7/29.
 */
public class SearchParam {

    private String type;
    private String propertyName;
    private Object value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public static List<SearchParam> buiderSearchParam(HttpServletRequest request){
        List<SearchParam> searchParamList = Lists.newArrayList();

        //获取所有查询的字符串
        Enumeration<String> enumeration= request.getHeaderNames();

        while (enumeration.hasMoreElements()){
            String queryString = enumeration.nextElement();
            String value = request.getParameter(queryString);
            if(queryString.startsWith("q_")&& StringUtils.isNotEmpty(value)){
                String[] array = queryString.split("-");
                if(array.length!=3){
                    throw new RuntimeException("地址栏查询格式错误"+queryString);
                }
                String type = array[1];
                String propertyName = array[2];

                SearchParam searchParam = new SearchParam();
                searchParam.setType(type);
                searchParam.setValue(Strings.toUTF8(value));
                searchParam.setPropertyName(propertyName);

                searchParamList.add(searchParam);
            }
        }
        return searchParamList;
    }
}
