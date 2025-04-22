# 1번
nums = [1, 2, 3, 4, 5, 6]

for i in nums :
    if i % 2 == 0 : 
        print(i)

# 2번
chars = ('a', 'b', 'c', 'A', 'B')
for i in chars :
    if i.isupper():
        print(i)


# 3번
scores = {'math': 90, 'english': 45, 'science': 60}
for i in scores.values() :
    if i > 50 :
        print(i)


# 4번
sum = 0
numbers = [10, 20, 30, 40]
for i in numbers :
    sum = sum + i
print(sum)



# 5번
even_nums=[]
t = (1, 2, 3, 4, 5)
for i in t :
    if i % 2 == 0 :
        even_nums.append(i)
print(even_nums)


# 6번
num = 0
data = {'a': 100, 'b': 200, 'c': 150} 
for i in data.values()  :
    if num < i :
        num = i
print(num)

# 7번
count = 0
nums = [3, 6, 9, 10, 12, 13]
for i in nums :
    if i % 3 == 0 :
        count = count+1
print(count)

# 8번
students = (("Tom", 90), ("Jane", 70), ("Lee", 80))
for i in range(0,len(students)) :
    if students[i][1] >= 80 :
        print(students[i])

# 9번
fruit = {'apple': 3, 'banana': 2}
for key,value in fruit.items() :
    print(value, "개의" , key)

# 10번
nested = [[1, 2], [3, 4], [5, 6]]
for i in nested :
    for j in i :
        print(j,end='')


