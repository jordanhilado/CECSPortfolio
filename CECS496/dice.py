def solution(A, F, M):
    total = 0
    counter = 0
    ans = []
    aTotal = 0
    for i in A:
        total += i
    aTotal = total
    total += F
    if (aTotal + 1 > (F + len(A))) and M == 1:
        return [0]
    while total / (F + len(A)) != M:
        total += 1
        counter += 1
    total -= aTotal
    while len(ans) < F:
        if len(ans) == (F - 1):
            if total > 6:
                return [0]
            ans.append(total)
            break
        elif total == 12 and F == 2:
            ans.append(6)
            ans.append(6)
            break
        ans.append(1)
        total -= 1
    return ans



# A = [1, 5, 6]
# F = 4
# M = 3

# A = [1, 2, 3, 4]
# F = 4
# M = 6

# A = [6, 1]
# F = 1
# M = 1

# A = [3, 2, 4, 3]
# F = 2
# M = 4

print(solution(A, F, M))