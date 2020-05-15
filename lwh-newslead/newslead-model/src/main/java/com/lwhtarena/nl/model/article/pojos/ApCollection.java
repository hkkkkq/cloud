package com.lwhtarena.nl.model.article.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lwhtarena.nl.model.annotation.IdEncrypt;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author liwh
 * @Title: ApCollection
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:49
 */
@Data
public class ApCollection {
    private Long id;
    @IdEncrypt
    private Integer behaviorEntryId;
    @IdEncrypt
    private Integer entryId;
    private Short type;
    private Date collectionTime;
    private Date publishedTime;
    @JsonIgnore
    private String burst;
    // 定义收藏内容类型的枚举
    @Alias("ApCollectionEnumType")
    public enum Type{
        ARTICLE((short)0),DYNAMIC((short)1);
        short code;
        Type(short code){
            this.code = code;
        }
        public short getCode(){
            return this.code;
        }
    }

    public boolean isCollectionArticle(){
        return (this.getType()!=null&&this.getType().equals(Type.ARTICLE));
    }
}
