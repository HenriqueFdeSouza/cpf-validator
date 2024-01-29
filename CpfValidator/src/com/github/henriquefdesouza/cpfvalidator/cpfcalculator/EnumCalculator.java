package com.github.henriquefdesouza.cpfvalidator.cpfcalculator;

public enum EnumCalculator {

    FIRST_DIGIT() {
        @Override
        public CpfCalculator extractCpfAndArray(String cpf) {
            return new CpfCalculator(cpf.substring(0, 9), new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2});
        }
    },
    SECOND_DIGIT() {
        @Override
        public CpfCalculator extractCpfAndArray(String cpf) {
            return new CpfCalculator(cpf.substring(0, 10), new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2});
        }
    };
    public abstract CpfCalculator extractCpfAndArray(String cpf);
}