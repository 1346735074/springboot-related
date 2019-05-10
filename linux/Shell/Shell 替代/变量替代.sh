#!/usr/bin/env bash


# ${var} 替换var的值。
# ${var:-word} 如果var为空或未设置，则用word替换var。var的值不变。
echo ${var:-"Variable is not set"}
echo "1 - Value of var is ${var}"



# ${var:=word} 如果var为null或unset，则将var设置为word的值。
echo ${var:="Variable is not set"}
echo "2 - Value of var is ${var}"


# ${var:+word} 如果设置了var，则用word替换var。var的值不变。
unset var
echo ${var:+"This is default value"}
echo "3 - Value of var is $var"


var="Prefix"
echo ${var:+"This is default value"}
echo "4 - Value of var is $var"


# ${var:?message} 如果var为null或未设置，则将消息打印为标准错误。这将检查变量是否设置正确。
echo ${var:?"Print this message"}
echo "5 - Value of var is ${var}"

