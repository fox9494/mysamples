package com.openframe.sysmanager.web.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import com.openframe.sysmanager.domain.Role;

public class RoleValidator {
	


    public void validate(Role role, Errors errors) {
    	String name = role.getRoleName();
    	if (!StringUtils.hasLength(name)) {
            errors.rejectValue("roleName", "required", "角色名称不能为空");
        }
    	
    }




}
