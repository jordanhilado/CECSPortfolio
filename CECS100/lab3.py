# Jordan Hilado
# 027460119
# CECS 100 Lab Section 15
# Lab Assignment #3
# Due Date September 29, 2020

# Lab Assignment #3 Code
females = int(input("How many females are in the class?"))
males = int(input("How many males are in the class?"))
total = males + females
female_percentage = (females / total) * 100
male_percentage = (males / total) * 100
print("Percentage of females: " +format(female_percentage, '.2f') + "%")
print("Percentage of males: " + format(male_percentage, '.2f') + "%")