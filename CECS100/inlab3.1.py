# Jordan Hilado
# 027460119
# In Lab Assignment #3


# import the module
import random

# define the first function 'main'
def main():
    # call function 'generate'
    generate()

# define function 'generate'
def generate():
    # set counter variables
    even = 0
    odd = 0
    # start for loop iterating 5 times
    for i in range(5):
        # set 'num' to equal the random integer
        num = random.randint(1, 10)
        # check if number is even
        if num % 2 == 0:
            # add to even counter
            even += 1
        # check if number is odd
        else:
            # add to odd counter
            odd += 1
    # print number of even and odd numbers generated
    print("Number of even: ", even)
    print("Number of odd: ", odd)

main()