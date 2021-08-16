package com.hzero.order.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hzero.order.domain.entity.Item;

import java.util.List;

/**
 * 物料(Item)资源库
 *
 * @author chw
 * @since 2021-08-02 14:06:23
 */
public interface ItemRepository extends BaseRepository<Item> {
    /**
     * 查询
     *
     * @param item 查询条件
     * @return 返回值
     */
    List<Item> selectList(Item item);

    /**
     * 根据主键查询（可关联表）
     *
     * @param itemId 主键
     * @return 返回值
     */
    Item selectByPrimary(Long itemId);
}
