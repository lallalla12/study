# 리스트 - 수정가능
# [값1, 값2, 값3]
a = []

b = [1,2,3]
print(b)        # [1, 2, 3]
print(b[0])     # 1출력
print(b[1])     # 2출력
print(b[2])     # 3출력
b[1] = 4
print(b)        # [1, 4, 3]
# 음수도 들어감
print(b[-3])    # 1 출력
print(b[-2])    # 4 출력
print(b[-1])    # 3 출력


print("---------리스트 for문---------")

# b리스트에 for문
for i in b :
    print("리스트 b에 대한 반복 결과 : ",i)



print("------------------")

c = ['a', 'b', 'c']
print(c[0])     # a출력
print(c[1])     # b출력
print(c[2])     # c출력

for i in c :
    print("리스트 c에 대한 반복 결과", i)

print("------------------")

d = [1,2,'a','b']
print(d[0])     # 1 출력
print(d[1])     # 2 출력
print(d[2])     # a 출력
print(d[3])     # b 출력
print("슬라이싱 : " , d[1:3])       # 1부터 2까지 슬라이싱

for i in d :
    print("리스트 d에 대한 반복 결과", i)

print("------------------")

e = [1,2,['a','b']]
print(e[0])     # 1 출력
print(e[1])     # 2 출력
print(e[2])     # ['a','b']출력
print(e[2][0])  # a 출력
print(e[2][1])  # b 출력

for i in e :
    print("리스트 e에 첫번째 반복 결과", i)
    if isinstance(i,list) : # i변수에 list자료형이 있는지 확인, 있으면 true, 없으면 false
        for j in i :
            print("리스트 e에 두번째 반복 결과", j)

print("------------------")

f = list()       # 빈 리스트
g = list([1,2,3])  # [1,2,3]
print(f)
print(g)

print("--------튜플----------")

# 튜플 - 수정 불가능
#(값1, 값2, 값3)

a = ()          # 빈 튜플
b = (1,2,3)     
print(b)        # (1, 2, 3)
print(b[0])     # 1 출력
print(b[1])     # 2 출력
print(b[2])     # 3 출력

for i in b :
    print("b튜플의 결과", i)


print("------------------")


c = ('a', 'b', 'c')
print(c[0])     # a출력
print(c[1])     # b출력
print(c[2])     # c출력


for i in c :
    print("c튜플의 결과", i)

print("------------------")

d = (1,2,'a','b')
print(d[0])     # 1 출력
print(d[1])     # 2 출력
print(d[2])     # a 출력
print(d[3])     # b 출력


for i in d :
    print("d튜플의 결과", i)

print("------------------")

e = (1,2,('a','b'))
print(e[0])     # 1 출력
print(e[1])     # 2 출력
print(e[2])     # ('a','b')출력
print(e[2][0])  # a 출력
print(e[2][1])   # b 출력

for i in e :
    print("튜플 e에 첫번째 반복 결과", i)
    if isinstance(i,list) : # i변수에 list자료형이 있는지 확인, 있으면 true, 없으면 false
        for j in i :
            print("튜플 e에 두번째 반복 결과", j)

f = tuple()         # 빈 튜플
g = tuple([1,2,3])  # 리스트 -> 튜플
print(f)
print(g)

print("---------딕셔너리---------")

# 딕셔너리
# {키:값1, 키2:값2, 키3:값3}
a = {"name" : "홍길동", "age" : 30, "country" : "korea"}
print(a)
# 추가
a["phone"] = "010-1111-2222"
print(a)
# 삭제
del a["age"]
print(a)

# 홍길동 출력
print(a["name"])
# korea 출력
print(a["country"])
# 010-1111-2222 출력
print(a["phone"])

# a 딕셔너리에 어떤 키가 있는지 확인
print(a.keys())
# a 딕셔너리에 어떤 값이 있는지 확인
print(a.values())
# a 딕셔너리에 키와 값의 쌍을 확인
print(a.items())


for i in a.keys() :
    print("딕셔너리의 값",i)

for i in a.values() :
    print("딕셔너리 키의 대한 값",i)

for key,value in a.items() :
    print("딕셔너리 키와 값의 쌍의 결과",key,":",value)