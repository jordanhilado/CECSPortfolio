# Jordan Hilado
# 027460119
# CECS 100 Lab Section 15
# In Lab Assignment #1
# Due Date September 28, 2020

# In Lab Assignment #1 Code
tax = 0.08
tip = 0.15
food_total = float(input("What is the meal total?"))
tip_total = food_total * tip
tax_total = food_total * tax
grand_total = tip_total + tax_total + food_total
print("Tip Total: $", format(tip_total, '.2f'))
print("Tax Total: $", format(tax_total, '.2f'))
print("Grand Total: $", format(grand_total, '.2f'))