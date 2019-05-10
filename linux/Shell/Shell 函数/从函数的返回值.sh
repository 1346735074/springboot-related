#!/usr/bin/env bash

# Define your function here
Hello () {
   echo "Hello World $1 $2"
   return 10
}

# Invoke your function
Hello Zara Ali

# 通过最后一个命令捕获值returnd
ret=$?

echo "Return value is $ret"

