package com.sankuai.inf.leaf.facade;

import com.alibaba.cola.dto.SingleResponse;
import com.sankuai.inf.leaf.IdGeneratorType;
import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.service.SegmentService;
import com.sankuai.inf.leaf.service.SnowflakeService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@DubboService
public class IdGenerateFacadeImpl implements IdGenerateFacade {

    @Autowired
    private SegmentService segmentService;
    @Autowired
    private SnowflakeService snowflakeService;

    @Override
    public SingleResponse getId(String isNamespace, IdGeneratorType type) {
        if (StringUtils.isEmpty(isNamespace)) {
            return SingleResponse.buildFailure("400", "Parameter 'isNamespace' must be not null");
        }
        Result result;
        switch (type) {
            case SEGMENT:
                result = segmentService.getId(isNamespace);
                break;
            default:
            case SNOWFLAKE:
                result = snowflakeService.getId(isNamespace);
                break;
        }
        return SingleResponse.of(result);
    }
}
