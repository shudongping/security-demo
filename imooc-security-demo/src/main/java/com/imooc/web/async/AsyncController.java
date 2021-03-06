package com.imooc.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author shudp
 * @create 2017/12/9.
 */
@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHold deferredResultHold;

    @RequestMapping("/order")
    public DeferredResult<String> order() throws Exception {
        logger.info("主线程开始");

        String orderNum = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNum);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHold.getMap().put(orderNum, result);

//        Callable<String> result = new Callable<String>(){
//
//            @Override
//            public String call() throws Exception {
//                logger.info("副线程开始");
//                Thread.sleep(1000);
//                logger.info("副线程返回");
//                return "success";
//            }
//        };

        logger.info("主线程返回");
        return result;
    }

}
