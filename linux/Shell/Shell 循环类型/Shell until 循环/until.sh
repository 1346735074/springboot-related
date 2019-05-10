#!/usr/bin/env bash

a=0

# 如果结果值是false
until [ ! $a -lt 10 ] ; do
    echo $a
    # 执行a+1
    a=`expr $a + 1`
done