package com.sankuai.inf.leaf.facadeimpl;

import com.alibaba.cola.dto.SingleResponse;
import com.sankuai.inf.leaf.IdGeneratorType;
import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.common.Status;
import com.sankuai.inf.leaf.dto.Id;
import com.sankuai.inf.leaf.facade.IdGenerateFacade;
import com.sankuai.inf.leaf.service.SegmentService;
import com.sankuai.inf.leaf.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class IdGenerateFacadeImpl implements IdGenerateFacade {

    @Autowired
    private SegmentService segmentService;
    @Autowired
    private SnowflakeService snowflakeService;

    @Override
    public SingleResponse<Id> getId(String key, IdGeneratorType type) {
        if (StringUtils.isEmpty(key)) {
            return SingleResponse.of(new Id(null, false));
        }
        Result result;
        switch (type) {
            case SEGMENT:
                result = segmentService.getId(key);
                break;
            default:
            case SNOWFLAKE:
                result = snowflakeService.getId(key);
                break;
        }
        if (null == result || result.getStatus().equals(Status.EXCEPTION)) {
            return SingleResponse.of(new Id(null, false));
        }
        return SingleResponse.of(new Id(result.getId(), true));
    }
}
