package com.github.henriquefdesouza.cpfvalidator.cpfcalculator;

import com.github.henriquefdesouza.cpfvalidator.exception.CpfInvalidException;

public class CpfCalculator {
    private final String digitsCpf;
    private final int[] array;

    public CpfCalculator(String digitsCpf, int[] array) {
        this.digitsCpf = digitsCpf;
        this.array = array;
    }

    public static int calculatorDigitsCpf(String cpf, EnumCalculator enumCalculator) {
        int sumDigits = 0;
        CpfCalculator cpfCalculator = enumCalculator.extractCpfAndArray(cpf);
        for (int i = 0; i < cpfCalculator.digitsCpf.length(); i++) {
            sumDigits += Integer.parseInt(cpfCalculator.digitsCpf.substring(i, i + 1)) * cpfCalculator.array[i];
        }
        return sumDigits % 11 == 0 || sumDigits % 11 == 1 ? 0 : 11 - sumDigits % 11;
    }

    public static boolean checkFullCpf(String cpf){
        if(!cpf.matches("(\\d{11})")){
            throw new CpfInvalidException("Cpf not has 11 digits!");
        }
        return calculatorDigitsCpf(cpf, EnumCalculator.FIRST_DIGIT) == Integer.parseInt(cpf.substring(9, 10)) ||
                calculatorDigitsCpf(cpf, EnumCalculator.SECOND_DIGIT) == Integer.parseInt(cpf.substring(10,11));
    }

}