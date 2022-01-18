# Jordan Hilado
# Student ID #027460119
# CECS Lab Section 15
# Lab Assignment #2
# Due Date September 28, 2020

# Lab Assignment #2 Code
item1 = float(input("What is the price of the first item?"))
item2 = float(input("What is the price of the second item?"))
item3 = float(input("What is the price of the third item?"))
item4 = float(input("What is the price of the fourth item?"))
item5 = float(input("What is the price of the fifth item?"))
tax = 0.08
subtotal = item1 + item2 + item3 + item4 + item5
salestax = tax * subtotal
total = subtotal * 1.08
print("Subtotal: $", format(subtotal, '.2f'))
print("Sales Tax: $", format(salestax, '.2f'))
print("Total Purchase: $", format(total, '.2f'))
