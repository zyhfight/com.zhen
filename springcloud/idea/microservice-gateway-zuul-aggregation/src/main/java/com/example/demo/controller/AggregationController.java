package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.AggregationService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;

/**
 * @Description: 实现微服务聚合
 * @author: zyh
 * @date: 2018-9-8
 */
@RestController
public class AggregationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AggregationController.class);

    @Autowired
    AggregationService aggregationService;

    @GetMapping("/aggregate/{id}")
    public DeferredResult<HashMap<String,User>> aggregate(@PathVariable Long id){
        Observable<HashMap<String,User>> result = this.aggregateObservable(id);
        return this.toDeferredResult(result);
    }

    /**
     * 合并两个或多个Observables发射出的数据项，根据指定函数变换它们
     * @param id
     * @return
     */
    public Observable<HashMap<String,User>> aggregateObservable(Long id){
        return Observable.zip(
            this.aggregationService.getUserById(id),
                this.aggregationService.getConsumerUserById(id),
                (user,consumerUser) -> {
                    HashMap<String, User> map = Maps.newHashMap();
                    map.put("user", user);
                    map.put("consumerUser", consumerUser);
                    return map;
                }
        );
    }

    public DeferredResult<HashMap<String,User>> toDeferredResult(Observable<HashMap<String,User>> observables){
        DeferredResult<HashMap<String,User>> result = new DeferredResult<>();
        //订阅
        observables.subscribe(new Observer<HashMap<String, User>>() {
            @Override
            public void onCompleted() {
                LOGGER.info("完成。。。");
            }

            @Override
            public void onError(Throwable e) {
                LOGGER.error("发生错误：{}" , e);
            }

            @Override
            public void onNext(HashMap<String, User> detailsMap) {
                result.setResult(detailsMap);
            }
        });
        return result;
    }
}
