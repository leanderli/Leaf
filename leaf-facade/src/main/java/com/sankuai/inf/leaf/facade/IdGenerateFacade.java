package com.sankuai.inf.leaf.facade;

import com.sankuai.inf.leaf.IdGeneratorType;

public interface IdGenerateFacade {

    long getId(String isNamespace, IdGeneratorType type);
}
