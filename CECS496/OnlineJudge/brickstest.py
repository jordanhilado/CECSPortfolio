arr = ['6', '5 2 4 1 7 5', '4', '1 1 3 3', '5', '5 5 5 5 5', '6', '1 1 1 1 1 19', '0']
for i in range(len(arr)):
    if (i % 2 != 0):
        arr[i] = arr[i].split(' ')

for i in range(len(arr)):
    stacks = 0
    total = 0
    moves = 0
    if (i % 2 == 0) and (i != (len(arr) - 1)):
        stacks = arr[i]
        for k in range(0, len(arr[i + 1]), 1):
            if arr[i + 1][k] != " ":
                total += int(arr[i + 1][k])
            else:
                pass
        height = total / int(stacks)
        for k in range(0, len(arr[i + 1]), 1):
            if arr[i + 1][k] != " ":
                if int(arr[i + 1][k]) > int(height):
                    moves += int(arr[i + 1][k]) - height
            else:
                pass
    else:
        continue
    print("The minimum number of moves is", int(moves))
