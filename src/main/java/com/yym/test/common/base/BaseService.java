package com.benlai.test.common.base;

import com.benlai.test.common.constants.TestConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Created by yaoyimin on 2018/2/5
 */
@Component
public abstract class BaseService {

	protected String getUserId(){
		String userId = (String) RequestContextHolder.currentRequestAttributes().getAttribute(TestConstants.USER_ID, RequestAttributes.SCOPE_SESSION);
		return StringUtils.isEmpty(userId) ? "system" : userId;
	}

}
