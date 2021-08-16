package com.hzero.order.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hzero.order.domain.entity.Item;

import java.util.List;

/**
 * 物料(Item)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:06:20
 */
public interface ItemMapper extends BaseMapper<Item> {
    /**
     * 基础查询
     *
     * @param item 查询条件
     * @return 返回值
     */
    List<Item> selectList(Item item);
}
