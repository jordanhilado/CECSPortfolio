def getRomanN(): # function that gathers a string input from the user
    roman = str(input()).upper() #  uses .upper() method to retrieve only uppercase input
    return roman # returns the given input

def isValidRoman(roman): # function that determines whether the input is a valid Roman numeral
    counter = 0 # sets counter to zero
    while counter < 400: # while loop that iterates from 0 to 399
        if roman == arabicToRoman(counter): # return True if input is equal to the Roman numeral being iterated with
            return True 
        counter += 1 # after each loop iterate counter by 1
    return False # return False if there is no match

def romanToArabic(roman): # function that takes in a Roman numeral as the argument and returns it in Arabic form
    roman_values = [1, 5, 10, 50, 100] # creates a list of valid Roman numeral values
    roman_letters = ['I', 'V', 'X', 'L', 'C'] # creates a list of valid Roman numeral letters 
    temp = 0 # sets a temporary variable to zero
    index = 0 # sets index to zero
    while (index < len(roman)): # while loop that runs if the index variable is less than the length of the input
        temp1 = roman_values[roman_letters.index(roman[index])] # sets temp1 variable with the current Roman numeral's value
        if (index + 1 < len(roman)): # if the letter in front of the current index is less than length of input, run
            temp2 = roman_values[roman_letters.index(roman[index + 1])] # sets temp2 variable with the value of the next letter after temp1
            if (temp1 >= temp2): # if the value of the current letter is greater than or equal to the value of the next one, run
                temp = temp + temp1 # increment the temporary variable with the value of temp1
                index = index + 1 # increment the index by 1
            else: # else increment the temporary variable with the value of the larger one minus the smaller one
                temp = temp + temp2 - temp1 
                index = index + 2 # increment the index variable by 2
        else: # if the next indexed letter is greater than the length of the input, run
            temp = temp + temp1 # increment the temporary variable by temp1
            index = index + 1 # increment the index by 1
    return temp # return the temporary variable from the beginning, which is now the real Arabic value of the input

def arabicToRoman(arabic): # function that changes from Arabic form to Roman Numeral form
    index = 0 # sets index to zero
    roman = '' # sets roman variable to an empty string
    roman_vals = ["C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"] # creates a list of Roman numerals to correspond with the Arabic values list
    arabic_vals = [100, 90, 50, 40, 10, 9, 5, 4, 1] # creates a list of Arabic values that corresponds to the above Roman numerals
    while arabic > 0: # if the given argument is greater than zero, run
        for x in range(arabic // arabic_vals[index]): # for loop that determines which is the greatest value in the list that can be divded with the input
            roman += roman_vals[index] # uses addition compound operator to increment the Roman variable with the value that can be used
            arabic -= arabic_vals[index] # subtracts the Arabic value from the input
        index += 1 # increments the index by 1
    return roman # returns the completed Roman numeral

def add(roman1, roman2): # function that adds two Roman numerals given in the argument
    result = romanToArabic(roman1) + romanToArabic(roman2) # converts the Roman numerals to Arabic, then sets it to result
    return arabicToRoman(result) # returns the result in Roman form

def sub(roman1, roman2): # function that subtracts the two Roman numerals given in the argument
    if romanToArabic(roman1) < romanToArabic(roman2): # if the first Roman numeral is less than the second Roman numeral, run
        result = romanToArabic(roman2) - romanToArabic(roman1) # subtract the second by the first
        return arabicToRoman(result) # return the calculated result
    else: # if the first Roman numeral is greater than the second Roman numeral
        result = romanToArabic(roman1) - romanToArabic(roman2) # subtract the first by the second
        return arabicToRoman(result) # return the calculated result in Roman form

def mul(roman1, roman2): # function that multiplies the two Roman numerals given in the argument
    result = romanToArabic(roman1) * romanToArabic(roman2) # converts the Roman numerals to Arabic form, then multiplies both
    return arabicToRoman(result) # returns the calculated result in Roman form

def div(roman1, roman2): # function that divides the two Roman numerals given in the argument
    result = romanToArabic(roman1) // romanToArabic(roman2) # converts the Roman numerals to Arabic form, then divides the two
    return arabicToRoman(result) # return the calculated result in Roman form

def menu(): # function that outputs the menu of the program
    validCode = ['A', 'S', 'M', 'D', 'Q'] # list of the valid codes that the user can input in the menu
    print('Please select from the following:\n\nA- Add two Roman Numerals.\nS- Subtract two Roman Numerals\nM- Multiply two Roman Numerals\nD- Divide two Roman Numerals\nQ- Quit\n')
    code = str(input('Select A, S, M, D or Q only. ')).upper() # asks for the input and converts it to uppercase
    while code not in validCode: # if the inputted code is not valid, ask for the input again
        code = str(input('Invalid entry. Please Try again.\n\nPlease Select from the following:\n\nA- Add two Roman Numerals.\nS- Subtract two Roman Numerals\nM- Multiply two Roman Numerals\nD- Divide two Roman Numerals\nQ- Quit\n\nSelect A, S, M, D or Q only. ')).upper()
    if code in validCode: # if the code is valid, return the code
        return code

def main(): # main function that calls all of the other functions to run the full program
    print('Welcome to the Roman Numerals Calculator')
    code = menu() # call the menu, ask for a letter selection and store it in the code variable
    while code != 'Q': # if the code is not equal to Q, run the following
        print('Enter First Roman Number (no spaces): ', end='')
        roman1 = getRomanN() # gathers the first Roman numeral
        while isValidRoman(roman1) == False: # while the first Roman numeral doesn't pass validation, keep asking for correct input
            print('Invalid Entry. Please Try again.')
            print('Enter First Roman Number (no spaces): ', end='')
            roman1 = getRomanN()
        print('Value of {}: {}'.format(roman1, romanToArabic(roman1))) # if the input is valid, print its Arabic form
        print('Enter Second Roman Number (no spaces): ', end='')
        roman2 = getRomanN() # gathers the second Roman numeral
        while isValidRoman(roman2) == False: # while the second Roman numeral doesn't pass validation, keep asking for correct input
            print('Invalid Entry. Please Try again.')
            print('Enter Second Roman Number (no spaces): ', end='')
            roman2 = getRomanN()
        print('Value of {}: {}\n'.format(roman2, romanToArabic(roman2))) # if the input is valid, print its Arabic form
        if code == 'A': # if the user selects addition, run the following
            result = add(roman1, roman2) # call the add() function with two arguments, then print the results
            print('{} + {} = {}\n{} + {} = {}\n'.format(roman1, roman2, result, romanToArabic(roman1), romanToArabic(roman2), romanToArabic(result)))
            code = menu() # repeat the menu again
        elif code == 'S': # if the user selects subtraction, run the following
            result = sub(roman1, roman2) # call the sub() function with two arguments, then print the results
            if romanToArabic(roman1) < romanToArabic(roman2): # if the first input is less than the second, add negative signs to the difference
                print('{} - {} = -{}\n{} - {} = -{}\n'.format(roman1, roman2, result, romanToArabic(roman1), romanToArabic(roman2), romanToArabic(result)))
                code = menu() # repeat the menu again
            else: # if the first input is greater than the second, print the corresponding difference
                print('{} - {} = {}\n{} - {} = {}\n'.format(roman1, roman2, result, romanToArabic(roman1), romanToArabic(roman2), romanToArabic(result)))
                code = menu() # repeat the menu again
        elif code == 'M': # if the user selects multiplication, run the following
            result = mul(roman1, roman2) # call the mul() function with two arguments, then print the results
            print('{} * {} = {}\n{} * {} = {}\n'.format(roman1, roman2, result, romanToArabic(roman1), romanToArabic(roman2), romanToArabic(result)))
            code = menu() # repeat the menu again
        elif code == 'D': # if the user selects division, run the following
            result = div(roman1, roman2) # call the div() function with two arguments, then print the results
            remainder = romanToArabic(roman1) % romanToArabic(roman2) # calculate the remainder if there is one
            if remainder > 0: # if there is a remainder, include it in the output
                print('{} / {} = {} R {}\n{} / {} = {} R {}\n'.format(roman1, roman2, result, arabicToRoman(remainder), romanToArabic(roman1), romanToArabic(roman2), romanToArabic(result), remainder))
            else: # if there isn't a remainder, print the corresponding output
                print('{} / {} = {}\n{} / {} = {}\n'.format(roman1, roman2, result, romanToArabic(roman1), romanToArabic(roman2), romanToArabic(result)))
            code = menu() # repeat the menu again
    print('Good Bye.') # if the code is Q for quit, then print a goodbye message
main() # call the main function to run the program in its entirety
