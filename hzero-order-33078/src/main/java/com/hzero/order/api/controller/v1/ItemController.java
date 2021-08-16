package com.hzero.order.api.controller.v1;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hzero.order.app.service.ItemService;
import com.hzero.order.domain.entity.Item;
import com.hzero.order.domain.repository.ItemRepository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 物料(Item)表控制层
 *
 * @author chw
 * @since 2021-08-02 14:06:27
 */

@RestController("itemController.v1")
@RequestMapping("/v1/{organizationId}/hodr-items")
public class ItemController extends BaseController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "物料列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<Item>> list(Item item, @PathVariable Long organizationId, @ApiIgnore @SortDefault(value = Item.FIELD_ITEM_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Item> list = itemService.selectList(pageRequest, item);
        return Results.success(list);
    }

    @ApiOperation(value = "物料明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{itemId}")
    public ResponseEntity<Item> detail(@PathVariable Long itemId) {
        Item item = itemRepository.selectByPrimary(itemId);
        return Results.success(item);
    }

    @ApiOperation(value = "创建物料")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<List<Item>> save(@PathVariable Long organizationId, @RequestBody List<Item> items) {
        validObject(items);
        SecurityTokenHelper.validTokenIgnoreInsert(items);
        itemService.saveData(items);
        return Results.success(items);
    }

    @ApiOperation(value = "删除物料")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Item item) {
        SecurityTokenHelper.validToken(item);
        itemRepository.deleteByPrimaryKey(item);
        return Results.success();
    }
    @ApiOperation(value = "修改物料")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<Item> update(@PathVariable("organizationId") Long organizationId, @RequestBody Item item) {
        itemService.update(organizationId, item);
        return Results.success(item);
    }

}
