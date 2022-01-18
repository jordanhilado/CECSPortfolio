# sets a variable to 'y' for user who wants to continue
x = 'y'
# while loop for user who wants to continue
while (x == 'y'):
    # asks the user for the first number
    num1 = int(input("First number: "))
    # asks the user for the second number
    num2 = int(input("Second number: "))
    # calculates the sum
    answer = num1 + num2
    # print the sum of the two numbers
    print("The sum of the two numbers is " + str(answer) + ".")
    # ask the user if they want to continue or not
    x = input("Do you want to continue? (y/n) ")
