package com.sankuai.inf.leaf.facade;

import com.sankuai.inf.leaf.IdGeneratorType;
import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.common.Status;
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
    public long getId(String isNamespace, IdGeneratorType type) {
        if (StringUtils.isEmpty(isNamespace)) {
            throw new IllegalArgumentException("Parameter 'isNamespace' must be not null");
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
        if (null == result || result.getStatus() == Status.EXCEPTION) {
            throw new IllegalStateException("Id generate failed,result is null");
        }
        return result.getId();
    }
}
