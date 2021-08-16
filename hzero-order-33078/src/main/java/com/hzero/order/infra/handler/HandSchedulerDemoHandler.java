package com.hzero.order.infra.handler;

import com.hzero.order.app.service.SoHeaderService;
import org.hzero.boot.message.MessageClient;
import org.hzero.boot.message.entity.Receiver;
import org.hzero.boot.scheduler.infra.annotation.JobHandler;
import org.hzero.boot.scheduler.infra.enums.ReturnT;
import org.hzero.boot.scheduler.infra.handler.IJobHandler;
import org.hzero.boot.scheduler.infra.tool.SchedulerTool;
import com.hzero.order.infra.mapper.SoHeaderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JobHandler("HandSchedulerDemoHandler")
public class HandSchedulerDemoHandler implements IJobHandler {
    @Autowired
    private SoHeaderMapper soHeaderMapper;
    @Autowired
    private MessageClient messageClient;


    @Override
    public ReturnT execute(Map<String, String> map, SchedulerTool tool) {
        tool.updateProgress(1, "任务开始...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tool.updateProgress(50, "任务执行 50%...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Long num = soHeaderMapper.closeOrderStatus();
        if(num >= 0){
            long tenantId = 0L;
            //账户代码
            String serverCode = "HAND_DEMO_006";
            //消息模板代码
            String messageTemplateCode = "HAND_DEMO_007";
            List<Receiver> receiverList = new ArrayList<>();
            Receiver receiver = new Receiver();
            //接受方
            receiver.setEmail("465834429@qq.com");
            receiverList.add(receiver);
            Map<String, String> args = new HashMap<>();
            String context = null;
            args.put("parmA", context);
            messageClient.sendEmail(tenantId, serverCode, messageTemplateCode, receiverList, args, null);
        }
        tool.updateProgress(100, "任务执行完毕...");
        tool.info("任务执行完毕了...");
        return ReturnT.SUCCESS;
    }

    @Override
    public void onCreate(SchedulerTool tool) {
        tool.info("任务执行前置 onCreate...");
    }
    @Override
    public void onException(SchedulerTool tool) {
        tool.info("任务执行错误 onException...");
    }
    @Override
    public void onFinish(SchedulerTool tool, ReturnT returnT) {
        tool.info("任务执行完毕 onFinish...");

    }
}