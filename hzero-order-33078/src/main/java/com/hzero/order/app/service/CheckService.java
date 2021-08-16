package com.hzero.order.app.service;

import com.hzero.order.domain.entity.SoHeader;
import org.springframework.stereotype.Service;

@Service
public interface CheckService {
    void update(SoHeader soHeader);
}
