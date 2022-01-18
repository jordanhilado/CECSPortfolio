# define 3 variables - 'gallons_used', 'billed', and 'running'
gallons_used = 0
billed = 0
running = 'y'
# define the constants
residential_perGallon = 0.0005
flatRate_1k = 1000
flatRate_2k = 2000
additional_rate = 0.00025
minMeter = 000000000
maxMeter = 999999999
gallons_4mil = 4000000
# run the program if the running variable is equivalent to 'y' or 'Y'
while running == 'y' or running == 'Y':
    # ask the user for input and initialize the input to the 'code' variable
    code = input("Customer code: ")
    # if the code is not any of the valid codes, then print an error and ask again
    while not (code == 'r' or code == 'R' or code == 'I' or code == 'i' or code == 'C' or code == 'c'):
        print("Invalid Entry try again, please enter")
        code = input("Customer code: ")
    # if the code is one of the valid codes, then ask for new input
    if (code == 'r' or code == 'R' or code == 'I' or code == 'i' or code == 'C' or code == 'c'):
        # ask the user for the beginning meter reading and initialize the input to variable 'beginning'
        beginning = int(input("Beginning meter reading: "))
        # if the variable is not within the parameters, display an error and ask again
        while not (minMeter <= beginning <= maxMeter):
            print("Invalid Entry try again, please enter")
            beginning = int(input("Beginning meter reading: "))
        # if the 'beginning' variable is within the parameters, then ask for a new input
        if (minMeter <= beginning <= maxMeter):
            # ask the user for the ending meter reading and initialize the input into the 'end' variable
            end = int(input("Ending meter reading: "))
            # if the variable is not within the parameters, display an error and ask again
            while not (minMeter <= end <= maxMeter):
                print("Invalid Entry try again, please enter")
                end = int(input("Ending meter reading: "))
            # if the 'end' variable is within the parameters, run the continuing body of statements
            if (minMeter <= end <= maxMeter):
                # if it is a residential code, then run the following statements
                if (code == 'r' or code == 'R'):
                    # if the ending reading is larger than the beginning reading, find gallons_used
                    if end > beginning:
                        gallons_used = (end - beginning) / 10
                    # if beginning reading is larger than the ending reading, find gallons_used
                    else:
                        gallons_used = (1000000000 - (beginning - end)) / 10
                    # calculate the how much money billed depending on gallons_used with the residential rate
                    billed = 5 + (residential_perGallon * gallons_used)
                    # print the results of the readings
                    print("Customer Code:", code)
                    print("Beginning meter reading: {:0>9}".format(beginning))
                    print("Ending meter reading: {:0>9}".format(end))
                    print("Gallons of water used:", (gallons_used))
                    print("Amount billed: ${:.2f}".format(billed))
                    # ask the user if they would like to continue and run using a flag statement
                    running = input("Would you like to continue? (y/n) ")
                    while not (running == 'Y' or running == 'y' or running == 'N' or running == 'n'):
                        print("Invalid Entry try again, please enter")
                        running = input("Would you like to continue? (y/n) ")
                # if the code is a commercial-use code, run the following statements
                elif (code == 'c' or code == 'C'):
                    # if the ending reading is larger than the beginning reading, find gallons_used
                    if end > beginning:
                        gallons_used = (end - beginning) / 10
                    # if beginning reading is larger than the ending reading, find gallons_used
                    else:
                        gallons_used = (1000000000 - (beginning - end)) / 10
                    # if gallons_used is greater than or equal to four million gallons
                    if gallons_used >= gallons_4mil:
                        # define remaining variable to represent any gallons over 4 million
                        remaining = gallons_used - gallons_4mil
                        # calculate the amount billed depending on the rate for industrial
                        billed = flatRate_1k + (remaining * additional_rate)
                    else:
                        # if gallons_used is less than 4 million, then the rate billed is just $1k
                        billed = flatRate_1k
                    # print the results of the readings
                    print("Customer Code:", code)
                    print("Beginning meter reading: {:0>9}".format(beginning))
                    print("Ending meter reading: {:0>9}".format(end))
                    print("Gallons of water used:", (gallons_used))
                    print("Amount billed: ${:.2f}".format(billed))
                    # ask the user if they would like to continue and run using a flag statement
                    running = input("Would you like to continue? (y/n) ")
                    while not (running == 'Y' or running == 'y' or running == 'N' or running == 'n'):
                        print("Invalid Entry try again, please enter")
                        running = input("Would you like to continue? (y/n) ")
                elif code == 'i' or code == 'I':
                    # if the ending reading is larger than the beginning reading, find gallons_used
                    if end > beginning:
                        gallons_used = (end - beginning) / 10
                    # if beginning reading is larger than the ending reading, find gallons_used
                    else:
                        gallons_used = (1000000000 - (beginning - end)) / 10
                    # if gallons_used is less than or equal to four million gallons
                    if gallons_used <= gallons_4mil:
                        # industrial use is charged $1k for gallons under or equal to four million
                        billed = flatRate_1k
                    # if gallons_used is in between 4,000,000 and 10,000,000
                    elif gallons_4mil < gallons_used < 10000000:
                        # industrial use is billed $2k for using this much gallons
                        billed = flatRate_2k
                    # if gallons_used is over 10,000,000
                    else:
                        # charge the user the flat rate for industrial along with per gallon after 10 million
                        remaining = gallons_used - 10000000
                        billed = flatRate_2k + (additional_rate * remaining)
                    # print the results of the readings
                    print("Customer Code:", code)
                    print("Beginning meter reading: {:0>9}".format(beginning))
                    print("Ending meter reading: {:0>9}".format(end))
                    print("Gallons of water used:", (gallons_used))
                    print("Amount billed: ${:.2f}".format(billed))
                    # ask the user if they would like to continue and run using a flag statement
                    running = input("Would you like to continue? (y/n) ")
                    while not (running == 'Y' or running == 'y' or running == 'N' or running == 'n'):
                        print("Invalid Entry try again, please enter")
                        running = input("Would you like to continue? (y/n) ")
# if the user inputs 'n' or 'N' into running, tell them goodbye
if running == 'n' or running == 'N':
    print("Goodbye")
