package com.army.armytiger.controller;

import com.army.armytiger.ajax.service.AjaxService;
import com.army.armytiger.command.GroundVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AjaxController {

    @Autowired
    private AjaxService ajaxService;

    // 카테고리 설정
    @GetMapping("/getGround")
    public ResponseEntity<ArrayList<GroundVO>> getGround() {
        return new ResponseEntity<>(ajaxService.getGround(), HttpStatus.OK);
    }

    // 하위 카테고리
    @GetMapping("/getGroundChild1/{a}")
    public ResponseEntity<ArrayList<GroundVO>> getGroundChild1(@PathVariable("a") String attmpt){

        GroundVO vo = GroundVO.builder().attmpt(attmpt).build();
        ArrayList<GroundVO> list = ajaxService.getGroundChild1(vo);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 2차 카테고리
    @GetMapping("/getGroundChild1/{a}/{b}")
    public ResponseEntity<ArrayList<GroundVO>> getGroundChild2(@PathVariable("a") String attmpt,
                                                               @PathVariable("b") String gungu ){

        GroundVO vo = GroundVO.builder().attmpt(attmpt).gungu(gungu).build();
        ArrayList<GroundVO> list = ajaxService.getGroundChild2(vo);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/setImg/{a}")
    public ResponseEntity<String> setImg(@PathVariable("a") String g_no){

        String src = ajaxService.setImg(g_no);
        return new ResponseEntity<>(src, HttpStatus.OK);
    }
}
