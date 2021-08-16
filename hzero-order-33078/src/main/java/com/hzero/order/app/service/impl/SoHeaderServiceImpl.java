package com.hzero.order.app.service.impl;


import com.hzero.order.infra.constant.Constants;
import com.hzero.order.infra.mapper.SoHeaderMapper;
import io.choerodon.core.domain.Page;
import io.choerodon.core.exception.CommonException;
import io.choerodon.core.oauth.CustomUserDetails;
import io.choerodon.core.oauth.DetailsHelper;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.apache.ibatis.annotations.Mapper;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.boot.workflow.WorkflowClient;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.hzero.order.app.service.SoHeaderService;
import org.springframework.stereotype.Service;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.SoHeaderRepository;

import java.util.List;
import java.util.Map;

/**
 * 销售订单头信息(SoHeader)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:07:12
 */
@Service

public class SoHeaderServiceImpl implements SoHeaderService {
    @Autowired
    private SoHeaderRepository soHeaderRepository;
    @Autowired
    private SoHeaderMapper soHeaderMapper;
    @Autowired
    private CodeRuleBuilder codeRuleBuilder;
    @Autowired
    private WorkflowClient workflowClient;

    @Override
    public Page<SoHeader> selectList(PageRequest pageRequest, SoHeader soHeader) {
        return PageHelper.doPageAndSort(pageRequest, () -> soHeaderRepository.selectList(soHeader));
    }

    @Override
    public void saveData(SoHeader soHeader) {
        // List<SoHeader> soHeaderinfo = soHeaderRepository.selectByPrimary(soHeaders.);
//        soHeaders.forEach(item -> {
//            if (item.getSoHeaderId() == null) {
//                soHeaderRepository.insertSelective(item);
//            } else {
//                soHeaderRepository.updateByPrimaryKeySelective(item);
//            }
        soHeader.setOrderNumber(codeRuleBuilder.generateCode("HZERO.33078.ORDER.NUMBER", (Map) null));
        soHeaderRepository.insertSelective(soHeader);
    }


    @Override
    public SoHeader update(Long organizationId, SoHeader soHeader) {
        SoHeader soHeader1 = soHeaderRepository.selectByPrimary(soHeader.getSoHeaderId());
        SoHeader soHeader2 = soHeaderRepository.selectOne(soHeader);
        System.out.println(soHeader1.toString()+"====================================");
        if ("NEW".equals(soHeader1.getOrderStatus()) ||
            "REJECTED".equals(soHeader1.getOrderStatus()) ){

            if (!DetailsHelper.getUserDetails().getUserId().equals(soHeader1.getCreatedBy())) {
                System.out.println(DetailsHelper.getUserDetails().getUserId()+"==========================");
                System.out.println("soHeader1.getCreatedBy()="+soHeader1);
                throw new CommonException("error,不是创建人");
            }
            soHeaderRepository.updateByPrimaryKey(soHeader);

        } else {
            throw new CommonException("error,当前状态不是新建或已拒绝状态，编辑失败");
        }


            return soHeader;
        }

        @Override
        public void orderStartWorkFlow (Long organizationId, String soHeaderId){

        }


    }
