package com.yun.yscdserviceuser;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yun
 * @createdOn: 2018/6/28 09:40.
 */

@RestController()
@RequestMapping(value = "api/v1/test")
public class TestController {

    // region --Field

    // endregion

    // region --Constructor

    // endregion

    // region --static method

    // endregion   

    // region --Getter and Setter

    // endregion

    // region --Public method

    @RequestMapping(value = {"/{cId}"}, method = RequestMethod.GET)
    public Object getAll(@PathVariable("cId") String cId) {
        return "sdad" + cId;
    }

    // endregion

    // region --private method

    // endregion

    // region --Other

    // endregion
}
