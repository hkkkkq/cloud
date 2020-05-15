package com.lwhtarena.nl.model.behavior.pojos;

import lombok.Data;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author liwh
 * @Title: ApBehaviorEntry
 * @Package com.lwhtarena.nl.model.behavior.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:41
 */
@Data
public class ApBehaviorEntry {
    private Integer id;
    private Short type;
    private Integer entryId;
    private Date createdTime;
    public String burst;

    @Alias("ApBehaviorEntryEnumType")
    public enum  Type{
        USER((short)1),EQUIPMENT((short)0);
        @Getter
        short code;
        Type(short code){
            this.code = code;
        }
    }

    public boolean isUser(){
        if(this.getType()!=null&&this.getType()== Type.USER.getCode()){
            return true;
        }
        return false;
    }
}
