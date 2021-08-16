package com.hzero.order.app.service;

import com.hzero.order.domain.entity.SoHeader;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hzero.order.domain.entity.Item;

import java.util.List;

/**
 * 物料(Item)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:06:25
 */
public interface ItemService {

    /**
     * 查询数据
     *
     * @param pageRequest 分页参数
     * @param items       查询条件
     * @return 返回值
     */
    Page<Item> selectList(PageRequest pageRequest, Item items);

    /**
     * 保存数据
     *
     * @param items 数据
     */
    void saveData(List<Item> items);
    Item update(Long organizationId, Item item);
}
