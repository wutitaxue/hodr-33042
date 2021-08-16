package com.hzero.order.domain.DTO;

import com.hzero.order.domain.vo.SolineVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;
import java.util.List;

public class ItemDTO {
    public List<SolineVo> getSolineVoList() {
        return solineVoList;
    }

    public void setSolineVoList(List<SolineVo> solineVoList) {
        this.solineVoList = solineVoList;
    }

    @ApiModelProperty(value = "soline")
    private List<SolineVo> solineVoList;



}
