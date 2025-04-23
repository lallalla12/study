# 본인 이름을 화면에 출력하는 print_name 함수를 정의
def print_name() :
    print("정현정")

# 1번에서 정의한 함수를 호출
print_name()

# 1번에서 정의한 print_name 함수를 100번 호출
for i in range(0,100):
    print_name()

# 에러가 발생하는 이유

# hello()
#def hello():
#   print("Hi") 선언이 위에 있어서 ,,

# 함수의 호출 예측
# def add(a,b) :
#   print(a+b)

# add(3,4) 7
# add(7,8) 15



