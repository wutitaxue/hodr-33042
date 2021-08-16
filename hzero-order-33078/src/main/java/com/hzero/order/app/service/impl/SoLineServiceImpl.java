package com.hzero.order.app.service.impl;


import com.hzero.order.domain.DTO.ItemDTO;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.SoHeaderRepository;
import org.hzero.core.base.BaseAppService;
import com.hzero.order.domain.vo.SolineVo;
import io.choerodon.core.domain.Page;
import io.choerodon.core.oauth.CustomUserDetails;
import io.choerodon.core.oauth.DetailsHelper;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.hzero.order.app.service.SoLineService;
import org.springframework.stereotype.Service;
import com.hzero.order.domain.entity.SoLine;
import com.hzero.order.domain.repository.SoLineRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (SoLine)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:08:04
 */
@Service
public class SoLineServiceImpl implements SoLineService {
    @Autowired
    private SoLineRepository soLineRepository;
    private SoHeaderRepository soHeaderRepository;

    @Override
    public Page<SoLine> selectList(PageRequest pageRequest, SoLine soLine) {
        return PageHelper.doPageAndSort(pageRequest, () -> soLineRepository.selectList(soLine));
    }

//    @Override
//    public void saveData(List<SoLine> soLines) {
//        soLines.forEach(item -> {
//            if (item.getSoLineId() == null) {
//                soLineRepository.insertSelective(item);
//            } else {
//                soLineRepository.updateByPrimaryKeySelective(item);
//            }
//        });
//    }

    @Autowired
    public SoLineServiceImpl(SoLineRepository soLineRepository) {
        this.soLineRepository = soLineRepository;
    }

    @Override
    public Page<SolineVo> listBySoHeaderId(Long organizationId, SoLine soLine, PageRequest pageRequest) {
        return soLineRepository.listBySoHeaderId(soLine, pageRequest);
    }


    @Override
    public SoLine detail(Long organizationId, Long soLineId) {
        return soLineRepository.selectByPrimaryKey(soLineId);
    }

    @Override
    public SoLine create(Long organizationId, SoLine soLine) {

        soLineRepository.insertSelective(soLine);
        return soLine;
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    public SoLine update(Long organizationId, SoLine soLine) {
        //SecurityTokenHelper.validToken(soLine);
        soLineRepository.updateByPrimaryKeySelective(soLine);
        return soLine;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long organizationId,ItemDTO itemDTO) {

        // 获取行记录
        String hang =itemDTO.getSolineVoList().stream().map(SolineVo::getSoLineId).map(String::valueOf).collect(Collectors.joining(","));
        List<SoLine> soLineList = soLineRepository.selectByIds(hang);
//        SoHeader soHeader=soHeaderRepository.selectByPrimaryKey();

        //获取登录用户并进行校验
        CustomUserDetails self = DetailsHelper.getUserDetails();
        Long userId = self.getUserId(); // 用户ID
        for(SoLine soline:soLineList){
            soLineRepository.deleteByPrimaryKey(soline);

        }
    }
}

