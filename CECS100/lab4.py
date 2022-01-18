# Jordan Hilado
# 027460119
# CECS 100 Lab Section 15
# Lab Assignment #4
# Due Date October 12, 2020

# Lab Assignment #4 Code
age = int(input("What is the person's age?"))
if age <= 1:
    print("The person is an infant.")
elif 1 < age < 13:
    print("The person is a child.")
elif 13 <= age < 20:
    print("The person is a teenager.")
else:
    print("The person is an adult.")