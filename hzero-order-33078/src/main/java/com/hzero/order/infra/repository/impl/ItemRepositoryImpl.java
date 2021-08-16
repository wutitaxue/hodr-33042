package com.hzero.order.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hzero.order.domain.entity.Item;
import com.hzero.order.domain.repository.ItemRepository;
import com.hzero.order.infra.mapper.ItemMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 物料(Item)资源库
 *
 * @author chw
 * @since 2021-08-02 14:06:24
 */
@Component
public class ItemRepositoryImpl extends BaseRepositoryImpl<Item> implements ItemRepository {
    @Resource
    private ItemMapper itemMapper;

    @Override
    public List<Item> selectList(Item item) {
        return itemMapper.selectList(item);
    }

    @Override
    public Item selectByPrimary(Long itemId) {
        Item item = new Item();
        item.setItemId(itemId);
        List<Item> items = itemMapper.selectList(item);
        if (CollectionUtils.isEmpty(items)) {
            return null;
        }
        return items.get(0);
    }

}
