# Jordan Hilado
# 027460119
# CECS 100 Lab Section 15
# Lab Assignment #6
# Due Date November 9, 2020

# Lab Assignment #6 Code
# set a counter variable to 1
user_num = 1
# set a counter variable to 0
total = 0
# while loop that iterates if user_num is greater than 0
while user_num > 0:
    # ask the user for a positive number
    user_num = int(input("Enter a positive number: "))
    # check if number is greater than 0
    if user_num > 0:
        # if the number is greater than 0 then add to total counter
        total += user_num
# display the total if the while loop does not occur
print(total)