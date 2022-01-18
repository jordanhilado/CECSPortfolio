# Jordan Hilado
# 027460119
# CECS 100 Lab Section 15
# Lab Assignment #8
# Due Date November 23, 2020

# Lab Assignment #8 Code:
# import module 'random'
import random

# set global variable 'nums'
global nums

# define the main function
def main():
    # set variables equal to the two calling functions
    num_1 = num1()
    num_2 = num2()
    # print the two generated numbers in an equation
    print(str(num_1) + " + " + str(num_2) + " = ")
    # set the answers to a variable
    answer = num_1 + num_2
    # ask the user for the answer
    user_input = int(input())
    # if answer is wrong, tell the user the answer
    if answer != user_input:
        print("Incorrect. The answer is: ", answer)
    # if the user is correct, congratulate them
    else:
        print("Congrats! That is correct! (:")

# define the first number's function
def num1():
    # set the random number to a variable
    num = random.randint(100, 1000)
    # return the generated number
    return num

# define the second number's function
def num2():
    # set the random number to a variable
    num = random.randint(100, 1000)
    # return the generated number
    return num

# call the main function
main()

# computer generated output:

# 456 + 942 = 
# 1398
# Congrats! That is correct! (:

# 373 + 935 = 
# 1
# Incorrect. The answer is:  1308