package com.task.xlsxmax.controllers;

import com.task.xlsxmax.api.XlsxApi;
import com.task.xlsxmax.service.XlsxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class XlsxRestController implements XlsxApi {

    private final XlsxService xlsxService;

    @Override
    public ResponseEntity<Integer> findNthMax(MultipartFile file, Integer n) {
            return ResponseEntity.ok(xlsxService.findNthMax(file, n));
    }
}
