num = int(input())
stacks = str(input())
end = int(input())
total = 0
moves = 0

if end != 0:
    print("Error, you have inputted more than", num, "stacks.")
    exit()

for i in range(0, len(stacks), 2):
    total += int(stacks[i])
height = int(total / num)

for i in range(0, len(stacks), 2):
    if int(stacks[i]) > height:
        moves += int(stacks[i]) - height
print("The minimum number of moves is", moves)
