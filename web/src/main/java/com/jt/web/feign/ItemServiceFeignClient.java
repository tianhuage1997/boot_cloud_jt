package com.jt.web.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("server-manager")
public interface ItemServiceFeignClient {

      @RequestMapping(value = "item/itemById" ,method = RequestMethod.GET)
      String  queryItemByItemId(@RequestParam(value = "itemId")  String itemId);
}
