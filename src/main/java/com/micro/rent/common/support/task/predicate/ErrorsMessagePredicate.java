package com.micro.rent.common.support.task.predicate;

import com.micro.rent.common.support.task._enum.MessageType;

/**
 * @Description error消息条件
 * @author caobin
 * @date 2012-11-26
 * @version 1.0
 */
public class ErrorsMessagePredicate extends BaseTaskPredicate {

	@Override
	public boolean evaluate(Object object) {
		String messageType = this.toMessageTaskContext(object).getMessageType();
		return MessageType.ERRORS_TYPE.getCode().equals(messageType);
	}

}
