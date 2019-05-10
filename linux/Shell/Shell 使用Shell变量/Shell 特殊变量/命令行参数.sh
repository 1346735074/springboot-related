#!/usr/bin/env bash

# $0 当前脚本的文件名。
# $n 这些变量对应于调用脚本时使用的参数。这里n是一个与参数位置对应的正十进制数(第一个参数是$1，第二个参数是$2，依此类推)。
# $# 提供给脚本的参数数。
# $* 所有的参数都是双引号。如果脚本收到两个参数，$*就等于$1 $2。
# $@ 所有参数都单独双引号。如果脚本收到两个参数，$@就等于$1 $2。
# $? 执行的最后一条命令的退出状态。
# $$ 当前shell的进程号。对于shell脚本，这是它们执行的进程ID。
# $! 最后一个后台命令的进程号。



# 下面的脚本使用命令行相关的各种特殊变量
echo "File Name: $0"
echo "First Parameter : $1"
echo "First Parameter : $2"
echo "Quoted Values: $@"
echo "Quoted Values: $*"
echo "Total Number of Parameters : $#"