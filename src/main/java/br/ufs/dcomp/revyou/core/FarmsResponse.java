package br.ufs.dcomp.revyou.core;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.ResponseEntity;

import br.ufs.dcomp.revyou.common.message.ErrorMessage;
import br.ufs.dcomp.revyou.common.message.InformationMessage;
import br.ufs.dcomp.revyou.common.message.SuccessMessage;

@XmlRootElement
public class FarmsResponse {

	public FarmsResponse() {
	}

	public static ResponseEntity<?> ok(SuccessMessage message) {
		return ResponseEntity.ok(message);
	}

	public static ResponseEntity<?> ok(Object object) {
		return ResponseEntity.ok(object);
	}

	public static ResponseEntity<?> ok(SuccessMessage message, Object data) {
		message.setData(data);
		return ResponseEntity.ok(message);
	}

	public static ResponseEntity<?> error(ErrorMessage message) {
		return ResponseEntity.ok(message);
	}

	public static ResponseEntity<?> info(InformationMessage message) {
		return ResponseEntity.ok(message);
	}
}
