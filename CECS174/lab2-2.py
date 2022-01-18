# define the variables
P = 10000
n = 12
r = 0.08
# ask the user for input
t = int(input('How many years of compound interest?'))
# calculate the answer using the compound interest formula
A = P*(1 + (r/n))**(n*t)
# print the answer
print('The final amount is $', format(A, '.2f'))
