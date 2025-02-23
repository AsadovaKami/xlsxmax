package com.task.xlsxmax.services;

import com.task.xlsxmax.service.XlsxService;
import com.task.xlsxmax.utils.TestUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XlsxServiceTest {

    private final XlsxService xlsxService;

    public XlsxServiceTest() {
        this.xlsxService = new XlsxService();
    }

    @Test
    void testFindNthMax() throws Exception {
        var excelData = TestUtils.createTestExcel(new Integer[]{20, 50, 10, 70, 5});
        var file = new MockMultipartFile("file",
                "test.xlsx",
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                excelData);

        var result = xlsxService.findNthMax(file, 3);
        assertEquals(20, result);
    }

    @Test
    void testFindNthMaxWithInvalidFile() {
        var invalidFile = new MockMultipartFile("file", new byte[]{});
        assertThrows(RuntimeException.class, () -> xlsxService.findNthMax(invalidFile, 2));
    }
}
