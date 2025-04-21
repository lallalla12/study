# 변수 선언
boolVar, intVar, floatVar, strVar = True, 0, 0.0, ""

# 변수 타입
# print(type(boolVar))
# print(type(intVar)) 
# print(type(floatVar))
# print(type(strVar))

# print("안녕하세요?")

# 산술연산자
# a = 5; b = 3
# print(a+b, a-b, a*b, a/b, a//b, a%b, a**b)

# 관계 연산자
# a,b= 100,200
# print(a == b, a !=b, a>b, a<b, a>=b, a<=b)

# 문자열과 숫자의 상호 변환
# s1, s2, s3 = "100", "100.123", "99999999999999999999999"
# print(int(s1)+1 , float(s2)+1, int(s3)+1)
# a = 100; b = 100.123
# print(str(a) + '1');
# print(str(b)+'1')

# if조건문
a = 99;
if a < 100 :
    print("100보다 작군요.")


a = 200

if a < 100 :
    print("100보다 작군요.")
else :
    print("100보다 크군요.") 


# for문
for i in range(0,3,1) :
    print("안녕하세요? for문을 공부중입니다 . ^^")

for i in[0,1,2] :
	print("안녕하세요? for문을 공부중입니다. ^^")
     
# while문
# while True :
#     print("ㅋ", end="")

# break 문
for i in range(1,100) :
     print("for문을 %d번 실행했습니다" %i)
     break

# 리스트의 생성
aa = [10, 20, 30, 40]
print(aa[0])
aa[1] = 200
print(aa[1])

# 리스트 추가
aa = []
aa.append(0)
aa.append(0)
aa.append(0)
aa.append(0)
print(aa)

# len()을 사용하여 리스트의 개수 출력
aa = []
for i in range(0,100) :
     aa.append(0)
print(len(aa))



# 리스트 활용
# 빈 리스트 생성
aa = []
# 4회 반복해서 4개 크기의 리스트, 즉 aa = [0,0,0,0]로 만듬
for i in range(0,4) :
     aa.append(0)

# i가 0부터 3까지 반복하여 차례로 리스트에 변수 대입
for i in range(0,4) : 
     aa[i] = int(input( str(i+1) + "번째 숫자 : "))

# 반복문을 사용해 4개의 리스트 값을 더함
hap = 0
for i in range(0,4) :
     hap = hap + aa[i]

print("합계 ==> %d " % hap)


# 여러 리스트를 동시에 순회하는 zip()함수
foods = ['떡볶이', '짜장면', '라면', '피자', '맥주', '치킨', '삼겹살']
sides = ['오뎅', '단무지', '김치']
for food, side in zip (foods, sides) :
     print(food, ' --> ', side)


foods = ['떡볶이', '짜장면', '라면']
sides = ['오뎅', '단무지', '김치']
tupList = list (zip(foods, sides))
dic = dict (zip(foods, sides))
print(tupList)
print(dic)



# 리스트 조작 함수 활용
myList = [30, 10, 20]
print("현재 리스트 : %s" % myList)

# 리스트 제일 뒤에 항목을 추가
myList.append(40)
print("append(40) 후의 리스트 : %s" % myList)

# 리스트 제일 뒤의 항목을 빼내고 빼낸 항목은 삭제
print("pop()으로 추출한 값 : %s" % myList.pop())
print("pop() 후의 리스트 : %s" % myList)

# 리스트의 항목을 정렬
myList.sort()
print("sort() 후의 리스트 %s" %myList)

# 리스트 항목의 순서를 역순으로 만듬
myList.reverse()
print("reverse() 후의 리스트 : %s" %myList)

# 지정한 값을 찾아서 그 위치를 반환
print("20 값의 위치 : %d " %myList.index(20))

# 지정된 위치에 값을 삽입
myList.insert(2,222)
print("insert(222) 후의 리스트 %s" %myList)

# 리스트에서 지정한 값을 제거, 지정한 값이 여러 개일 경우 첫 번째 값만 지움
myList.remove(222)
print("remove(222) 후의 리스트 : %s" %myList)

# 리스트의 뒤에 리스트를 추가함, 리스트의 더하기(+) 연산과 동일한 기능
myList.extend([77, 88, 77])
print("extend([77,88,77]) 후의 리스트 : %s" %myList )

# 리스트의 해당 값의 개수를 셈
print("77 값의 개수 : %d" %myList.count(77))

ss = "파이썬 최고"
print(ss[0])
print(ss[1:3])
print(ss[3:])

ss = '파이썬' + '최고'
print(ss)
ss = '파이썬' * 3
print(ss)

ss = '파이썬abcd'
print(len(ss))

# 문자열 찾기 함수
ss = '파이썬 공부는 즐겁습니다, 물론 모든 공부가 다 재밌지는 않죠. ^^'
print(ss.count('공부'))
print(ss.find('공부'), ss.rfind('공부'), ss.find('공부',5), ss.find('없다'))
print(ss.index('공부'), ss.rindex('공부'), ss.index('공부',5))
print(ss.startswith('파이썬'), ss.startswith('공부'), ss.endswith('^^'))

ss = 'Python을 열심히 공부 중'
print(ss.split())
ss = '하나:둘:셋'
print(ss.split(':'))
ss = '하나\n둘\n셋'
# 행 단위로 분리시켜줌
print(ss.splitlines())
ss='%'
# 묶여질 구분자를 먼저 ss에 준비한 후 구분자.join('문자열')로 사용
print(ss.join('파이썬'))

# 함수의 기본
## 함수 선언부
def plus(v1, v2) :
    result = 0
    result = v1 + v2
    return result

## 전역 변수부
hap = 0

## 메인 코드
hap = plus(100,200)
print("100과 200의 plus() 함수 결과는 %d" % hap)

# 전역 변수와 지역 변수
def func1() :
    # 지역 변수
    a = 10
    print("func1()에서 a의 값 %d" %a)

def func2() :
    print("func2()에서 a의 값 %d" %a)

## 전역 변수 선언부
# 전역변수
a = 20

## 메인 코드
func1()
func2()
