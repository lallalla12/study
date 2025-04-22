# 1번
person = {'name': '홍길동', 'age': 30, 'country': 'korea'}
print(person)


# 2번
print(person["name"])

# 3번
person["age"] = 20
print(person)

# 4번
person["number"] = "010-1234-5678"

# 5번
del person["age"]
print(person)

# 6번
info = {'a': 1, 'b': 2, 'c': 3}
print(info.keys())

# 7번
info = {'a': 1, 'b': 2, 'c': 3}
print(info.values())

# 8번
for key,value in info.items() : 
    print(key, "->", value)

# 9번
score = {'math': 90}
print('english' in score)

# 10번
data = list({'x': 1, 'y': 2})
print(data)
