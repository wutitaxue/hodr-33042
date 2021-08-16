package com.hzero.order.app.service.impl;

import com.hzero.order.app.service.CheckService;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.SoHeaderRepository;
import io.choerodon.core.oauth.CustomUserDetails;
import io.choerodon.core.oauth.DetailsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    private SoHeaderRepository soHeaderRepository;

    @Override
    public void update(SoHeader soHeader) {
        SoHeader soHeaderinfo = soHeaderRepository.selectByPrimary(soHeader.getSoHeaderId());
        CustomUserDetails self = DetailsHelper.getUserDetails();
        Long userId = self.getUserId(); // 用户ID
        if (soHeaderinfo == null) {
            throw new RuntimeException("error,没有这个订单");
        }
        if (soHeader.getOrderStatus().equals("SUBMITED")) {
            if (soHeader.getOrderStatus().equals("NEW") || soHeader.getOrderStatus().equals("REJECTED")) {
                throw new RuntimeException("error,当前状态不是提交状态");
            }
            if(!userId.equals(soHeaderinfo.getCreatedBy())){
                throw new RuntimeException("error,您不是订单的创建者");
            }

        } else if (soHeader.getOrderStatus().equals("APPROVED")) {
            if (soHeader.getOrderStatus().equals("SUBMITED")) {
                throw new RuntimeException("error,当前状态不是审批状态");
            }


        } else if (soHeader.getOrderStatus().equals("REJECTED")) {
            if (soHeader.getOrderStatus().equals("SUBMITED")) {
                throw new RuntimeException("error,当前状态不是拒绝状态");
            }
        }
        soHeaderRepository.updateByPrimaryKey(soHeaderinfo);
    }
}
