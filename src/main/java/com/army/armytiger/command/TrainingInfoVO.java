package com.army.armytiger.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class TrainingInfoVO {
	
	private String p_no;
	private String p_kind;
	private String p_regdate;
	private String p_plantime;
	private String p_playtime;
	private String p_remaintime;
	private String p_result;
	private String p_other;
	private String tp_location;
	private String military_sn;
	

}
