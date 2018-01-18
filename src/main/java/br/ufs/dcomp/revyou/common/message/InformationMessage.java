package br.ufs.dcomp.revyou.common.message;

import java.util.HashMap;
import java.util.Map;

import br.ufs.dcomp.revyou.enums.MessageEnum;

public class InformationMessage extends Message {

	private Map<Integer, String> messageMap = new HashMap<Integer, String>();

	public InformationMessage(Integer code, String description) {
		super(MessageEnum.INFORMATION, code, description);
		messageMap.put(code, description); // TODO For validity in tests.
	}

}
