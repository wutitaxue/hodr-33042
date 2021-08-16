package com.hzero.order.app.service.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.SoHeaderRepository;

import com.hzero.order.infra.mapper.SoHeaderMapper;
import org.hzero.boot.imported.app.service.IDoImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;

import com.hzero.order.domain.entity.SoHeader;
@ImportService(templateCode = "HAND_DEMO_33078")
public class IamUserImportServicelmpl implements IDoImportService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SoHeaderRepository soHeaderRepository;
    @Autowired
    private SoHeaderMapper soHeaderMapper;
    @Override
    public Boolean doImport(String data) {
        SoHeader soheader;
        try {
            soheader = objectMapper.readValue(data, SoHeader.class);
        } catch (IOException e) {
            return false;
        }
        soHeaderMapper.insertSelective(soheader);
        return true;
    } }