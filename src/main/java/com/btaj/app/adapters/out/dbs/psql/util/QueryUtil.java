package com.btaj.app.adapters.out.dbs.psql.util;

import static java.util.Objects.isNull;

public class QueryUtil {
    public static String getLike(String str){
        if(isNull(str)){
            str = "";
        }
        return "%"+str+"%";
    }
}
