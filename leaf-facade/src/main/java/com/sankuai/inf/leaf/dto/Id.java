package com.sankuai.inf.leaf.dto;

import com.alibaba.cola.dto.DTO;

public class Id extends DTO {

    private Long Id;

    private Boolean success;

    public Id() {
    }

    public Id(Long id, Boolean success) {
        Id = id;
        this.success = success;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
