# ask the user for input: the current time in hours
time = int(input("What is the current time?\n"))
# ask the user through input, in how many hours they want the alarm to go off
alarm = int(input("In how many hours do you want your alarm to go off?\n"))
# calculate the final time using modulus operator
final = (time + alarm) % 24
# if the final time is less than twelve, print the final time in PM
final2 = 0
if final > 12:
    final2 = final - 12
    print("Your alarm will set off at " + str(final) + ":00 or", final2, end=":00 PM.\n")
# if the final time is 0, add 12 to make it 12AM
elif final == 0:
    final2 += 12
    print("Your alarm will set off at " + str(final) + ":00 or", final2, end=":00 AM.\n")
# if final time is more than 12, print the answer itself
else:
    final2 = final
    print("Your alarm will set off at " + str(final) + ":00 or", final2, end=":00 AM.\n")
