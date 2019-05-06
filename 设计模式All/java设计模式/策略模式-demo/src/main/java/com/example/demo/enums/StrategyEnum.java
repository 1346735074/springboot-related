package com.example.demo.enums;

import lombok.Data;
import lombok.Getter;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2018/11/26 17
 * @description
 */
public enum StrategyEnum {
    ADD("+") {
        @Override
        public int exec(int a, int b) {
            return a+b;
        }
    },
    SUB("-") {
        @Override
        public int exec(int a, int b) {
            return a-b;
        }
    },
    MUTI("*") {
        @Override
        public int exec(int a, int b) {
            return a*b;
        }
    };

    StrategyEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public abstract int exec(int a, int b);
}


