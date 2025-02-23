package com.task.xlsxmax.controllers;


import com.task.xlsxmax.utils.TestUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class XlsxRestControllerTest {

    @Autowired
    private XlsxRestController xlsxRestController;

    @Test
    void testFindNthMax() throws Exception {
        var excelData = TestUtils.createTestExcel(new Integer[]{15, 5, 55, 25, 35, 45});
        var file = new MockMultipartFile("file", "test.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", excelData);
        var resp = xlsxRestController.findNthMax(file, 3);
        assertEquals(resp.getBody(), 35);
    }
}