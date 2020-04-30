package com.soft1851.springboot.mbp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

/**
 * @author zhao
 * @className Follow
 * @Description TODO
 * @Date 2020/4/16
 * @Version 1.0
 **/
@Data
@Builder
public class Follower {
    @TableId(value = "id",type = IdType.INPUT)
    private String id;
    private String name;
    private String url;
    private Integer gender;
    private String avatarUrl;
    private Integer followerCount;
}
