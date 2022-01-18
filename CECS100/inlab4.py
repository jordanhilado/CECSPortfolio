# Jordan Hilado
# 027460119
# In Lab Assignment # 4
# Due Monday, November 23


# Graphics # 1 Code

import turtle
# declare f as an appropriate variable for the turtle function
f = turtle.Turtle()
# show the turtle
f.showturtle()
# create a loop to create the square
for i in range(4):
    f.forward(100)
    f.left(90)
# create a fill color red and begin
f.fillcolor("red")
f.begin_fill()
# move forward to the halfway point for the circle
f.forward(50)
# set pencolor to red
f.pencolor("red")
# create the circle and end the fill
f.circle(50)
f.end_fill()

# Graphics # 2 Code

# lift the pen up and move it to an empty area 200 pixels away
f.penup()
f.forward(200)
f.pendown()
# fill in the color red and begin
f.fillcolor("red")
f.begin_fill()
# create the circle and end the fill
f.circle(50)
f.end_fill()
# set pencolor to black and begin the fill
f.pencolor("black")
f.fillcolor("black")
f.begin_fill()
f.forward(50)
# create for loop to create the square
for i in range(4):
    f.right(90)
    f.forward(100)
# end the fill to make the square black
f.end_fill()
