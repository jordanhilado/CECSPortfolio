# Jordan Hilado
# 027460119
# In Lab Assignment # 5

# In Lab Assignment # 5 Code:
# create an empty list
userlist = []
# define the main function and call the other functions inside
def main():
    ask()
    display()
# define the display function
def display():
    # low will find the minimum value in the list
    low = min(userlist)
    # high will find the minimum value in the list
    high = max(userlist)
    # total will be the accumulator
    total = 0
    # for loop to find the average in the list
    for i in range(0, len(userlist)):
        # total is the accumulator
        total += userlist[i]
        avg = total / len(userlist)
    # displays all the necessary output for the user to know about the list
    print("The list is: ", userlist)
    print("The lowest number in the list is: ", low)
    print("The highest number in the list is: ", high)
    print("The total of the numbers in the list is: ", total)
    print("The average of the numbers in the list is: ", avg)
# define the ask function
def ask():
    # while the length of the userlist is not equal to 10
    while len(userlist) != 10:
        # ask the user for a number input
        num = int(input("Enter a number: "))
        # if the number is not in the list, append the list with the value
        if num not in userlist:
            userlist.append(num)
        # if the number is in the list ask the user to enter another number
        else:
            print("Choose another number:")


main()