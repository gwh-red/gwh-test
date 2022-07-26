package com.gwh.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 123
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RunfastGoodsSellVO {
    /**
     * 排序
     * 商品名称
     * 副标题
     * 商品标签
     * 主料
     * 商品描述
     * 图片地址
     * 分类排序
     * 分类名称
     * 分类描述
     * 最低购买数量
     * 是否必要商品
     * 商品状态
     * 数量
     * 销售时间
     * 开始时间1
     * 结束时间2
     * 开始时间2
     * 结束时间2
     * 开始时间3
     * 结束时间3
     */
    @Excel(name = "排序", orderNum = "1")
    private Integer index;

    @Excel(name = "商品名称", orderNum = "2")
    private String goodsName;
}
