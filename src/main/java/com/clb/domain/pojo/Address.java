package com.clb.domain.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author clibin
 * @since 2023-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 省
     */
    @TableField("province")
    private String province;

    /**
     * 市
     */
    @TableField("city")
    private String city;

    /**
     * 县/区
     */
    @TableField("town")
    private String town;

    /**
     * 手机
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 详细地址
     */
    @TableField("street")
    private String street;

    /**
     * 联系人
     */
    @TableField("contact")
    private String contact;

    /**
     * 是否是默认 1默认 0否
     */
    @TableField("is_default")
    private Boolean isDefault;

    /**
     * 备注
     */
    @TableField("notes")
    private String notes;


}
