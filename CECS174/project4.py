# ask the user for an integer input
num = int(input('Please enter an integer (negative integer to quit): '))
# run the code while the input is a positive integer
while num >= 0:
    # set the input to two separate variables for additive and multiplicative
    num_add = num
    num_multi = num
    # print the first line of output that displays what integer was inputted
    print("For the integer:", num)
    # if the inputted integer is a single digit integer, run the following
    if not (0 <= num <= 9):
        # set additive persistence to zero
        add_persistence = 0
        # while the additive num variable is not single digit, do the following
        while num_add > 9:
            # set additive persistence to add 1 everytime the while loop executes
            add_persistence += 1
            # set the additive root variable to zero
            add_root = 0
            # while the additive num variable is a positive integer run the following
            while num_add > 0:
                # calculate the rightmost digit, then add it to the root variable
                temporary_var1 = num_add % 10
                add_root = add_root + temporary_var1
                # calculate the digits to the left of the rightmost digit
                num_add = num_add // 10
            # set the new lefthand digits to the additive num variable and continue
            num_add = add_root
        # when the previous while loop is finished print the additive persistence
        print("Additive Persistence:", add_persistence, ", Additive Root:", add_root)
        # set the multiplicative persistence to zero
        multi_persistence = 0
        # run the while loop if multiplicative num input is not a single digit integer
        while num_multi > 9:
            # set multiplicative persistence to add 1 everytime the while loop executes
            multi_persistence += 1
            # set the multiplicative root variable to 1
            multi_root = 1
            # while the multiplicative num variable is a positive int run the following
            while num_multi > 0:
                # calculate the rightmost digit, then multiply it with multi. root
                temporary_var2 = num_multi % 10
                multi_root = multi_root * temporary_var2
                # calculate the digits to the left of the rightmost digit
                num_multi = num_multi // 10
            # set the new lefthand digits to the multiplicative num variable and continue
            num_multi = multi_root
        # when the previous while loop is finished calculate the multi. persistence
        print("Multiplicative Persistence: ", multi_persistence, ", Multiplicative Root:", multi_root)
    # if the user enters a single digit integer, print the corresponding root and persistence
    else:
        print("Additive Persistence:", 0, ", Additive Root:", num)
        print("Multiplicative Persistence:", 0, ", Multiplicative Root:", num)
    # after all necessary calculations are printed, ask the user for another integer
    num = int(input('Please enter an integer (negative integer to quit): '))
# if the user enters a negative integer, print a goodbye message
print('Thanks for playing with numbers... Goodbye')
