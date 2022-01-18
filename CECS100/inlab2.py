length1 = float(input("What is the length of Rectangle 1?"))
width1 = float(input("What is the width of Rectangle 1?"))
length2 = float(input("What is the length of Rectangle 2?"))
width2 = float(input("What is the width of Rectangle 2?"))
area1 = length1 * width1
area2 = length2 * width2
if area1 > area2:
    print("Rectangle 1 is larger.")
elif area2 > area1:    
    print("Rectangle 2 is larger.")
else:
    print("The areas are the same.")