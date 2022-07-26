package com.gwh.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsTest {
    /**
     * 商品排序
     * 商品名称
     * 规格名称
     * 价格(元)
     * 餐盒费(元)
     * 库存
     * 开启次日置满
     */

    @Excel(name = "商品排序", orderNum = "1")
    private Integer index;

    @Excel(name = "商品名称", orderNum = "2")
    private String goodsName;

    @Excel(name = "规格名称", orderNum = "3")
    private String goodsName1;

    @Excel(name = "价格(元)", orderNum = "4")
    private BigDecimal money;
}
