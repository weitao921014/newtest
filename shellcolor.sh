#!/bin/sh
echo "############################################################"
echo "#                                                          #"
echo "		一个Linux下shell文字颜色测试的脚本"
echo "#                                                          #"
echo "############################################################"
for attr in 0 1 22 4 24 5 25 7 27 ; do
printf "ESC[%s;Foreground;Background : \n" $attr
for fore in 30 31 32 33 34 35 36 37; do
for back in 40 41 42 43 44 45 46 47; do

printf '\033[%s;%s;%sm %02s;%02s;%02s 文字 \033[0m' $attr $fore $back $attr $fore $back
#printf '\033[%s;%s;%sm 文字 \033[0m' $attr $fore $back 

done
printf '\n'
done
printf '\n'
done
