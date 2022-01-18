import math

def fib(k):
    n = int(k)
    a = 0
    b = 1
    counter = 0
    if n < 0:
        return 0
    elif n == 0:
        return 0
    elif n == 1:
        return b
    else:
        for i in range(1, n):
            counter = counter + 1
            c = a + b
            a = b
            b = c
        return b

print(fib(0))
print(fib(1))


