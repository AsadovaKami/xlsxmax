package com.task.xlsxmax.utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;

public class TestUtils {

    public static byte[] createTestExcel(Integer[] numbers) throws Exception {
        try (
                var workbook = new XSSFWorkbook();
                var outputStream = new ByteArrayOutputStream()
        ) {
            var sheet = workbook.createSheet("Numbers");
            for (var i = 0; i < numbers.length; i++) {
                var row = sheet.createRow(i);
                row.createCell(0).setCellValue(numbers[i]);
            }
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }
}
