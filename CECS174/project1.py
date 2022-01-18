# ask the user for input: the current time in hours
time = int(input("What is the current time?\n"))
# ask the user through input, in how many hours they want the alarm to go off
alarm = int(input("In how many hours do you want your alarm to go off?\n"))
# calculate the final time using modulus operator
final = time + alarm % 24
# display to the user what time the alarm will set
print("Your alarm will set off at", final, end=":00.\n")
