package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public double addition(double number1, double number2) {
        return number1 + number2;
    }

    @Override
    public double subtraction(double number1, double number2) {
        return number1 - number2;
    }

    @Override
    public double multiplication(double number1, double number2) {
        return number1*number2;
    }

    @Override
    public double division(double number1, double number2) {
        return number1/number2;
    }

    @Override
    public double calculate(double number1, double number2,String calculate) {
        double result = 0;
        switch (calculate){
            case "+":
                result = addition(number1,number2);
                break;
            case "-":
                result = subtraction(number1,number2);
                break;
            case "x":
                result = multiplication(number1,number2);
                break;
            case "/":
                result = division(number1,number2);
                break;
        }
        return result;
    }
}
