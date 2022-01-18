# sets variable 'bug_total' to zero
bug_total = 0
# sets a for loop to iterate five times
for x in range(5):
    # asks the user for input - how many bugs were caught each day
    bugs = int(input("How many bugs were caught? "))
    # calculates the total bugs
    bug_total = bugs + bug_total
    # displays the total number of bugs after the iteration 
    print("There are a total of " + str(bug_total) + " bugs.")