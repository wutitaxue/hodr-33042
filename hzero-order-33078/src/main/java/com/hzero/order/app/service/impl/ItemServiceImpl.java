package com.hzero.order.app.service.impl;


import com.hzero.order.domain.entity.SoHeader;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.hzero.order.app.service.ItemService;
import org.springframework.stereotype.Service;
import com.hzero.order.domain.entity.Item;
import com.hzero.order.domain.repository.ItemRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 物料(Item)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:06:26
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Page<Item> selectList(PageRequest pageRequest, Item item) {
        return PageHelper.doPageAndSort(pageRequest, () -> itemRepository.selectList(item));
    }

    @Override
    public void saveData(List<Item> items) {
        items.forEach(item -> {
            if (item.getItemId() == null) {
                itemRepository.insertSelective(item);
            } else {
                itemRepository.updateByPrimaryKeySelective(item);
            }
        });
    }

    @Override
    public Item update(Long organizationId, Item item) {
        //SecurityTokenHelper.validToken(soHeader);
        itemRepository.updateByPrimaryKeySelective(item);
        return item;
    }

}
