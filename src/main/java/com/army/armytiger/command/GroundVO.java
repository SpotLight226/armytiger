package com.army.armytiger.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroundVO {

    private Integer g_no; // 고유번호 pk
    private String g_name; // 훈련장 명
    private String gungu; // 군구
    private String attmpt; // 시도
    private String addr; // 주소
    private String g_img; // 약도 이미지 src
    private String telno; // 전화번호
}
