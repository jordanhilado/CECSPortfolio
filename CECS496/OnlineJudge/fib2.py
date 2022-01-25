# sample inputs:
# 10 100
# 1234567890 9876543210
# 0 0

import math
arr = []
nums = 0

def fib(num):
    a = 0
    b = 1
    counter = 0
    if num < 0:
        return 0
    elif num == 0:
        return 0
    elif num == 1:
        return b
    else:
        for i in range(1, num):
            counter = counter + 1
            c = a + b
            a = b
            b = c
        return b

while True:
    x, y =  input().split()
    arr.append(int(x))
    arr.append(int(y))
    if (int(x) == 0) and (int(y) == 0):
        arr.pop()
        arr.pop()
        for i in range(0, len(arr), 2):
            count = 0
            nums = 0
            while True:
                # print("count:", count)
                # print("arr[i]:", arr[i], ", arr[i+1]:", arr[i+1])
                if arr[i] == 0 and arr[i + 1] == 1:
                    nums = 1
                    break
                elif count >= (arr[i] + arr[i + 1]):
                    break
                elif (fib(count) < arr[i]) or (fib(count) == 0 and arr[i] == 0): # fix
                    # print("B")
                    count += 1
                    pass
                elif (fib(count) >= arr[i]) and (fib(count) <= arr[i + 1]):
                    # print("if", fib(count), ">=", arr[i], "and", fib(count), "<=", arr[i+1])
                    # print("C")
                    count += 1
                    nums += 1
                else:
                    # print("D")
                    break
                # print("nums:", nums)
            if arr[i] == 0 and arr[i + 1] > 2:
                nums -= 1
            print(nums)
        break