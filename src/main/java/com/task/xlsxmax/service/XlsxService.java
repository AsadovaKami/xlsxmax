package com.task.xlsxmax.service;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class XlsxService {

    public Integer findNthMax(MultipartFile file, Integer n) {
        var numbers = parseNumbers(file);
        return find(numbers, n);
    }

    private List<Integer> parseNumbers(MultipartFile file) {
        var numbers = new ArrayList<Integer>();
        try (
                var inputStream = file.getInputStream();
                var workbook = WorkbookFactory.create(inputStream)
        ) {
            var sheet = workbook.getSheetAt(0);
            for (var row : sheet) {
                for (var cell : row) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        numbers.add((int) cell.getNumericCellValue());
                    }
                }
            }
            return numbers;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка обработки XLSX", e);
        }
    }

    private Integer find(List<Integer> numbers, Integer n) {
        return quickSelect(numbers, 0, numbers.size() - 1, n - 1);
    }

    private Integer quickSelect(List<Integer> numbers, Integer left, Integer right, Integer k) {
        if (left.equals(right)) {
            return numbers.get(left);
        }

        var pivotIndex = partition(numbers, left, right);
        if (k.equals(pivotIndex)) {
            return numbers.get(k);
        } else if (k < pivotIndex) {
            return quickSelect(numbers, left, pivotIndex - 1, k);
        } else {
            return quickSelect(numbers, pivotIndex + 1, right, k);
        }
    }

    private Integer partition(List<Integer> numbers, Integer left, Integer right) {
        var pivot = numbers.get(right);
        var i = left;
        for (var j = left; j < right; j++) {
            if (numbers.get(j) >= pivot) {
                swap(numbers, i, j);
                i++;
            }
        }
        swap(numbers, i, right);
        return i;
    }

    private void swap(List<Integer> numbers, Integer i, Integer j) {
        var temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }
}