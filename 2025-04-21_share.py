# 1번
print("Hello World")
# 2번
print("Mar's consmetics")
# 3번
print("신씨가 소리질렀다 \"도둑이야\"")
# 4번
print("안녕하세요\n 만나서 \t\t 반갑습니다.")
# 5번
print("오늘은","일요일")
# 6번
print("first",end=''); print("second")
# 7번
print(str("720")+"1")
# 8번
print(int("720")+1)
# 9번
print(str("15.79")+"10")
# 10번
print(float("15.79")+10)
# 11번
a, b = 48584,36
print(a*b)
# 12번
num = eval(input("점수를 입력하세요 ==> "))
if 81 < num :
    print("A")
elif 61 < num :
    print("B")
elif 41 < num :
    print("C")
elif 21 < num :
    print("D")
else :
    print("E")

sum = 0;
for i in range(1,101) :
    sum = sum + i;
print(sum)