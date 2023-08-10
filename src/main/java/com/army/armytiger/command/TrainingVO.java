package com.army.armytiger.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingVO {

    private Integer t_no; // 훈련 고유 번호
    private Integer g_no; // 훈련장 고유번호 FK
    private String t_name; // 훈련 명
    private String t_startdate; // 훈련 시작일자
    private String t_enddate; // 훈련 끝 일자
    private String t_time; // 계획 시간
    private String t_other; // 비고
    private String g_img; // 사진 위치
    private String g_name; // 훈련소 명
}
