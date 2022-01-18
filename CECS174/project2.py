# ask the user for three inputs: the user code, beginning reading, and ending reading
code = input("Enter the customer's code: ")
beg = int(input("Enter the customer's beginning meter reading: "))
end = int(input("Enter the customer's ending meter reading: "))
# define gallons_used and billed variables
gallons_used = 0
billed = 0
# if statements to create instances for each code corresponding to residential, commercial, or industrial
# if the reading is between 000000000 and 999999999 and is one of the valid codes then continue
if (code == 'r' or code == 'R') and (0 <= beg <= 999999999 and 0 <= end <= 999999999):
    # if the ending reading is larger than the beginning reading, find gallons_used
    if end > beg:
        gallons_used = (end - beg) / 10
    # if beginning reading is larger than the ending reading, find gallons_used
    else:
        gallons_used = (1000000000 - (beg - end)) / 10
    # calculate the how much money billed depending on gallons_used with the residential rate
    billed = 5 + (0.0005 * gallons_used)
elif code == 'c' or code == 'C' and (0 <= beg <= 999999999 and 0 <= end <= 999999999):
    # if the ending reading is larger than the beginning reading, find gallons_used
    if end > beg:
        gallons_used = (end - beg) / 10
    # if beginning reading is larger than the ending reading, find gallons_used
    else:
        gallons_used = (1000000000 - (beg - end)) / 10
    # if gallons_used is greater than or equal to four million gallons
    if gallons_used >= 4000000:
        # define remaining variable to represent any gallons over 4 million
        remaining = gallons_used - 4000000
        # calculate the amount billed depending on the rate for industrial
        billed = 1000 + (remaining * 0.00025)
    else:
        # if gallons_used is less than 4 million, then the rate billed is just $1k
        billed = 1000
elif code == 'i' or code == 'I' and (0 <= beg <= 999999999 and 0 <= end <= 999999999):
    # if the ending reading is larger than the beginning reading, find gallons_used
    if end > beg:
        gallons_used = (end - beg) / 10
    # if beginning reading is larger than the ending reading, find gallons_used
    else:
        gallons_used = (1000000000 - (beg - end)) / 10
    # if gallons_used is less than or equal to four million gallons
    if gallons_used <= 4000000:
        # industrial use is charged $1k for gallons under or equal to four million
        billed = 1000
    # if gallons_used is in between 4,000,000 and 10,000,000
    elif 4000000 < gallons_used < 10000000:
        # industrial use is billed $2k for using this much gallons
        billed = 2000
    # if gallons_used is over 10,000,000
    else:
        # charge the user the flat rate for industrial along with per gallon after 10 million
        remaining = gallons_used - 10000000
        billed = 2000 + (0.00025 * remaining)
# if the user enters invalid numbers or an invalid code, output to the user that the input is invalid
else:
    print("Invalid Entry")
    code = 'Invalid'
    billed = 0
    gallons_used = 0
    beg = 0
    end = 0
# print the customer code, the beginning reading formatted, the ending meter formatted, the water used, and the amount billed formatted
print("Customer Code:", code)
print("Beginning meter reading: {:0>9}".format(beg))
print("Ending meter reading: {:0>9}".format(end))
print("Gallons of water used:", (gallons_used))
print("Amount billed: ${:.2f}".format(billed))
